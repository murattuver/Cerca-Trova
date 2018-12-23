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
public class METheme extends Theme {
    public METheme(){
        ImageIcon img = new ImageIcon("assets/meimage.jpg");
        File audio = new File("assets/me_sound.wav");
        image = img;
        audioFile = audio;
    }
}