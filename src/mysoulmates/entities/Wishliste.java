/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohamed
 */
public class Wishliste {
    private int prix;
    private String email_client;
    private List<Produit> listeWish;

        public Wishliste() {
        this.listeWish= new ArrayList<Produit>();
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


    

    public void setListe(ArrayList<Produit> liste)
    {
        this.listeWish=liste;
                }
    public ArrayList<Produit>getListe()
    {
        return (ArrayList<Produit>)this.listeWish;
    }
    public void addToWishListe(Produit p)
    {
        this.listeWish.add(p);
    }
    
}
