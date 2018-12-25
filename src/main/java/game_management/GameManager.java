/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_management;

import game_interface.GamePanel;
import menu_interface.OptionsView;
import menu_interface.MenuFrame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import menu_management.MainMenuController;
import network_management.NetworkManager;

/**
 *
 * @author murattuver
 */
public class GameManager{
    
    private SoundManager soundManager;
    private Board myBoard;
    private Board yourBoard;
    private List<Pentomino> pentos;
    private List<GameObject> objectsOnScreen;
    private Level level;
    private OptionsView settingsView;
    private MenuFrame menuFrame;
    private GameEngine gameEngine ;
    private boolean isGameRunning = false;
    private GamePanel gamePanel;
    private int initialX;
    private int initialY;
    private int draggingX;
    private int draggingY;
    private boolean wasOnBoard = false;
    private Pentomino pentoDragged = null;
    private NetworkManager network = null;
    private boolean isMultiplayer;
    private int playerNo = 1;
    private int gameWinner = 0;
    private String gameMode;
    private MainMenuController menuController;

    
    public GameManager(MainMenuController menuController, String gMode, Level level, boolean isMultiplayer, int playerNo) {
        
        this.menuController = menuController;
        this.gameMode = gMode;
        this.playerNo = playerNo;
        this.isMultiplayer = isMultiplayer;
        pentos = new ArrayList<>();
        objectsOnScreen = new ArrayList<GameObject>();
        this.level = level;
        
        initPentominoes();
        myBoard = new Board(level.getDifficultyLevel(), false);
        
        if(isMultiplayer){
            myBoard.setX(40);
            myBoard.setY(55);
        }
        else{
            myBoard.setX(40);
            myBoard.setY(55);
        }
        
        objectsOnScreen.add(myBoard);
                
        for(int i =0; i < pentos.size(); i++){
            Pentomino p = pentos.get(i);
            
            objectsOnScreen.add(p);

        }
        //Logic related to multiplater game creation.
        if(isMultiplayer){
            yourBoard = new Board(level.getDifficultyLevel(), true);
            
            yourBoard.setX(370);
            yourBoard.setY(55);
            objectsOnScreen.add(yourBoard);
            
        }
        
        gamePanel = new GamePanel(objectsOnScreen, this);
        
    }
    
    public void startGameEngine(){
        gameEngine = new GameEngine(gamePanel, this);
        
        if(!gameEngine.isGameRunning()){
            gameEngine.startGameEngine();
            isGameRunning = true;
        }

    }
    
    public void stopGameEngine(){
        boolean gameRunning = false;
        gameEngine.stopGameEngine();
    }
    
    private void initPentominoes(){
        PentominoesSet pSet = level.getPentominoes();
        
        for(int i = 0; i < pSet.getNumberOfPentominoes(); i++){
            pentos.add(pSet.getPentomino(i));
        }
    }
    
    public void terminateSingleGame(){
        gameEngine.stopGameEngine();
        menuController.menuFrameVisible();
    }
    
    public boolean isGameRunning(){
        return isGameRunning;
    }
    
