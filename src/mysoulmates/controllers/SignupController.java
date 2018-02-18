/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import mysoulmates.entities.User;
import mysoulmates.services.UserService;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class SignupController implements Initializable {

    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField email;
    @FXML
    private TextField age;
    @FXML
    private TextField phonenumber;
    @FXML
    private PasswordField password;
    @FXML
    private TextField address;
    @FXML
    private Button signupbtn;
    @FXML
    private TextField username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    @FXML
    private void signup(ActionEvent event) {
        UserService us = new UserService();
        User p = new User();
        p.setLname(lastname.getText());
        p.setFname(firstname.getText());
        p.setEmail(email.getText());
        p.setPassword(password.getText());
        p.setUsername(username.getText());
        p.setImage("test.png");
        p.setAge(Integer.parseInt(age.getText()));
        p.setGender("homme");
        p.setAddress(address.getText());
        p.setPhoneNumber(Integer.parseInt(phonenumber.getText()));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        p.setDate_SU(dtf.format(localDate));
        us.signIn(p);
    }

}
