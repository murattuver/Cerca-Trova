/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_management;

import game_interface.GamePanel;
import java.awt.Color;
import menu_interface.OptionsView;
import menu_interface.MenuFrame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import network_management.NetworkManager;
import view.*;

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

    
    public GameManager(Level level, boolean isMultiplayer, int playerNo) {
        
        this.playerNo = playerNo;
        this.isMultiplayer = isMultiplayer;
        pentos = new ArrayList<>();
        objectsOnScreen = new ArrayList<GameObject>();
        this.level = level;
        
        initPentominoes();
        myBoard = new Board(level.getDifficultyLevel(), false);
        
        myBoard.setX(40);
        myBoard.setY(55);
        objectsOnScreen.add(myBoard);
        
                
        for(int i =0; i < 5; i++){
            Pentomino p = pentos.get(i);
            
            objectsOnScreen.add(p);

        }
        
        
        //Logic related to multiplater game creation.
        if(isMultiplayer){
            yourBoard = new Board(level.getDifficultyLevel(), true);
            
            yourBoard.setX(300);
            yourBoard.setY(55);
            objectsOnScreen.add(yourBoard);
            
        }

        /* Actual code to be used.
        for(int i = 0; i < pentos.size(); i++){
            objectsOnScreen.add(pentos.get(i));
        }
        */
        
        gamePanel = new GamePanel(objectsOnScreen);
        
    }
    
    public void startGameEngine(){
        //gameFrame.removeAll();
        //gameFrame.dispose();
        gameEngine = new GameEngine(gamePanel, this);
        if(!gameEngine.isGameRunning()){
            gameEngine.startGameEngine();
            isGameRunning = true;

        }

    }
    
    private void initPentominoes(){
        PentominoesSet pSet = level.getPentominoes();
        
        for(int i = 0; i < pSet.getNumberOfPentominoes(); i++){
            pentos.add(pSet.getPentomino(i));
        }
    }
    
    public void stopGameEngine(){
        boolean gameRunning = false;
        gameEngine.stopGameEngine();
    }
    
    public boolean isGameRunning(){
        return isGameRunning;
    }
    
    public void createView(View view){
        
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
        System.out.println(pentoDragged.getX());
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
                JOptionPane.showMessageDialog(gamePanel, "Game is Over");
                System.out.println("Done.");
            }
        } else {
            movePentomino(pentoDragged.getDefaultX(), pentoDragged.getDefaultY());
            wasOnBoard = false;
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
        
        
        yourBoard.setFromDB(newLocations, newColors);   
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
        network.sendBoardData(dataToSet);
        
    }
   
    
}
