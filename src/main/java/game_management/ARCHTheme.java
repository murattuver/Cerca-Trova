package game_management;

/**
 *
 * @author hp
 */
import game_management.Theme;
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
