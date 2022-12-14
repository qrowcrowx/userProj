/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userprof;

import com.lambdaworks.crypto.SCryptUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vince
 */
public class NewJFrame extends javax.swing.JFrame {

    String user;
    String pass;
    Statement sqlSt;
    String output;
    ResultSet result;
    String confirm;
    String fname;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
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

        txt_update = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        phonenum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_pass1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txt_pass2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_update.setText("UPDATE");
        txt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_updateActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel2.setText("Email");

        jLabel3.setText("Phone");

        jLabel4.setText("New Password");

        txt_pass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pass1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Confirm Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(txt_email)
                            .addComponent(phonenum)
                            .addComponent(txt_pass1)
                            .addComponent(txt_pass2)
                            .addComponent(jLabel1))
                        .addGap(137, 690, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_update, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phonenum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_pass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(txt_update, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_updateActionPerformed
        // TODO add your handling code here:

        //Make your NewJFrame obj
        NewJFrame a = new NewJFrame();

        //Buttons Listener
        if (evt.getSource() == txt_update) {
            if (txt_name.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Input Required");
            } else {
                //Connection of DB to Java
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String dbURL = "jdbc:mysql://database-1.cwcul3ylqcmq.ap-southeast-1.rds.amazonaws.com:3306/Registration";
                    Connection dbConnect = DriverManager.getConnection(dbURL, "admin", "zxcasdqwe123");
                    a.sqlSt = dbConnect.createStatement();
                    a.result = a.sqlSt.executeQuery("select * from login_details where email = '" + txt_email.getText() + "';");

                    //If the Result is true the code will work, if not error message
                    if (a.result.next() == true) {
                        if (txt_pass1.getText().equals(txt_pass2.getText())) {
                            String pass = SCryptUtil.scrypt(txt_pass1.getText(), 16, 16, 16);

                            a.sqlSt.executeUpdate("UPDATE login_details SET fname = '" + txt_name.getText() + "',Password = '" + pass + "' where email = '" + txt_email.getText() + "';");

                            JOptionPane.showMessageDialog(null, "Success Update", "ALERT", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Account is not in the db", "ALERT", JOptionPane.INFORMATION_MESSAGE);
                    }
                    //SQL Close
                    a.sqlSt.close();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("1");
                } catch (SQLException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("2" + ex.getMessage());
                }
            }
        }

    }//GEN-LAST:event_txt_updateActionPerformed

    private void txt_pass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pass1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pass1ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField phonenum;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_name;
    private javax.swing.JPasswordField txt_pass1;
    private javax.swing.JPasswordField txt_pass2;
    private javax.swing.JButton txt_update;
    // End of variables declaration//GEN-END:variables
}
