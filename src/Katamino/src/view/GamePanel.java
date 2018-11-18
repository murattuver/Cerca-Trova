/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;
import model.GameObject;

/**
 *
 * @author Murat
 */
public class GamePanel extends JPanel implements View {
    private float interpolation;
    private List<GameObject> objectsOnScreen;
    
    public GamePanel(List<GameObject> objectsList){
        objectsOnScreen = objectsList;
    }
    
    
    public void setInterpolation(float interp){
        interpolation = interp;
    }
    
    public void paintComponents(Graphics g){
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
