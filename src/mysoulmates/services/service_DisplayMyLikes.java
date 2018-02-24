/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysoulmates.utils.Bd;

/**
 *
 * @author Mohamed
 */
public class service_DisplayMyLikes {
    public static String emailCliked="mohamed.abdelhafidh@esprit.tn";
    public static String fname,lname,age,phone,signDate,address,city,state,zip,membership,image,gender="";
            static Bd bd = Bd.getInstance();
    public static void getClickedInfo(String emailCliked)
    {
        if (!(emailCliked.equals("")))
        {
        String req="select * from user where email = ?";
        
        try {
            PreparedStatement statement =bd.getConnection().prepareStatement(req);
            statement.setString(1, emailCliked);
            ResultSet result = statement.executeQuery();
            while(result.next())
            {
                fname=result.getString("fname");
                lname=result.getString("lname");
                age=result.getString("age");
                phone=result.getString("phoneNumber");
                signDate=result.getString("date_SU");
                address=result.getString("address");
                city=result.getString("city");
                state=result.getString("state");
                zip=result.getString("zip");
                membership=result.getString("membership");
                image=result.getString("image");
                gender=result.getString("gender");
                
            }
            

        } catch (SQLException ex) {
                Logger.getLogger(service_DisplayMyLikes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    }
}
