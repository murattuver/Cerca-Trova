/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import game_management.GameEngine;
import menu_interface.MainMenuView;
import menu_interface.OptionsView;
import menu_interface.MenuFrame;
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

/**
 *
 * @author Cerca-Trova
 */
public class MainController {
    
    //reference for the controller.
    private static volatile MainController gameController = null;
    MenuFrame menuFrame;
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
        menuFrame = new MenuFrame();
        
        showMainMenu();

    }
    
    public void showMainMenu() {
        //mainMenu = new MainMenuView();
        //optionsView = new OptionsView();
        loadOptions();
        menuFrame.getContentPane().add(mainMenu);
        menuFrame.updateFrame();
    }
    
    //Method that closes the game.
    public void closeGame() {
        if(gameEngine.isGameRunning())
            gameEngine.stopGameEngine();
        menuFrame.dispose();
        System.exit(0);
    }
    
    public void showGameOptions() {
        menuFrame.remove(mainMenu);
        menuFrame.getContentPane().add(optionsView);
        menuFrame.updateFrame();
    }
    
    public void optionsToMainMenu() {
        menuFrame.remove(optionsView);
        menuFrame.add(mainMenu);
        menuFrame.updateFrame();
    }
    
    public void startGame() {
        menuFrame.remove(mainMenu);
        menuFrame.add(gameEngine);
        if(!gameEngine.isGameRunning())
            gameEngine.startGameEngine();
        menuFrame.updateFrame();
    }
    
    public void setFullScreen(boolean toFullScreen) {
        //menuFrame.setFullScreen(toFullScreen);
        menuFrame.updateFrame();
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
        //optionsView.setOptionsValues(list);
        menuFrame.updateFrame();
    }
}

