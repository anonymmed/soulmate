/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysoulmates.entities.Client;
import mysoulmates.utils.Bd;

/**
 *
 * @author Mohamed
 */
public class service_Client {
    
            static Bd bd = Bd.getInstance();

    public static String getType(Client c1)
    {       
String type="";
                String req = "select type from user where email = ?";
                try {
                        PreparedStatement statement0 = bd.getConnection().prepareStatement(req);
            statement0.setString(1, c1.getEmail());
            ResultSet rs = statement0.executeQuery();
          while(rs.next())
          {
              type=rs.getString("type");
          }

        } catch (SQLException ex) {
                                  Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);

        }
return type;
    }
    
    public static void likeClient(Client c1,Client c2)
    {
        
        
        String req0 = "select likes from user where email = ?";
        
        String req = "insert into likes (liked,liked_by) values (?,?)";
        try {
            PreparedStatement statement0 = bd.getConnection().prepareStatement(req0);
            statement0.setString(1, c1.getEmail());
            ResultSet rs = statement0.executeQuery();
                                        int likes=0;
            while(rs.next())
            {
            likes =rs.getInt("likes");

            }
            if (likes<Client.MAX || getType(c1) == "vip")
            {
                            PreparedStatement statement = bd.getConnection().prepareStatement(req);
            statement.setString(1, c2.getEmail());
            statement.setString(2, c1.getEmail());
            statement.executeUpdate();
        
        String req2="update user set likes=likes+1 where email = ? and likes < ?";
        statement = bd.getConnection().prepareStatement(req2);
        statement.setString(1, c1.getEmail());
                statement.setInt(2,Client.MAX);
statement.executeUpdate();

            }
        
        } catch (SQLException ex ) {
                      Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);

        }
        
    }
    
    
    public static List<Client> DisplayLikes(Client c)
    {
        List<Client> l1 = new ArrayList<Client>();
        String req = "select liked from likes where liked_by = ?";
        try
        {
                    PreparedStatement statement = bd.getConnection().prepareStatement(req);
            statement.setString(1, c.getEmail());
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                l1.add(new Client(rs.getString("liked")));
            }
        }
        catch(SQLException ex)
        {
                                  Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);

        }
        return l1;
    }
    
    public static void DeleteLike(Client c1,Client c2)
    {
        String req  = "DELETE from likes where liked  = ? and liked_by = ?  ";
        
        try{
                    PreparedStatement statement = bd.getConnection().prepareStatement(req);
                    statement.setString(1, c2.getEmail());
                    statement.setString(2, c1.getEmail());
                    statement.executeUpdate();
                    
        }
        catch(SQLException ex)
        {
     Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
            
}
