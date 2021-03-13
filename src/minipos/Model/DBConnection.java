/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minipos.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdelrahman
 */
public class DBConnection {
    Connection conn=null;
    String serverIP = "localhost";
    String serverPort = "3306";
    String schemaName="store";
    String dbUser="root";
    String dbPass="";
    
    
    public Connection createConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+serverIP+":"+serverPort+"/"+schemaName , dbUser, dbPass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
     public  void closeConnection() throws SQLException{
        if (conn != null || !conn.isClosed()) {
            conn.close();
        }
    }
}
