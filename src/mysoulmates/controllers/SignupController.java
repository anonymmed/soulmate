/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import mysoulmates.entities.User;
import mysoulmates.services.UserService;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class SignupController implements Initializable {

    @FXML
    private JFXTextField firstname;
     @FXML
    private JFXTextField lastname;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField age;
    @FXML
    private JFXTextField phonenumber;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXButton signupbtn;
    @FXML
    private JFXTextField username;
    
    @FXML
    private RadioButton homme;
    @FXML
    private RadioButton femme;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    @FXML
    private void signup(ActionEvent event) throws IOException {
       
        UserService us = new UserService();
        User p = new User();
         System.out.println("Controllers.SignupController.signup()");
        p.setLname(lastname.getText());
        p.setFname(firstname.getText());
        p.setEmail(email.getText());
        p.setPassword(password.getText());
        p.setUsername(username.getText());
        p.setImage("test.png");
        p.setAge(Integer.parseInt(age.getText())); 
        if(homme.isSelected()){
            p.setGender("homme");
        }
        if(femme.isSelected()){
            p.setGender("femme");
        }
        p.setAddress(address.getText());
        p.setPhoneNumber(Integer.parseInt(phonenumber.getText()));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        p.setDate_SU(dtf.format(localDate));
        us.signIn(p);
        Stage stage;

        
       
         
          //  Session.start(u.getId());
                
             //   System.out.println( Session.getCurrentSession());
          //  System.out.println("Role from login! : member");

              Parent page2 = FXMLLoader.load(getClass().getResource("../Views/login.fxml"));
                Scene scene = new Scene(page2);
            stage = (Stage) signupbtn.getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.show();

    

}}
