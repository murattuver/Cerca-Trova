/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_interface;

import menu_management.MainMenuController;

/**
 *
 * @author BERKYILDIZ
 */
public class GameModeScreen extends javax.swing.JPanel {
    MainMenuController menuController;
    /**
     * Creates new form GameModeScreen
     */
    public GameModeScreen(MainMenuController menuController) {
        this.menuController = menuController;
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
        classicButton = new javax.swing.JButton();
        arcadeButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 255));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton);
        backButton.setBounds(11, 11, 100, 50);

        classicButton.setText("Classic");
        classicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classicButtonActionPerformed(evt);
            }
        });
        add(classicButton);
        classicButton.setBounds(300, 230, 200, 100);

        arcadeButton.setText("Arcade");
        arcadeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arcadeButtonActionPerformed(evt);
            }
        });
        add(arcadeButton);
        arcadeButton.setBounds(300, 380, 200, 100);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitte.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 3, true));
        add(jLabel4);
        jLabel4.setBounds(270, 190, 260, 330);

        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText(" GAME MODES");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(300, 100, 200, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitte.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 3, true));
        jPanel2.add(jLabel2);
        jLabel2.setBounds(200, 70, 390, 100);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WhatsApp Image 2018-12-28 at 01.13.32.jpeg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 0, 800, 600);

        add(jPanel2);
        jPanel2.setBounds(0, 0, 820, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void classicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classicButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.setGameMode("classic");
        menuController.showView("level");
    }//GEN-LAST:event_classicButtonActionPerformed

    private void arcadeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arcadeButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.setGameMode("arcade");

    }//GEN-LAST:event_arcadeButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.setGameMode("");
        menuController.showView("numberofplayer");
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton arcadeButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton classicButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
