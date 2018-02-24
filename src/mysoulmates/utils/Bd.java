/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ryhab
 */
public class Bd {
    static Bd instance;
    private String url="jdbc:mysql://localhost:3306/mysoulmate";
    private String user="root";
    private String  password="V4Vendetta";
      Connection connection ;
    private  Bd() {
        try {
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public static Bd getInstance(){
       if(instance==null){
           return instance=new Bd();
       }
       return instance;
   } 

       public Connection getConnection() {
        return connection;
    }
}
