package game_management;

/**
 *
 * @author hp
 */
import java.io.*;
import java.awt.Image;
import javax.imageio.ImageIO;

public class ARCHTheme extends Theme {
    public ARCHTheme(){
        try {
            Image img = ImageIO.read(new File("assets/archTheme.png"));
            File audio = new File("assets/arch_sound.wav");
            image = img;
            audioFile = audio;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
