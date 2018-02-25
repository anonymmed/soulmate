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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
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
    
    @FXML
    private AnchorPane holderPane;
    
    private String name;
    private User currentUser;
    private int sessionId;
        UserService us;
    @FXML
    private JFXButton deletebutton;
        
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

       // tableview.getItems().addAll(new Produit("med", "abdh", 15,new ImageView("/mysoulmates/img/fb.png")));
 
    tableview .setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

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
        ObservableList<Product> pob = FXCollections.observableArrayList();
        
        pob=Controller_Wishlist.displayWishListe(currentUser.getEmail());
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
        public void deleteItem()
        {
                        name=(tableview.getSelectionModel().getSelectedItem().getNom());
                        service_DisplayWishlist.deleteItem(name);
                        tableview.getSelectionModel().clearSelection(sessionId, logo);
                        tableview.getSelectionModel().clearSelection(sessionId, price);
                        tableview.getSelectionModel().clearSelection(sessionId, product_Description);
                        tableview.getSelectionModel().clearSelection(sessionId, product_Name);

       try {
         setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/DisplayWishList.fxml")));
       } catch (IOException ex) {
           Logger.getLogger(ControllerDisplayWishList.class.getName()).log(Level.SEVERE, null, ex);
       }
        }
        
        
        
        
        @FXML 
        private void switchhome()
        {
       try {
           setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/welcome.fxml")));
       } catch (IOException ex) {
           Logger.getLogger(ControllerDisplayWishList.class.getName()).log(Level.SEVERE, null, ex);
       }
        }
        
        
        
        
                    private void setNode(Node node)
        {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void ConfirmWishlist(ActionEvent event) {
       try {
           setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/InforWishList.fxml")));
       } catch (IOException ex) {
           Logger.getLogger(ControllerDisplayWishList.class.getName()).log(Level.SEVERE, null, ex);
       }

    }
    

}
