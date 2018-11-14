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
        Board b = new Board(4);


        Pentomino p = new Pentomino(Color.yellow);
        Pentomino p2 = new Pentomino(Color.red);
        
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



        System.out.println("Board:");
        b.print();
        System.out.println("Pentomino:");
        p.print();
        System.out.println("Pentomino:");
        p2.print();
        System.out.println();

        b.placePentomino(p, 1, 0);
        System.out.println("Board:");
        b.print();
        
        b.placePentomino(p2, 2, 0);
        System.out.println("Board:");
        b.print();
        System.out.println("Colors: \n");
        b.printColor();
        Pentomino p3 = b.getPentomino(0, 0);
           
        System.out.println(p3.getColor());
        
    }
    
}
