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
public abstract class GameObject {
    private int locX;
    private int locY;
    private String id;
    private int deltaX;
    private int deltaY;
    
    
    public int getX(){
        return locX;
    }
    
    public int getY(){
        return locY;
    }
    
    public void setY(int y){
        locY = y;
    }
    
    public void setX(int x){
        locX = x;
    }
    
    public int getDeltaX(){
        return deltaX;
    }
    
    public int getDeltaY(){
        return deltaY;
    }
}
