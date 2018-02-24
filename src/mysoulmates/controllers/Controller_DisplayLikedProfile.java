/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import mysoulmates.services.service_DisplayMyLikes;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class Controller_DisplayLikedProfile implements Initializable {

    @FXML
    private ImageView likedimg;
    @FXML

    private JFXTextField fname;
    @FXML
    private JFXTextField lname;
    @FXML
    private JFXTextField membership;
    @FXML
    private JFXTextField age;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField signdate;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField city;
    @FXML
    private JFXTextField state;
    @FXML
    private JFXTextField zip;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXButton backbtn;
    @FXML
    private AnchorPane holderPane;
    Image img;
    static boolean clicked= false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fname.setText(service_DisplayMyLikes.fname);
        lname.setText(service_DisplayMyLikes.lname);
        age.setText(service_DisplayMyLikes.age);
        phone.setText(service_DisplayMyLikes.phone);
        signdate.setText(service_DisplayMyLikes.signDate);
        address.setText(service_DisplayMyLikes.address);
        city.setText(service_DisplayMyLikes.city);
        state.setText(service_DisplayMyLikes.state);
        zip.setText(service_DisplayMyLikes.zip);
        email.setText(service_DisplayMyLikes.emailCliked);
        if (getClass().getResourceAsStream("/mysoulmates/images/"+service_DisplayMyLikes.image)== null)
        {
            if (service_DisplayMyLikes.gender.equals("male"))
            {
                 Rectangle clip = new Rectangle(
                likedimg.getFitWidth(), likedimg.getFitHeight()
            );
            clip.setArcWidth(20);
            clip.setArcHeight(20);
            likedimg.setClip(clip);
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Color.TRANSPARENT);

            WritableImage image = likedimg.snapshot(parameters, null);

            // remove the rounding clip so that our effect can show through.
            likedimg.setClip(null);

            // apply a shadow effect.
            likedimg.setEffect(new DropShadow(20, Color.BLACK));

                             
                             likedimg.setImage(new Image("/mysoulmates/images/profile.png"));

            }
            else
            {
             Rectangle clip = new Rectangle(
            likedimg.getFitWidth(), likedimg.getFitHeight()
            );
            clip.setArcWidth(20);
            clip.setArcHeight(20);
            likedimg.setClip(clip);
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Color.TRANSPARENT);

            WritableImage image = likedimg.snapshot(parameters, null);

            // remove the rounding clip so that our effect can show through.
            likedimg.setClip(null);

            // apply a shadow effect.
            likedimg.setEffect(new DropShadow(20, Color.BLACK));

                             
           likedimg.setImage(new Image("/mysoulmates/images/profile2.png"));

            }

        }
        else
            
        {
                 Rectangle clip = new Rectangle(
                likedimg.getFitWidth(), likedimg.getFitHeight()
            );
            clip.setArcWidth(20);
            clip.setArcHeight(20);
            likedimg.setClip(clip);
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Color.TRANSPARENT);

            WritableImage image = likedimg.snapshot(parameters, null);

            // remove the rounding clip so that our effect can show through.
            likedimg.setClip(null);

            // apply a shadow effect.
            likedimg.setEffect(new DropShadow(20, Color.BLACK));

                             
             likedimg.setImage(new Image("/mysoulmates/images/"+service_DisplayMyLikes.image));

        }
                
       
        
        
    }    

    @FXML
    private void switchlikes(ActionEvent event) {
        try {
            setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/displayMyLikes.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(Controller_DisplayLikedProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
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


    
}
