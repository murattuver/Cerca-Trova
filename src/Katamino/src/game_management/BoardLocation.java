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

    public BoardLocation(){
        pento = null;
        isOccupied = false;
    }
    
    public void setPentomino(Pentomino pento){
        this.pento = pento;
        isOccupied = true;
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
    
}
