/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import menu_management.MainMenuController;

/**
 *
 * @author murattuver
 */
public class JoinLobbyScreen extends javax.swing.JPanel {
    MainMenuController menuController;
    /**
     * Creates new form JoinLobbyScreen
     */
    public JoinLobbyScreen(MainMenuController menuController) {
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

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        refreshButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lobbies = new javax.swing.JTable();
        joinButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 51));
        setLayout(null);

        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField1.setText("Active Lobbies:");
        jFormattedTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        add(jFormattedTextField1);
        jFormattedTextField1.setBounds(56, 34, 165, 36);

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        add(refreshButton);
        refreshButton.setBounds(496, 165, 148, 50);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton);
        backButton.setBounds(496, 226, 148, 50);

        lobbies.setBackground(new java.awt.Color(255, 255, 153));
        lobbies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lobby Name", "Level", "id"
            }
        ));
        jScrollPane1.setViewportView(lobbies);

        add(jScrollPane1);
        jScrollPane1.setBounds(31, 79, 453, 403);

        joinButton.setText("Join");
        joinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinButtonActionPerformed(evt);
            }
        });
        add(joinButton);
        joinButton.setBounds(496, 104, 148, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whitte.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 3, true));
        add(jLabel2);
        jLabel2.setBounds(11, 16, 660, 520);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/WhatsApp Image 2018-12-28 at 01.13.32.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        menuController.getSoundManager().playSound();
        HashMap lobbyData = menuController.fetchLobbies();

        Iterator it = lobbyData.entrySet().iterator();
        
        DefaultTableModel model = (DefaultTableModel) lobbies.getModel();
        model.setRowCount(0);
        
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            
            ArrayList<String> values = new ArrayList<>();
            values = (ArrayList<String>)pair.getValue();
            
            model = (DefaultTableModel) lobbies.getModel();
            model.addRow(new Object[]{values.get(0), values.get(1), pair.getKey()});
            
            it.remove(); // avoids a ConcurrentModificationException
        }
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.showView("multimenu");
        
    }//GEN-LAST:event_backButtonActionPerformed

    private void joinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinButtonActionPerformed
        menuController.getSoundManager().playSound();
        int rowNo = lobbies.getSelectedRow();
        
        if(rowNo != -1){
            menuController.setLevelNo( Integer.parseInt( "" + lobbies.getValueAt(rowNo, 1)));
            
            menuController.setGameId( (String) lobbies.getValueAt(rowNo, 2));
            menuController.setPlayerNo(2);
            menuController.setMatched(true);
            menuController.startMultiGame();
            menuController.startDatabaseListener();

        }
    }//GEN-LAST:event_joinButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton joinButton;
    private javax.swing.JTable lobbies;
    private javax.swing.JButton refreshButton;
    // End of variables declaration//GEN-END:variables
}
