/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
import javax.swing.JFrame;

/**
 *
 * @author Murat
 */
public class GameFrame extends JFrame {
    
    final int WIDTH = 800;
    final int HEIGHT = 600;
    //final String GAME_NAME = "Katamino";
    //final String LAYOUT = "";
    
    public GameFrame(MainController gameController) {
        //super(GAME_NAME, LAYOUT);
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(WIDTH, HEIGHT);
        setDefaultLookAndFeelDecorated(true);

        //setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //setUndecorated(true);
        
        setVisible(true);
        
    }
    
    
}
