/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import mysoulmates.entities.User;
import mysoulmates.entities.Command;
import mysoulmates.entities.Session;
import mysoulmates.services.UserService;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class Controller_InforWishList implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField fname;
    @FXML
    private JFXTextField lname;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField city;
    @FXML
    private JFXTextField state;
    @FXML
    private JFXTextField zip;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXDatePicker  dob;
    @FXML
    private JFXTextField c_email;
    @FXML
    private AnchorPane holderPane;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void insertBillingInformation() throws IOException
    {
        UserService us = new UserService();
        int currentSession = Session.getCurrentSession();
User c1 = new User();
c1=us.findById(currentSession);

        int prix=Controller_Wishlist.CalculatePrix(c1);
        System.out.println(prix);
                Command comm = new Command(fname.getText(), lname.getText(), address.getText(), city.getText(), state.getText(), zip.getText(), c_email.getText(), phone.getText(),dob.getValue(),prix);

c1.setCommand(comm);
        Controller_Command.insertBillingInformation(c1);
        setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/views/PaymentWishList.fxml")));
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
    private void backToCart(ActionEvent event) {
        try {
            setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/DisplayWishList.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(Controller_InforWishList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
