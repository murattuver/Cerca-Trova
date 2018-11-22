/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Murat
 */
public abstract class GameObject implements Drawable{
    private int xLoc;
    private int yLoc;
    private int deltaX;
    private int deltaY;
    
    
    public int getX(){
        return xLoc;
    }
    
    public int getY(){
        return yLoc;
    }
    
    public void setY(int y){
        yLoc = y;
    }
    
    public void setX(int x){
        xLoc = x;
    }
    
    public int getDeltaX(){
        return deltaX;
    }
    
    public int getDeltaY(){
        return deltaY;
    }
    
    public void setDeltaX(int x){
        deltaX = x;
    }
    
    public void setDeltaY(int y){
        deltaY = y;
    }
    
 
}

