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
public class METheme extends Theme {
    public METheme(){
        try {
            Image img = ImageIO.read(new File("assets/meTheme.png"));
            File audio = new File("assets/me_sound.wav");
            image = img;
            audioFile = audio;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}