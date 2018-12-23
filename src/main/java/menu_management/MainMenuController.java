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
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import menu_interface.CreateLobbyScreen;
import menu_interface.JoinLobbyScreen;
import menu_interface.LoginScreen;
import menu_interface.MultiMenu;
import menu_interface.SignUpScreen;
import network_management.NetworkManager;

/**
 *
 * @author murattuver
 */
public class MainMenuController {
    
    private MenuFrame menuFrame;
    private Level level1, level2, level3, level4, level5,
            level6, level7, level8, level9;
    private int numberOfPlayers = 0;
    private String gameMode = "";
    private int levelNo = -1;
    private NetworkManager network = null;
    private int playerNo;
    private boolean showFrame;
    
    public MainMenuController(boolean showFrame){
        this.showFrame = showFrame;
        
        if(showFrame){
            menuFrame = new MenuFrame();

            menuFrame.add(new MainMenuView(this));
            menuFrame.updateFrame();
        }
        
        
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
       else if(type.equals("login")){
           menuFrame.getContentPane().add(new LoginScreen(this));
       }
       else if(type.equals("signup")){
           menuFrame.getContentPane().add(new SignUpScreen(this));
       }
       else if(type.equals("multimenu")){
           menuFrame.getContentPane().add(new MultiMenu(this));
       }
       else if(type.equals("createlobby")){
           menuFrame.getContentPane().add(new CreateLobbyScreen(this)); 
       }
       else if(type.equals("joinlobby")){
           menuFrame.getContentPane().add(new JoinLobbyScreen(this));
       }
       
       menuFrame.updateFrame();
   }
   
   public void backFromMulti(NetworkManager nm){
       numberOfPlayers = 2;
       this.network = nm;
       playerNo = 0;
       showView("multimenu");
   }
   
   public void backFromSingle(){
   //    numberOfPlayers =
   }
   
   public void initNextLevel(String gMode, int levelNo){
       numberOfPlayers = 1;
       gameMode = gMode;
       this.levelNo = levelNo;
       initLevel();
   }
   
   public void initNetwork(){
       network = new NetworkManager(this);
   }
   
   public void breakNetwork(){
       network = null;
   }
   
   public void startDatabaseListener(){
       network.startDatabaseListener();
   }
   
   public void createLobby(String lobbyName, int level){
       playerNo = 1;
       network.createOnlineGame(lobbyName, level);
       network.startDatabaseListener();
   }
   
   public void destroyLobby(){
       network.destroyOnlineGame();
   }
   
   public void setGameId(String id){
       network.setGameID(id);
   }
   
   public void setMatched(boolean isMatched){
       network.setGameMatched(isMatched);
   }
   
   public void startMultiGame(){
       GameManager gm = initLevel();
       gm.setNetworkManager(network);
       network.setGameManager(gm);
       network.setIsGameStarted(true);
   }
   
   
   public boolean validateUser(String mail, String password){
       return true;
       //return network.fetchUserData(mail, password);

   }
   
   public HashMap<Object,Object> fetchLobbies(){
       return network.getLobbies();
   }
   
   public boolean createUser(String mailAdress, String password, String nickName){
       return network.createAccount(mailAdress, password, nickName);
   }
   
   public void setNumberOfPlayers(int number){
       numberOfPlayers = number;
   }
   
   public MenuFrame getMenuFrame(){
       return menuFrame;
   }
   
   public void setGameMode(String mode){
       gameMode = mode;
   }
   
   public void setPlayerNo(int no){
       playerNo = no;
   }
   
