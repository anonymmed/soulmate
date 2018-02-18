/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mysoulmates.entities.Product;
import mysoulmates.entities.Session;
import mysoulmates.entities.User;
import mysoulmates.services.UserService;
import mysoulmates.services.service_DisplayWishlist;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class Controller_displayMyLikes implements Initializable {

    /**
     * Initializes the controller class.
     */
 
@FXML
private GridPane glview;
@FXML
private JFXButton gotowishlist;
@Override
    public void initialize(URL url, ResourceBundle rb) {
        
    try
    {
        ViewMyLikes();
    } 
    
    catch (Exception ex)
    {
        System.out.println(ex.getMessage());
    }
    
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

    
    
        public void ViewMyLikes() throws Exception 
        {
            UserService us = new UserService();
            int currentid = Session.getCurrentSession();
            User u =new User();
            u= us.findById(currentid);
           List<User>likedList = new ArrayList<>();
            ResultSet rs;
            rs=Controller_Client.DisplayLikes(u); 
        int i = 0;
        int j = 0;

            while(rs.next())
{
                    AnchorPane ap = new AnchorPane();
               ap.setPrefWidth(150);
                ap.setPrefHeight(150);
                ap.setStyle(" -fx-background-color:transparent");
                ap.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)");
                ImageView im ;
if (getClass().getResourceAsStream("/mysoulmates/images/" + rs.getString("image"))== null)
{
                     im = new ImageView(new Image(getClass().getResourceAsStream("/mysoulmates/images/profile.png")));

}
else
{
                     im = new ImageView(new Image(getClass().getResourceAsStream("/mysoulmates/images/" + rs.getString("image"))));

}
                im.setFitWidth(143);
                im.setFitHeight(143);

                Separator separator2 = new Separator();
                separator2.setOrientation(Orientation.HORIZONTAL);
                separator2.prefHeight(200);
                separator2.setPrefWidth(365);
                separator2.setLayoutY(208);
                separator2.setStyle(" -fx-border-color: red");
                separator2.setStyle(" -fx-border-width: 1");

                Button bouton = new Button("Learn More");
                bouton.setFont(new Font("Cambria", 20));
                bouton.setTextFill(Color.web("#0076a3"));
                bouton.setLayoutY(204);
                Label l = new Label("Name : "+rs.getString("fname")+" "+rs.getString("lname"));
                l.setLayoutX(272);
                l.setLayoutY(211);
                l.setFont(new Font("Cambria", 20));
                l.setTextFill(Color.web("#0076a3"));

                ap.getChildren().add(im);
                ap.getChildren().add(separator2);
                ap.getChildren().add(bouton);
                ap.getChildren().add(l);
                
                glview.add(ap, i, j);

                i++;
                if (i == 2) {
                    j++;
                    i = 0;
                }
            }

}
        
        }    
    


