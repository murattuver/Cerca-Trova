/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Murat
 */
public class Pentomino extends GameObject{
    private boolean[][] shape = new boolean[5][5];
    private Color color;
    private Theme theme;
    private String imgURL;
    
    public Pentomino(){
        setDeltaX(35);
        setDeltaY(35);       
        
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
    
    public void setImgURL(String s){
        imgURL = s;
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
    
    public Color getColor(){ 
        return color;   
    }
    
    public void setShape(int x, int y, boolean b){
        shape[y][x] = b;
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
    

    @Override
    public void update() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics g, Component view) {
        ImageIcon i = new ImageIcon(
            Pentomino.class.getResource(imgURL));
        i.paintIcon(view, g, this.getX(), this.getY() -(getDeltaY() * findMaxRow()));
        
    }
}
