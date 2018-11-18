/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.java.accessibility.util.AWTEventMonitor;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
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
    private int releasedOnX;
    private int releasedOnY;
    
    public GameManager(Level level) {
        pentos = new ArrayList<>();
        objectsOnScreen = new ArrayList<GameObject>();
        this.level = level;
        
        initPentominoes();
        createBoard(level.getDifficultyLevel());
        
        board.setX(40);
        board.setY(55);
        board.setDeltaX(720);
        board.setDeltaY(300);
        board.setImgURL("/assets/board.png");
        
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
        System.out.println("Get object:" + x + ", " + y);
        for(int k = 0; k < pentos.size(); k++){
            Pentomino p = pentos.get(k);
            boolean[][] shape = pentos.get(k).getShape();
            
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(shape[i][j]){
                        if( (x >= p.getX() + (j * p.getDeltaX()) //Checking x interval.
                                && x <= p.getX() + (j + 1) * p.getDeltaX() )
                                && (y <= p.getY() - i * p.getDeltaY() //Checking y interval.
                                && y >= p.getY() - (i + 1) * p.getDeltaY())){
                            return p;
                        }
                    }
                }
            }
        }
        
        System.err.println("No pentomino in the coordinate.");
        return null;
    }
    
    public void coorClicked(int x, int y){
        Pentomino p = getGameObject(x, y);
        if(p != null){
            p.setX(x - 30);
            p.setY(y + 30);
            
            //System.out.println("x: " + x + " y: " + y);
        }
    }
    
    public void setInitialPoints(int x, int y){
        initialX = x;
        initialY = y;
    }
    
    public void releasedOn(int x, int y){
        releasedOnX = x;
        releasedOnY = y;
    }
    
    public void checkOnBoard(int x, int y){
        Pentomino p = getGameObject(x, y);
        if(p != null){
            if(releasedOnX < board.getX() || releasedOnX > board.getX() + board.getDeltaX() ||
                    releasedOnY < board.getY() - board.getDeltaY() || releasedOnY > board.getY()){
                p.setX(initialX);
                p.setX(initialY);
            } else{
                p.setX(x);
                p.setX(y);
            }
        }
    }
   
    
}
