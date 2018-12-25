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
import java.io.*;
import javax.swing.*;
public class MANTheme extends Theme {
    public MANTheme(){
        ImageIcon img = new ImageIcon("assets/manimage.jpg");
        File audio = new File("assets/man_sound.wav");
        image = img;
        audioFile = audio;
    }
}
