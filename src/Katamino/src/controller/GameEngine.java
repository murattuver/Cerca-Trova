/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.nio.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cerca-Trova
 */
public class GameEngine extends Canvas implements Runnable {

    private static volatile GameEngine gameEngine = null;
    private Thread thread;
    private boolean running = false;
    
    private GameEngine() {
        this.setVisible(true);
    }
    
    public static GameEngine getInstance() {
        if( gameEngine == null) {
            synchronized(GameEngine.class) {
                if(gameEngine == null) {
                    gameEngine = new GameEngine();
                }
            }
        }
        return gameEngine;
    }
    
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        long previousSystemTime = System.nanoTime();
        final int FPS_LOCK = 60; 
        double ns = 1000000000 / FPS_LOCK;
        double interval = 0;
        long timer = System.currentTimeMillis();
        int numberOfFrames = 0;
        
        while(running) {
            long currentSystemTime = System.nanoTime();
            interval = interval + (currentSystemTime - previousSystemTime) / ns;
            previousSystemTime = currentSystemTime;
            
            while(interval >= 1) {
                tick();
                interval--;
            }
            
            if(running){
                render();
            }
            numberOfFrames++;
            
            if(System.currentTimeMillis() - timer > 1000) {
                timer = timer + 1000;
                System.out.println("FPS: " + numberOfFrames);
                numberOfFrames = 0;
            }  
        }
        
        stop();
        
    }
    
    public void tick() {
        
    }
    
    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.dispose();
        bs.show();
    }
    
    public boolean isGameRunning() {
        return running;
    }
    
}
