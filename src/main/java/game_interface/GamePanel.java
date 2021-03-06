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
import javax.swing.JLabel;

/**
 *
 * @author Murat
 */
public class GamePanel extends JPanel {
    private float interpolation;
    private List<GameObject> objectsOnScreen;
    private GameManager gameManager;
    
    
    public GamePanel(List<GameObject> objectsList, GameManager gameManager){
        objectsOnScreen = objectsList;
        this.gameManager = gameManager;
       
        setSize(800, 600);
        setPreferredSize(new Dimension(800, 600));
        setLayout(null);
        
        if(gameManager.isMultiplayer()) {
            JLabel your = new JLabel("YOUR BOARD");
            JLabel opponent = new JLabel("OPPONENT'S BOARD");
            your.setBounds(66, 10, 100, 10);
            opponent.setBounds(396, 10, 150, 10);
            this.add(your);
            this.add(opponent);
        }
        setVisible(true);
        repaint();   
    }
    
    
    public void setInterpolation(float interp){
        interpolation = interp;
    }
    

    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(gameManager.getTheme() != null) {
            g.drawImage(gameManager.getTheme().getImageIcon(), 0, 0, null);
        }
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
