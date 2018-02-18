/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import mysoulmates.entities.Session;
import mysoulmates.entities.User;
import mysoulmates.services.UserService;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class LoginController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private PasswordField pwd;
    @FXML
    private Button signin;
    @FXML
    private Button signupbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
    @FXML
    private void testaut(ActionEvent event) throws Exception {
         int count = 0;
        UserService us = new UserService();
        User u = new User();
        u.setUsername(email.getText());
        u.setPassword(pwd.getText());
        count = us.login(u);
        Stage stage;

        
        if (count == 1 ) {
         
          //  Session.start(u.getId());
            System.out.println("user id is : "+u.getId());
                 Session.start(u.getId());
                System.out.println( Session.getCurrentSession());
            System.out.println("Role from login! : member");

              Parent page2 = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/home.fxml"));
                Scene scene = new Scene(page2);
            stage = (Stage) signin.getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.show();
         
              
         
          /* */
        } if(count==0){
              Session.start(u.getId());
              System.out.println( Session.getCurrentSession());
            System.out.println("Role from login! : admin");
         Parent page2 = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/signup.fxml"));
           Scene scene = new Scene(page2);
            stage = (Stage) signin.getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.show();
            
        }
       
                if (count !=0 && count!=1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not login");
            alert.setContentText("please check your credentials!");
            alert.showAndWait();
        }
    }

    @FXML
    private void signup(ActionEvent event) throws IOException {
        
        
         Stage primaryStage= new Stage();
          Parent signup = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/signup.fxml"));
        Scene scene = new Scene(signup);
        
        primaryStage.setTitle("signup");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
}

    

