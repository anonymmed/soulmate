/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mysoulmates.entities.User;
import mysoulmates.entities.Product;
import mysoulmates.services.service_Wishliste;

/**
 *
 * @author Mohamed
 */
public class Controller_Wishlist {

    public Controller_Wishlist() {
    }
    
    public static void addToWishlist(ArrayList<Product> listeWish , String email)
    {
        service_Wishliste.addToWishlist(listeWish,email);

    }
            public static ObservableList<Product> displayWishListe(String email)
            {
                ObservableList<Product> l1 = FXCollections.observableArrayList();
                
                
                l1=service_Wishliste.displayWishListe(email);
                return l1;
            }
            
                    public static void DeleteFromWishList(Product p)
                    {
                        service_Wishliste.DeleteFromWishList(p);
                    }
                    
                  public static int CalculatePrix(User c)
                  {
                      int prix = service_Wishliste.CalculatePrix(c);
                      return prix;
                  }
              
}
