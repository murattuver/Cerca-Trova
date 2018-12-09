/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_management;

/**
 *
 * @author Murat
 */
public class Level {
    private PentominoesSet pSet;
    private boolean isLevelUnlocked = false;
    private int difficultyLevel;
    private int time;
    
    public Level(PentominoesSet set, boolean isUnlocked, int time, int difficulty){
        pSet = set;
        isLevelUnlocked = isUnlocked;
        this.time = time;
        difficultyLevel = difficulty;
    }
    
    public void setDifficulty(int diff){
        difficultyLevel = diff;
    }
    
    public void setTime(int time){
        this.time = time;
    }
    
    public int getTime(){
        return time;
    }
    
    public int getDifficultyLevel(){
        return difficultyLevel;
    }
    
    public void setUnlocked(boolean b){
        isLevelUnlocked = b;
    }
    
    public PentominoesSet getPentominoes(){
        return pSet;
    }
}
