/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mysoulmates.controllers.ControllerDisplayWishList;
import mysoulmates.controllers.Controller_Command;
import mysoulmates.controllers.Controller_Wishlist;
import mysoulmates.entities.Command;
import mysoulmates.entities.User;
import mysoulmates.utils.Bd;

/**
 *
 * @author Mohamed
 */
public class service_Command {
    
            static Bd bd = Bd.getInstance();

    public static void insertBillingInformation(User c)
    {
        String req ="insert into command (first_name,last_name,dob,address,city,state,zip,phone,contact_email,creation_date,price) values (?,?,?,?,?,?,?,?,?,NOW(),?)";
        
        PreparedStatement statement;
                try {
                    statement = bd.getConnection().prepareStatement(req);
                    statement.setString(1, c.getCommand().getFname());
                    statement.setString(2, c.getCommand().getLname());
                    statement.setString(3, c.getCommand().getDob().toString());
                    statement.setString(4, c.getCommand().getAddress());
                    statement.setString(5, c.getCommand().getCity());
                    statement.setString(6, c.getCommand().getState());
                    statement.setString(7, c.getCommand().getZip());
                    statement.setString(8, c.getCommand().getPhone());
                    statement.setString(9, c.getCommand().getCemail());
                    statement.setDouble(10,Controller_Wishlist.CalculatePrix(c));

                    statement.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(service_Command.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
    }
        public static  HashMap<String,Object>getCommandInfo(User c)
    {
        String req = "select * from command where contact_email = ? ";
        Map<String,Object> billingInformation = new HashMap<String,Object>();
        try {
            PreparedStatement statement = bd.getConnection().prepareStatement(req);
            statement.setString(1, c.getEmail());
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
                //increment by 1 
                billingInformation.put("fname", result.getString(2));
                billingInformation.put("lname",result.getString(3));
                billingInformation.put("dob",result.getString(4));
                billingInformation.put("address", result.getString(5));
                billingInformation.put("city", result.getString(6));
                billingInformation.put("state", result.getString(7));
                billingInformation.put("zip", result.getString(8));
                billingInformation.put("phone", result.getString(9));
                billingInformation.put("contact_email", result.getString(10));
                billingInformation.put("ammount", result.getDouble(12));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Command.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (HashMap<String, Object>) billingInformation;
        
    }
            
        public static  ObservableList<Command>getCommandInfo()
    {
        String req = "select * from command";
        ObservableList<Command> billingInformation = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = bd.getConnection().prepareStatement(req);
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
                //increment by 1 
                billingInformation.add(new Command(result.getString("first_name"),result.getString("last_name"), result.getString("address"),result.getString("city"),result.getString("state"),result.getString("creation_date"), result.getInt("price")));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Command.class.getName()).log(Level.SEVERE, null, ex);
        }

        return billingInformation;
        
    }
    
}
