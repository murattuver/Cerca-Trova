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
import java.io.*;
import javax.swing.*;
public class CSTheme extends Theme {
    public CSTheme(){
        ImageIcon img = new ImageIcon("assets/csimage.jpg");
        File audio = new File("assets/cs_sound.wav");
        image = img;
        audioFile = audio;
    }
}
