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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mysoulmates.entities.User;
import mysoulmates.entities.Command;

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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void insertBillingInformation() throws IOException
    {
        
User c1 = new User("mohamed.abdelhafidh@esprit.tn");
        int prix=Controller_Wishlist.CalculatePrix(c1);
        System.out.println(prix);
                Command comm = new Command(fname.getText(), lname.getText(), address.getText(), city.getText(), state.getText(), zip.getText(), c_email.getText(), phone.getText(),dob.getValue(),prix);

c1.setCommand(comm);
        Controller_Command.insertBillingInformation(c1);
        ((Stage) c_email.getScene().getWindow()).close();
        Controller_PaymentWishList.client=c1;
        FXMLLoader fxmlLLoader = new FXMLLoader(getClass().getResource("/mysoulmates/views/PaymentWishList.fxml"));
                Parent root1 =  fxmlLLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));

                stage.show();
    }
    
}
