/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_management;


import game_interface.GamePanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/**
 *
 * @author Cerca-Trova
 */
public class GameEngine extends JFrame {
    
    protected GameManager gameManager;
    protected GamePanel gamePanel;
    protected boolean running = false;
    protected boolean paused = false;
    protected int fps = 60;
    protected int frameCount = 0;
    protected int width = 800;
    protected int height = 600;

    
    public GameEngine(GamePanel gamePanel, GameManager gm){
        super("Katamino");
        gameManager = gm;
        this.gamePanel = gamePanel;
        JButton exitButton = new JButton("Exit");
        
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        add(gamePanel, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_START; //bottom of space
        c.insets = new Insets(50,500,0,50);  //top padding
        c.gridx = 0;      //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 0;       //third row
        this.add(exitButton, c);

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });


        //setUndecorated(true);
        
        MouseAdapter mAdap = new MouseAdapter() { 
            
            @Override
            public void mouseDragged(MouseEvent e) {
                if(gameManager.getSelected()){
                    gameManager.dragPentomino(e.getX(), e.getY());
                    gameManager.setInitialPoints(e.getX(), e.getY());
                }
            } 
            
            @Override
            public void mousePressed(MouseEvent e){
               System.out.println("x" + e.getX());
               System.out.println("y" + e.getY());
                gamePanel.requestFocusInWindow();
                
            
                gameManager.setInitialPoints(e.getX(), e.getY());
                gameManager.setSelected(true, e.getX(), e.getY());
                System.out.println("x from e: " + e.getX());
                System.out.println("y from e: " + e.getY());
                
            }
            
            @Override
            public void mouseReleased(MouseEvent e){
              
                gameManager.checkOnBoard(e.getX(), e.getY());
                gameManager.setSelected(false, e.getX(), e.getY());
                
            }
        };
        
        KeyAdapter kAdap = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_R && gameManager.getSelected()){
                    System.out.println("R pressed.");
                    gameManager.rotateSelected();
                } else if(e.getKeyCode() == KeyEvent.VK_T && gameManager.getSelected()){
                    gameManager.symSelected();
                    System.out.println("T Pressed.");
                }
            }
        };

        
        this.setSize(width, height);
        pack();
        setVisible(true);
        
        //this.setResizable(false);
        
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();
        
        gamePanel.addMouseListener(mAdap);
        gamePanel.addMouseMotionListener(mAdap);
        gamePanel.addKeyListener(kAdap);
        repaint();
        
 
    }
    
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        gameManager.getMenuController().getSoundManager().playSound();
        Object[] options = {"I Quit", "I Can Do This"};
        int n = JOptionPane.showOptionDialog((JFrame)SwingUtilities.windowForComponent(this),
        "Do you really want to quit? ",
        "Are You Sure?",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,     //do not use a custom Icon
        options,  //the titles of buttons
        options[1]); //default button title
        
        if(n == 0){
            gameManager.getMenuController().getSoundManager().setMusicClosed(false);
            gameManager.getMenuController().getSoundManager().playSound();
            gameManager.terminateSingleGame();
            if(gameManager.getTheme() != null) {
                System.out.println(gameManager.getTheme());
                gameManager.getMenuController().getSoundManager().closeThemeMusic();
                gameManager.getMenuController().getSoundManager().resetMusic();
            }
        }
        else {
            gameManager.getMenuController().getSoundManager().playSound();
        }
    }

    public void startGameEngine(){
        running = true;
        Thread loop = new Thread() { 
            public void run(){
                gameLoop();
            }
        };
        
        loop.start();
    }
    
    private void gameLoop(){
        final double GAME_HERTZ = 30.0;
        final double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;
        final int MAX_UPDATES_BEFORE_RENDER = 5;
        double lastUpdateTime = System.nanoTime();
        double lastRenderTime = System.nanoTime();
        final double TARGET_FPS = 60;
        final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;
        
        int lastSecondTime = (int) (lastUpdateTime / 1000000000);
        
        while(running){
            double now = System.nanoTime();
            int updateCount = 0;
         
            if (!paused){
                while(now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER){
                    updateGame();
                    lastUpdateTime += TIME_BETWEEN_UPDATES;
                    updateCount++;
                }
            }
            
            //If for some reason an update takes forever, we don't want to do an insane number of catchups.
            if ( now - lastUpdateTime > TIME_BETWEEN_UPDATES){
                lastUpdateTime = now - TIME_BETWEEN_UPDATES;
            }
            
            //Render. To do so, we need to calculate interpolation for a smooth render.
            float interpolation = Math.min(1.0f, (float) ((now - lastUpdateTime) / TIME_BETWEEN_UPDATES) );
            drawGame(interpolation);
            lastRenderTime = now;
            
            //Update the fraes got so far.
            int thisSecond = (int) (lastUpdateTime / 1000000000);
            if (thisSecond > lastSecondTime){
                //System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
                fps = frameCount;
                frameCount = 0;
                lastSecondTime = thisSecond;
            }
            
            //Yield until it has been at least the target time between renders. This saves the CPU from hogging.
            while ( now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS && now - lastUpdateTime < TIME_BETWEEN_UPDATES){
                Thread.yield();
            
                //This stops the app from consuming all your CPU. It makes this slightly less accurate, but is worth it.
                //You can remove this line and it will still work (better), your CPU just climbs on certain OSes.
                //FYI on some OS's this can cause pretty bad stuttering. Scroll down and have a look at different peoples' solutions to this.
                try {Thread.sleep(1);} catch(Exception e) {} 
            
                now = System.nanoTime();
            }
        }
        
    }
    
    public void drawGame(float interpolation){
        gamePanel.setInterpolation(interpolation);
        gamePanel.repaint();
        frameCount++;
    }
    
    public void updateGame(){
        gamePanel.update();
    }
    
    public boolean isGameRunning(){
        return running;
    }
    
    public void stopGameEngine(){
        running = false;
        dispose();
    }
    
}
