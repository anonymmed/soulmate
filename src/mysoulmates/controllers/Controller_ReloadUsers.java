/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class Controller_ReloadUsers implements Initializable {

    @FXML
    private AnchorPane holderPane;
    @FXML
    private ImageView reload;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        reload.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                    reloadUsers();
                    rotationTransitionRight();

                try {
                    setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/welcome.fxml")));
                } catch (IOException ex) {
                    Logger.getLogger(Controller_ReloadUsers.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }    
    
    private void reloadUsers()
    {
        Controller_Welcome.nbr_user=0;
                                    rotationTransitionRight();
        
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
                    
     private void rotationTransitionRight()
    {
     Rectangle rect = new Rectangle (100, 40, 100, 100);
     
     rect.setArcHeight(50);
     rect.setArcWidth(50);
     rect.setFill(Color.VIOLET);
     RotateTransition rt = new RotateTransition(Duration.millis(5000), rect);
     rt.setByAngle(1800);
     rt.setCycleCount(1);
     rt.setAutoReverse(true);
     rt.setNode(reload);
rt.play();
    }
     

    
}
