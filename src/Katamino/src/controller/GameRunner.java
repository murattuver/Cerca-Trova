/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics;
import model.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Cerca-Trova
 */
public class GameRunner {
    
    public static void main(String[] args) {
        
        

        //MainController.getInstance().start();
        

        Pentomino p = new Pentomino();
        Pentomino p2 = new Pentomino();
        Pentomino p3 = new Pentomino();
        Pentomino p4 = new Pentomino();
        Pentomino p5 = new Pentomino();
        
        p.setShape(0, 0, true);
        p.setShape(1, 0, true);
        p.setShape(0, 1, true);
        p.setShape(0, 2, true);
        p.setShape(0, 3, true);
        p.setImgURL("/assets/p.png");
        
        p2.setShape(0, 0, true);
        p2.setShape(0, 1, true);
        p2.setShape(0, 2, true);
        p2.setShape(1, 2, true);
        p2.setShape(2, 2, true);
        p2.setImgURL("/assets/p2.png");
        
        p3.setShape(0, 0, true);
        p3.setShape(0, 1, true);
        p3.setShape(1, 1, true);
        p3.setShape(2, 1, true);
        p3.setShape(2, 2, true);
        p3.setImgURL("/assets/p3.png");
        
        p4.setShape(0,0, true);
        p4.setShape(1,0, true);
        p4.setShape(2,0, true);
        p4.setShape(2,1, true);
        p4.setShape(3,1, true);
        p4.setImgURL("/assets/p4.png");

        p5.setShape(0, 0, true);
        p5.setShape(1, 0, true);
        p5.setShape(1, 1, true);
        p5.setShape(1, 2, true);
        p5.setShape(0, 2, true);
        p5.setImgURL("/assets/p5.png");
        
        p.setX(56);
        p.setY(415);
        
        p2.setX(197);
        p2.setY(415);
        
        p3.setX(338);
        p3.setY(415);
        
        p4.setX(479);
        p4.setY(415);
        
        p5.setX(620);
        p5.setY(415);
        
        p.print();
        System.out.println("");
        p2.print();
                System.out.println("");

        p3.print();
                System.out.println("");

        p4.print();
                System.out.println("");

        p5.print();
                System.out.println("");


        
        List<Pentomino> list = new ArrayList<>();
        
        list.add(p);
        System.out.println("");
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        
        
        
        PentominoesSet pSet = new PentominoesSet(list);
        
        Level level = new Level(pSet, true, 60);
        
        GameManager gm = new GameManager(level);
        
        gm.startGameEngine();
        
       
        //System.out.println("hi");
        
     

        /*
        System.out.println("Board: \n");
        b.print();
        
        System.out.println("Pento: \n");
        p5.print();
        
        //p5.rotate();
        //System.out.println("Pento: \n");
        //p5.print();
        
        b.placePentomino(p5, 0, 0);
        b.placePentomino(p5, 1, 0);
        
        System.out.println("Board status: " + b.isBoardFull());
        
        System.out.println("Board: \n");
        
        b.placePentomino(p5, 2, 0);
        
        System.out.println("Board status: " + b.isBoardFull());
        */

        //b.print();
        
        /*
        Pentomino p1 = new Pentomino(Color.green);
        Pentomino p2 = new Pentomino(Color.blue);
        
        p1.setShape(0, 0, true);
        p1.setShape(0, 1, true);
        p1.setShape(1, 1, true);
        p1.setShape(1, 2, true);
        p1.setShape(1, 3, true);

        p2.setShape(0, 0, true);
        p2.setShape(1, 0, true);
        p2.setShape(1, 1, true);
        p2.setShape(1, 2, true);
        p2.setShape(1, 3, true);
        
        p1.setX(21);
        p1.setY(28);
        p1.setDeltaX(3);
        p1.setDeltaY(3);
        
        p2.setX(42);
        p2.setY(47);
        p2.setDelta(3);
        
        
        List<Pentomino> list = new ArrayList<>();
        
        list.add(p1);
        list.add(p2);
        
        PentominoesSet ps = new PentominoesSet(list);
        
        Level level = new Level(ps, true, 60);
        
        GameManager gm = new GameManager(level);
        gm.initPentominoes();
        Pentomino p3 = gm.getGameObject(43, 48);
        
        p3.print();
       */
        /*
        p1.print();
        System.out.println("");
        p2.print();
        */
        //Level level = new Level();
        //GameManager gm = new GameManager();
        
    }
    
}
