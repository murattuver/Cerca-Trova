/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_interface;

import menu_management.MainMenuController;

/**
 *
 * @author murattuver
 */
public class SignUpScreen extends javax.swing.JPanel {

    MainMenuController menuController;
    /**
     * Creates new form SignUpScreen
     */
    public SignUpScreen(MainMenuController menuController) {
        this.menuController = menuController;
        initComponents();
        notMatchedField.setVisible(false);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        passwordField1 = new javax.swing.JPasswordField();
        passwordField2 = new javax.swing.JPasswordField();
        mailAdressField = new javax.swing.JFormattedTextField();
        signupButton = new javax.swing.JButton();
        notMatchedField = new javax.swing.JTextField();
        nickNameField = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();

        passwordField1.setText("jPasswordField1");
        passwordField1.setMaximumSize(new java.awt.Dimension(134, 22));
        passwordField1.setMinimumSize(new java.awt.Dimension(134, 22));
        passwordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordField1FocusGained(evt);
            }
        });

        passwordField2.setText("jPasswordField2");
        passwordField2.setMaximumSize(new java.awt.Dimension(134, 22));
        passwordField2.setMinimumSize(new java.awt.Dimension(134, 22));
        passwordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordField2FocusGained(evt);
            }
        });

        mailAdressField.setText("example@mail.com");
        mailAdressField.setMaximumSize(new java.awt.Dimension(72, 26));
        mailAdressField.setMinimumSize(new java.awt.Dimension(72, 26));
        mailAdressField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mailAdressFieldFocusGained(evt);
            }
        });
        mailAdressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailAdressFieldActionPerformed(evt);
            }
        });

        signupButton.setText("Sign Up");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        notMatchedField.setEditable(false);
        notMatchedField.setText("Passwords do not match.");
        notMatchedField.setFocusable(false);
        notMatchedField.setOpaque(false);
        notMatchedField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notMatchedFieldActionPerformed(evt);
            }
        });

        nickNameField.setText("NickName");

        jTextField5.setText("At least 6 characters long.");

        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setText("Password:");

        jFormattedTextField2.setEditable(false);
        jFormattedTextField2.setText("Email Address:");

        jFormattedTextField3.setEditable(false);
        jFormattedTextField3.setText("re-Password:");

        jFormattedTextField4.setEditable(false);
        jFormattedTextField4.setText("NickName:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(notMatchedField, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField3)
                            .addComponent(jFormattedTextField1)
                            .addComponent(jFormattedTextField4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(signupButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(passwordField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nickNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(mailAdressField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(passwordField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addGap(266, 266, 266))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mailAdressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nickNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addComponent(signupButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(notMatchedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mailAdressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailAdressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailAdressFieldActionPerformed

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
        menuController.getSoundManager().playSound();
        String username = mailAdressField.getText();
        String p1 = new String( passwordField1.getPassword());
        String p2 = new String( passwordField2.getPassword());
        String nick = nickNameField.getText();
        boolean isSucceed = false;
        if(!p1.equals(p2)){
            notMatchedField.setText("Password does not match.");
            notMatchedField.setVisible(true);
            this.repaint();
            this.validate();
            
        }else if(p1.length() < 6){
            notMatchedField.setText("Password needs to be at least 6 characters long.");
            notMatchedField.setVisible(true);
            this.repaint();
            this.validate();
        } else{
            isSucceed = menuController.createUser(username, p1, nick);
        }
        
        if(isSucceed){
            notMatchedField.setText("Signed Up Successfully.");
            notMatchedField.setVisible(true);
            this.repaint();
            this.validate();
        }

    }//GEN-LAST:event_signupButtonActionPerformed

    private void notMatchedFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notMatchedFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notMatchedFieldActionPerformed

    private void passwordField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordField1FocusGained
        passwordField1.setText("");
    }//GEN-LAST:event_passwordField1FocusGained

    private void passwordField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordField2FocusGained
        passwordField2.setText("");

    }//GEN-LAST:event_passwordField2FocusGained

    private void mailAdressFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mailAdressFieldFocusGained
        mailAdressField.setText("");

    }//GEN-LAST:event_mailAdressFieldFocusGained

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        menuController.getSoundManager().playSound();
        menuController.showView("login");
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JFormattedTextField mailAdressField;
    private javax.swing.JTextField nickNameField;
    private javax.swing.JTextField notMatchedField;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JPasswordField passwordField2;
    private javax.swing.JButton signupButton;
    // End of variables declaration//GEN-END:variables
}
