/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.entities;

/**
 *
 * @author ss
 */
public class Produit {
    private int id;
    private String name;
    private String address;
     private float price;
    private String description;
    private String category;
    private String image;

    public Produit(int id, String name, String address, float price, String description, String category, String image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
    }

    public Produit(String name, String address, float price, String description, String category) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public Produit(String name, String address, float price, String description, String category, String image) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
   
}