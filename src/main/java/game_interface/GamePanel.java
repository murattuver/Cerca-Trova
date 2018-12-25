/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_interface;

import game_management.GameManager;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;
import game_management.GameObject;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import view.View;

/**
 *
 * @author Murat
 */
public class GamePanel extends JPanel implements View {
    private float interpolation;
    private List<GameObject> objectsOnScreen;
    private GameManager gameManager;
    
    
    public GamePanel(List<GameObject> objectsList, GameManager gameManager){
        objectsOnScreen = objectsList;
        this.gameManager = gameManager;

        setSize(800, 600);
        setPreferredSize(new Dimension(800, 600));
        
        setVisible(true);
        repaint();   
    }
    
    
    public void setInterpolation(float interp){
        interpolation = interp;
    }
    

    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int i = 0; i < objectsOnScreen.size(); i++){
            objectsOnScreen.get(i).draw(g);
        }
        
    }
    
    public void update(){
        for(int i = 0; i < objectsOnScreen.size(); i++){
            objectsOnScreen.get(i).update();
        }
    }
}
