/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.entities;

import com.jfoenix.controls.JFXButton;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohamed
 */
public class Wishlist {
    private int prix;
    private String email_client;
    private List<Product> listeWish;
    private JFXButton delete = new JFXButton("delete");

    public JFXButton getDelete() {
        return delete;
    }

    public void setDelete(JFXButton delete) {
        this.delete = delete;
    }
        public Wishlist() {
        this.listeWish= new ArrayList<Product>();
    }

    public String getEmail_client() {
        return email_client;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setEmail_client(String email_client) {
        this.email_client = email_client;
    }


    

    public void setListe(ArrayList<Product> liste)
    {
        this.listeWish=liste;
                }
    public ArrayList<Product>getListe()
    {
        return (ArrayList<Product>)this.listeWish;
    }
    public void addToWishListe(Product p)
    {
        this.listeWish.add(p);
    }
    
}
