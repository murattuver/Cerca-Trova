/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_interface;
import menu_management.MainMenuController;

/**
 *
 * @author Cerca-Trova
 */
public class MainMenuView extends javax.swing.JPanel{

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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        playButton = new javax.swing.JButton();
        optionsButton = new javax.swing.JButton();
        leaderBoardButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        exitButton1 = new javax.swing.JButton();
        optionsButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 204));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        add(playButton);
        playButton.setBounds(300, 180, 200, 50);

        optionsButton.setText("Tutorial");
        optionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsButtonActionPerformed(evt);
            }
        });
        add(optionsButton);
        optionsButton.setBounds(300, 250, 200, 50);

        leaderBoardButton.setText("Leaderboard");
        leaderBoardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderBoardButtonActionPerformed(evt);
            }
        });
        add(leaderBoardButton);
        leaderBoardButton.setBounds(300, 320, 200, 50);

        exitButton.setText("Credits");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        add(exitButton);
        exitButton.setBounds(300, 540, 200, 50);

        exitButton1.setText("Exit");
        exitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton1ActionPerformed(evt);
            }
        });
        add(exitButton1);
        exitButton1.setBounds(300, 470, 200, 50);

        optionsButton1.setText("Options");
        optionsButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsButton1ActionPerformed(evt);
            }
        });
        add(optionsButton1);
        optionsButton1.setBounds(300, 400, 200, 50);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("KATAMINO");
        add(jLabel2);
        jLabel2.setBounds(270, 60, 260, 56);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitte.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 3, true));
        add(jLabel3);
        jLabel3.setBounds(190, 40, 410, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backG.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        add(jLabel1);
        jLabel1.setBounds(-5, -4, 820, 610);
    }// </editor-fold>                        

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        menuManager.getSoundManager().playSound();
        menuManager.showView("numberofplayer");
    }                                          

    private void optionsButtonActionPerformed(java.awt.event.ActionEvent evt) {   
        menuManager.getSoundManager().playSound();
        //gameController.getInstance().showGameOptions();
    }                                             

    private void leaderBoardButtonActionPerformed(java.awt.event.ActionEvent evt) {   
        menuManager.getSoundManager().playSound();
        // TODO add your handling code here:
    }                                                 

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {  
        menuManager.getSoundManager().playSound();
        //Controller closes the game.
        //gameController.getInstance().closeGame();
    }                                          

    private void exitButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        menuManager.getSoundManager().playSound();
        menuManager.closeGame();
    }                                           

    private void optionsButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        menuManager.getSoundManager().playSound();
        menuManager.showView("options");
    }                                              


    // Variables declaration - do not modify                     
    private javax.swing.JButton exitButton;
    private javax.swing.JButton exitButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton leaderBoardButton;
    private javax.swing.JButton optionsButton;
    private javax.swing.JButton optionsButton1;
    private javax.swing.JButton playButton;
    // End of variables declaration                   
}