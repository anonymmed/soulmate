/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
         Parent page2 = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/homeAdmin.fxml"));
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
    @FXML
     private void facebook(ActionEvent event) {
        connecterfb();
    }
    
    
    void connecterfb(){
        String appId = "229268324202981";
        //  String secret="b9844c024e1b2c3a38b06ef5064df7aa";
        String domain = "http://stackoverflow.com/";
        String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id=" + appId + "&redirect_uri=" + domain + "&scope=user_about_me,"
                + "user_actions.books,user_actions.fitness,user_actions.music,user_actions.news,user_actions.video,user_birthday,user_education_history,"
                + "user_events,user_photos,user_friends,user_games_activity,user_hometown,user_likes,user_location,user_photos,user_relationship_details,"
                + "user_relationships,user_religion_politics,user_status,user_tagged_places,user_videos,user_website,user_work_history,ads_management,ads_read,email,"
                + "manage_pages,publish_actions,read_insights,read_page_mailboxes,rsvp_event";

        System.setProperty("webdirver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get(authUrl);
        String accessToken;
        while (true) {
            if (!driver.getCurrentUrl().contains("facebook.com")) {
                String url = driver.getCurrentUrl();
                accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");
                driver.quit();
                FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.LATEST);
                User user = fbClient.fetchObject("me", User.class);

                System.out.println(user);
            } 
        }
    }
}

    

