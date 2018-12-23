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
   
   
   public void initLevel(int levelNo){
       Pentomino pentomino1 = new Pentomino();
       Pentomino pentomino2 = new Pentomino();
       Pentomino pentomino3 = new Pentomino();
       Pentomino pentomino4 = new Pentomino();
       Pentomino pentomino5 = new Pentomino();
       Pentomino pentomino6 = new Pentomino();
       Pentomino pentomino7 = new Pentomino();
       Pentomino pentomino8 = new Pentomino();
       Pentomino pentomino9 = new Pentomino();
       Pentomino pentomino10 = new Pentomino();
       Pentomino pentomino11 = new Pentomino();
       Pentomino pentomino12 = new Pentomino();
       
       pentomino1.setShape(0,0,true);
       pentomino1.setShape(0,1,true);
       pentomino1.setShape(0,2,true);
       pentomino1.setShape(0,3,true);
       pentomino1.setShape(0,4,true);
       pentomino1.setColor(Color.red);
       
       pentomino2.setShape(0,0,true);
       pentomino2.setShape(1,0,true);
       pentomino2.setShape(0,2,true);
       pentomino2.setShape(0,3,true);
       pentomino2.setShape(0,1,true);
       pentomino2.setColor(Color.green);
       
       pentomino3.setShape(0,0,true);
       pentomino3.setShape(0,1,true);
       pentomino3.setShape(0,2,true);
       pentomino3.setShape(0,3,true);
       pentomino3.setShape(1,2,true);
       pentomino3.setColor(Color.blue);
       
       pentomino4.setShape(0,0,true);
       pentomino4.setShape(0,1,true);
       pentomino4.setShape(0,2,true);
       pentomino4.setShape(1,2,true);
       pentomino4.setShape(1,3,true);
       pentomino4.setColor(Color.yellow);
       
       pentomino5.setShape(0,0,true);
       pentomino5.setShape(0,1,true);
       pentomino5.setShape(0,2,true);
       pentomino5.setShape(1,0,true);
       pentomino5.setShape(2,0,true);
       pentomino5.setColor(Color.cyan);
       
       pentomino6.setShape(0,0,true);
       pentomino6.setShape(0,1,true);
       pentomino6.setShape(0,2,true);
       pentomino6.setShape(1,2,true);
       pentomino6.setShape(1,1,true);
       pentomino6.setColor(Color.magenta);
       
       pentomino7.setShape(0,0,true);
       pentomino7.setShape(0,1,true);
       pentomino7.setShape(0,2,true);
       pentomino7.setShape(1,0,true);
       pentomino7.setShape(1,2,true);
       pentomino7.setColor(Color.black);
       
       pentomino8.setShape(0,0,true);
       pentomino8.setShape(1,0,true);
       pentomino8.setShape(1,1,true);
       pentomino8.setShape(1,2,true);
       pentomino8.setShape(2,2,true);
       pentomino8.setColor(Color.gray);
       
       pentomino9.setShape(0,1,true);
       pentomino9.setShape(0,2,true);
       pentomino9.setShape(1,0,true);
       pentomino9.setShape(1,1,true);
       pentomino9.setShape(2,1,true);
       pentomino9.setColor(Color.LIGHT_GRAY);
       
       pentomino10.setShape(0,0,true);
       pentomino10.setShape(1,0,true);
       pentomino10.setShape(2,0,true);
       pentomino10.setShape(1,2,true);
       pentomino10.setShape(1,1,true);
       pentomino10.setColor(Color.DARK_GRAY);
       
       pentomino11.setShape(0,0,true);
       pentomino11.setShape(0,1,true);
       pentomino11.setShape(1,1,true);
       pentomino11.setShape(1,2,true);
       pentomino11.setShape(2,2,true);
       pentomino11.setColor(Color.orange);
       
       pentomino12.setShape(0,1,true);
       pentomino12.setShape(1,0,true);
       pentomino12.setShape(1,1,true);
       pentomino12.setShape(1,2,true);
       pentomino12.setShape(2,1,true);
       pentomino12.setColor(Color.pink);     
       
       if(levelNo == 1){
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
       else if(levelNo == 2){
           
           //x 156 artıyor
           
            pentomino2.setX(16);
            pentomino2.setY(283);
            pentomino2.setDefault(16, 283);
            
            pentomino3.setX(172);
            pentomino3.setY(283);
            pentomino3.setDefault(172, 283);

            pentomino5.setX(328);
            pentomino5.setY(283);
            pentomino5.setDefault(328, 283);

            pentomino10.setX(484);
            pentomino10.setY(283);
            pentomino10.setDefault(484, 283);

            pentomino11.setX(640);
            pentomino11.setY(283);
            pentomino11.setDefault(640, 283);
            
            pentomino8.setX(16);
            pentomino8.setY(441);
            pentomino8.setDefault(16, 441);
            
            List<Pentomino> list = new ArrayList<>();

            list.add(pentomino2);
            list.add(pentomino3);
            list.add(pentomino5);
            list.add(pentomino10);
            list.add(pentomino11);
            list.add(pentomino8);
            
            PentominoesSet pSet = new PentominoesSet(list);

            level = new Level(pSet, true, -1, 6);

            menuFrame.dispose();
            GameManager gm = new GameManager(level);
            gm.startGameEngine();
           
       }
       else if(levelNo == 3){
            pentomino3.setX(16);
            pentomino3.setY(283);
            pentomino3.setDefault(16, 283);
            
            pentomino5.setX(172);
            pentomino5.setY(283);
            pentomino5.setDefault(172, 283);

            pentomino6.setX(328);
            pentomino6.setY(283);
            pentomino6.setDefault(328, 283);

            pentomino8.setX(484);
            pentomino8.setY(283);
            pentomino8.setDefault(484, 283);

            pentomino11.setX(640);
            pentomino11.setY(283);
            pentomino11.setDefault(640, 283);
            
            pentomino4.setX(16);
            pentomino4.setY(441);
            pentomino4.setDefault(16, 441);
            
            pentomino9.setX(172);
            pentomino9.setY(441);
            pentomino9.setDefault(172, 441);
            
            List<Pentomino> list = new ArrayList<>();

            list.add(pentomino3);
            list.add(pentomino5);
            list.add(pentomino6);
            list.add(pentomino8);
            list.add(pentomino11);
            list.add(pentomino4);
            list.add(pentomino9);
            PentominoesSet pSet = new PentominoesSet(list);

            level = new Level(pSet, true, -1, 7);

            menuFrame.dispose();
            GameManager gm = new GameManager(level);
            gm.startGameEngine();        
       }
       else if(levelNo == 4){
            pentomino2.setX(16);
            pentomino2.setY(283);
            pentomino2.setDefault(16, 283);
            
            pentomino5.setX(172);
            pentomino5.setY(283);
            pentomino5.setDefault(172, 283);

            pentomino6.setX(328);
            pentomino6.setY(283);
            pentomino6.setDefault(328, 283);

            pentomino7.setX(484);
            pentomino7.setY(283);
            pentomino7.setDefault(484, 283);

            pentomino11.setX(640);
            pentomino11.setY(283);
            pentomino11.setDefault(640, 283);
            
            pentomino4.setX(16);
            pentomino4.setY(441);
            pentomino4.setDefault(16, 441);
            
            pentomino3.setX(172);
            pentomino3.setY(441);
            pentomino3.setDefault(172, 441);
            
            pentomino10.setX(328);
            pentomino10.setY(441);
            pentomino10.setDefault(328, 441);
            
            List<Pentomino> list = new ArrayList<>();

            list.add(pentomino2);
            list.add(pentomino5);
            list.add(pentomino6);
            list.add(pentomino7);
            list.add(pentomino11);
            list.add(pentomino4);
            list.add(pentomino3);
            list.add(pentomino10);
            
            PentominoesSet pSet = new PentominoesSet(list);

            level = new Level(pSet, true, -1, 8);

            menuFrame.dispose();
            GameManager gm = new GameManager(level);
            gm.startGameEngine();        
       }
       else if(levelNo == 5){
            pentomino2.setX(16);
            pentomino2.setY(283);
            pentomino2.setDefault(16, 283);
            
            pentomino3.setX(172);
            pentomino3.setY(283);
            pentomino3.setDefault(172, 283);

            pentomino6.setX(328);
            pentomino6.setY(283);
            pentomino6.setDefault(328, 283);

            pentomino11.setX(484);
            pentomino11.setY(283);
            pentomino11.setDefault(484, 283);

            pentomino7.setX(640);
            pentomino7.setY(283);
            pentomino7.setDefault(640, 283);
            
            pentomino4.setX(16);
            pentomino4.setY(441);
            pentomino4.setDefault(16, 441);
            
            pentomino5.setX(172);
            pentomino5.setY(441);
            pentomino5.setDefault(172, 441);
            
            pentomino8.setX(328);
            pentomino8.setY(441);
            pentomino8.setDefault(328, 441);
            
            pentomino12.setX(484);
            pentomino12.setY(441);
            pentomino12.setDefault(484, 441);
            
            List<Pentomino> list = new ArrayList<>();

            list.add(pentomino2);
            list.add(pentomino3);
            list.add(pentomino6);
            list.add(pentomino7);
            list.add(pentomino11);
            list.add(pentomino4);
            list.add(pentomino5);
            list.add(pentomino8);
            list.add(pentomino12);
            
            PentominoesSet pSet = new PentominoesSet(list);

            level = new Level(pSet, true, -1, 9);

            menuFrame.dispose();
            GameManager gm = new GameManager(level);
            gm.startGameEngine();        
       }
       else if(levelNo == 6){
            pentomino2.setX(16);
            pentomino2.setY(283);
            pentomino2.setDefault(16, 283);
            
            pentomino4.setX(172);
            pentomino4.setY(283);
            pentomino4.setDefault(172, 283);

            pentomino6.setX(328);
            pentomino6.setY(283);
            pentomino6.setDefault(328, 283);

            pentomino10.setX(484);
            pentomino10.setY(283);
            pentomino10.setDefault(484, 283);

            pentomino11.setX(640);
            pentomino11.setY(283);
            pentomino11.setDefault(640, 283);
            
            pentomino8.setX(16);
            pentomino8.setY(441);
            pentomino8.setDefault(16, 441);
            
            pentomino5.setX(172);
            pentomino5.setY(441);
            pentomino5.setDefault(172, 441);
            
            pentomino1.setX(308);
            pentomino1.setY(441);
            pentomino1.setDefault(308, 441);
            
            pentomino7.setX(509);
            pentomino7.setY(441);
            pentomino7.setDefault(509, 441);
            
            pentomino3.setX(640);
            pentomino3.setY(441);
            pentomino3.setDefault(640, 441);
            
            List<Pentomino> list = new ArrayList<>();

            list.add(pentomino2);
            list.add(pentomino4);
            list.add(pentomino6);
            list.add(pentomino10);
            list.add(pentomino11);
            list.add(pentomino8);
            list.add(pentomino5);
            list.add(pentomino1);
            list.add(pentomino7);
            list.add(pentomino3);
            
            PentominoesSet pSet = new PentominoesSet(list);

            level = new Level(pSet, true, -1, 10);

            menuFrame.dispose();
            GameManager gm = new GameManager(level);
            gm.startGameEngine();        
       }
       else if(levelNo == 7){
            pentomino2.setX(16);
            pentomino2.setY(283);
            pentomino2.setDefault(16, 283);
            
            pentomino5.setX(172);
            pentomino5.setY(283);
            pentomino5.setDefault(172, 283);

            pentomino6.setX(328);
            pentomino6.setY(283);
            pentomino6.setDefault(328, 283);

            pentomino7.setX(484);
            pentomino7.setY(283);
            pentomino7.setDefault(484, 283);

            pentomino11.setX(640);
            pentomino11.setY(283);
            pentomino11.setDefault(640, 283);
            
            pentomino3.setX(16);
            pentomino3.setY(441);
            pentomino3.setDefault(16, 441);
            
            pentomino12.setX(172);
            pentomino12.setY(441);
            pentomino12.setDefault(172, 441);
            
            pentomino9.setX(308);
            pentomino9.setY(441);
            pentomino9.setDefault(308, 441);
            
            pentomino8.setX(509);
            pentomino8.setY(441);
            pentomino8.setDefault(509, 441);
            
            pentomino4.setX(640);
            pentomino4.setY(441);
            pentomino4.setDefault(640, 441);
            
            //to do yerini hesapla
            pentomino10.setX(456);
            pentomino10.setY(125);
            pentomino10.setDefault(456, 125);
            
            List<Pentomino> list = new ArrayList<>();

            list.add(pentomino2);
            list.add(pentomino5);
            list.add(pentomino6);
            list.add(pentomino7);
            list.add(pentomino11);
            list.add(pentomino3);
            list.add(pentomino12);
            list.add(pentomino9);
            list.add(pentomino8);
            list.add(pentomino4);
            list.add(pentomino10);
            
            PentominoesSet pSet = new PentominoesSet(list);

            level = new Level(pSet, true, -1, 11);

            menuFrame.dispose();
            GameManager gm = new GameManager(level);
            gm.startGameEngine();        
       }
       else if(levelNo == 8){
            pentomino2.setX(16);
            pentomino2.setY(283);
            pentomino2.setDefault(16, 283);
            
            pentomino4.setX(172);
            pentomino4.setY(283);
            pentomino4.setDefault(172, 283);

            pentomino6.setX(328);
            pentomino6.setY(283);
            pentomino6.setDefault(328, 283);

            pentomino10.setX(484);
            pentomino10.setY(283);
            pentomino10.setDefault(484, 283);

            pentomino11.setX(640);
            pentomino11.setY(283);
            pentomino11.setDefault(640, 283);
            
            pentomino8.setX(16);
            pentomino8.setY(441);
            pentomino8.setDefault(16, 441);
            
            pentomino5.setX(172);
            pentomino5.setY(441);
            pentomino5.setDefault(172, 441);
            
            pentomino1.setX(308);
            pentomino1.setY(441);
            pentomino1.setDefault(308, 441);
            
            pentomino7.setX(509);
            pentomino7.setY(441);
            pentomino7.setDefault(509, 441);
            
            pentomino3.setX(640);
            pentomino3.setY(441);
            pentomino3.setDefault(640, 441);
            
            
            pentomino9.setX(456);
            pentomino9.setY(125);
            pentomino9.setDefault(456, 125);
            
            List<Pentomino> list = new ArrayList<>();

            list.add(pentomino2);
            list.add(pentomino4);
            list.add(pentomino6);
            list.add(pentomino10);
            list.add(pentomino11);
            list.add(pentomino8);
            list.add(pentomino5);
            list.add(pentomino1);
            list.add(pentomino7);
            list.add(pentomino3);
            list.add(pentomino9);
            
            PentominoesSet pSet = new PentominoesSet(list);

            level = new Level(pSet, true, -1, 11);

            menuFrame.dispose();
            GameManager gm = new GameManager(level);
            gm.startGameEngine();        
       }
       else{
           
            pentomino1.setX(16);
            pentomino1.setY(283);
            pentomino1.setDefault(16, 283);
            
            pentomino2.setX(172);
            pentomino2.setY(283);
            pentomino2.setDefault(172, 283);

            pentomino3.setX(328);
            pentomino3.setY(283);
            pentomino3.setDefault(328, 283);

            pentomino4.setX(484);
            pentomino4.setY(283);
            pentomino4.setDefault(484, 283);

            pentomino5.setX(640);
            pentomino5.setY(283);
            pentomino5.setDefault(640, 283);
            
            pentomino6.setX(16);
            pentomino6.setY(441);
            pentomino6.setDefault(16, 441);
            
            pentomino7.setX(172);
            pentomino7.setY(441);
            pentomino7.setDefault(172, 441);
            
            pentomino8.setX(308);
            pentomino8.setY(441);
            pentomino8.setDefault(308, 441);
            
            pentomino9.setX(509);
            pentomino9.setY(441);
            pentomino9.setDefault(509, 441);
            
            pentomino10.setX(640);
            pentomino10.setY(441);
            pentomino10.setDefault(640, 441);
            
            //to do yerini hesapla
            pentomino11.setX(486);
            pentomino11.setY(125);
            pentomino11.setDefault(486, 125);
            
            pentomino12.setX(647);
            pentomino12.setY(125);
            pentomino12.setDefault(647, 125);
            
            List<Pentomino> list = new ArrayList<>();

            list.add(pentomino1);
            list.add(pentomino2);
            list.add(pentomino3);
            list.add(pentomino4);
            list.add(pentomino5);
            list.add(pentomino6);
            list.add(pentomino7);
            list.add(pentomino8);
            list.add(pentomino9);
            list.add(pentomino10);
            list.add(pentomino11);
            list.add(pentomino12);
            
            PentominoesSet pSet = new PentominoesSet(list);

            level = new Level(pSet, true, -1, 12);

            menuFrame.dispose();
            GameManager gm = new GameManager(level);
            gm.startGameEngine();        
       }
       }
           
      public void closeGame(){
       menuFrame.dispose();
       //System.exit(0);
   }     
   }

 

