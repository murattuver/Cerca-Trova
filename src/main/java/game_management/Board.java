/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_management;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Murat
 */
public class Board extends GameObject {
    private boolean isOpponent;
    private Theme theme;
    private BoardLocation[][] locations;
    private int maxCol;
    
    //Empty cell color.
    private Color color = Color.white;
    private int prevRow;
    private int prevCol;
    private Pentomino prevPento;
    
    public Board(int col, boolean isOpponent) {
        this.isOpponent = isOpponent;
        setDeltaX(30);
        setDeltaY(30);
        maxCol = col;
        locations = new BoardLocation[5][col];
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < maxCol; j++){
                locations[i][j] = new BoardLocation();
                locations[i][j].setColor(0);
            }
        }
    }
            
    public Theme getTheme(){
        return theme;
    }
    
    public void setTheme(Theme theme) {
        this.theme = theme;
    }
    
    public boolean isOnBoard(Pentomino pento){
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < maxCol; col++){
                if(getPentomino(row, col) == pento)
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean isPointOnBoard(int x, int y){
        if(x < getX() || y < getY()){
            return false;
        }
        if(x > getX() + (maxCol * getDeltaX()) || y > getY() + ( 5 * getDeltaY())){
            return false;
        }
        return true;
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
        if(x < 0 || y < 0)
            return false;
        
        boolean[][] pentLocs = pento.getShape();
        
        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {
                
                
                if(pentLocs[row][col] && ( (row + x > 4) || (col + y > maxCol - 1) ) )
                    return false;
                
                if(!( (row + x > 4) || (col + y > maxCol -1))){
                    if(locations[x + row][y + col].isOccupied() && pentLocs[row][col])
                        return false;
                }
            }
        }
       
        
        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {
                
                if(pentLocs[row][col])
                    locations[x + row][y + col].setPentomino(pento); 
            }
        }
        
        return true;
    }
    
    public void removePentomino(Pentomino pento){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < maxCol; j++){
                if(getPentomino(i, j) == pento){
                    locations[i][j].removePentomino();
                }
            }
        }
    }
    
    public Pentomino getPentomino(int x, int y){
        if(locations[x][y].isOccupied())
            return locations[x][y].getPentomino(); 
        return null;
    }
    
    public void savePreviousLoc(Pentomino pento){
        boolean[][] shape = pento.getShape();
        int rowOnShape = -1;
        int colOnShape = -1;
        int rowOnBoard = -1;
        int colOnBoard = -1;
        
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                if(shape[row][col]){
                    rowOnShape = row;
                    colOnShape = col;
                }
            }
        }
        
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                if(getPentomino(row, col) == pento){
                    rowOnBoard = row;
                    colOnBoard = col;
                }
            }
        }
        
        prevRow = rowOnBoard - rowOnShape;
        prevCol = colOnBoard - colOnShape;  
        prevPento = pento;
    }
    
    public void placePrevPento(){
        placePentomino(prevPento, prevRow, prevCol);
    }
    
    public int getPrevRow(){
        return prevRow;
    }
    
    public int getPrevCol(){
        return prevCol;
    }
    
    //Used in multiplayer
    public void setFromDB(ArrayList<Boolean> newShape, ArrayList<Long> newColor){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < maxCol; j++){
                locations[i][j].setLocation(newShape.get(5 * i + j));
                locations[i][j].setColor(newColor.get(5 * i + j));
            }
        }
    }
    
    public boolean getShape(int row, int col){
        
        return locations[row][col].isOccupied(); 
    }
    
    public Integer getColor(int row, int col){
        return locations[row][col].getColor().getRGB();
    }
    
    //FOR TESTING PURPOSE!!!
    public void print(){
        for(int i = 0; i < 5; i++){
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

    @Override
    public void update() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics g) {
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < maxCol; j++){
                if(!locations[i][j].isOccupied()){
                    g.setColor(this.color);
                    g.fillRect(getX() + j * getDeltaX(), getY() + i * getDeltaY(), getDeltaX(), getDeltaY());
                    g.setColor(Color.black);
                    g.drawRect(getX() + j * getDeltaX(), getY() + i * getDeltaY(), getDeltaX(), getDeltaY());
                    
                }
                else {
                    if(!isOpponent){
                       g.setColor(getPentomino(i, j).getColor());
                    }
                    else {
                        g.setColor(locations[i][j].getColor());
                    }
                    g.fillRect(getX() + j * getDeltaX(), getY() + i * getDeltaY(), getDeltaX(), getDeltaY());
                    g.setColor(Color.black);
                    g.drawRect(getX() + j * getDeltaX(), getY() + i * getDeltaY(), getDeltaX(), getDeltaY());
                }
            }
        }
    }
}