/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.*;

/**
 *
 * @author Cerca-Trova
 */
public class MainController {
    
    //reference for the controller.
    private static volatile MainController gameController = null;
    GameFrame gameFrame;
    MainMenuView mainMenu;
    OptionsView optionsView;
    GameEngine gameEngine;
    OutputStream output = null;
    
    //gameOptions with default values in case of the missing config.properties files.
    String resolution = "800 x 600";
    boolean isFullScreen = true;
    boolean isMusicOn = true;
    boolean isSoundsOn = true;
    String theme = "Classic Theme";

    //private constructor for singleton design pattern.
    private MainController() {}
    
    public static MainController getInstance() {
        if( gameController == null) {
            synchronized(MainController.class) {
                if(gameController == null) {
                    gameController = new MainController();
                }
            }
        }
        return gameController;
    }
    
    //This method is Called my the GameRunner which contains the main method.
    public void start() {
        //initializing the mainframe.
        gameFrame = new GameFrame(this.getInstance());
        
        showMainMenu();

    }
    
    public void showMainMenu() {
        mainMenu = new MainMenuView(this.getInstance());
        optionsView = new OptionsView(this.getInstance());
        loadOptions();
        gameFrame.getContentPane().add(mainMenu);
        gameFrame.updateFrame();
    }
    
    //Method that closes the game.
    public void closeGame() {
        if(gameEngine.isGameRunning())
            gameEngine.stopGameEngine();
        gameFrame.dispose();
        System.exit(0);
    }
    
    public void showGameOptions() {
        gameFrame.remove(mainMenu);
        gameFrame.getContentPane().add(optionsView);
        gameFrame.updateFrame();
    }
    
    public void optionsToMainMenu() {
        gameFrame.remove(optionsView);
        gameFrame.add(mainMenu);
        gameFrame.updateFrame();
    }
    
    public void startGame() {
        gameFrame.remove(mainMenu);
        gameFrame.add(gameEngine);
        if(!gameEngine.isGameRunning())
            gameEngine.startGameEngine();
        gameFrame.updateFrame();
    }
    
    public void setFullScreen(boolean toFullScreen) {
        gameFrame.setFullScreen(toFullScreen);
        gameFrame.updateFrame();
    }
    
    public void saveOptions(Properties prop ) {
        
        //Setting internal properties first in case of a change.
        resolution = prop.getProperty("resolution");
        isFullScreen = Boolean.parseBoolean(prop.getProperty("isFullScreen"));
        isMusicOn = Boolean.parseBoolean(prop.getProperty("isMusicOn"));
        isSoundsOn = Boolean.parseBoolean(prop.getProperty("isSoundsOn"));
        theme = prop.getProperty("theme");
        
        //Saving properties to a file.
        try {
            output = new FileOutputStream("config.properties");
            prop.store(output, null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(output != null) {
                try {
                    output.close();
                } catch (IOException err) {
                    err.printStackTrace();
                }
            }
        }
    }
    
    /* Brings data from the local file "config.properties" and sets it to relevant
     * variables. If file does not exit, then it uses default values put in the 
     * decleration.
    */
    public void loadOptions() {
        Properties prop = new Properties();
        InputStream input = null;
        
        //Link list to hold and send variables to the OptionsView.
        LinkedList<String> list = new LinkedList<String>();
        
        //First, getting Options from the local file
        try {
            input = new FileInputStream("config.properties");
            
            prop.load(input);
            
            resolution = prop.getProperty("resolution");
            isFullScreen = Boolean.parseBoolean(prop.getProperty("isFullScreen"));
            isMusicOn = Boolean.parseBoolean(prop.getProperty("isMusicOn"));
            isSoundsOn = Boolean.parseBoolean(prop.getProperty("isSoundsOn"));
            theme = prop.getProperty("theme");
            
            
        } catch (IOException err) {
            err.printStackTrace();
        } finally {
            if(input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        
        //Second, setting values to the OptionsView
        list.add(resolution);
        list.add(isFullScreen + "");
        list.add(isMusicOn + "");
        list.add(isSoundsOn + "");
        list.add(theme);
        
        //local variables are set, now showing them in the view.
        optionsView.setOptionsValues(list);
        gameFrame.updateFrame();
    }
}
