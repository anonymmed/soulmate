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
import mysoulmates.entities.Category;
import mysoulmates.utils.Bd;

/**
 *
 * @author ss
 */
public class CategoryService {
     static Bd ds = Bd.getInstance();

    public static void insertCategory(Category c) {
        try {
            String req = "INSERT INTO `category`(`name`) VALUES (?)";

            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, c.getName());
           
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static  ObservableList<String> selectCategory() {
       ObservableList<String> list = FXCollections.observableArrayList();
        String req = "SELECT name FROM category";
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(
                                     
                         result.getString("name")
                                    );
            }

        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      public static  ObservableList<Category> selectCategories() {
       ObservableList<Category> list = FXCollections.observableArrayList();
        String req = "SELECT * FROM category";
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Category(
                                     result.getInt("id"),
                         result.getString("name")
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
     public ResultSet displayCategory() {
       
        ResultSet rs = null;
      String req = "SELECT name FROM category";
        try{
         
       
          PreparedStatement ste = ds.getConnection().prepareStatement(req);
           
           rs = ste.executeQuery();
        }catch(SQLException e){
            System.out.println("Erreur affichage !");
        }
        return rs;
    }

    
    
}
