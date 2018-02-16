/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mysoulmates.entities.Produit;
import mysoulmates.services.service_DisplayWishlist;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class ControllerDisplayWishList implements Initializable {

    /**
     * Initializes the controller class.
     */
 
   @FXML
    private Label labelwishlist;  
   @FXML
   private JFXButton ConfirmWishlist;
   
      @FXML
    private TableView<Produit> tableview;
      
      
      //table collumns
         @FXML
    private TableColumn<Produit,JFXButton> action;
    @FXML
    private TableColumn<Produit,ImageView>logo;
    @FXML
    private TableColumn<Produit,String> product_Name;

    @FXML
    private TableColumn<Produit, String> product_Description;

    @FXML
    private TableColumn<Produit, Integer> price;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO


       // tableview.getItems().addAll(new Produit("med", "abdh", 15,new ImageView("/mysoulmates/img/fb.png")));
 

        //columns initialization
        action.setCellValueFactory(new PropertyValueFactory<>("delete"));
                
        logo.setCellValueFactory(new PropertyValueFactory<>("productImg"));
        product_Name.setCellValueFactory(new PropertyValueFactory<>("nom"));
       product_Description.setCellValueFactory(new PropertyValueFactory<>("description"));
       price.setCellValueFactory(new PropertyValueFactory<>("prix"));
        //collumns filling test

            tableview.setItems(Controller_Wishlist.displayWishListe("mohamed.abdelhafidh@esprit.tn"));


           

 //tableview.getColumns().addAll(product_Name,product_Description,price);
    }
    
    
    
    @FXML
        public  void ConfirmWishList() throws IOException
        {
        ((Stage) ConfirmWishlist.getScene().getWindow()).close();
            service_DisplayWishlist s = new service_DisplayWishlist();

            s.ConfirmWishList(ConfirmWishlist);
          
        }    
    

}
