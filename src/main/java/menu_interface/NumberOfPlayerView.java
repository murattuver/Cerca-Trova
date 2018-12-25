/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_interface;

import java.awt.Graphics;
import menu_management.MainMenuController;

/**
 *
 * @author BERKYILDIZ
 */
public class NumberOfPlayerView extends javax.swing.JPanel {
    
    MainMenuController menuManager;

    /**
     * Creates new form NumberOfPlayerView
     */
    public NumberOfPlayerView(MainMenuController menuManager) {
        this.menuManager = menuManager;
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

        backButton = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        multiPlayerButton = new javax.swing.JButton();
        singlePlayerButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        title.setText("                 Select Player");

        multiPlayerButton.setText("Multiplayer");
        multiPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiPlayerButtonActionPerformed(evt);
            }
        });

        singlePlayerButton.setText("Single Player");
        singlePlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlePlayerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(multiPlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(singlePlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(singlePlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(multiPlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        menuManager.getSoundManager().playSound();
        menuManager.setNumberOfPlayers(0);
        menuManager.showView("mainmenu");
    }//GEN-LAST:event_backButtonActionPerformed

    private void singlePlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlePlayerButtonActionPerformed
        menuManager.getSoundManager().playSound();
        menuManager.setNumberOfPlayers(1);
        menuManager.showView("gamemode");
    }//GEN-LAST:event_singlePlayerButtonActionPerformed

    private void multiPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiPlayerButtonActionPerformed
        menuManager.getSoundManager().playSound();
        menuManager.setNumberOfPlayers(2);
        menuManager.showView("login");
        menuManager.initNetwork();
        //menuManager.initLevel();
    }//GEN-LAST:event_multiPlayerButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton multiPlayerButton;
    private javax.swing.JButton singlePlayerButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
