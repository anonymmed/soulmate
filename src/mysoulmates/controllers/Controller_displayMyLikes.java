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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.text.html.CSS;
import static javax.swing.text.html.CSS.Attribute.PADDING_BOTTOM;
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

    @FXML
    private ResourceBundle resources;
        @FXML
    private URL location;
        
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
            int count = 0;
            int max= 9;
        int i = 0;
        int j = 0;
        int y;

        
       y=0;
            while(rs.next())
{
    count++;
    y+=80;
                 Separator separatorh = new Separator(Orientation.HORIZONTAL);
                 Separator separatorv = new Separator(Orientation.VERTICAL);
                 AnchorPane ap = new AnchorPane();
                ap.setPrefWidth(300);
                ap.setPrefHeight(400);
                ap.setStyle(" -fx-background-color:transparent");
               // ap.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(53,49,112,0.21), 10, 0, 0, 0)");
                ap.setLayoutX(glview.getLayoutX()-(glview.getLayoutX()/3));
                ap.setLayoutY(glview.getLayoutY()-(glview.getLayoutY()/3));
                ImageView im =null;
if (getClass().getResourceAsStream("/mysoulmates/images/" + rs.getString("image"))== null)
{
    if (rs.getString("gender").equals("male"))
    {
                             im = new ImageView(new Image(getClass().getResourceAsStream("/mysoulmates/images/profile.png")));
                     im.setLayoutY(ap.getLayoutY()-10);
                     im.setLayoutX(ap.getLayoutX());

    }
    else
    {
                     im = new ImageView(new Image(getClass().getResourceAsStream("/mysoulmates/images/profile2.png")));
                     im.setLayoutY(ap.getLayoutY()-10);
                     im.setLayoutX(ap.getLayoutX());

    }

}
else
{
                     im = new ImageView(new Image(getClass().getResourceAsStream("/mysoulmates/images/" + rs.getString("image"))));
                     im.setLayoutY(ap.getLayoutY()-10);
                     im.setLayoutX(ap.getLayoutX());

}
                im.setFitWidth(150);
                im.setFitHeight(150);

                Label l = new Label("Full Name :"+rs.getString("fname")+" "+rs.getString("lname"));
               
                l.setLayoutX(im.getLayoutX());
                l.setLayoutY(im.getLayoutY()-25);
                l.setFont(new Font("Cambria", 20));
                l.setTextFill(Color.web("#0076a3"));
                ap.getChildren().add(l);
                ap.getChildren().add(im);
                im.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Visit meber profile");
            alert.setHeaderText("Do you want to visit his/her profile ?");
            alert.setContentText("Choose your option.");
            ButtonType buttonTypeOne = new ButtonType("Yes");
            ButtonType buttonTypeTwo = new ButtonType("No");
            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne)
            {
                System.out.println("choosed to visit his profile");
            }
            else
            {
                System.out.println("choosed to not visit the profile");
            }
                }
                });
                        glview.add(ap, i, j);
                

                i++;
                if (i == 3) {
                    j++;
                    i = 0;
                }
            }

}
        
        }    
    