    public Pentomino getGameObject(int x, int y){
        for(int k = 0; k < pentos.size(); k++){
            Pentomino p = pentos.get(k);
            boolean[][] shape = pentos.get(k).getShape();
            
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(shape[i][j]){
                        if( (x >= p.getX() + (j * p.getDeltaX()) //Checking x interval.
                                && x <= p.getX() + (j + 1) * p.getDeltaX() )
                                && (y >= p.getY() + i * p.getDeltaY() //Checking y interval.
                                && y <= p.getY() + (i + 1) * p.getDeltaY())){
                            setDraggingCoor(i, j);
                            return p;
                        }
                    }
                }
            }
        }
        
        return null;
    }
    
    public void setDraggingCoor(int x, int y){
        draggingX = x;
        draggingY = y;
    }
    
    public void dragPentomino(int x, int y){
        
        if(myBoard.isOnBoard(pentoDragged)){
            wasOnBoard = true;
            myBoard.savePreviousLoc(pentoDragged);
            myBoard.removePentomino(pentoDragged);
        }
        
        movePentomino(pentoDragged.getX() + (x - initialX), pentoDragged.getY() + (y - initialY));
    }
    
    public void movePentomino(int x, int y){
        pentoDragged.setX(x);
        pentoDragged.setY(y);
    }
    
    public void setInitialPoints(int x, int y){
        initialX = x;
        initialY = y;
    }
    
    public void setSelected(boolean b, int x, int y){
        Pentomino p = getGameObject(x, y);
        
        if(b && ( p != null )){
            pentoDragged = p;
        }else{   
            pentoDragged = null; 
        } 
    }
    
    public boolean getSelected(){
        return pentoDragged != null;
    }
    
    public void rotateSelected(){
        pentoDragged.rotate();
    }
    
    public void symSelected(){
        pentoDragged.takeSym();
    }
    
    public void checkOnBoard(int x, int y){
        
        if(pentoDragged == null)
            return;
        
        if(myBoard.isPointOnBoard(x, y)){
            int rowOnBoard = ( y - myBoard.getY() ) / myBoard.getDeltaY();
            int colOnBoard = ( x - myBoard.getX() ) / myBoard.getDeltaX();
            
            int rowToPlace = rowOnBoard - draggingX;
            int colToPlace = colOnBoard - draggingY;
            
            boolean isPlaced = myBoard.placePentomino(pentoDragged, rowToPlace, colToPlace);
            
            if(isPlaced){
                movePentomino(colToPlace * myBoard.getDeltaY() + myBoard.getX(), rowToPlace * myBoard.getDeltaX() + myBoard.getY());
                
      
                
            }
            else if(wasOnBoard){
                myBoard.placePrevPento();
                movePentomino(myBoard.getPrevCol() * myBoard.getDeltaY() + myBoard.getX(), myBoard.getPrevRow() * myBoard.getDeltaX() + myBoard.getY());
              

            } else{
                movePentomino(pentoDragged.getDefaultX(), pentoDragged.getDefaultY());
                

            }
            wasOnBoard = false;
            
            if(isMultiplayer){
                sendMultiData();
            }
            
            if(myBoard.isBoardFull()){
                //Game finished will be implemented.
                
                if(isMultiplayer){
                    gameWinner = playerNo;
                    sendMultiData();
                    announceWinner();
                    
                } else {
                    finishLevel();
                }
                
            }
        } else {
            movePentomino(pentoDragged.getDefaultX(), pentoDragged.getDefaultY());
            wasOnBoard = false;
        }
        
    }
    
    public void finishLevel(){
        
        Object[] options = {"Next Level"};
        int n = JOptionPane.showOptionDialog((JFrame)SwingUtilities.windowForComponent(gameEngine),
        "Level Finished!\nCongratulations! ",
        "Level Finished!",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,     //do not use a custom Icon
        options,  //the titles of buttons
        options[0]); //default button title
        
        if(n == 0){
            gameEngine.stopGameEngine();
            menuController.setLevelUnlocked(level.getDifficultyLevel() - 3);
            menuController.initNextLevel(gameMode, level.getDifficultyLevel() - 3);
        }
        
    }
    
    public void setMultiData(HashMap data){
        
        ArrayList<Boolean> newLocations = new ArrayList<>();
        ArrayList<Long> newColors = new ArrayList<>();

        if(playerNo == 1){
            newLocations = (ArrayList<Boolean>)data.get("p2Board");
            newColors = (ArrayList<Long>)data.get("p2Colors");
        } else if(playerNo == 2){
            newLocations = (ArrayList<Boolean>)data.get("p1Board");
            newColors = (ArrayList<Long>)data.get("p1Colors");
        }
        gameWinner = ((Long) data.get("winner")).intValue();
        yourBoard.setFromDB(newLocations, newColors);
        
        if((gameWinner != playerNo)  && (gameWinner != 0)){
            announceWinner();
        }
    }
    
    public void announceWinner(){
        
        int n = -1;
        if(gameWinner == playerNo){
            Object[] options = {"Thank You!"};
            n = JOptionPane.showOptionDialog((JFrame)SwingUtilities.windowForComponent(gameEngine),
            "You won the game!\nCongratulations! ",
            "You Won!",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,     //do not use a custom Icon
            options,  //the titles of buttons
            options[0]); //default button title
        }
        
        else{
            Object[] options = {"Accept Defeat"};
            n = JOptionPane.showOptionDialog((JFrame)SwingUtilities.windowForComponent(gameEngine),
            "Opponent finished the level faster than you.\nGood Luck Next Time ",
            "You Lost",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,     //do not use a custom Icon
            options,  //the titles of buttons
            options[0]); //default button title
        }
        
        if(n == 0){
            network.destroyOnlineGame();
            menuController.getSoundManager().playSound();
            gameEngine.stopGameEngine();
            //network.stopDatabaseListener();
            menuController.menuFrameVisible();
            menuController.backFromMulti(network);
        }
            
    }
    
    public void setNetworkManager(NetworkManager nm){
        network = nm;
    }
    
    public void sendMultiData(){
        
        Map<String, Object> dataToSet = new HashMap<>();
        
        ArrayList<Boolean> locs = new ArrayList<>();
        ArrayList<Integer> colors = new ArrayList<>();
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < level.getDifficultyLevel(); j++){
                locs.add( myBoard.getShape(i, j));
                colors.add(myBoard.getColor(i, j));
            }
        }
        if(playerNo == 1){
            dataToSet.put("p1Board", locs);
            dataToSet.put("p1Colors", colors);
        } else if(playerNo == 2){
            dataToSet.put("p2Board", locs);
            dataToSet.put("p2Colors", colors);
        }
        
        if(gameWinner == playerNo){
            dataToSet.put("winner", playerNo);
        }
        network.sendBoardData(dataToSet);
        
    }
    public boolean isBoardFull()
    {
        return myBoard.isBoardFull();
    }
   
    
}
