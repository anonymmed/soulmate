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
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import mysoulmates.entities.User;
import mysoulmates.entities.Product;
import mysoulmates.utils.Bd;

/**
 *
 * @author Mohamed
 */

public class service_Wishliste {
    
        static Bd bd = Bd.getInstance();

        public static ObservableList<Product> displayWishListe(String email)
        {
            ObservableList<Product> l1 = FXCollections.observableArrayList();
                    String req="select * from wishlist where email_client = ? ";

                    try {
            PreparedStatement statement = bd.getConnection().prepareStatement(req);
            statement.setString(1, email);
            ResultSet rs= statement.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getString("prod_name"));
              l1.add(new Product(rs.getString("prod_name"),rs.getString("description"),rs.getInt("prod_price"),new ImageView("/mysoulmates/images/Transparent_Hearts_Decorative_Element.png")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
             
        }
        return l1;
        }
        
        
        public static void addToWishlist(ArrayList<Product> listeWish , String email)
    {
        for (Product p : listeWish)
        {
            

        try {
        String req="Insert into wishlist (prod_name,description,email_client,prod_price) values(?,?,?,?)";
       
            PreparedStatement statement = bd.getConnection().prepareStatement(req);
            statement.setString(1,p.getNom());
            statement.setString(2, p.getDescription());
            statement.setString(3,email);
            statement.setInt(4,p.getPrix());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }

        }

    }
        
        public static void DeleteFromWishList(Product p)
        {
            String req = "Delete from wishlist where prod_name = ?";
            try {
            PreparedStatement statement = bd.getConnection().prepareStatement(req);
            statement.setString(1, p.getNom());
            statement.executeUpdate();
            
            } catch (SQLException ex) {
              Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);

            }
            
        }
        
        
        
        public static int CalculatePrix(User c)
        {
            int prix=0;
            String req = "select prod_price from wishlist where email_client = ?";
            try {
                PreparedStatement statement = bd.getConnection().prepareStatement(req);
               statement.setString(1,c.getEmail());
               ResultSet rs = statement.executeQuery();
               while(rs.next())
               {
                   prix+=rs.getInt(1);
               }
            } 
            catch (SQLException ex) {
              Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);

            }
            return prix;
                   
        }
}
