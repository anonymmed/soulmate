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
import mysoulmates.entities.Product;
import mysoulmates.entities.Session;
import mysoulmates.entities.User;
import mysoulmates.services.UserService;
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
    private TableView<Product> tableview;
      
      
      //table collumns
    @FXML
    private TableColumn<Product,ImageView>logo;
    @FXML
    private TableColumn<Product,String> product_Name;

    @FXML
    private TableColumn<Product, String> product_Description;

    @FXML
    private TableColumn<Product, Integer> price;
    
    private String name;
    private User currentUser;
    private int sessionId;
        UserService us;
        
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

       // tableview.getItems().addAll(new Produit("med", "abdh", 15,new ImageView("/mysoulmates/img/fb.png")));
 

        //columns initialization
         us = new UserService();

                     sessionId = Session.getCurrentSession();
         currentUser = new User();

                        currentUser=us.findById(sessionId);

        logo.setCellValueFactory(new PropertyValueFactory<>("productImg"));
        product_Name.setCellValueFactory(new PropertyValueFactory<>("nom"));
       product_Description.setCellValueFactory(new PropertyValueFactory<>("description"));
       price.setCellValueFactory(new PropertyValueFactory<>("prix"));
        //collumns filling test
            tableview.setItems(Controller_Wishlist.displayWishListe(currentUser.getEmail()));
/*            if (tableview.getSelectionModel().getSelectedItem().getNom()!= null)
            {
            name=(tableview.getSelectionModel().getSelectedItem().getNom());
            }
            else
                name="";
*/

 //tableview.getColumns().addAll(product_Name,product_Description,price);
    }
    
    
    
    @FXML
        public  void ConfirmWishList() throws IOException
        {
        ((Stage) ConfirmWishlist.getScene().getWindow()).close();
            service_DisplayWishlist s = new service_DisplayWishlist();

            s.ConfirmWishList(ConfirmWishlist);
          
        }
        @FXML
        public void deleteItem()
        {
                        name=(tableview.getSelectionModel().getSelectedItem().getNom());
                        service_DisplayWishlist.deleteItem(name);
                        tableview.getSelectionModel().clearSelection(sessionId, logo);
                        tableview.getSelectionModel().clearSelection(sessionId, price);
                        tableview.getSelectionModel().clearSelection(sessionId, product_Description);
                        tableview.getSelectionModel().clearSelection(sessionId, product_Name);

                        Controller_Wishlist.displayWishListe(currentUser.getEmail());
        }
    

}
