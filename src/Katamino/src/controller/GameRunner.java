/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import model.*;

/**
 *
 * @author Cerca-Trova
 */
public class GameRunner {
    
    public static void main(String[] args) {
        // MainController.getInstance().start();
        Board b = new Board(3);


        Pentomino p = new Pentomino(Color.yellow);
        Pentomino p2 = new Pentomino(Color.red);
        Pentomino p3 = new Pentomino(Color.blue);
        Pentomino p4 = new Pentomino(Color.orange);
        Pentomino p5 = new Pentomino(Color.cyan);
        
        p.setShape(0, 0, true);
        p.setShape(1, 0, true);
        p.setShape(0, 1, true);
        p.setShape(0, 2, true);
        p.setShape(0, 3, true);
        
        p2.setShape(0, 1, true);
        p2.setShape(1, 0, true);
        p2.setShape(1, 1, true);
        p2.setShape(1, 2, true);
        p2.setShape(1, 3, true);
        
        p3.setShape(0, 1, true);
        p3.setShape(1, 1, true);
        p3.setShape(2, 1, true);
        p3.setShape(3, 1, true);
        p3.setShape(3, 0, true);
        
        p4.setShape(0,0, true);
        p4.setShape(1,0, true);
        p4.setShape(1,1, true);
        p4.setShape(1,2, true);
        p4.setShape(2,2, true);

        p5.setShape(0, 0, true);
        p5.setShape(0, 1, true);
        p5.setShape(0, 2, true);
        p5.setShape(0, 3, true);
        p5.setShape(0, 4, true);

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


        b.print();

        
    }
    
}
