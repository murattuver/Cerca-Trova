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
    private Level level;
    private OptionsView settingsView;
    private GameFrame gameFrame;
    private GameEngine gameEngine;
    private boolean isGameRunning = false;
    
    public GameManager(Level level) {
        pentos = new ArrayList<>();
        this.level = level;
    }
    
    public void startGameEngine(){
        gameFrame.removeAll();
        gameFrame.add(GameEngine.getInstance());
        if(!GameEngine.getInstance().isGameRunning())
            gameEngine.getInstance().start();
        gameFrame.updateFrame();
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
        gameEngine.stop();
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
