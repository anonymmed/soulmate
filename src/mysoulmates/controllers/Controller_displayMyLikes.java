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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import mysoulmates.entities.Session;
import mysoulmates.entities.User;
import mysoulmates.services.UserService;
import mysoulmates.services.service_DisplayMyLikes;
import static mysoulmates.services.service_DisplayMyLikes.emailCliked;

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
    private AnchorPane holderPane;
    @FXML
    private JFXButton gotowishlist;

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private AnchorPane selectedProfile;
    @FXML
    private JFXButton clickbtn;
@Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            ViewMyLikes();
        } catch (Exception ex) {
            Logger.getLogger(Controller_displayMyLikes.class.getName()).log(Level.SEVERE, null, ex);
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
                ImageView im = new ImageView();
                Image ima;
                

if (getClass().getResourceAsStream("/mysoulmates/images/" + rs.getString("image"))== null)
{
    if (rs.getString("gender").equals("male"))
    {
        
        ima = new Image("/mysoulmates/images/profile.png");
        
                 Rectangle clip = new Rectangle(
                im.getFitWidth(), im.getFitHeight()
            );
            clip.setArcWidth(20);
            clip.setArcHeight(20);
            im.setClip(clip);
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Color.TRANSPARENT);

            WritableImage image = im.snapshot(parameters, null);

            // remove the rounding clip so that our effect can show through.
            im.setClip(null);

            // apply a shadow effect.
            im.setEffect(new DropShadow(20, Color.BLACK));

                             
                             im.setImage(ima);
                     im.setLayoutY(ap.getLayoutY()+5);
                     im.setLayoutX(ap.getLayoutX()+50);

    }
    else
    {
        ima = new Image("/mysoulmates/images/profile2.png");
                         Rectangle clip = new Rectangle(
                im.getFitWidth(), im.getFitHeight()
            );
            clip.setArcWidth(20);
            clip.setArcHeight(20);
            im.setClip(clip);
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Color.TRANSPARENT);

            WritableImage image = im.snapshot(parameters, null);

            // remove the rounding clip so that our effect can show through.
            im.setClip(null);

            // apply a shadow effect.
            im.setEffect(new DropShadow(20, Color.BLACK));

                             
                     im.setImage(ima);
                     im.setLayoutY(ap.getLayoutY()+5);
                     im.setLayoutX(ap.getLayoutX()+50);

    }

}
else
{
    ima=new Image("/mysoulmates/images/" + rs.getString("image"));
       
    Rectangle clip = new Rectangle(
                im.getFitWidth(), im.getFitHeight()
            );
            clip.setArcWidth(20);
            clip.setArcHeight(20);
            im.setClip(clip);
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Color.TRANSPARENT);

            WritableImage image = im.snapshot(parameters, null);

            // remove the rounding clip so that our effect can show through.
            im.setClip(null);

            // apply a shadow effect.
            im.setEffect(new DropShadow(20, Color.BLACK));

                             
                             im.setImage(ima);

                     im.setLayoutY(ap.getLayoutY()+5);
                     im.setLayoutX(ap.getLayoutX()+50);

}
                im.setFitWidth(150);
                im.setFitHeight(150);
                clickbtn = new JFXButton();
                clickbtn.setLayoutX(ap.getLayoutY()+33);
                clickbtn.setLayoutY(ap.getLayoutX()+20);
                clickbtn.setMinHeight(150);
                clickbtn.setMinWidth(150);
                clickbtn.setMaxSize(150, 150);
                Label l = new Label(rs.getString("fname")+" "+rs.getString("lname"));
               
                l.setLayoutX(im.getLayoutX()+13);
                l.setLayoutY(im.getLayoutY()+150);
                l.setFont(new Font("Cambria", 25));
                l.setTextFill(Color.web("#0076a3"));
                ap.getChildren().add(l);
                ap.getChildren().add(im);
                ap.getChildren().add(clickbtn);
                im.setAccessibleRoleDescription(rs.getString("email"));
                
                                        clickbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            service_DisplayMyLikes.emailCliked=im.getAccessibleRoleDescription();
            Controller_DisplayLikedProfile.clicked=true;
            System.out.println("from service : "+ service_DisplayMyLikes.emailCliked);
                                                service_DisplayMyLikes.getClickedInfo(emailCliked);
            System.out.println("from service : "+ service_DisplayMyLikes.fname);
                    try {
            selectedProfile=FXMLLoader.load(getClass().getResource("/mysoulmates/Views/displayLikedProfile.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Controller_displayMyLikes.class.getName()).log(Level.SEVERE, null, ex);
        }


            setNode(selectedProfile);
    
           
            
        }
    });
                
              
               
                        glview.add(ap, i, j);

                        glview.setStyle("-fx-border-radius: 50");
                

                i++;
                if (i == 4) {
                    j++;
                    i = 0;
                }
                if (i==3 && j==3)
                {
                    break;
                }
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
                @FXML
                private void switchprofile()
                {
        try {
            setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/profile.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(Controller_displayMyLikes.class.getName()).log(Level.SEVERE, null, ex);
        }
                }

                
                
                
        }    
        

