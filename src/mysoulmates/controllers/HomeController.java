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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class HomeController implements Initializable {
 @FXML
    private AnchorPane holderPane;
    @FXML
    private Button profileBtn;
    @FXML
    private Button weddingBtn;
    @FXML
    private Button eventBtn;
    @FXML
    private Button chatBtn;
     AnchorPane profile,favourite,complaints,wedding,wishlist,event,chat;
    @FXML
    private JFXButton homeBtn;
    @FXML
    private JFXButton orderBtn;
    @FXML
    private JFXButton quizzBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     try {
         // TODO
         // TODO
         setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/welcome.fxml")));
        wedding = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/product.fxml"));
     } catch (IOException ex) {
         Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }    
public void setNode(Node node) {
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
    /*private void Profile(ActionEvent event) throws IOException {
       setNode(profile);

    }*/

    @FXML
    private void switchHome(ActionEvent event) {
     try {
         setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/welcome.fxml")));
     } catch (IOException ex) {
         Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    @FXML
    private void switchProfile(ActionEvent event) {
        
     try {
         setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/profile.fxml")));
     } catch (IOException ex) {
         Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
     }

    }

    @FXML
    private void switchEvent(ActionEvent event) {
         try {
         setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/viewEventMember.fxml")));
     } catch (IOException ex) {
         Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    @FXML
    private void switchWedding(ActionEvent event) {
     try {
         setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/product.fxml")));
     } catch (IOException ex) {
         Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    public void productInfo()
    {
        try {
         setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/infoProduct.fxml")));
     } catch (IOException ex) {
         Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    @FXML
    private void switchOrder(ActionEvent event) {
     try {
         setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/DisplayOrders.fxml")));
     } catch (IOException ex) {
         Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    @FXML
    private void switchChat(ActionEvent event) {
         try {
         setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/ComplaintMember.fxml")));
     } catch (IOException ex) {
         Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    @FXML
    private void switchQuizz(ActionEvent event) {
         try {
         setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/quizzMember.fxml")));
     } catch (IOException ex) {
         Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
        @FXML
    private void switchcart ()
    {
     try {
         
         setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/DisplayWishList.fxml")));
     } catch (IOException ex) {
         Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
   
}
