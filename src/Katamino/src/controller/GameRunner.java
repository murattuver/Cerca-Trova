/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import model.*;
import view.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Cerca-Trova
 */
public class GameRunner {
    
    public static void main(String[] args) {
        
        Pentomino p1 = new Pentomino();
        Pentomino p2 = new Pentomino();
        Pentomino p3 = new Pentomino();
        Pentomino p4 = new Pentomino();
        Pentomino p5 = new Pentomino();
        
        p1.setShape(0, 0, true);
        p1.setShape(1, 0, true);
        p1.setShape(2, 0, true);
        p1.setShape(3, 0, true);
        p1.setShape(3, 1, true);

        p2.setShape(0, 0, true);
        p2.setShape(1, 0, true);
        p2.setShape(2, 0, true);
        p2.setShape(0, 1, true);
        p2.setShape(0, 2, true);
        
        p3.setShape(0, 2, true);
        p3.setShape(1, 0, true);
        p3.setShape(1, 1, true);
        p3.setShape(1, 2, true);
        p3.setShape(2, 0, true);
        
        p4.setShape(1, 0, true);
        p4.setShape(1, 1, true);
        p4.setShape(1, 2, true);
        p4.setShape(0, 2, true);
        p4.setShape(0, 3, true);

        p5.setShape(0, 0, true);
        p5.setShape(0, 1, true);
        p5.setShape(1, 1, true);
        p5.setShape(2, 1, true);
        p5.setShape(2, 0, true);
        
        p1.setX(56);
        p1.setY(415);
        p1.setDefault(56, 415);
        p1.setColor(Color.yellow);
        
        p2.setX(197);
        p2.setY(415);
        p2.setColor(Color.green);
        p2.setDefault(197, 415);
        
        p3.setX(338);
        p3.setY(415);
        p3.setColor(Color.cyan);
        p3.setDefault(338, 415);
        
        p4.setX(479);
        p4.setY(415);
        p4.setColor(Color.magenta);
        p4.setDefault(479, 415);
        
        p5.setX(630);
        p5.setY(415);
        p5.setDefault(630, 415);
        
        List<Pentomino> list = new ArrayList<>();
        
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        
        PentominoesSet pSet = new PentominoesSet(list);
        
        Level level = new Level(pSet, true, 60, 5);
        
        MainMenuController menuC = new MainMenuController();
        
        MainMenuView mw = new MainMenuView(menuC);
        
        
        //GameManager gm = new GameManager(level);
        
        //gm.startGameEngine();
    }
    
}
