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
import javax.sound.sampled.*;

public class SoundManager {
    
    protected AudioInputStream audioIn;
    protected AudioInputStream soundIn;
    protected Clip clip;
    protected Clip clipSound;
    protected Music music;
    protected Sound sound;
    protected long clipTime;
    
    public SoundManager() {
        music = new Music();
        sound = new Sound();
    }
    
    public void play(Theme theme) {
       try {
            File audio = theme.getAudioFile();
            audioIn = AudioSystem.getAudioInputStream(audio.toURI().toURL());
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
       }
       catch(UnsupportedAudioFileException | IOException | LineUnavailableException e) {
           e.printStackTrace();
       }
    }
    
    public void play() {
       try {
            File audio = music.getMainTheme();
            audioIn = AudioSystem.getAudioInputStream(audio.toURI().toURL());
            clip = AudioSystem.getClip();
            clip.start();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
       }
       catch(UnsupportedAudioFileException | IOException | LineUnavailableException e) {
           e.printStackTrace();
       }
    }
    
    public void playSound() {
        try {
            File audio = sound.getMainTheme();
            soundIn = AudioSystem.getAudioInputStream(audio.toURI().toURL());
            clipSound = AudioSystem.getClip();
            clipSound.start();
            clipSound.open(soundIn);    
       }
       catch(UnsupportedAudioFileException | IOException | LineUnavailableException e) {
           e.printStackTrace();
       } 
    }
    
    public void pause() {
        clipTime = clip.getMicrosecondPosition();
        clip.stop();
    }
    
    public void resume() {
        clip.setMicrosecondPosition(clipTime);
        clip.start();
    }
    
    public void stopSound() {
        clipSound.stop();
    }
}
