/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeshop;

import java.awt.CardLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ghin
 */
public class ResetPassword extends javax.swing.JFrame {

    /**
     * Creates new form ResetPassword
     */
    public ResetPassword() {
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

        pnUser = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        jlPrompt = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pnQuestion = new javax.swing.JPanel();
        txtAnswer = new javax.swing.JTextField();
        jlSecQuestionOne = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        pnPass = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbSubmit = new javax.swing.JButton();
        txtPass1 = new javax.swing.JPasswordField();
        txtPass2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reset Password - Krankies");
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jlPrompt.setText("Username:");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnUserLayout = new javax.swing.GroupLayout(pnUser);
        pnUser.setLayout(pnUserLayout);
        pnUserLayout.setHorizontalGroup(
            pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUserLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnUserLayout.createSequentialGroup()
                        .addComponent(jlPrompt)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnUserLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(59, 59, 59)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        pnUserLayout.setVerticalGroup(
            pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnUserLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPrompt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(43, 43, 43))
        );

        getContentPane().add(pnUser, "pnUser");

        jlSecQuestionOne.setText("Security Question:");

        lblQuestion.setText("SecQuestion");

        jLabel1.setText("Your answer:");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnQuestionLayout = new javax.swing.GroupLayout(pnQuestion);
        pnQuestion.setLayout(pnQuestionLayout);
        pnQuestionLayout.setHorizontalGroup(
            pnQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnQuestionLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(pnQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlSecQuestionOne)
                    .addComponent(jLabel1))
                .addGroup(pnQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnQuestionLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnSubmit))
                    .addGroup(pnQuestionLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(pnQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41))
        );
        pnQuestionLayout.setVerticalGroup(
            pnQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnQuestionLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(pnQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSecQuestionOne)
                    .addComponent(lblQuestion))
                .addGap(10, 10, 10)
                .addGroup(pnQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubmit)
                .addGap(25, 25, 25))
        );

        getContentPane().add(pnQuestion, "pnQuestion");

        pnPass.setMaximumSize(new java.awt.Dimension(440, 130));

        jLabel3.setText("Confirm:");

        jLabel2.setText("Enter new password:");

        jbSubmit.setText("Reset");
        jbSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPassLayout = new javax.swing.GroupLayout(pnPass);
        pnPass.setLayout(pnPassLayout);
        pnPassLayout.setHorizontalGroup(
            pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPassLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbSubmit)
                    .addComponent(txtPass1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(txtPass2))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        pnPassLayout.setVerticalGroup(
            pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPassLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSubmit)
                .addGap(21, 21, 21))
        );

        getContentPane().add(pnPass, "pnPassword");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtUsername.getText().length() != 0) {
            accessor = new DBAccessor();
            accessor.connectDB();
            rsUser = accessor.getAccount(txtUsername.getText());
            try {
                if (rsUser.next()) {
                    showPanel("pnQuestion");
                    txtUsername.setText("");
                    lblQuestion.setText(rsUser.getString(3));
                } else {
                    JOptionPane.showMessageDialog(null, "User not found", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ResetPassword.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please enter an username", "No Input", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (txtAnswer.getText().length() != 0) {
            try {
                if (txtAnswer.getText().equals(rsUser.getString(4))) {
                    txtAnswer.setText("");
                    showPanel("pnPassword");
                } else {
                    JOptionPane.showMessageDialog(null, "Your answer is wrong. Please try again.", "Wrong answer", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ResetPassword.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter your answer", "No Input", JOptionPane.PLAIN_MESSAGE);
        }

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void jbSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSubmitActionPerformed
        if (txtPass1.getPassword().length != 0 & txtPass2.getPassword().length != 0) {
            if (String.valueOf(txtPass1.getPassword()).equals(String.valueOf(txtPass2.getPassword()))) {
                try {
                    if (accessor.resetPassword(String.valueOf(txtPass1.getPassword()), rsUser.getString(1))) {
                        JOptionPane.showMessageDialog(null, "Your password has been reset successfully!", "Password reset", JOptionPane.PLAIN_MESSAGE);
                        txtPass1.removeAll();
                        txtPass2.removeAll();
                        rsUser.close();
                        accessor.disconnect();
                    } else JOptionPane.showMessageDialog(null, "Cannot reset your password.", "Error", JOptionPane.PLAIN_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(ResetPassword.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Passwords not match. Please try again.", "Password not match.", JOptionPane.PLAIN_MESSAGE);
            }
        } else JOptionPane.showMessageDialog(null, "Please enter your new password", "No Input", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jbSubmitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResetPassword().setVisible(true);
            }
        });
    }

    private void showPanel(String pnName) {
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.show(getContentPane(), pnName);
    }
    private ResultSet rsUser;
    private DBAccessor accessor;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbSubmit;
    private javax.swing.JLabel jlPrompt;
    private javax.swing.JLabel jlSecQuestionOne;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JPanel pnPass;
    private javax.swing.JPanel pnQuestion;
    private javax.swing.JPanel pnUser;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JPasswordField txtPass2;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
