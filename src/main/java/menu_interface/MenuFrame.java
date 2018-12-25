/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_interface;

import controller.MainController;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Cerca-Trova
 */
public class MenuFrame extends JFrame {
    
    int width = 800;
    int height = 600;
    
    public MenuFrame() {
        
        super("Katamino");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(width, height);
        
        setLocationRelativeTo(null);
        
        setVisible(true);
        
    }
    
    //Makes frame full screen.
    public void setFullScreen(boolean toFullScreen) {
        if(toFullScreen) {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setResizable(false);
            
        } else {
            setSize(width, height);
            

        }
    }
    
    //Repaints frames all components.
    public void updateFrame() {
        revalidate();
        repaint(); 
    }
    
}
