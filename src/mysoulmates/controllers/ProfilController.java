/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import mysoulmates.entities.Session;
import mysoulmates.entities.User;
import mysoulmates.services.UserService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class ProfilController implements Initializable {

    @FXML
    private TextField firstname;
    @FXML
    private JFXButton viewlikes;
    @FXML
    private TextField lastname;
    @FXML
    private TextField email;
    @FXML
    private TextField age;
    @FXML
    private TextField phonenumber;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    private TextField address;
    @FXML
    private Button updateBtn;
    @FXML
    private ImageView imgview;
    @FXML
    private Button image;
    private File file;
    private JFXButton gotowishlist;
     @FXML
     private JFXButton desactivate;
    @FXML
    private AnchorPane holderPane,like;
    @FXML
    private ImageView mylikes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    UserService us = new UserService();
    Integer idad = Session.getCurrentSession();
    User u = us.findById(idad);
        try {
            like=FXMLLoader.load(getClass().getResource("/mysoulmates/Views/displayMyLikes.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(u.getFname()+" "+u.getLname()+" "+u.getPassword()+" "+u.getUsername());
        firstname.setText(u.getFname());
        lastname.setText(u.getLname());
        email.setText(u.getEmail());
        age.setText(Integer.toString(u.getAge()));
        password.setText(u.getPassword());
        phonenumber.setText(Integer.toString(u.getPhoneNumber()));
        address.setText(u.getAddress());
        username.setText(u.getUsername());
        // TODO
    }


    @FXML
    private void update(ActionEvent event) {
                  UserService us = new UserService();
    Integer idad = Session.getCurrentSession();
    User u = us.findById(idad);

        
        u.setFname(firstname.getText());
        u.setLname(lastname.getText());
        u.setEmail(email.getText());
        u.setPassword(password.getText());
     u.setRole(0);
               u.setPhoneNumber(Integer.parseInt(phonenumber.getText()));

               if (file!=null)
               {
        String[] tmp=file.toURI().toString().split("/");
        String myimg=(tmp[tmp.length-1]);
        u.setImage(myimg);

               }
               else
               {
                   u.setImage("NONE");
               }
          u.setAge(Integer.parseInt(age.getText()));
     
    
       u.setAddress(address.getText());
      
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
LocalDate localDate = LocalDate.now();
      u.setDate_SU(dtf.format(localDate));
               u.setNbr_like(0);
       UserService.Update(u, idad);
    }

    @FXML
    private void getImage(ActionEvent event) {
        
         FileChooser fileChooser = new FileChooser();
        file=fileChooser.showOpenDialog(null);
        if(file != null)
        {
            Image img =new Image(file.toURI().toString(),100,150,true,true);
            imgview.imageProperty().unbind();
            imgview.setImage(img);
            imgview.setFitWidth(200);
            imgview.setFitHeight(150);
        }
        else
        {
            System.out.println("e404");
        }
    }
    public  void GoToWishList() throws IOException
    {
        ((Stage)gotowishlist.getScene().getWindow()).close();
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/mysoulmates/Views/DisplayWishList.fxml"));
        Parent root = fXMLLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void gotomylikes() throws IOException
    {
        ((Stage)viewlikes.getScene().getWindow()).close();
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/mysoulmates/Views/displayMyLikes.fxml"));
        Parent rooted = fXMLLoader.load();
        Stage stageed = new Stage();
        stageed.setScene(new Scene(rooted));
        stageed.show();
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
        private void desactivateprofile()
    {
        
    }

    @FXML
    private void switchLikes(ActionEvent event) {
        
        setNode(like);
    }
    

    }


