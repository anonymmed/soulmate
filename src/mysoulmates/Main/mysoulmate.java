/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mysoulmates.EncryptionHandling.EncryptionHandling;

/**
 *
 * @author ss
 */
public class mysoulmate extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
      
        
        Parent login = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/login.fxml"));
        Scene scene = new Scene(login);
        
        primaryStage.setTitle("LOGIN");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EncryptionHandling enc = new EncryptionHandling();
        try {
            enc.encrypt("V4Vendetta");
        } catch (Exception ex) {
            System.out.println("error : "+ex.getMessage());
        }
        launch(args);
    }
    
}
