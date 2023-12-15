/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fees_management_system;

/**
 *
 * @author kuson
 */

import java.sql.*;

public class JDBConnection{
    
    public  static Connection getConnection()
    {
        Connection con  = null;
        
        try 
        {
            Class.forName("\"com.mysql.cj.jdbc.Driver\"");
                    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fees_management","root","");
            
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        
        return con;
    }
}