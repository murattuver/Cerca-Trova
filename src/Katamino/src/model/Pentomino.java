/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;

/**
 *
 * @author Murat
 */
public class Pentomino extends GameObject{
    private boolean[][] shape = new boolean[5][5];
    private Color color;
    private Theme theme;
    private int xLoc;
    private int yLoc;
    private int deltaX;
    private int deltaY;
    
    public Pentomino(boolean[][] shape, Color color){
        this.shape = shape;
        this.color = color;
    }
    
    public Pentomino(Color color){
        this.color = color;
        
        for(int i = 0; i < 5;i++){
            for(int j = 0; j < 5; j++){
                  this.shape[i][j] = false;
            }
        }
    }
    
    public void rotate() {
        int maxCol = findMaxCol();
        boolean[][] newShape = new boolean[5][5];
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++) {
                if(shape[i][j]){
                    x = j;
                    y = i;
                    
                    x = x - maxCol;
                    int temp = x;
                    x = y;
                    y = -1 * temp - 1;
                    
                    newShape[y][x] = true;
                                                      
                }
            }
        }
        
        shape = newShape;
    }
    
    private int findMaxCol() {
        int maxSoFar = -1;
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(shape[i][j] && j > maxSoFar - 1){
                    maxSoFar = j + 1;
                }
            }
        }
        
        return maxSoFar;
    }
    
    public boolean[][] getShape() {
        return shape;
    }
    
    public Color getColor(){ 
        return color;   
    }
    
    public void setShape(int x, int y, boolean b){
        shape[y][x] = b;
    }
    
    public int getX(){
        return xLoc;
    }
    
    public int getY(){
        return yLoc;
    }
    
    public void setX(int x){
        xLoc = x;
    }
    
    public void setY(int y){
        yLoc = y;
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
    
    //FOR TESTING PURPOSE!!!
    public void print(){
        for(int i = 4; i >= 0; i--){
            for(int j = 0; j < 5; j++) {
                if(shape[i][j]){
                    System.out.print("[x]");
                }
                else {
                    System.out.print("[ ]");
                }
            }
            System.out.println("");
        }
    } 
}
