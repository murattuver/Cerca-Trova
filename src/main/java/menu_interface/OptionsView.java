/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_interface;
import game_management.SettingsManager;
import java.util.HashMap;
import menu_management.MainMenuController;
/**
 *
 * @author Cerca-Trova
 */
public class OptionsView extends javax.swing.JPanel {
    
    MainMenuController menuController;
    public OptionsView(MainMenuController menuController) {
        initComponents();
        this.menuController = menuController;
        showSettings();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sound = new javax.swing.ButtonGroup();
        music = new javax.swing.ButtonGroup();
        theme = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        soundOn = new javax.swing.JRadioButton();
        soundOff = new javax.swing.JRadioButton();
        musicOn = new javax.swing.JRadioButton();
        musicOff = new javax.swing.JRadioButton();
        ARCH = new javax.swing.JRadioButton();
        CS = new javax.swing.JRadioButton();
        ME = new javax.swing.JRadioButton();
        MAN = new javax.swing.JRadioButton();
        Default = new javax.swing.JRadioButton();
        BACK = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Options");
        add(jLabel2);
        jLabel2.setBounds(320, 50, 170, 60);

        sound.add(soundOn);
        soundOn.setSelected(true);
        soundOn.setText("ON");
        soundOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soundOnActionPerformed(evt);
            }
        });
        add(soundOn);
        soundOn.setBounds(290, 240, 60, 28);

        sound.add(soundOff);
        soundOff.setText("OFF");
        soundOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soundOffActionPerformed(evt);
            }
        });
        add(soundOff);
        soundOff.setBounds(430, 240, 60, 28);

        music.add(musicOn);
        musicOn.setSelected(true);
        musicOn.setText("ON");
        musicOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicOnActionPerformed(evt);
            }
        });
        add(musicOn);
        musicOn.setBounds(290, 360, 60, 28);

        music.add(musicOff);
        musicOff.setText("OFF");
        musicOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicOffActionPerformed(evt);
            }
        });
        add(musicOff);
        musicOff.setBounds(430, 360, 60, 28);

        theme.add(ARCH);
        ARCH.setText("ARCH");
        ARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ARCHActionPerformed(evt);
            }
        });
        add(ARCH);
        ARCH.setBounds(240, 450, 70, 28);

        theme.add(CS);
        CS.setText("CS");
        CS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSActionPerformed(evt);
            }
        });
        add(CS);
        CS.setBounds(330, 450, 60, 28);

        theme.add(ME);
        ME.setText("ME");
        ME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MEActionPerformed(evt);
            }
        });
        add(ME);
        ME.setBounds(410, 450, 70, 28);

        theme.add(MAN);
        MAN.setText("MAN");
        MAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MANActionPerformed(evt);
            }
        });
        add(MAN);
        MAN.setBounds(490, 450, 70, 28);

        theme.add(Default);
        Default.setSelected(true);
        Default.setText("Default");
        Default.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultActionPerformed(evt);
            }
        });
        add(Default);
        Default.setBounds(350, 490, 90, 28);

        BACK.setText("Back");
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });
        add(BACK);
        BACK.setBounds(30, 30, 80, 32);

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        add(Save);
        Save.setBounds(350, 540, 90, 32);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Music");
        add(jLabel5);
        jLabel5.setBounds(360, 310, 70, 22);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Sound");
        add(jLabel6);
        jLabel6.setBounds(360, 200, 80, 22);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitte.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 3, true));
        add(jLabel3);
        jLabel3.setBounds(240, 40, 310, 80);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Theme");
        add(jLabel7);
        jLabel7.setBounds(360, 410, 80, 22);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitte.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 3, true));
        add(jLabel4);
        jLabel4.setBounds(210, 160, 380, 420);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitte.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jLabel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 3, true));
        add(jLabel8);
        jLabel8.setBounds(20, 20, 100, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WhatsApp Image 2018-12-28 at 01.13.32.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents
    
    private void showSettings() {
        for(HashMap.Entry<String, String> entry : menuController.getSettingsManager().loadSettings().entrySet()) {
            if(entry.getKey().equals("Sound")) {
                if(entry.getValue().equals("ON")) {
                    soundOn.setSelected(true);
                    soundOff.setSelected(false);
                }
                else {
                    soundOn.setSelected(false);
                    soundOff.setSelected(true);
                }
            }
            else if(entry.getKey().equals("Music")) {
                if(entry.getValue().equals("ON")) {
                    musicOn.setSelected(true);
                    musicOff.setSelected(false);
                }
                else {
                    musicOn.setSelected(false);
                    musicOff.setSelected(true);
                }
            }
            else {
                if(entry.getValue().equals("ARCH")) {
                    ARCH.setSelected(true);
                }
                else if(entry.getValue().equals("CS")) {
                    CS.setSelected(true);
                }
                else if(entry.getValue().equals("MAN")) {
                    MAN.setSelected(true);
                }
                else if(entry.getValue().equals("ME")){
                    ME.setSelected(true);
                }   
                else {
                    Default.setSelected(true);
                }
            }
        }
    }
    
    private void musicOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicOnActionPerformed
        menuController.getSoundManager().playSound();
        menuController.getSoundManager().resume();
        menuController.getSettingsManager().setMusicStatus("ON");
    }//GEN-LAST:event_musicOnActionPerformed

    private void musicOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicOffActionPerformed
        menuController.getSoundManager().playSound();
        menuController.getSoundManager().pause();
        menuController.getSettingsManager().setMusicStatus("OFF");
    }//GEN-LAST:event_musicOffActionPerformed

    private void soundOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soundOnActionPerformed
        menuController.getSoundManager().setClosed(false);
        menuController.getSoundManager().playSound();
        menuController.getSettingsManager().setSoundStatus("ON");
    }//GEN-LAST:event_soundOnActionPerformed

    private void soundOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soundOffActionPerformed
        menuController.getSoundManager().stopSound();
        menuController.getSoundManager().setClosed(true);
        menuController.getSettingsManager().setSoundStatus("OFF");
    }//GEN-LAST:event_soundOffActionPerformed

    private void ARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ARCHActionPerformed
        menuController.getSoundManager().playSound();
        menuController.getSettingsManager().setThemeStatus("ARCH");
    }//GEN-LAST:event_ARCHActionPerformed

    private void CSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSActionPerformed
        menuController.getSoundManager().playSound();
        menuController.getSettingsManager().setThemeStatus("CS");
    }//GEN-LAST:event_CSActionPerformed

    private void MEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MEActionPerformed
        menuController.getSoundManager().playSound();
        menuController.getSettingsManager().setThemeStatus("ME");
    }//GEN-LAST:event_MEActionPerformed

    private void MANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MANActionPerformed
        menuController.getSoundManager().playSound();
        menuController.getSettingsManager().setThemeStatus("MAN");
    }//GEN-LAST:event_MANActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        menuController.getSoundManager().playSound();
        menuController.showView("mainmenu");
    }//GEN-LAST:event_BACKActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        menuController.getSoundManager().playSound();
        menuController.getSettingsManager().saveConfig();
    }//GEN-LAST:event_SaveActionPerformed

    private void DefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefaultActionPerformed
        menuController.getSoundManager().playSound();
        menuController.getSettingsManager().setThemeStatus("Default");
    }//GEN-LAST:event_DefaultActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ARCH;
    private javax.swing.JButton BACK;
    private javax.swing.JRadioButton CS;
    private javax.swing.JRadioButton Default;
    private javax.swing.JRadioButton MAN;
    private javax.swing.JRadioButton ME;
    private javax.swing.JButton Save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.ButtonGroup music;
    private javax.swing.JRadioButton musicOff;
    private javax.swing.JRadioButton musicOn;
    private javax.swing.ButtonGroup sound;
    private javax.swing.JRadioButton soundOff;
    private javax.swing.JRadioButton soundOn;
    private javax.swing.ButtonGroup theme;
    // End of variables declaration//GEN-END:variables
}
