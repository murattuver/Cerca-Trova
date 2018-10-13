/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.*;

/**
 *
 * @author Murat
 */
public class MainController {
    
    //reference for the controller.
    private static volatile MainController gameController = null;
    GameFrame gameFrame;
    MainMenuView mainMenu;
    OptionsView optionsView;

    //private constructor for singeton design pattern.
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
        
        //Initializng and showing the main menu.
        mainMenu = new MainMenuView(this.getInstance());
        gameFrame.getContentPane().add(mainMenu);
    }
    
    //Method that closes the game.
    public void closeGame() {
        gameFrame.dispose();
    }
    
    public void showGameOptions() {
        optionsView = new OptionsView(this.getInstance());
        gameFrame.remove(mainMenu);
        gameFrame.repaint();
        gameFrame.getContentPane().add(optionsView);
        gameFrame.repaint();
    }
}
