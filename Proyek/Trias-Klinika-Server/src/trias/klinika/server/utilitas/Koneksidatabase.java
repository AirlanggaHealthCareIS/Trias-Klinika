/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trias.klinika.server.utilitas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faz
 */
public class Koneksidatabase {

   private static Connection connection;

    public static Connection getConnection() {
       if(connection == null){
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trias-klinika","root","");
            } catch (SQLException ex) {
                Logger.getLogger(Koneksidatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        return connection;
    }
    
}
