/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mysoulmates.entities.Client;
import mysoulmates.entities.Produit;
import mysoulmates.services.service_Wishliste;

/**
 *
 * @author Mohamed
 */
public class Controller_Wishlist {

    public Controller_Wishlist() {
    }
    
    public static void addToWishlist(ArrayList<Produit> listeWish , String email)
    {
        service_Wishliste.addToWishlist(listeWish,email);

    }
            public static ObservableList<Produit> displayWishListe(String email)
            {
                ObservableList<Produit> l1 = FXCollections.observableArrayList();
                        l1=service_Wishliste.displayWishListe(email);
                return l1;
            }
            
                    public static void DeleteFromWishList(Produit p)
                    {
                        service_Wishliste.DeleteFromWishList(p);
                    }
                    
                  public static int CalculatePrix(Client c)
                  {
                      int prix = service_Wishliste.CalculatePrix(c);
                      return prix;
                  }
              
}
