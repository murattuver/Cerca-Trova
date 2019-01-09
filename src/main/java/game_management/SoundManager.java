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
    protected AudioInputStream themeIn;
    protected Clip clip;
    protected Clip clipSound;
    protected Clip clipTheme;
    protected Music music;
    protected Sound sound;
    protected long clipTime;
    private boolean soundIsOff;
    private boolean musicIsOff;
    private boolean themeIsOff;
    
    public SoundManager() {
        soundIsOff = false;
        musicIsOff = false;
        themeIsOff = true;
        music = new Music();
        sound = new Sound();
        try {
            File audio = music.getMainTheme();
            audioIn = AudioSystem.getAudioInputStream(audio.toURI().toURL());
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        }
        catch(UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    public void play(Theme theme) {
       if(theme != null) {
           try {
               File audio = theme.getAudioFile();
               themeIn = AudioSystem.getAudioInputStream(audio.toURI().toURL());
               clipTheme = AudioSystem.getClip();
               clipTheme.open(themeIn);
               clipTheme.start();
               clipTheme.loop(Clip.LOOP_CONTINUOUSLY);
               
           } 
           catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
               e.printStackTrace();
           }
       } 
    }
    
    public void play() {
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void playSound() {
        if (!soundIsOff) {
            try {
                File audioSound = sound.getMainTheme();
                soundIn = AudioSystem.getAudioInputStream(audioSound.toURI().toURL());
                clipSound = AudioSystem.getClip();
                clipSound.open(soundIn);
                clipSound.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
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
    
    public void closeMusic() {
        musicIsOff = true;
        clip.stop();
    }
    
    public void resetMusic() {
        clip.flush();
        clip.setFramePosition(0);
        clip.start();
    } 
    
    public void closeThemeMusic() {
        themeIsOff = true;
        clipTheme.stop();
    }
    
    public void stopSound() {
        clipSound.stop();
    }
    
    public void setClosed(boolean isSound) {
        soundIsOff = isSound;
    }
    
    public void setMusicClosed(boolean isMusic) {
        musicIsOff = isMusic;
    }
    
    public void setThemeMusicClosed(boolean isTheme) {
        themeIsOff = isTheme;
    }
    
    public boolean getMusicClosed() {
        return musicIsOff;
    }
    
    public boolean getThemeMusicClosed() {
        return themeIsOff;
    }
}