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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class Controller_Mainfxml implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXButton gotowishlist;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
}
