/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author kuson
 */
public class EditCourse extends javax.swing.JFrame {

    /**
     * Creates new form EditCourse
     */
    
     DefaultTableModel model ;
     
    public EditCourse() {
        initComponents();
        setRecordsToTable();
    }
    
    public void setRecordsToTable()
    {
        try
        {
              Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fees_management","root","");
            PreparedStatement pst = con.prepareStatement( "select * from course");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                String courseId = rs.getString("Id");
                String courseName = rs.getString("CNAME");
                String coursePrice =rs.getString("COST");
                
                
                Object[] obj = {courseId,courseName,coursePrice};
               model = (DefaultTableModel)tbl_courseData.getModel();
               model.addRow(obj);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    public void clearTable()
    {
        DefaultTableModel model = (DefaultTableModel)tbl_courseData.getModel();
        model.setRowCount(0);
    }
    
    public void addCourse(int id , String cname , double cost)
    {
        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fees_management","root","");
            PreparedStatement pst = con.prepareStatement( "insert into course values(?,?,?)");
        
             pst.setInt(1, id);
             pst.setString(2, cname);
             pst.setDouble(3, cost);
             
                 int rowcount = pst.executeUpdate();
                 if(rowcount==1)
                 {
                     JOptionPane.showMessageDialog(this,"Course Added SuccessFully");
                     clearTable();
                     setRecordsToTable();
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(this,"Course Insertion Failed");
                 }
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(this,"Error");
             e.printStackTrace();
        }
    }

        public void update(int id , String cname , double cost)
        {
            try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fees_management","root","");
            PreparedStatement pst = con.prepareStatement( "update course set CNAME =?,COSt=? where ID =?");
            
        
             
             pst.setString(1, cname);
             pst.setDouble(2, cost);
             pst.setInt(3, id);
             
                 int rowcount = pst.executeUpdate();
                 if(rowcount==1)
                 {
                     JOptionPane.showMessageDialog(this,"Course Updated SuccessFully");
                     clearTable();
                     setRecordsToTable();
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(this,"Course Updation Failed");
                 }
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(this,"Error");
             e.printStackTrace();
        }
        }
             
         public void delete(int id )
        {
            try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fees_management","root","");
            PreparedStatement pst = con.prepareStatement( "delete from course where id = ?");
            
             pst.setInt(1, id);
             
                 int rowcount = pst.executeUpdate();
                 if(rowcount==1)
                 {
                     JOptionPane.showMessageDialog(this,"Course Deleted SuccessFully");
                     clearTable();
                     setRecordsToTable();
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(this,"Course Deletion Failed");
                 }
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(this,"Error");
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
        jPanel1 = new javax.swing.JPanel();
        txt_coursePrice = new javax.swing.JTextField();
        txt_courseId = new javax.swing.JTextField();
        txt_courseName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_courseData = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsidebar.setBackground(new java.awt.Color(0, 102, 102));
        panelsidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelhome.setBackground(new java.awt.Color(0, 102, 102));
        labelhome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        labelhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelhomeMouseClicked(evt);
            }
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

        panelsidebar.add(labelhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 300, 80));

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

        panelsidebar.add(labelrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 300, 80));

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

        panelsidebar.add(labelcourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 300, 80));

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

        panelsidebar.add(labellist, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 300, 80));

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

        panelsidebar.add(labelallrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 300, 80));

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

        panelsidebar.add(labelback, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 300, 80));

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
        btn_home6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_home6MouseClicked(evt);
            }
        });
        labellogout.add(btn_home6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 220, 70));

        panelsidebar.add(labellogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 300, 80));

        getContentPane().add(panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 0, 330, 810));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_coursePrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txt_coursePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, 320, 40));

        txt_courseId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txt_courseId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 320, 40));

        txt_courseName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txt_courseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 320, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Course Price :-");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 160, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Edit Course Details ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 270, 60));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Course Name :-");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 160, 40));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 120, 40));

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 110, 40));

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("UPDATE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 660, 110, 40));

        tbl_courseData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_courseData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Id", "Course Name", "Course Price"
            }
        ));
        tbl_courseData.setGridColor(new java.awt.Color(102, 102, 102));
        tbl_courseData.setRowHeight(35);
        tbl_courseData.setRowMargin(4);
        tbl_courseData.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tbl_courseData.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_courseData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_courseDataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_courseData);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 630, 650));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Course Id :-");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 140, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 340, 4));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/back1.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 850));

        setSize(new java.awt.Dimension(1554, 817));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        // TODO add your handling code here:
        Home home = new Home();
        home.show();
        this.dispose();
    }//GEN-LAST:event_btn_homeMouseClicked

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

    private void btn_recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_recordMouseClicked
        // TODO add your handling code here:
        SearchRecord search = new SearchRecord();
        search.show();
        this.dispose();
    }//GEN-LAST:event_btn_recordMouseClicked

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          int id = Integer.parseInt(txt_courseId.getText());
        
       delete( id );
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        int id = Integer.parseInt(txt_courseId.getText());
        String cname = txt_courseName.getText();
        double cost = Double.parseDouble(txt_coursePrice.getText());
        
       addCourse( id ,cname ,cost);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          int id = Integer.parseInt(txt_courseId.getText());
        String cname = txt_courseName.getText();
        double cost = Double.parseDouble(txt_coursePrice.getText());
        
       update( id ,cname ,cost);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_courseDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_courseDataMouseClicked
        // TODO add your handling code here:
       int rowNo = tbl_courseData.getSelectedRow();
       TableModel model = tbl_courseData.getModel();
       
       txt_courseId.setText((String)model.getValueAt(rowNo, 0));
       txt_courseName.setText((String)model.getValueAt(rowNo, 1));
       txt_coursePrice.setText((String)model.getValueAt(rowNo, 2));
    }//GEN-LAST:event_tbl_courseDataMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void labelhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelhomeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_labelhomeMouseClicked

    private void btn_coursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_coursesMouseClicked
        // TODO add your handling code here:
        
        EditCourse edit = new EditCourse();
        edit.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_coursesMouseClicked

    private void btn_home4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_home4MouseClicked
        // TODO add your handling code here:
         ViewAllRecords allrecords = new ViewAllRecords();
        allrecords.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_home4MouseClicked

    private void btn_home6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_home6MouseClicked
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_home6MouseClicked

    private void btn_home5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_home5MouseClicked
        // TODO add your handling code here:
         AddFees addfees = new AddFees();
        addfees.setVisible(true);
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
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_courses;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel btn_home3;
    private javax.swing.JLabel btn_home4;
    private javax.swing.JLabel btn_home5;
    private javax.swing.JLabel btn_home6;
    private javax.swing.JLabel btn_record;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel labelallrecord;
    private javax.swing.JPanel labelback;
    private javax.swing.JPanel labelcourses;
    private javax.swing.JPanel labelhome;
    private javax.swing.JPanel labellist;
    private javax.swing.JPanel labellogout;
    private javax.swing.JPanel labelrecord;
    private javax.swing.JPanel panelsidebar;
    private javax.swing.JTable tbl_courseData;
    private javax.swing.JTextField txt_courseId;
    private javax.swing.JTextField txt_courseName;
    private javax.swing.JTextField txt_coursePrice;
    // End of variables declaration//GEN-END:variables
}
