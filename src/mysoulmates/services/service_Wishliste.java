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
import mysoulmates.entities.Client;
import mysoulmates.entities.Produit;
import mysoulmates.utils.Bd;

/**
 *
 * @author Mohamed
 */

public class service_Wishliste {
    
        static Bd bd = Bd.getInstance();

        public static ObservableList<Produit> displayWishListe(String email)
        {
            ObservableList<Produit> l1 = FXCollections.observableArrayList();
                    String req="select * from wishliste where email_client = ? ";

                    try {
            PreparedStatement statement = bd.getConnection().prepareStatement(req);
            statement.setString(1, email);
            ResultSet rs= statement.executeQuery();
            while(rs.next())
            {
              l1.add(new Produit(rs.getString("nom_prod"),rs.getString("description"),rs.getInt("prix_prod"),new ImageView("/mysoulmates/img/fb.png")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
             
        }
        return l1;
        }
        
        
        public static void addToWishlist(ArrayList<Produit> listeWish , String email)
    {
        for (Produit p : listeWish)
        {
            

        try {
        String req="Insert into wishliste (nom_prod,description,email_client,prix_prod) values(?,?,?,?)";
       
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
        
        public static void DeleteFromWishList(Produit p)
        {
            String req = "Delete from wishliste where nom_prod = ?";
            try {
            PreparedStatement statement = bd.getConnection().prepareStatement(req);
            statement.setString(1, p.getNom());
            statement.executeUpdate();
            
            } catch (SQLException ex) {
              Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);

            }
            
        }
        
        
        
        public static int CalculatePrix(Client c)
        {
            int prix=0;
            String req = "select prix_prod from wishliste where email_client = ?";
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
