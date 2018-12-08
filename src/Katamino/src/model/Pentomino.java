/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Murat
 */
public class Pentomino extends GameObject{
    private boolean[][] shape = new boolean[5][5];
    private Color color = Color.red;
    private Theme theme;
    private int defaultX;
    private int defaultY;
    
    public Pentomino(){
        setDeltaX(35);
        setDeltaY(35);       
        
        for(int i = 0; i < 5;i++){
            for(int j = 0; j < 5; j++){
                  this.shape[i][j] = false;
            }
        }
    }
    
    public void setDefault(int x, int y){
        defaultX = x;
        defaultY = y;
    }
    
    public int getDefaultX(){
        return defaultX;
    }
    
    public int getDefaultY(){
        return defaultY;
    }
    
    public void rotate() {
        int maxRow = findMaxRow();
        boolean[][] newShape = new boolean[5][5];
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++) {
                if(shape[i][j]){
                    x = j;
                    y = -1 * i -1;
                    
                    y = y + maxRow;
                    
                    newShape[x][y] = true;
                                                      
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
    
    private int findMaxRow(){
        int maxSoFar = -1;
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(shape[i][j] && i > maxSoFar - 1){
                    maxSoFar = i + 1;
                }
            }
        }
        
        return maxSoFar;
    }
    
    public boolean[][] getShape() {
        return shape;
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    public Color getColor(){ 
        return color;   
    }
    
    public void setShape(int x, int y, boolean b){
        shape[x][y] = b;
    }
    
    //FOR TESTING PURPOSE!!!
    public void print(){
        for(int i = 0; i < 5; i++){
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
    

    @Override
    public void update() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics g) {
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(shape[i][j]){
                    g.setColor(this.color);
                    g.fillRect(getX() + j * getDeltaX(), getY() + i * getDeltaY(), getDeltaX(), getDeltaY());
                    g.setColor(Color.black);
                    g.drawRect(getX() + j * getDeltaX(), getY() + i * getDeltaY(), getDeltaX(), getDeltaY());

                }
            }
        }
    }
}