   public void setLevelNo(int no){
       levelNo = no;
   }
   
   
   public GameManager initLevel(){
       
        GameManager gm;
       
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

        pentomino1.setShape(0, 0, true);
        pentomino1.setShape(0, 1, true);
        pentomino1.setShape(0, 2, true);
        pentomino1.setShape(0, 3, true);
        pentomino1.setShape(0, 4, true);
        pentomino1.setColor(Color.red);

        pentomino2.setShape(0, 0, true);
        pentomino2.setShape(1, 0, true);
        pentomino2.setShape(0, 2, true);
        pentomino2.setShape(0, 3, true);
        pentomino2.setShape(0, 1, true);
        pentomino2.setColor(Color.green);

        pentomino3.setShape(0, 0, true);
        pentomino3.setShape(0, 1, true);
        pentomino3.setShape(0, 2, true);
        pentomino3.setShape(0, 3, true);
        pentomino3.setShape(1, 2, true);
        pentomino3.setColor(Color.blue);

        pentomino4.setShape(0, 0, true);
        pentomino4.setShape(0, 1, true);
        pentomino4.setShape(0, 2, true);
        pentomino4.setShape(1, 2, true);
        pentomino4.setShape(1, 3, true);
        pentomino4.setColor(Color.yellow);

        pentomino5.setShape(0, 0, true);
        pentomino5.setShape(0, 1, true);
        pentomino5.setShape(0, 2, true);
        pentomino5.setShape(1, 0, true);
        pentomino5.setShape(2, 0, true);
        pentomino5.setColor(Color.cyan);

        pentomino6.setShape(0, 0, true);
        pentomino6.setShape(0, 1, true);
        pentomino6.setShape(0, 2, true);
        pentomino6.setShape(1, 2, true);
        pentomino6.setShape(1, 1, true);
        pentomino6.setColor(Color.magenta);

        pentomino7.setShape(0, 0, true);
        pentomino7.setShape(0, 1, true);
        pentomino7.setShape(0, 2, true);
        pentomino7.setShape(1, 0, true);
        pentomino7.setShape(1, 2, true);
        pentomino7.setColor(Color.black);

        pentomino8.setShape(0, 0, true);
        pentomino8.setShape(1, 0, true);
        pentomino8.setShape(1, 1, true);
        pentomino8.setShape(1, 2, true);
        pentomino8.setShape(2, 2, true);
        pentomino8.setColor(Color.gray);

        pentomino9.setShape(0, 1, true);
        pentomino9.setShape(0, 2, true);
        pentomino9.setShape(1, 0, true);
        pentomino9.setShape(1, 1, true);
        pentomino9.setShape(2, 1, true);
        pentomino9.setColor(Color.LIGHT_GRAY);

        pentomino10.setShape(0, 0, true);
        pentomino10.setShape(1, 0, true);
        pentomino10.setShape(2, 0, true);
        pentomino10.setShape(1, 2, true);
        pentomino10.setShape(1, 1, true);
        pentomino10.setColor(Color.DARK_GRAY);

        pentomino11.setShape(0, 0, true);
        pentomino11.setShape(0, 1, true);
        pentomino11.setShape(1, 1, true);
        pentomino11.setShape(1, 2, true);
        pentomino11.setShape(2, 2, true);
        pentomino11.setColor(Color.orange);

        pentomino12.setShape(0, 1, true);
        pentomino12.setShape(1, 0, true);
        pentomino12.setShape(1, 1, true);
        pentomino12.setShape(1, 2, true);
        pentomino12.setShape(2, 1, true);
        pentomino12.setColor(Color.pink);

        

        List<Pentomino> list1 = new ArrayList<>();

        list1.add(pentomino2);
        list1.add(pentomino3);
        list1.add(pentomino10);
        list1.add(pentomino6);
        list1.add(pentomino11);

        PentominoesSet pSet1 = new PentominoesSet(list1);
        level1 = new Level(pSet1, true, -1, 5);
            
        List<Pentomino> list2 = new ArrayList<>();
        
                list2.add(pentomino2);
                list2.add(pentomino3);
                list2.add(pentomino5);
                list2.add(pentomino10);
                list2.add(pentomino11);
                list2.add(pentomino8);

                PentominoesSet pSet2 = new PentominoesSet(list2);

                level2 = new Level(pSet2, false, -1, 6);
                
                  List<Pentomino> list3 = new ArrayList<>();

                list3.add(pentomino3);
                list3.add(pentomino5);
                list3.add(pentomino6);
                list3.add(pentomino8);
                list3.add(pentomino11);
                list3.add(pentomino4);
                list3.add(pentomino9);
                PentominoesSet pSet3 = new PentominoesSet(list3);

                level3 = new Level(pSet3, false, -1, 7);
                
                List<Pentomino> list4 = new ArrayList<>();

                list4.add(pentomino2);
                list4.add(pentomino5);
                list4.add(pentomino6);
                list4.add(pentomino7);
                list4.add(pentomino11);
                list4.add(pentomino4);
                list4.add(pentomino3);
                list4.add(pentomino10);

                PentominoesSet pSet4 = new PentominoesSet(list4);

                level4 = new Level(pSet4, false, -1, 8);
                
                 List<Pentomino> list5 = new ArrayList<>();

                list5.add(pentomino2);
                list5.add(pentomino3);
                list5.add(pentomino6);
                list5.add(pentomino7);
                list5.add(pentomino11);
                list5.add(pentomino4);
                list5.add(pentomino5);
                list5.add(pentomino8);
                list5.add(pentomino12);

                PentominoesSet pSet5 = new PentominoesSet(list5);

                level5 = new Level(pSet5, false, -1, 9);
                
                List<Pentomino> list6 = new ArrayList<>();

                list6.add(pentomino2);
                list6.add(pentomino4);
                list6.add(pentomino6);
                list6.add(pentomino10);
                list6.add(pentomino11);
                list6.add(pentomino8);
                list6.add(pentomino5);
                list6.add(pentomino1);
                list6.add(pentomino7);
                list6.add(pentomino3);

                PentominoesSet pSet6 = new PentominoesSet(list6);

                level6 = new Level(pSet6, false, -1, 10);
                
                List<Pentomino> list7 = new ArrayList<>();

                list7.add(pentomino2);
                list7.add(pentomino5);
                list7.add(pentomino6);
                list7.add(pentomino7);
                list7.add(pentomino11);
                list7.add(pentomino3);
                list7.add(pentomino12);
                list7.add(pentomino9);
                list7.add(pentomino8);
                list7.add(pentomino4);
                list7.add(pentomino10);

                PentominoesSet pSet7 = new PentominoesSet(list7);

                level7 = new Level(pSet7, false, -1, 11);
                
                 List<Pentomino> list8 = new ArrayList<>();

                list8.add(pentomino2);
                list8.add(pentomino4);
                list8.add(pentomino6);
                list8.add(pentomino10);
                list8.add(pentomino11);
                list8.add(pentomino8);
                list8.add(pentomino5);
                list8.add(pentomino1);
                list8.add(pentomino7);
                list8.add(pentomino3);
                list8.add(pentomino9);

                PentominoesSet pSet8 = new PentominoesSet(list8);

                level8 = new Level(pSet8, false, -1, 11);
                
                List<Pentomino> list9 = new ArrayList<>();

                list9.add(pentomino1);
                list9.add(pentomino2);
                list9.add(pentomino3);
                list9.add(pentomino4);
                list9.add(pentomino5);
                list9.add(pentomino6);
                list9.add(pentomino7);
                list9.add(pentomino8);
                list9.add(pentomino9);
                list9.add(pentomino10);
                list9.add(pentomino11);
                list9.add(pentomino12);

                PentominoesSet pSet9 = new PentominoesSet(list9);

                level9 = new Level(pSet9, false, -1, 12);
       
        if(numberOfPlayers == 2){
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
            menuFrame.dispose();
            gm = new GameManager("classic", level5, true, 1);
            gm.startGameEngine();
        } 
        
        else{
            
        


        if (levelNo==1 ) {
            
            
            //Level1
        pentomino2.setX(16);
        pentomino2.setY(383);
        pentomino2.setDefault(16, 383);

        pentomino3.setX(172);
        pentomino3.setY(383);
        pentomino3.setDefault(172, 383);

        pentomino10.setX(328);
        pentomino10.setY(383);
        pentomino10.setDefault(328, 383);

        pentomino6.setX(484);
        pentomino6.setY(383);
        pentomino6.setDefault(484, 383);

        pentomino11.setX(640);
        pentomino11.setY(383);
        pentomino11.setDefault(640, 383);
        
            menuFrame.dispose();
            gm = new GameManager("classic", level1, false, 1);
            gm.startGameEngine();
            
            

        } else if (levelNo == 2 && level2.getUnlocked()) {
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
            menuFrame.dispose();
            gm = new GameManager("classic", level2, false, 1);
            gm.startGameEngine();
            
           

        } else if (levelNo == 3 ) {
             //Level 3
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
            menuFrame.dispose();
            gm = new GameManager("classic", level3, false, 1);
            gm.startGameEngine();
           
        } else if (levelNo == 4 && level4.getUnlocked()) {
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
            menuFrame.dispose();
            gm = new GameManager("classic", level4, false, 1);
            gm.startGameEngine();
           
        } else if (levelNo == 5 && level5.getUnlocked()) {
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
            menuFrame.dispose();
            gm = new GameManager("classic", level5, false, 1);
            gm.startGameEngine();
            
        } else if (levelNo == 6 && level6.getUnlocked()) {
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
            menuFrame.dispose();
            gm = new GameManager("classic", level6, false, 1);
            gm.startGameEngine();
           
        } else if (levelNo == 7 && level7.getUnlocked()) {
             //Level 7
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
            menuFrame.dispose();
            gm = new GameManager("classic", level7, false, 1);
            gm.startGameEngine();
            
        } else if (levelNo == 8 && level8.getUnlocked()) {
            //Level 8
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
            menuFrame.dispose();
            gm = new GameManager("classic", level8, false, 1);
            gm.startGameEngine();
            
            
        } else {
            //Level9
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
            menuFrame.dispose();
            gm = new GameManager("classic", level9, false, 1);
            gm.startGameEngine();
            
        }
        
        }
        
       return gm;
   }
   

   
   
   public void closeGame(){
       menuFrame.dispose();
       System.exit(0);
   }
}
