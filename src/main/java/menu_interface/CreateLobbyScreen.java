/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_interface;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import menu_management.MainMenuController;

/**
 *
 * @author murattuver
 */
public class CreateLobbyScreen extends javax.swing.JPanel {
    public MainMenuController menuController;
    /**
     * Creates new form CreateLobbyScreen
     */
    public CreateLobbyScreen(MainMenuController menuController) {
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

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        levelBox = new javax.swing.JComboBox<>();
        createLobbyButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lobbyName = new javax.swing.JFormattedTextField();
        backButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(0, 102, 102));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        levelBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6", "Level 7", "Level 8", "Level 9", "Level 10", "Level 11", "Level 12" }));
        add(levelBox);
        levelBox.setBounds(294, 220, 112, 26);

        createLobbyButton.setText("Create Lobby");
        createLobbyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createLobbyButtonActionPerformed(evt);
            }
        });
        add(createLobbyButton);
        createLobbyButton.setBounds(191, 273, 120, 32);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("LobbyName:");
        add(jLabel1);
        jLabel1.setBounds(206, 167, 80, 15);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Level:");
        add(jLabel2);
        jLabel2.setBounds(206, 220, 70, 15);

        lobbyName.setText("LobbyName");
        add(lobbyName);
        lobbyName.setBounds(294, 165, 112, 20);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton);
        backButton.setBounds(320, 273, 110, 32);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitte.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 3, true));
        add(jLabel4);
        jLabel4.setBounds(170, 130, 280, 220);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WhatsApp Image 2018-12-28 at 01.13.32.jpeg"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(0, 0, 810, 610);
    }// </editor-fold>//GEN-END:initComponents

    private void createLobbyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createLobbyButtonActionPerformed
        menuController.getSoundManager().playSound();
        String lobbyName = this.lobbyName.getText();
        String level = levelBox.getSelectedItem().toString();
        int levelNo = Integer.parseInt(level.substring(level.length() - 1));
        
        menuController.createLobby(lobbyName, levelNo);

        Object[] options = {"Quit Lobby"};
        int n = JOptionPane.showOptionDialog((JFrame)SwingUtilities.windowForComponent(this),
            "Your lobby is created.\nSearching for an opponent...",
            "Lobby Created",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,     //do not use a custom Icon
            options,  //the titles of buttons
            options[0]); //default button title
        
        if(n == 0){
            menuController.destroyLobby();
        }
    }//GEN-LAST:event_createLobbyButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.showView("multimenu");
        
    }//GEN-LAST:event_backButtonActionPerformed

    private void lobbyNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lobbyNameFocusGained
        lobbyName.setText("");
    }//GEN-LAST:event_lobbyNameFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton createLobbyButton;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> levelBox;
    private javax.swing.JFormattedTextField lobbyName;
    // End of variables declaration//GEN-END:variables
}
