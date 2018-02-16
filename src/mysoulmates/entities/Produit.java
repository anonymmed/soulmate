/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.entities;

import com.jfoenix.controls.JFXButton;
import javafx.scene.image.ImageView;

/**
 *
 * @author Mohamed
 */
public class Produit {
    private String nom;
    private String description;
    private int prix;
    private ImageView productImg;
    private JFXButton Delete;

    public JFXButton getDelete() {
        return Delete;
    }

    public void setDelete(JFXButton Delete) {
        this.Delete = Delete;
    }

    public ImageView getProductImg() {
        return productImg;
    }

    public void setProductImg(ImageView productImg) {
        this.productImg = productImg;
    }
    

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Produit(String nom, String description,int prix,ImageView img) {
        this.nom = nom;
        this.description = description;
        this.prix=prix;
        this.productImg=img;
    }
    public Produit(String nom, String description,int prix) {
        this.nom = nom;
        this.description = description;
        this.prix=prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "nom : "+getNom()+" description : "+getDescription();
        
    }
    
    
}
