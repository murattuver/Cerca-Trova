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
}
