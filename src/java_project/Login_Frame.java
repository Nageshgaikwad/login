/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_project;

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
 * @author Hactastic
 */
public class Login_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Login_Frame
     */
    public Login_Frame() {
        initComponents();
    }

    public Connection getConnection()
    {
        Connection con = null;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/products_db","root","");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Login_Frame.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_userid = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lgnbtn_signup = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(240, 234, 40));
        jPanel1.setLayout(null);
        jPanel1.add(txt_userid);
        txt_userid.setBounds(430, 200, 180, 40);

        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel1.add(txt_password);
        txt_password.setBounds(430, 270, 180, 40);

        btn_login.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel1.add(btn_login);
        btn_login.setBounds(370, 370, 160, 60);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setText("Password");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(250, 270, 170, 40);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel3.setText("User Id");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(290, 200, 150, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("If you dont have a user id and password please signup by clicking the signup button");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(130, 470, 480, 14);

        lgnbtn_signup.setText("Sign Up");
        lgnbtn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lgnbtn_signupActionPerformed(evt);
            }
        });
        jPanel1.add(lgnbtn_signup);
        lgnbtn_signup.setBounds(610, 460, 80, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/store images/background.jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 850, 540);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed

        String uid = new String();
        String pas = new String();
        String type = new String();
        
        try {
            Connection con = getConnection();
            String query = "Select User_Id,Password,User_Type from users where User_Id = " + "'" + txt_userid.getText()+ "'" + ";";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
             while(rs.next())
             {
                uid = rs.getString(1);
                pas = rs.getString(2);
                type = rs.getString(3);
                
                
            }
            
             if(uid.equals(txt_userid.getText())
                    && pas.equals(txt_password.getText())
                     && type.equals("Shopkeeper"))
             {
                Main_Window main = new Main_Window();
                main.setVisible(true);
             }
             else if(uid.equals(txt_userid.getText())
                    && pas.equals(txt_password.getText())
                     && type.equalsIgnoreCase("Customer"))
            {
                Customer_Frame cust = new Customer_Frame();
                this.dispose();
                cust.setVisible(true);
            }
            else if(txt_userid.getText() == null
                    || txt_password.getText() == null)
            {
                JOptionPane.showMessageDialog(null, "One of the fields is empty");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect details");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_btn_loginActionPerformed

    private void lgnbtn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lgnbtn_signupActionPerformed
        SignUp_Frame sp = new SignUp_Frame();
        sp.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_lgnbtn_signupActionPerformed

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
            java.util.logging.Logger.getLogger(Login_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton lgnbtn_signup;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_userid;
    // End of variables declaration//GEN-END:variables
}
