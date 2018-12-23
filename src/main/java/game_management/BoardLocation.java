/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_management;

import java.awt.Color;

/**
 *
 * @author Murat
 */
public class BoardLocation {
    private boolean isOccupied;
    private Pentomino pento;
    
    //only used in multiplayer
    private Color color = new Color(0);

    public BoardLocation(){
        pento = null;
        isOccupied = false;
    }
    
    public void setPentomino(Pentomino pento){
        this.pento = pento;
        isOccupied = true;
        color = pento.getColor();
    }
    
    public void removePentomino(){
        pento = null;
        isOccupied = false;
    }
    
    public boolean isOccupied(){
        return isOccupied;
    }
    
    public Pentomino getPentomino(){
        return pento;
    }
    
    public void setLocation(boolean state){
        isOccupied = state;
        
    }
    
    public void setColor(long rgb){
        color = new Color((int)rgb);
    }
    
    public Color getColor(){
        return color;
    }
    
}
