/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package fees_management_system;

import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author kuson
 */

public class SignupPage extends javax.swing.JFrame {

    /**
     * Creates new form SignupPage
     */
    
    String fname,lname,uname,pass,confirm_pass,contact_no;
    Date d_o_b;
    
  
    public SignupPage() {
        initComponents();
        
    }

    public int getId()
    {
         int id = 0;
        ResultSet rs = null;
        try
        {
            Class.forName("\"com.mysql.cj.jdbc.Driver\"");
           
            
           
                   Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fees_management","root","");
             String sql = "select max(Id) from signup ";
             Statement st = con.createStatement();
             rs = st.executeQuery(sql);
             while (rs.next())
             {
                  
                 
                 id = rs.getInt(1);
                 id++;
                 
             }
             
             
                   
            
        }
        catch(Exception e)
        {
               e.printStackTrace();
                }
        return id;
               
    }
    boolean validation()
    {
        fname = firstname.getText();
        lname = lastname.getText();
        uname = username.getText();
        pass = password.getText();
        confirm_pass = confirmpassword.getText();
        contact_no = contact.getText();
        d_o_b = dob.getDate();
        
        if(fname.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter Firstname");
            return false;
        }
        
        if(lname.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter Lastname");
            return false;
        }
        
        if(uname.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter Username");
            return false;
        }
        
        if(pass.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter Password");
            return false;
        }
        
        if(confirm_pass.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Confirm the Password");
            return false;
        }
        
        if(d_o_b ==null)
        {
            JOptionPane.showMessageDialog(this,"Please enter Date Of Birth");
            return false;
        }
        
        if(contact_no.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter Contact Number");
            return false;
        }
        
        if(!pass.equals(confirm_pass))
        {
            JOptionPane.showMessageDialog(this,"Password not Matched");
//            confpass.setText(" password not matched");
             return false;
        }
        
         Login l = new Login();
         l.show();
          this.dispose();
        return true;
       
    }
    
    public void checkPassword()
    {
        pass = password.getText();
        if(pass.length()<8)
        {
            password_error.setText("Password should be 8 digit");
            
        }
        else
        {
          password_error.setText("");
        }
    }
    
   
    
    public void checkContactNo()
    {
         contact_no = contact.getText();

        if(contact_no.length()==10)
        {
            contact_error.setText("");
        }
        else
        {
            contact_error.setText("Contact should be 10 digit");
        }
        
    }
    
