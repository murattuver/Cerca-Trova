/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game_management;

/**
 *
 * @author highcsavci
 */
import game_management.Theme;
import java.awt.Image;
import java.io.*;
import javax.imageio.ImageIO;
public class CSTheme extends Theme {
    public CSTheme(){
        try {
            Image img = ImageIO.read(new File("assets/csTheme.png"));
            File audio = new File("assets/cs_sound.wav");
            image = img;
            audioFile = audio;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
