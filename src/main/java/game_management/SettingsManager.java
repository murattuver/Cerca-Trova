/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_management;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author highcsavci
 */
public class SettingsManager {
    private HashMap<String, String> settings = new HashMap<String, String>();
    private String musicStatus;
    private String soundStatus;
    private String themeStatus;
    Properties properties;
    
    public SettingsManager() {
        resetConfig();
    }

    
    public void saveConfig() {
        String musicPre = properties.get("Music").toString();
        String soundPre = properties.get("Sound").toString();
        String themePre = properties.get("Theme").toString();
        if(musicStatus == null) {
            musicStatus = musicPre;
        }
        if(themeStatus == null) {
            themeStatus = themePre;
        }
        if(soundStatus == null) {
            soundStatus = soundPre;
        }
        settings.put("Music", musicStatus);
        settings.put("Sound", soundStatus);
        settings.put("Theme", themeStatus);
        writeToFile();
    }
    
    public void loadConfig() {
        try {
            properties.load(new FileInputStream("cerca.properties"));
            for(String key : properties.stringPropertyNames()) {
                settings.put(key, properties.get(key).toString());
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeToFile() {
        properties = new Properties();
        try {
            for (HashMap.Entry<String, String> entry : settings.entrySet()) {
                properties.put(entry.getKey(), entry.getValue());
            }
            properties.store(new FileOutputStream("cerca.properties"), null);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void resetConfig() {
        settings.put("Music", "ON");
        settings.put("Sound", "ON");
        settings.put("Theme", "Default");
        writeToFile();
    }
    
    public HashMap<String,String> loadSettings() {
        return settings;
    }
    
    public void setMusicStatus(String status) {
        musicStatus = status;
    }
    
    public void setSoundStatus(String status) {
        soundStatus = status;
    }
    
    public void setThemeStatus(String status) {
        themeStatus = status;
    }
}
