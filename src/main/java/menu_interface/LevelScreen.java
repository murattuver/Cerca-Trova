/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_interface;

import game_management.Level;
import java.util.ArrayList;
import javax.swing.JButton;
import menu_management.MainMenuController;

/**
 *
 * @author BERKYILDIZ
 */
public class LevelScreen extends javax.swing.JPanel {
    MainMenuController menuController;
    ArrayList<Level> levels;
    ArrayList<JButton> buttons;
    /**
     * Creates new form LevelScreen
     */
    public LevelScreen(MainMenuController menuController) {
        this.menuController = menuController;
        initComponents();
        levels = new ArrayList<Level>();
        buttons = new ArrayList<JButton>();
        levels = menuController.getLevels();
        addButtons();
        checkUnlocked();
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
        jLabel1 = new javax.swing.JLabel();
        level1Button = new javax.swing.JButton();
        level2Button = new javax.swing.JButton();
        level3Button = new javax.swing.JButton();
        level4Button = new javax.swing.JButton();
        level5Button = new javax.swing.JButton();
        level6Button = new javax.swing.JButton();
        level7Button = new javax.swing.JButton();
        level8Button = new javax.swing.JButton();
        level9Button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 102));
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

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("LEVELS");
        add(jLabel1);
        jLabel1.setBounds(320, 60, 170, 50);

        level1Button.setText("Level 1");
        level1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level1ButtonActionPerformed(evt);
            }
        });
        add(level1Button);
        level1Button.setBounds(50, 190, 200, 50);

        level2Button.setText("Level 2");
        level2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level2ButtonActionPerformed(evt);
            }
        });
        add(level2Button);
        level2Button.setBounds(300, 190, 200, 50);

        level3Button.setText("Level 3");
        level3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level3ButtonActionPerformed(evt);
            }
        });
        add(level3Button);
        level3Button.setBounds(550, 190, 200, 50);

        level4Button.setText("Level 4");
        level4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level4ButtonActionPerformed(evt);
            }
        });
        add(level4Button);
        level4Button.setBounds(50, 310, 200, 50);

        level5Button.setText("Level 5");
        level5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level5ButtonActionPerformed(evt);
            }
        });
        add(level5Button);
        level5Button.setBounds(300, 310, 200, 50);

        level6Button.setText("Level 6");
        level6Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level6ButtonActionPerformed(evt);
            }
        });
        add(level6Button);
        level6Button.setBounds(550, 310, 200, 50);

        level7Button.setText("Level 7");
        level7Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level7ButtonActionPerformed(evt);
            }
        });
        add(level7Button);
        level7Button.setBounds(50, 430, 200, 50);

        level8Button.setText("Level 8");
        level8Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level8ButtonActionPerformed(evt);
            }
        });
        add(level8Button);
        level8Button.setBounds(300, 430, 200, 50);

        level9Button.setText("Level 9");
        level9Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level9ButtonActionPerformed(evt);
            }
        });
        add(level9Button);
        level9Button.setBounds(550, 430, 200, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitte.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 3, true));
        add(jLabel3);
        jLabel3.setBounds(190, 40, 410, 100);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitte.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 3, true));
        add(jLabel4);
        jLabel4.setBounds(20, 170, 750, 340);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WhatsApp Image 2018-12-28 at 01.13.32.jpeg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 590);
    }// </editor-fold>//GEN-END:initComponents
    
    private void addButtons() {
        buttons.add(level1Button);
        buttons.add(level2Button);
        buttons.add(level3Button);
        buttons.add(level4Button);
        buttons.add(level5Button);
        buttons.add(level6Button);
        buttons.add(level7Button);
        buttons.add(level8Button);
        buttons.add(level9Button);
    }
    
    private void checkUnlocked() {
        for(int i = 0; i < menuController.getLevels().size(); i++) {
            if(menuController.getLevels().get(i).getUnlocked()) {
                buttons.get(i).setEnabled(true);
            }
            if(!menuController.getLevels().get(i).getUnlocked()) {
                buttons.get(i).setEnabled(false);
            }
        }
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.setLevelNo(-1);
        menuController.showView("gamemode");
    }//GEN-LAST:event_backButtonActionPerformed

    private void level1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level1ButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.setLevelNo(1);
        menuController.initLevel();
        System.out.println(menuController.getSettingsManager().loadSettings().get("Theme"));
        if(!menuController.getSettingsManager().loadSettings().get("Theme").equals("Default")) {
            menuController.getSoundManager().closeMusic();
        }
    }//GEN-LAST:event_level1ButtonActionPerformed

    private void level2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level2ButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.setLevelNo(2);
        menuController.initLevel();
        if(!menuController.getSettingsManager().loadSettings().get("Theme").equals("Default"))
            menuController.getSoundManager().closeMusic();
    }//GEN-LAST:event_level2ButtonActionPerformed

    private void level3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level3ButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.setLevelNo(3);
        menuController.initLevel();
        if(!menuController.getSettingsManager().loadSettings().get("Theme").equals("Default"))
            menuController.getSoundManager().closeMusic();
    }//GEN-LAST:event_level3ButtonActionPerformed

    private void level4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level4ButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.setLevelNo(4);
        menuController.initLevel();
        if(!menuController.getSettingsManager().loadSettings().get("Theme").equals("Default"))
            menuController.getSoundManager().closeMusic();
    }//GEN-LAST:event_level4ButtonActionPerformed

    private void level5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level5ButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.setLevelNo(5);
        menuController.initLevel();
        if(!menuController.getSettingsManager().loadSettings().get("Theme").equals("Default"))
            menuController.getSoundManager().closeMusic();
    }//GEN-LAST:event_level5ButtonActionPerformed

    private void level6ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level6ButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.setLevelNo(6);
        menuController.initLevel();
        if(!menuController.getSettingsManager().loadSettings().get("Theme").equals("Default"))
            menuController.getSoundManager().closeMusic();
    }//GEN-LAST:event_level6ButtonActionPerformed

    private void level7ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level7ButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.setLevelNo(7);
        menuController.initLevel();
        if(!menuController.getSettingsManager().loadSettings().get("Theme").equals("Default"))
            menuController.getSoundManager().closeMusic();
    }//GEN-LAST:event_level7ButtonActionPerformed

    private void level8ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level8ButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.setLevelNo(8);
        menuController.initLevel();
        if(!menuController.getSettingsManager().loadSettings().get("Theme").equals("Default"))
            menuController.getSoundManager().closeMusic();
    }//GEN-LAST:event_level8ButtonActionPerformed

    private void level9ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level9ButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.setLevelNo(9);
        menuController.initLevel();
        if(!menuController.getSettingsManager().loadSettings().get("Theme").equals("Default"))
            menuController.getSoundManager().closeMusic();
    }//GEN-LAST:event_level9ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton level1Button;
    private javax.swing.JButton level2Button;
    private javax.swing.JButton level3Button;
    private javax.swing.JButton level4Button;
    private javax.swing.JButton level5Button;
    private javax.swing.JButton level6Button;
    private javax.swing.JButton level7Button;
    private javax.swing.JButton level8Button;
    private javax.swing.JButton level9Button;
    // End of variables declaration//GEN-END:variables
}