    void insertDetails()
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String myDob = format.format(d_o_b);
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
           
                   Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fees_management","root","");
             String sql = "insert into signup values (?,?,?,?,?,?,?)";
                   PreparedStatement stm  = con.prepareStatement(sql);
             stm.setInt(1,getId() );
             stm.setString(2, fname);
             stm.setString(3, lname);
             stm.setString(4, uname);
             stm.setString(5, pass);
             stm.setString(6,myDob );
             stm.setString(7, contact_no);
             int i =  stm.executeUpdate();
             if (i>0)
             {
                 JOptionPane.showMessageDialog(this,"Record Inserted");
             }
             else
             {
                 JOptionPane.showMessageDialog(this,"Record is not Inserted");
             }
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        
    }

    public SignupPage(String fname, String lname, String uname, String pass, String confirm_pass, String contact_no, Date d_o_b, JPasswordField confirmpassword, JTextField contact, JLabel contact_error, JDateChooser dob, JTextField firstname, JLabel jLabel1, JLabel jLabel10, JLabel jLabel11, JLabel jLabel12, JLabel jLabel13, JLabel jLabel14, JLabel jLabel2, JLabel jLabel9, JPanel jPanel1, JPanel jPanel2, JTextField jTextField3, JTextField lastname, JButton login, JPasswordField password, JLabel password_error, JButton signup, JTextField username) throws HeadlessException {
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.pass = pass;
        this.confirm_pass = confirm_pass;
        this.contact_no = contact_no;
        this.d_o_b = d_o_b;
        this.confirmpassword = confirmpassword;
        this.contact = contact;
        this.contact_error = contact_error;
        this.dob = dob;
        this.firstname = firstname;
        this.jLabel1 = jLabel1;
        this.jLabel10 = jLabel10;
        this.jLabel11 = jLabel11;
        this.jLabel12 = jLabel12;
        this.jLabel13 = jLabel13;
        this.jLabel14 = jLabel14;
        this.jLabel2 = jLabel2;
        this.jLabel9 = jLabel9;
        this.jPanel1 = jPanel1;
        this.jPanel2 = jPanel2;
        this.jTextField3 = jTextField3;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.password_error = password_error;
        this.signup = signup;
        this.username = username;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        firstname = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        signup = new javax.swing.JButton();
        login = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        confirmpassword = new javax.swing.JPasswordField();
        dob = new com.toedter.calendar.JDateChooser();
        password_error = new javax.swing.JLabel();
        contact_error = new javax.swing.JLabel();

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jTextField3.setText("jTextField1");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Signup");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 45, 135, 52));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 130));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lastname :-");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 99, 135, -1));

        lastname.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        jPanel2.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 98, 230, -1));

        firstname.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        jPanel2.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 35, 230, -1));

        username.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 161, 230, -1));

        contact.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contactKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contactKeyReleased(evt);
            }
        });
        jPanel2.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 230, -1));

        signup.setBackground(new java.awt.Color(102, 102, 102));
        signup.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        signup.setForeground(new java.awt.Color(255, 255, 255));
        signup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/signup.png"))); // NOI18N
        signup.setText("Signup");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        jPanel2.add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 496, -1, -1));

        login.setBackground(new java.awt.Color(102, 102, 102));
        login.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/login.png"))); // NOI18N
        login.setText("Login");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel2.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 500, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Password :-");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 224, 135, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Confirm Password :-");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 285, 215, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Firstname :-");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 36, 135, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Contact No. :-");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 411, 215, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("D.O.B :-");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 135, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Username :-");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 164, 135, -1));

        password.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordKeyReleased(evt);
            }
        });
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 230, -1));

        confirmpassword.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        confirmpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmpasswordActionPerformed(evt);
            }
        });
        confirmpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmpasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                confirmpasswordKeyReleased(evt);
            }
        });
        jPanel2.add(confirmpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 230, -1));

        dob.setPreferredSize(new java.awt.Dimension(64, 33));
        jPanel2.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 347, 230, -1));

        password_error.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        password_error.setForeground(new java.awt.Color(204, 0, 51));
        jPanel2.add(password_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 224, 176, 30));

        contact_error.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        contact_error.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(contact_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 410, 171, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 700, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
     if(validation())
     {
         insertDetails();
     }
    }//GEN-LAST:event_signupActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void confirmpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpasswordActionPerformed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        // TODO add your handling code here:
        checkPassword();
    }//GEN-LAST:event_passwordKeyPressed

    private void passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyReleased
checkPassword();

        // TODO add your handling code here:
    }//GEN-LAST:event_passwordKeyReleased

    private void contactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactKeyReleased
        // TODO add your handling code here:
        checkContactNo();
    }//GEN-LAST:event_contactKeyReleased

    private void contactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactKeyPressed
        // TODO add your handling code here:
        checkContactNo();
    }//GEN-LAST:event_contactKeyPressed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
         Login login = new Login();
         login.show();
       this.dispose();
        
    }//GEN-LAST:event_loginActionPerformed

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_loginMouseClicked

    private void confirmpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmpasswordKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_confirmpasswordKeyReleased

    private void confirmpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmpasswordKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpasswordKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run()
            {
                new SignupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmpassword;
    private javax.swing.JTextField contact;
    private javax.swing.JLabel contact_error;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField lastname;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel password_error;
    private javax.swing.JButton signup;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
