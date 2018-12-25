/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_management;

import java.io.File;

/**
 *
 * @author highcsavci
 */
public class Sound {
    protected File mainMenuMusic = new File("assets/click.wav");
    public File getMainTheme() {
        return mainMenuMusic;
    }
}
