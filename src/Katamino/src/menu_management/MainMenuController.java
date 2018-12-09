/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_management;

import game_management.GameManager;
import menu_interface.MainMenuView;
import menu_interface.LevelScreen;
import menu_interface.OptionsView;
import menu_interface.MenuFrame;
import menu_interface.NumberOfPlayerView;
import menu_interface.GameModeScreen;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import game_management.Level;
import game_management.Pentomino;
import game_management.PentominoesSet;

/**
 *
 * @author murattuver
 */
public class MainMenuController {
    
    private MenuFrame menuFrame;
    private Level level;
    private int numberOfPlayers = 0;
    private String gameMode = "";
    private int levelNo = -1;
    
    public MainMenuController(){
        menuFrame = new MenuFrame();
        menuFrame.add(new MainMenuView(this));
        menuFrame.updateFrame();
    }
    
   public void showView(String type){
       menuFrame.getContentPane().removeAll();

       if(type.equals("mainmenu")){
           menuFrame.getContentPane().add(new MainMenuView(this));
       }
       else if(type.equals("numberofplayer")){
           menuFrame.getContentPane().add(new NumberOfPlayerView(this));
       }
       else if(type.equals("options")){
           menuFrame.getContentPane().add(new OptionsView(this));
       }
       else if(type.equals("gamemode")){
           menuFrame.getContentPane().add(new GameModeScreen(this));
       }
       else if(type.equals("level")){
           menuFrame.getContentPane().add(new LevelScreen(this));

       }
       
       menuFrame.updateFrame();
   }
   
   public void setNumberOfPlayers(int number){
       numberOfPlayers = number;
   }
   
   public void setGameMode(String mode){
       gameMode = mode;
   }
   
   public void setLevelNo(int no){
       levelNo = no;
   }
   
   //Hard coded for now.
   public void initLevel(){
       Pentomino p1 = new Pentomino();
       Pentomino p2 = new Pentomino();
       Pentomino p3 = new Pentomino();
       Pentomino p4 = new Pentomino();
       Pentomino p5 = new Pentomino();
        
       p1.setShape(0, 0, true);
       p1.setShape(1, 0, true);
       p1.setShape(2, 0, true);
       p1.setShape(3, 0, true);
       p1.setShape(3, 1, true);

       p2.setShape(0, 0, true);
       p2.setShape(1, 0, true);
       p2.setShape(2, 0, true);
       p2.setShape(0, 1, true);
       p2.setShape(0, 2, true);
        
       p3.setShape(0, 2, true);
       p3.setShape(1, 0, true);
       p3.setShape(1, 1, true);
       p3.setShape(1, 2, true);
       p3.setShape(2, 0, true);
        
       p4.setShape(1, 0, true);
       p4.setShape(1, 1, true);
       p4.setShape(1, 2, true);
       p4.setShape(0, 2, true);
       p4.setShape(0, 3, true);

       p5.setShape(0, 0, true);
       p5.setShape(0, 1, true);
       p5.setShape(1, 1, true);
       p5.setShape(2, 1, true);
       p5.setShape(2, 0, true);
        
       p1.setX(56);
       p1.setY(415);
       p1.setDefault(56, 415);
       p1.setColor(Color.yellow);
        
       p2.setX(197);
       p2.setY(415);
       p2.setColor(Color.green);
       p2.setDefault(197, 415);
        
       p3.setX(338);
       p3.setY(415);
       p3.setColor(Color.cyan);
       p3.setDefault(338, 415);
        
       p4.setX(479);
       p4.setY(415);
       p4.setColor(Color.magenta);
       p4.setDefault(479, 415);
        
       p5.setX(630);
       p5.setY(415);
       p5.setDefault(630, 415);
        
       List<Pentomino> list = new ArrayList<>();
        
       list.add(p1);
       list.add(p2);
       list.add(p3);
       list.add(p4);
       list.add(p5);
        
       PentominoesSet pSet = new PentominoesSet(list);
        
       level = new Level(pSet, true, -1, 5);
       
       menuFrame.dispose();
       GameManager gm = new GameManager(level);
       gm.startGameEngine();
       
   }
   
   public void closeGame(){
       menuFrame.dispose();
       System.exit(0);
   }
}
