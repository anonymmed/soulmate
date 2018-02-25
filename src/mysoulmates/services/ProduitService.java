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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mysoulmates.entities.Produit;
import mysoulmates.utils.Bd;

/**
 *
 * @author ss
 */
public class ProduitService {

    static Bd ds = Bd.getInstance();

    public static void insererProduit(Produit p) {
        try {
            String req = "INSERT INTO`product`(`name`, `address`, `price`, `description`, `category`, `image`) values(?,?,?,?,?,?)";

            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, p.getName());
            ste.setString(2, p.getAddress());
            ste.setFloat(3, p.getPrice());
            ste.setString(4, p.getDescription());
            ste.setString(5, p.getCategory());
            ste.setString(6, p.getImage());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insererProduit2(Produit p) {
        try {
            String req = "INSERT INTO `product`( `name`, `address`, `longitude`, `latitude`, `price`, `description`, `category`, `image`,`note`, `countNote`) VALUES (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, p.getName());
            ste.setString(2, p.getAddress());
            ste.setString(3, p.getLongitude());
            ste.setString(4, p.getLatitude());
            ste.setFloat(5, p.getPrice());
            ste.setString(6, p.getDescription());
            ste.setString(7, p.getCategory());
            ste.setString(8, p.getImage());
             ste.setDouble(9, 0);
                ste.setInt(10, 0);            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateProduct(Produit f, int id) {
        String req = "UPDATE product  SET name=?, address=?, price=?, description=?, category=?, image=?  WHERE id=?";
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req);

            ste.setString(1, f.getName());
            ste.setString(2, f.getAddress());
            ste.setFloat(3, f.getPrice());
            ste.setString(4, f.getDescription());
            ste.setString(5, f.getCategory());
            ste.setString(6, f.getImage());
            ste.setInt(7, id);
            ste.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ObservableList<Produit> selectProduit(String category) {
        ObservableList<Produit> list = FXCollections.observableArrayList();
        String req = "SELECT * FROM product where category=?";
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, category);
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Produit(result.getInt("id"),
                        result.getString("name"),
                        result.getString("address"),
                        result.getFloat("price"),
                        result.getString("description"),
                        result.getString("category"),
                        result.getString("image")));
                // Button b=new Button("modifier");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ObservableList<Produit> listProduit() {
        ObservableList<Produit> list = FXCollections.observableArrayList();
        String req = "SELECT * FROM product ";
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req);

            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Produit(result.getInt("id"),
                        result.getString("name"),
                        result.getString("address"),
                        result.getFloat("price"),
                        result.getString("description"),
                        result.getString("category"),
                        result.getString("image")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void deleteProduct(int id) {
        String req = "DELETE FROM product WHERE id=?";
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ste.setInt(1, id);
            ste.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ResultSet selectProduits(int ec) {
        ResultSet result = null;
       
        String req = "SELECT * FROM product LIMIT 9 OFFSET ? ";
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
           //  ste.setInt(1, sc);
            ste.setInt(1, ec);
            result = ste.executeQuery();

             
            

        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
public static int count(){
        int noes = 0; 
        try {
             String req = "SELECT count(*) FROM product ";
                PreparedStatement ste = ds.getConnection().prepareStatement(req);
            
             ResultSet rs = ste.executeQuery();
             while(rs.next()){
                 
                 noes = rs.getInt(1);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceReponse.class.getName()).log(Level.SEVERE, null, ex);
         }
        return noes;
    }
  public static ResultSet selectInfo(int id) {
        ResultSet result = null;
       
        String req = "SELECT * FROM product where id=? ";
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
           //  ste.setInt(1, sc);
            ste.setInt(1, id);
            result = ste.executeQuery();

             
            

        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static void updateProduct2(double note,int count,int id) {
        String req = "UPDATE product  SET note=? countNote=? WHERE id=?";
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req);

            ste.setDouble(1,note);
            ste.setInt(2,count);
            ste.setInt(3, id);
            ste.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
