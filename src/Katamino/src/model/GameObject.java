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
    private int LocX;
    private int LocY;
    private String id;
    private int deltaX;
    private int deltaY;
    
    
    public int getX(){
        return LocX;
    }
    
    public int getY(){
        return LocY;
    }
    
    public void setY(int y){
        LocY = y;
    }
    
    public void setX(int x){
        LocX = x;
    }
    
    public int getDeltaX(){
        return deltaX;
    }
    
    public int getDeltaY(){
        return deltaY;
    }
}
