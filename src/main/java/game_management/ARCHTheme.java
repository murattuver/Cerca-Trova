/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_management;

/**
 *
 * @author hp
 */
import java.io.*;
import javax.swing.*;
public class ARCHTheme extends Theme {
    public ARCHTheme(){
        ImageIcon img = new ImageIcon("assets/archimage.jpg");
        File audio = new File("assets/arch_sound.wav");
        image = img;
        audioFile = audio;
    }
}
