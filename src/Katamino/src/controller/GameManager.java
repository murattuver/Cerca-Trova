/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;
import view.*;

/**
 *
 * @author murattuver
 */
public class GameManager{
    
    private SoundManager soundManager;
    private Board board;
    private List<Pentomino> pentos;
    private List<GameObject> objectsOnScreen;
    private Level level;
    private OptionsView settingsView;
    private GameFrame gameFrame;
    private GameEngine gameEngine;
    private boolean isGameRunning = false;
    private GamePanel gamePanel;
    private int initialX;
    private int initialY;
    private int draggingX;
    private int draggingY;
    private boolean wasOnBoard = false;
    private Pentomino pentoDragged = null;

    
    public GameManager(Level level) {
        pentos = new ArrayList<>();
        objectsOnScreen = new ArrayList<GameObject>();
        this.level = level;
        
        initPentominoes();
        createBoard(level.getDifficultyLevel());
        
        board.setX(40);
        board.setY(55);
        
        
        objectsOnScreen.add(board);
        
        for(int i =0; i < 5; i++){
            Pentomino p = pentos.get(i);
            
            objectsOnScreen.add(p);

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
    
    private void createBoard(int col){
        board = new Board(col);
        
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
        
        if(board.isOnBoard(pentoDragged)){
            wasOnBoard = true;
            board.savePreviousLoc(pentoDragged);
            board.removePentomino(pentoDragged);
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
        
        if(board.isPointOnBoard(x, y)){
            int rowOnBoard = ( y - board.getY() ) / board.getDeltaY();
            int colOnBoard = ( x - board.getX() ) / board.getDeltaX();
            
            int rowToPlace = rowOnBoard - draggingX;
            int colToPlace = colOnBoard - draggingY;
            
            boolean isPlaced = board.placePentomino(pentoDragged, rowToPlace, colToPlace);
            
            if(isPlaced){
                movePentomino(colToPlace * board.getDeltaY() + board.getX(), rowToPlace * board.getDeltaX() + board.getY());
                
            }
            else if(wasOnBoard){
                board.placePrevPento();
                movePentomino(board.getPrevCol() * board.getDeltaY() + board.getX(), board.getPrevRow() * board.getDeltaX() + board.getY());

              

            } else{
                movePentomino(pentoDragged.getDefaultX(), pentoDragged.getDefaultY());
                

            }
            wasOnBoard = false;
            
            if(board.isBoardFull()){
                //Game finished will be implemented.
                JOptionPane.showMessageDialog(gamePanel, "Game is Over");
                System.out.println("Done.");
            }
        } else {
            movePentomino(pentoDragged.getDefaultX(), pentoDragged.getDefaultY());
            wasOnBoard = false;
        }
        
    }
   
    
}
