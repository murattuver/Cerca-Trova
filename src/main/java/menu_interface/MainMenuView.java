/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_interface;

import menu_management.MainMenuController;
import view.View;

/**
 *
 * @author Cerca-Trova
 */
public class MainMenuView extends javax.swing.JPanel implements View{

    //Reference of the gameController.
    MainMenuController menuManager = null;
    
    /**
     * Creates new form MainMenuView
     */
    public MainMenuView(MainMenuController gameController) {
        
        this.menuManager = gameController;
        
        //Inilializing the components.
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        playButton = new javax.swing.JButton();
        optionsButton = new javax.swing.JButton();
        leaderBoardButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        exitButton1 = new javax.swing.JButton();
        optionsButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 51, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/sera/Desktop/outside.jpeg")); // NOI18N
        jLabel1.setText("Katamino");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 3, true));

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        playButton.setBackground(java.awt.Color.white);
        playButton.setForeground(new java.awt.Color(0, 0, 0));
        playButton.setText("Play");
        playButton.setToolTipText("");
        playButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, null));
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        add(playButton);
        playButton.setBounds(300, 170, 200, 50);

        optionsButton.setBackground(new java.awt.Color(255, 255, 255));
        optionsButton.setForeground(new java.awt.Color(0, 0, 0));
        optionsButton.setText("Tutorial");
        optionsButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        optionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsButtonActionPerformed(evt);
            }
        });
        add(optionsButton);
        optionsButton.setBounds(300, 240, 200, 50);

        leaderBoardButton.setBackground(new java.awt.Color(255, 255, 255));
        leaderBoardButton.setForeground(new java.awt.Color(0, 0, 0));
        leaderBoardButton.setText("Leaderboard");
        leaderBoardButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        leaderBoardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderBoardButtonActionPerformed(evt);
            }
        });
        add(leaderBoardButton);
        leaderBoardButton.setBounds(300, 310, 200, 50);

        exitButton.setBackground(new java.awt.Color(255, 255, 255));
        exitButton.setForeground(new java.awt.Color(0, 0, 0));
        exitButton.setText("Credits");
        exitButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        add(exitButton);
        exitButton.setBounds(300, 520, 200, 50);

        exitButton1.setBackground(new java.awt.Color(255, 255, 255));
        exitButton1.setForeground(new java.awt.Color(0, 0, 0));
        exitButton1.setText("Exit");
        exitButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton1ActionPerformed(evt);
            }
        });
        add(exitButton1);
        exitButton1.setBounds(300, 450, 200, 50);

        optionsButton1.setBackground(new java.awt.Color(255, 255, 255));
        optionsButton1.setForeground(new java.awt.Color(0, 0, 0));
        optionsButton1.setText("Options");
        optionsButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        optionsButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsButton1ActionPerformed(evt);
            }
        });
        add(optionsButton1);
        optionsButton1.setBounds(300, 380, 200, 50);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 51, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("KATAMINO");
        add(jLabel3);
        jLabel3.setBounds(240, 40, 310, 70);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon("/Users/sera/Desktop/outside.jpeg")); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 3, true));
        add(jLabel5);
        jLabel5.setBounds(150, 20, 470, 110);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/sera/Desktop/backGround.png")); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(0, -40, 800, 640);
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        menuManager.showView("numberofplayer");
    }//GEN-LAST:event_playButtonActionPerformed

    private void optionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsButtonActionPerformed
        //gameController.getInstance().showGameOptions();
    }//GEN-LAST:event_optionsButtonActionPerformed

    private void leaderBoardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderBoardButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leaderBoardButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        //Controller closes the game.
        //gameController.getInstance().closeGame();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void exitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButton1ActionPerformed
        menuManager.closeGame();
    }//GEN-LAST:event_exitButton1ActionPerformed

    private void optionsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsButton1ActionPerformed
        menuManager.showView("options");
    }//GEN-LAST:event_optionsButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JButton exitButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton leaderBoardButton;
    private javax.swing.JButton optionsButton;
    private javax.swing.JButton optionsButton1;
    private javax.swing.JButton playButton;
    // End of variables declaration//GEN-END:variables
}