/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class DB_Connection {
    
    public Connection getConnection(){
       
        Connection con = null;
        
        try{
          Class.forName("com.mysql.jdbc.Driver");
          String url="jdbc:mysql://localhost:3307/city_bank_db";
          String user="root";
          String password="";
          
          con= DriverManager.getConnection(url, user, password);
          
          
        }
        
        catch(Exception e){
        
         JOptionPane.showMessageDialog(null,"Error encounterd while entering connection" +e);
        
        }
        
         return con;
    }
    
    
    
}
