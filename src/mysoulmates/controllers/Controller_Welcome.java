/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.SnapshotParameters;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import mysoulmates.entities.Session;
import mysoulmates.entities.User;
import mysoulmates.services.UserService;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class Controller_Welcome implements Initializable {

    @FXML
    private ImageView soulmateimg,like,unlike;
    @FXML
    private JFXTextField fullname;
    @FXML
    private JFXTextField age;
    @FXML
    private List<User> lst = new ArrayList<>();
    @FXML
    private AnchorPane holderPane;
       
    public static int nbr_user=0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        User u1 = new User();
        User u2 = new User() ;
        lst=Controller_Client.displayMatching(u1, u2);
                         Rectangle clip = new Rectangle(
                soulmateimg.getFitWidth(), soulmateimg.getFitHeight()
            );
            clip.setArcWidth(20);
            clip.setArcHeight(20);
            soulmateimg.setClip(clip);
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Color.TRANSPARENT);

            WritableImage image = soulmateimg.snapshot(parameters, null);

            // remove the rounding clip so that our effect can show through.
            soulmateimg.setClip(null);

            // apply a shadow effect.
            soulmateimg.setEffect(new DropShadow(20, Color.BLACK));

            displayUserInfo();
            like.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
            int current_id = Session.getCurrentSession();
            User user = new User();
            User user2 = new User(lst.get(nbr_user).getEmail());
            UserService us = new UserService();
            user = us.findById(current_id);

                    Controller_Client.likeClient(user, user2);
                    
            nbr_user++;
            displayUserInfo();
            rotationTransitionRight();
                }
                
            });
            unlike.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    
            nbr_user++;
            displayUserInfo();
            rotationTransitionLeft();
                }
                
            });


        
    }    
    public void displayUserInfo()
    {
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(holderPane);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        if(nbr_user+1==lst.size())
        {
            try {
                setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/reloadUsers.fxml")));
                
            } catch (IOException ex) {
                Logger.getLogger(Controller_Welcome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
        
                    if(getClass().getResourceAsStream("/mysoulmates/images/"+lst.get(nbr_user).getImage()) == null)
            {
                if (lst.get(nbr_user).getGender().equals("male"))
                {
                    soulmateimg.setImage(new Image("/mysoulmates/images/profile.png"));
                }
                else if (lst.get(nbr_user).getGender().equals("female"))
                {
                    soulmateimg.setImage(new Image("/mysoulmates/images/profile2.png"));
                }
                
            }
            else
            {
                   soulmateimg.setImage(new Image("/mysoulmates/images/"+lst.get(nbr_user).getImage()));
            }
            fullname.setText(lst.get(nbr_user).getFname()+" "+lst.get(nbr_user).getLname());
            age.setText(Integer.toString(lst.get(nbr_user).getAge())+" years old");
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
                    
     private void rotationTransitionRight()
    {
     Rectangle rect = new Rectangle (100, 40, 100, 100);
     
     rect.setArcHeight(50);
     rect.setArcWidth(50);
     rect.setFill(Color.VIOLET);
     RotateTransition rt = new RotateTransition(Duration.millis(1000), rect);
     rt.setByAngle(360);
     rt.setCycleCount(1);
     rt.setAutoReverse(true);
     rt.setNode(holderPane);
     rt.play();

      }
     
          private void rotationTransitionLeft()
    {
     Rectangle rect = new Rectangle (100, 40, 100, 100);
     
     rect.setArcHeight(50);
     rect.setArcWidth(50);
     rect.setFill(Color.VIOLET);
     RotateTransition rt = new RotateTransition(Duration.millis(1000), rect);
     rt.setByAngle(-360);
     rt.setCycleCount(1);
     rt.setAutoReverse(true);
     rt.setNode(holderPane);
     rt.play();

      }

    
    
}
