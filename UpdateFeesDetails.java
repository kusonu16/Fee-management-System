/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system;

//import com.sun.jdi.connect.spi.Connection;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JOptionPane;
import java.sql.*;

import java.text.SimpleDateFormat;
/**
 *
 * @author kuson
 */
public class UpdateFeesDetails extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
    public UpdateFeesDetails() {
        initComponents();
        displayCashFirst();
        comboBox();
   
//         Container c = getContentPane();
//         c.setBackground(new Color(0,153,153));
        
        int receiptNo = getReceiptNo();
        txt_receiptno.setText(Integer.toString(receiptNo));
        
        setRecords();
        
    }
    
    
    public void displayCashFirst()
    {
        DD_No.setVisible(false);
        Cheque_No.setVisible(false);
        bankName.setVisible(false);
        
        txt_chequeNo.setVisible(false);
         txt_ddNo.setVisible(false);
         txt_bankName.setVisible(false);
    }
    
    public boolean validation()
    {
//        if(txt_receiptno.getText().equals(""))
//        {
//             JOptionPane.showMessageDialog(this,"Please Enter Receipt No.");
//            return false;
//        }
        if(txt_Received_From.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Enter Received From");
            return false;
        }
        
         if(DateChooser.getDate()==null)
        {
            JOptionPane.showMessageDialog(this,"Please Select a Date");
            return false;
        }
         
         
         
         if(Combo_paymentMode.getSelectedItem().toString().equalsIgnoreCase("Cheque"))
         {
       
             if(txt_chequeNo.getText().equals(""))
             {
                 JOptionPane.showMessageDialog(this,"Please Enter Cheque Number ");
            return false;
             }
             
          if(txt_bankName.getText().equals(""))
             {
                 JOptionPane.showMessageDialog(this,"Please Enter Bank Name ");
            return false;
             }   
         }
         
         if(Combo_paymentMode.getSelectedItem().toString().equalsIgnoreCase("DD"))
         {
             if(txt_ddNo.getText().equals(""))
             {
                  JOptionPane.showMessageDialog(this,"Please Enter DD Number");
            return false;
             }
            if(txt_bankName.getText().equals(""))
             {
                 JOptionPane.showMessageDialog(this,"Please Enter Bank Name ");
            return false;
             } 
         }
         
         if(Combo_paymentMode.getSelectedItem().toString().equalsIgnoreCase("card"))
         {
             if(txt_bankName.getText().equals(""))
             {
                 JOptionPane.showMessageDialog(this,"Please Enter Bank Name ");
            return false;
             } 
         }
         if(txt_amount.getText().equals("") || txt_amount.getText().matches("[0-9]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter Amount(in numbers)");
            return false;
        }
        return true;
    }
    

    
    
    public void comboBox()
    {
          try {
            // TODO add your handling code here:
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con  = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fees_management","root","");
            PreparedStatement stm = con.prepareStatement("SELECT CNAME FROM course");
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                String name  = rs.getString("CNAME");
                Combo_Course.addItem(name);
                
            }
           txt_CourseName.setText(null);
//            Combo_Course.setSelectedItem(null);

        
        } 
        catch (Exception ex) {
           ex.printStackTrace();
           System.out.println(ex);
        }
    }
    
    
    
    public int getReceiptNo()
    {
        int receiptNo = 0;
        try
        {
//            Connection con = JDBConnection.getConnection();
            
             Class.forName("com.mysql.cj.jdbc.Driver");
           
                   Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fees_management","root","");
            
            PreparedStatement pst = con.prepareStatement("Select max(reciept_no) from fees_Details");
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()== true)
            {
               receiptNo = rs.getInt(1);
            }
        }
        catch(Exception e)
        {
         e.printStackTrace();

        }
        return receiptNo+1 ;
    }
    
    public String updateData()
    {
        String status = " " ;
        
        int receiptNo = Integer.parseInt( txt_receiptno.getText());
        String studentName = txt_Received_From.getText();
        String rollNo = txt_rollNo.getText();
        String paymentMode = Combo_paymentMode.getSelectedItem().toString();
        String chequeNo = txt_chequeNo.getText();
        String bankname = txt_bankName.getText();
        String ddNO = txt_ddNo.getText();
        String courseName = txt_CourseName.getText();
        String gstin = txt_GSTNo.getText();
        float totalAmount = Float.parseFloat(txt_total.getText());
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String date = dateFormat.format(DateChooser.getDate());
        int initialAmount = Integer.parseInt(txt_amount.getText());
        float cgst = Float.parseFloat(txt_CGST.getText());
        float sgst = Float.parseFloat(txt_SGST.getText());
        String totalInWords = txt_total_words.getText();
        String remark = txt_remark.getText();
        int year1 = Integer.parseInt(txt_Year1.getText());
        int year2 = Integer.parseInt(txt_Year2.getText());
        
        try
        {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fees_management","root","");
             String sql = "update fees_details set student_name=?,roll_no=?,payment_mode=?,cheque_no=?,bank_name=?,"
                     +"dd_no=?,courses=?,gstin=?,date=?,amount=?,cgst=?,sgst=?,total_amount=?,total_in_words = ?,year1=?,year2=?,remark=? where reciept_no=?";
           
            PreparedStatement pst = con.prepareStatement(sql);
           
            pst.setString(1,studentName);
            pst.setString(2,paymentMode);
            pst.setString(3,rollNo);
            pst.setString(4, chequeNo);
            pst.setString(5, bankname);
            pst.setString(6,ddNO);
            pst.setString(7,courseName);
            pst.setString(8, gstin);
            pst.setString(9,date);
            pst.setFloat(10,initialAmount);
            pst.setFloat(11, cgst);
            pst.setFloat(12,sgst);
            pst.setFloat(13, totalAmount);
            pst.setString(14, totalInWords);
            pst.setInt(15,year1);
            pst.setInt(16,year2);
            pst.setString(17,remark);
             pst.setInt(18,receiptNo );
            
           int rowCount = pst.executeUpdate();
           if(rowCount==1)
           {
               status = "Success";
                 JOptionPane.showMessageDialog(this,"Successfull");
           }
           else
           {
               status = "Failed";
                 JOptionPane.showMessageDialog(this,"Error");
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        return status;
    }

    public void setRecords()
    {
        try{
            
             Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fees_management","root","");
            PreparedStatement pst = con.prepareStatement("Select * from fees_details order by reciept_no desc limit 1");
            ResultSet rs = pst.executeQuery();
            rs.next();
            txt_receiptno.setText(rs.getString("reciept_no"));
            Combo_paymentMode.setSelectedItem(rs.getString("payment_mode"));
            txt_chequeNo.setText((rs.getString("cheque_no")));
            txt_ddNo.setText(rs.getString("dd_no"));
            txt_bankName.setText(rs.getString("bank_name"));
            txt_Received_From.setText(rs.getString("student_name"));
            DateChooser.setDate(rs.getDate("date"));
            txt_rollNo.setText(rs.getString("roll_no"));
            Combo_Course.setSelectedItem(rs.getString("courses"));
            txt_amount.setText(rs.getString("amount"));
               txt_total.setText(rs.getString("total_amount"));
            txt_total_words.setText(rs.getString("total_in_words"));
            txt_SGST.setText(rs.getString("sgst"));
            txt_CGST.setText(rs.getString("cgst"));
            txt_Year1.setText(rs.getString("year1"));
            txt_Year2.setText(rs.getString("year2"));
            txt_remark.setText(rs.getString("remark"));
            
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelsidebar = new javax.swing.JPanel();
        labelhome = new javax.swing.JPanel();
        btn_home = new javax.swing.JLabel();
        labelrecord = new javax.swing.JPanel();
        btn_record = new javax.swing.JLabel();
        labelcourses = new javax.swing.JPanel();
        btn_courses = new javax.swing.JLabel();
        labellist = new javax.swing.JPanel();
        btn_home3 = new javax.swing.JLabel();
        labelallrecord = new javax.swing.JPanel();
        btn_home4 = new javax.swing.JLabel();
        labelback = new javax.swing.JPanel();
        btn_home5 = new javax.swing.JLabel();
        labellogout = new javax.swing.JPanel();
        btn_home6 = new javax.swing.JLabel();
        panelparent = new javax.swing.JPanel();
        txt_GSTNo = new javax.swing.JLabel();
        Receipt_No = new javax.swing.JLabel();
        Payment_Mode = new javax.swing.JLabel();
        DD_No = new javax.swing.JLabel();
        Cheque_No = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_receiptno = new javax.swing.JTextField();
        txt_chequeNo = new javax.swing.JTextField();
        txt_ddNo = new javax.swing.JTextField();
        DateChooser = new com.toedter.calendar.JDateChooser();
        panelChild = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_Year1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_total_words = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Combo_Course = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_CourseName = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_CGST = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txt_SGST = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_Received_From = new javax.swing.JTextField();
        txt_rollNo = new javax.swing.JTextField();
        txt_Year2 = new javax.swing.JTextField();
        bankName = new javax.swing.JLabel();
        Combo_paymentMode = new javax.swing.JComboBox<>();
        txt_bankName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsidebar.setBackground(new java.awt.Color(0, 102, 102));
        panelsidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelhome.setBackground(new java.awt.Color(0, 102, 102));
        labelhome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        labelhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelhomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelhomeMouseExited(evt);
            }
        });
        labelhome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home.setFont(new java.awt.Font("Sylfaen", 1, 30)); // NOI18N
        btn_home.setForeground(new java.awt.Color(255, 255, 255));
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        btn_home.setText(" HOME");
        btn_home.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homeMouseClicked(evt);
            }
        });
        labelhome.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 70));

        panelsidebar.add(labelhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 300, 80));

        labelrecord.setBackground(new java.awt.Color(0, 102, 102));
        labelrecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        labelrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelrecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelrecordMouseExited(evt);
            }
        });
        labelrecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_record.setFont(new java.awt.Font("Sylfaen", 1, 30)); // NOI18N
        btn_record.setForeground(new java.awt.Color(255, 255, 255));
        btn_record.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/search2.png"))); // NOI18N
        btn_record.setText("Search Record");
        btn_record.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_record.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_recordMouseClicked(evt);
            }
        });
        labelrecord.add(btn_record, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, 70));

        panelsidebar.add(labelrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 300, 80));

        labelcourses.setBackground(new java.awt.Color(0, 102, 102));
        labelcourses.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        labelcourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelcoursesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelcoursesMouseExited(evt);
            }
        });
        labelcourses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_courses.setFont(new java.awt.Font("Sylfaen", 1, 30)); // NOI18N
        btn_courses.setForeground(new java.awt.Color(255, 255, 255));
        btn_courses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/edit2.png"))); // NOI18N
        btn_courses.setText(" Edit Courses");
        btn_courses.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_courses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_coursesMouseClicked(evt);
            }
        });
        labelcourses.add(btn_courses, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, -1));

        panelsidebar.add(labelcourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 300, 80));

        labellist.setBackground(new java.awt.Color(0, 102, 102));
        labellist.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        labellist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labellistMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labellistMouseExited(evt);
            }
        });
        labellist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home3.setFont(new java.awt.Font("Sylfaen", 1, 30)); // NOI18N
        btn_home3.setForeground(new java.awt.Color(255, 255, 255));
        btn_home3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/list.png"))); // NOI18N
        btn_home3.setText(" Course List");
        btn_home3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        labellist.add(btn_home3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 60));

        panelsidebar.add(labellist, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 300, 80));

        labelallrecord.setBackground(new java.awt.Color(0, 102, 102));
        labelallrecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        labelallrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelallrecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelallrecordMouseExited(evt);
            }
        });
        labelallrecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home4.setFont(new java.awt.Font("Sylfaen", 1, 30)); // NOI18N
        btn_home4.setForeground(new java.awt.Color(255, 255, 255));
        btn_home4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/view all record.png"))); // NOI18N
        btn_home4.setText("View All Record");
        btn_home4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_home4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_home4MouseClicked(evt);
            }
        });
        labelallrecord.add(btn_home4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 70));

        panelsidebar.add(labelallrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 300, 80));

        labelback.setBackground(new java.awt.Color(0, 102, 102));
        labelback.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        labelback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelbackMouseExited(evt);
            }
        });
        labelback.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home5.setFont(new java.awt.Font("Sylfaen", 1, 30)); // NOI18N
        btn_home5.setForeground(new java.awt.Color(255, 255, 255));
        btn_home5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/back-button.png"))); // NOI18N
        btn_home5.setText(" Back");
        btn_home5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_home5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_home5MouseClicked(evt);
            }
        });
        labelback.add(btn_home5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 250, 70));

        panelsidebar.add(labelback, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 300, 80));

        labellogout.setBackground(new java.awt.Color(0, 102, 102));
        labellogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        labellogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labellogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labellogoutMouseExited(evt);
            }
        });
        labellogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home6.setFont(new java.awt.Font("Sylfaen", 1, 30)); // NOI18N
        btn_home6.setForeground(new java.awt.Color(255, 255, 255));
        btn_home6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/logout.png"))); // NOI18N
        btn_home6.setText(" Logout");
        btn_home6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        labellogout.add(btn_home6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 220, 70));

        panelsidebar.add(labellogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 300, 80));

        getContentPane().add(panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 810));

        panelparent.setBackground(new java.awt.Color(0, 153, 153));
        panelparent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_GSTNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_GSTNo.setText("22HVSJH55");
        panelparent.add(txt_GSTNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 120, -1));

        Receipt_No.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Receipt_No.setText("Receipt no. :- COT-");
        panelparent.add(Receipt_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 160, 30));

        Payment_Mode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Payment_Mode.setText("Mode of Payment :-");
        panelparent.add(Payment_Mode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 180, 30));

        DD_No.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DD_No.setText("DD no. :-");
        panelparent.add(DD_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 110, 30));

        Cheque_No.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Cheque_No.setText("Cheque no. :-");
        panelparent.add(Cheque_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 120, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Date :-");
        panelparent.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 70, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("GSTIN :-");
        panelparent.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 80, -1));

        txt_receiptno.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_receiptno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receiptnoActionPerformed(evt);
            }
        });
        panelparent.add(txt_receiptno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 290, 30));

        txt_chequeNo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_chequeNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_chequeNoActionPerformed(evt);
            }
        });
        panelparent.add(txt_chequeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 290, 30));

        txt_ddNo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_ddNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ddNoActionPerformed(evt);
            }
        });
        panelparent.add(txt_ddNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 290, 30));
        panelparent.add(DateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 230, 30));

        panelChild.setBackground(new java.awt.Color(0, 153, 153));
        panelChild.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("The following payment in the college office for the year :-");
        panelChild.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 470, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText(" to");
        panelChild.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, 30, 30));

        txt_Year1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Year1ActionPerformed(evt);
            }
        });
        panelChild.add(txt_Year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 160, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Recieved From :-");
        panelChild.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 150, 40));

        txt_total_words.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelChild.add(txt_total_words, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 470, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Roll No. :-");
        panelChild.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 90, 30));

        Combo_Course.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Combo_Course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_CourseActionPerformed(evt);
            }
        });
        panelChild.add(Combo_Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 250, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Amount(Rs.).");
        panelChild.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 110, -1));

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panelChild.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1140, 20));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        panelChild.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 380, 250, 10));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Course :-");
        panelChild.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 100, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Reciever Signature");
        panelChild.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, 160, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Head");
        panelChild.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 60, -1));

        txt_CourseName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_CourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CourseNameActionPerformed(evt);
            }
        });
        panelChild.add(txt_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 420, 30));

        txt_amount.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        panelChild.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, 160, 30));

        txt_CGST.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelChild.add(txt_CGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 240, 160, 30));

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        panelChild.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1140, 10));

        txt_SGST.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelChild.add(txt_SGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, 160, 30));

        txt_total.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelChild.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 340, 210, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("SGST. 9%");
        panelChild.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 90, 30));

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        panelChild.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 330, 250, 10));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setText("Total in Words :-");
        panelChild.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 140, 40));

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        jScrollPane1.setViewportView(txt_remark);

        panelChild.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 400, 90));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("Remark :-");
        panelChild.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 90, 40));

        btn_print.setBackground(new java.awt.Color(102, 102, 102));
        btn_print.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setText("Print");
        btn_print.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        panelChild.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 510, 70, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("S.No.");
        panelChild.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 60, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setText("CGST. 9%");
        panelChild.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 90, 30));

        txt_Received_From.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelChild.add(txt_Received_From, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 290, 40));

        txt_rollNo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_rollNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rollNoActionPerformed(evt);
            }
        });
        panelChild.add(txt_rollNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 130, 30));

        txt_Year2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_Year2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Year2ActionPerformed(evt);
            }
        });
        panelChild.add(txt_Year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, 160, 30));

        panelparent.add(panelChild, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 570));

        bankName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bankName.setText("Bank Name :- ");
        panelparent.add(bankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 120, 30));

        Combo_paymentMode.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Combo_paymentMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "Cash", "Card" }));
        Combo_paymentMode.setSelectedIndex(2);
        Combo_paymentMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_paymentModeActionPerformed(evt);
            }
        });
        panelparent.add(Combo_paymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 290, -1));

        txt_bankName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelparent.add(txt_bankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 290, 30));

        getContentPane().add(panelparent, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 1140, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelhomeMouseEntered
        // TODO add your handling code here:
         Color clr  = new Color(0,51,51);
        labelhome.setBackground(clr);
    }//GEN-LAST:event_labelhomeMouseEntered

    private void labelhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelhomeMouseExited
        // TODO add your handling code here:
         Color clr  = new Color(0,102,102);
        labelhome.setBackground(clr);
    }//GEN-LAST:event_labelhomeMouseExited

    private void labelrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelrecordMouseEntered
        // TODO add your handling code here:
         Color clr  = new Color(0,51,51);
        labelrecord.setBackground(clr);
    }//GEN-LAST:event_labelrecordMouseEntered

    private void labelrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelrecordMouseExited
        // TODO add your handling code here:
        Color clr  = new Color(0,102,102);
        labelrecord.setBackground(clr);
    }//GEN-LAST:event_labelrecordMouseExited

    private void labelcoursesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcoursesMouseEntered
        // TODO add your handling code here:
         Color clr  = new Color(0,51,51);
        labelcourses.setBackground(clr);
    }//GEN-LAST:event_labelcoursesMouseEntered

    private void labelcoursesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcoursesMouseExited
        // TODO add your handling code here:
        Color clr  = new Color(0,102,102);
        labelcourses.setBackground(clr);
    }//GEN-LAST:event_labelcoursesMouseExited

    private void labellistMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labellistMouseEntered
        // TODO add your handling code here:
         Color clr  = new Color(0,51,51);
        labellist.setBackground(clr);
    }//GEN-LAST:event_labellistMouseEntered

    private void labellistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labellistMouseExited
        // TODO add your handling code here:
        Color clr  = new Color(0,102,102);
        labellist.setBackground(clr);
    }//GEN-LAST:event_labellistMouseExited

    private void labelallrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelallrecordMouseEntered
        // TODO add your handling code here:
         Color clr  = new Color(0,51,51);
        labelallrecord.setBackground(clr);
    }//GEN-LAST:event_labelallrecordMouseEntered

    private void labelallrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelallrecordMouseExited
        // TODO add your handling code here:
        Color clr  = new Color(0,102,102);
        labelallrecord.setBackground(clr);
    }//GEN-LAST:event_labelallrecordMouseExited

    private void labelbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelbackMouseEntered
        // TODO add your handling code here:
         Color clr  = new Color(0,51,51);
        labelback.setBackground(clr);
    }//GEN-LAST:event_labelbackMouseEntered

    private void labelbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelbackMouseExited
        // TODO add your handling code here:
        Color clr  = new Color(0,102,102);
        labelback.setBackground(clr);
    }//GEN-LAST:event_labelbackMouseExited

    private void labellogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labellogoutMouseEntered
        // TODO add your handling code here:
         Color clr  = new Color(0,51,51);
        labellogout.setBackground(clr);
    }//GEN-LAST:event_labellogoutMouseEntered

    private void labellogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labellogoutMouseExited
        // TODO add your handling code here:
        Color clr  = new Color(0,102,102);
        labellogout.setBackground(clr);
    }//GEN-LAST:event_labellogoutMouseExited

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        // TODO add your handling code here:
        Home home = new Home();
        home.show();
        this.dispose();
    }//GEN-LAST:event_btn_homeMouseClicked

    private void btn_recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_recordMouseClicked
        // TODO add your handling code here:
        SearchRecord search = new SearchRecord();
        search.show();
        this.dispose();
    }//GEN-LAST:event_btn_recordMouseClicked

    private void btn_home4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_home4MouseClicked
        // TODO add your handling code here:
         ViewAllRecords allrecords = new ViewAllRecords();
        allrecords.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_home4MouseClicked

    private void btn_coursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_coursesMouseClicked
        // TODO add your handling code here:
          EditCourse edit = new EditCourse();
        edit.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_coursesMouseClicked

    private void Combo_paymentModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_paymentModeActionPerformed
        // TODO add your handling code here:
        if(Combo_paymentMode.getSelectedIndex() == 0)
        {
            DD_No.setVisible(true);
            txt_ddNo.setVisible(true);
            Cheque_No.setVisible(false);
            txt_chequeNo.setVisible(false);
            bankName.setVisible(true);
            txt_bankName.setVisible(true);

        }

        if(Combo_paymentMode.getSelectedIndex() == 1)
        {
            DD_No.setVisible(false);
            txt_ddNo.setVisible(false);
            Cheque_No.setVisible(true);
            txt_chequeNo.setVisible(true);
            bankName.setVisible(true);
            txt_bankName.setVisible(true);

        }

        if(Combo_paymentMode.getSelectedIndex() == 2)
        {
            DD_No.setVisible(false);
            txt_ddNo.setVisible(false);
            Cheque_No.setVisible(false);
            txt_chequeNo.setVisible(false);
            bankName.setVisible(false);
            txt_bankName.setVisible(false);

        }
        if(Combo_paymentMode.getSelectedIndex()==3)
        {
            DD_No.setVisible(false);
            txt_ddNo.setVisible(false);
            Cheque_No.setVisible(false);
            txt_chequeNo.setVisible(false);
            bankName.setVisible(true);
            txt_bankName.setVisible(true);

        }
    }//GEN-LAST:event_Combo_paymentModeActionPerformed

    private void txt_Year2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Year2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Year2ActionPerformed

    private void txt_rollNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rollNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rollNoActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        // TODO add your handling code here:
        if(validation())
        {
            //            JOptionPane.showMessageDialog(this,"Validation Successfull");
            String result = updateData();

            if(result.equals("Failed"))
            {
                JOptionPane.showMessageDialog(this,"Record updation Failed");
            }
            else
            {

                JOptionPane.showMessageDialog(this,"Record updated Sucessfully");
                PrintReciept p =  new PrintReciept();
                p.setVisible(true);
                this.dispose();
            }
        }

    }//GEN-LAST:event_btn_printActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
        // TODO add your handling code here:
        float amnt = Float.parseFloat(txt_amount.getText());

        Float cgst  = (float)(amnt * 0.09);
        Float sgst  = (float)(amnt * 0.09);

        txt_CGST.setText(cgst.toString());
        txt_SGST.setText(sgst.toString());

        float total = amnt + cgst + sgst;

        txt_total.setText(Float.toString(total));

        txt_total_words.setText(NumberToWordsConverter.convert((int)total)+" only");
    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_CourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CourseNameActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_CourseNameActionPerformed

    private void Combo_CourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_CourseActionPerformed
        // TODO add your handling code here:

        txt_CourseName.setText(Combo_Course.getSelectedItem().toString());

    }//GEN-LAST:event_Combo_CourseActionPerformed

    private void txt_Year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Year1ActionPerformed

    private void txt_chequeNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_chequeNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_chequeNoActionPerformed

    private void txt_receiptnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receiptnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receiptnoActionPerformed

    private void txt_ddNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ddNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ddNoActionPerformed

    private void btn_home5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_home5MouseClicked
        // TODO add your handling code here:
        PrintReciept print = new PrintReciept();
        print.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_home5MouseClicked

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
            java.util.logging.Logger.getLogger(UpdateFeesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateFeesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateFeesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateFeesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateFeesDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cheque_No;
    private javax.swing.JComboBox<String> Combo_Course;
    private javax.swing.JComboBox<String> Combo_paymentMode;
    private javax.swing.JLabel DD_No;
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JLabel Payment_Mode;
    private javax.swing.JLabel Receipt_No;
    private javax.swing.JLabel bankName;
    private javax.swing.JLabel btn_courses;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel btn_home3;
    private javax.swing.JLabel btn_home4;
    private javax.swing.JLabel btn_home5;
    private javax.swing.JLabel btn_home6;
    private javax.swing.JButton btn_print;
    private javax.swing.JLabel btn_record;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel labelallrecord;
    private javax.swing.JPanel labelback;
    private javax.swing.JPanel labelcourses;
    private javax.swing.JPanel labelhome;
    private javax.swing.JPanel labellist;
    private javax.swing.JPanel labellogout;
    private javax.swing.JPanel labelrecord;
    private javax.swing.JPanel panelChild;
    private javax.swing.JPanel panelparent;
    private javax.swing.JPanel panelsidebar;
    private javax.swing.JTextField txt_CGST;
    private javax.swing.JTextField txt_CourseName;
    private javax.swing.JLabel txt_GSTNo;
    private javax.swing.JTextField txt_Received_From;
    private javax.swing.JTextField txt_SGST;
    private javax.swing.JTextField txt_Year1;
    private javax.swing.JTextField txt_Year2;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bankName;
    private javax.swing.JTextField txt_chequeNo;
    private javax.swing.JTextField txt_ddNo;
    private javax.swing.JTextField txt_receiptno;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_rollNo;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_total_words;
    // End of variables declaration//GEN-END:variables
}
