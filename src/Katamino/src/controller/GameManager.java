/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.*;
import view.*;

/**
 *
 * @author murattuver
 */
public class GameManager {
    
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
    
    public GameManager(Level level) {
        pentos = new ArrayList<>();
        this.level = level;
        
        initPentominoes();
        createBoard(level.getDifficultyLevel());
        
        board.setX(40);
        board.setY(55);
        
        objectsOnScreen = new ArrayList<GameObject>();
        
        objectsOnScreen.add(board);
        
        for(int i = 0; i < pentos.size(); i++){
            objectsOnScreen.add(pentos.get(i));
        }
        
        gamePanel = new GamePanel(objectsOnScreen);
    }
    
    public void startGameEngine(){
        gameFrame.removeAll();
        gameFrame.dispose();
        gameEngine = new GameEngine(gamePanel);
        if(!gameEngine.isGameRunning())
            gameEngine.startGameEngine();
    }
    
    public void createBoard(int col){
        board = new Board(col);
        
    }
    
    public void initPentominoes(){
        PentominoesSet pSet = level.getPentominoes();
        
        for(int i = 0; i < pSet.getNumberOfPentominoes(); i++){
            pentos.add(pSet.getPentomino(i));
        }
    }
    
    public void stopGameEngine(){
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
                        if( (x >= p.getX() + j * p.getDeltaX() //Checking x interval.
                                && x <= p.getX() + (j + 1) * p.getDeltaX() )
                                && (y >= p.getY() + i * p.getDeltaY() //Checking y interval.
                                && y <= p.getY() + (i + 1) * p.getDeltaY())){
                            return p;
                        }
                    }
                }
            }
            

        }
        
        System.err.println("No pentomino in the coordinate.");
        return null;
    }
    
    public void movePentomino(Pentomino pent, int x, int y){
        pent.setX(x);
        pent.setY(y);
    }
    
}
