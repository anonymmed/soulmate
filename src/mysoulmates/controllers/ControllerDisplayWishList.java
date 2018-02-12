/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.oracle.jrockit.jfr.Producer;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;
import mysoulmates.entities.Client;
import mysoulmates.entities.Produit;
import mysoulmates.services.service_Client;
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
    private JFXListView<String> ProductDisplayList;
   @FXML
    private Label labelwishlist;  
   @FXML
   private JFXButton ConfirmWishlist;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                        ProductDisplayList.setStyle("-fx-background-insets: 0 ;");
        service_DisplayWishlist.DisplayWishList(ProductDisplayList, new Client("mohamed.abdelhafidh@esprit.tn"));

        
        
    }
        public  void ConfirmWishList() throws IOException
        {
        ((Stage) ConfirmWishlist.getScene().getWindow()).close();
            service_DisplayWishlist s = new service_DisplayWishlist();

            s.ConfirmWishList(ConfirmWishlist);

           {
               
           }
        }    
    

}
