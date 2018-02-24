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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class oldHomeController implements Initializable {
 @FXML
    private AnchorPane holderPane;
    @FXML
    private Button profileBtn;
    @FXML
    private Button favouriteBtn;
    @FXML
    private Button cmplaintBtn;
    @FXML
    private Button weddingBtn;
    @FXML
    private Button wishlistBtn;
    @FXML
    private Button eventBtn;
    @FXML
    private Button chatBtn;
        @FXML
    private JFXButton gotowishlist;

     AnchorPane profile,favourite,complaints,wedding,wishlist,event,chat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
             profile= FXMLLoader.load(getClass().getResource("/mysoulmates/views/profil.fxml"));
            
            setNode(profile);
        } catch (IOException ex) {
            Logger.getLogger(oldHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
        // TODO
    }    
private void setNode(Node node) {
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
    private void Profile(ActionEvent event) throws IOException {
        try {
             profile= FXMLLoader.load(getClass().getResource("/mysoulmates/views/profil.fxml"));
            
            setNode(profile);
        } catch (IOException ex) {
            Logger.getLogger(oldHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void Favourite(ActionEvent event) {
    }

    @FXML
    private void Complaints(ActionEvent event) {
    }

    @FXML
    private void WeddingPlanner(ActionEvent event) {
    }

    @FXML
    private void WishList(ActionEvent event) {
    }
    @FXML
    public  void GoToWishList() throws IOException
    {
        ((Stage)gotowishlist.getScene().getWindow()).close();
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/mysoulmates/Views/DisplayWishList.fxml"));
        Parent root = fXMLLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void Event(ActionEvent event) {
    }

    @FXML
    private void Chat(ActionEvent event) {
    }
    
}
