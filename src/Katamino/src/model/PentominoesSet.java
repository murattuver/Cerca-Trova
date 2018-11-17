/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Murat
 */
public class PentominoesSet {
    private List<Pentomino> pentominoes;
    
    public PentominoesSet(List<Pentomino> set){
        pentominoes = set;
    }
    
    public void addPentomino(Pentomino pent){
        pentominoes.add(pent);
    }
    
    public boolean removePentomino(Pentomino pent){
        if(!pentominoes.contains(pent)){
            System.err.println("Peice is not in the list for remove operation.");
            return false;
        } else {
            pentominoes.remove(pent);
            return true;
        }
    }
}
