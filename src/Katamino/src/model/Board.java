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
public class Board {
    private Theme theme;
    private BoardLocation[][] locations;
    private int maxCol;
    
    public Board(int col) {
        maxCol = col;
        locations = new BoardLocation[5][col];
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < maxCol; j++){
                locations[i][j] = new BoardLocation();
            }
        }
    }
            
    public Theme getTheme(){
        return theme;
    }
    
    public void setTheme(Theme theme) {
        this.theme = theme;
    }
    
    public boolean isBoardFull(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < maxCol; j++){
                if(!locations[i][j].isOccupied())
                    return false;
            }
        }
        
        return true;
    }
    
    public boolean placePentomino(Pentomino pento, int x, int y){
        
        boolean[][] pentLocs = pento.getShape();
        
        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {
                
                //Checking if the location is in the boundary
                if(pentLocs[row][col] && (col + x) >= maxCol){
                    System.err.println("Err: couldn't add the piece.");
                    return false;
                }
                else if(pentLocs[row][col] && locations[row + y][col + x].isOccupied()){
                    System.err.println("Err: couldn't add the peice.");
                    return false;    
                } 
            }
        }
        
        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {
                if(pentLocs[row][col])
                    locations[row + y][col + x].setPentomino(pento);
            }
        }
        return true;

    }
    
    public Pentomino getPentomino(int x, int y){
        if(locations[y][x].isOccupied())
            return locations[y][x].getPentomino();
        else
            System.err.println("Error: There is no Pentomino in the slot.");
        return null;
    }
    
    //FOR TESTING PURPOSE!!!
    public void print(){
        for(int i = 4; i >= 0; i--){
            for(int j = 0; j < maxCol; j++) {
                if(locations[i][j].isOccupied()){
                    System.out.print("[x]");
                }
                else {
                    System.out.print("[ ]");
                }
            }
            System.out.println("");
        }
    }
    
    //TESTING PURPOSE!!!
    public void printColor(){
        for(int i = 4; i >= 0; i--){
            for(int j = 0; j < maxCol; j++) {
                if(locations[i][j].isOccupied()){
                    System.out.print(locations[i][j].getPentomino().getColor());
                }
                else {
                    System.out.print("[ ]");
                }
            }
            System.out.println("");
        }
    }
}
