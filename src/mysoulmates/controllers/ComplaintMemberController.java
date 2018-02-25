/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import mysoulmates.entities.Complaint;
import mysoulmates.entities.Session;
import mysoulmates.entities.User;
import mysoulmates.services.ComplaintService;
import mysoulmates.services.UserService;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class ComplaintMemberController implements Initializable {

    @FXML
    private WebView emailReader;
    @FXML
    private ImageView senderImage;
    @FXML
    private Label noMailOpenLabel;
    @FXML
    private Label subjectLabel;
    @FXML
    private JFXButton closeMailButton;
    @FXML
    private VBox mailVbox;
    @FXML
    private JFXTextField sendMailTo;
    @FXML
    private JFXTextField sendMailSub;
    @FXML
    private JFXButton sendMailBtn;
    @FXML
    private HTMLEditor sendMailBody;
    @FXML
    private JFXButton sendMailCancel;

    /**
     * Initializes the controller class.
     */
    
     public void mailListFactory(String from, 
                                String subject,
                                String content,
                                String image,
                                int    isRead,
                                int    mailId){
                                  
        HBox h = new HBox();
        Label subjectL = new Label(),
                 fromL = new Label();
        /*
        * Pass the image url to an image object
        * Can cause NullPointerException (Runtime Exception) otherwise
        * 
        */
        Image img   = new Image(image);
        ImageView i = new ImageView(img);
        
        GridPane gp = new GridPane();
        
        subjectL.setText("Subject : "+subject);
        fromL.setText(from);
        
        h.setPrefWidth(304);
        h.setPrefHeight(60);
        h.setAccessibleText(image+","+subject+","+content+","+mailId);
        if(isRead != 1)
            h.setStyle("-fx-background-color: #e8ecf2;");
        else
            h.setStyle("-fx-background-color: #ffffff;");
        i.setFitWidth (100);
        i.setFitHeight(100);
        i.setPreserveRatio(false);
        Circle clip = new Circle(i.getFitWidth() / 2,
                         i.getFitHeight()/2 ,
                         50);
        i.setClip(clip);
        
        gp.getColumnConstraints().add(new ColumnConstraints(100,
                                                            300, 
                                                            Double.MAX_VALUE, 
                                                            Priority.ALWAYS, 
                                                            HPos.LEFT,
                                                            true)
                                    );
        gp.add(fromL,    0, 0);
        gp.add(subjectL, 0, 1);
        
        h.getChildren().add(i);
        h.getChildren().add(gp);
        
        mailVbox.getChildren().add(h);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void closeMail(ActionEvent event) {
        emailReader.getEngine().loadContent("");
        senderImage.setImage(null);
        System.gc();
        subjectLabel.setText("");
        noMailOpenLabel.setVisible(true);
    }

    @FXML
    private void sendMail(ActionEvent event) throws SQLException {
        UserService us = new UserService();
    Integer idad = Session.getCurrentSession();
        User u = us.findById(idad);
       
          java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          Complaint c = new Complaint(u.getEmail(), date,  sendMailSub.getText(), sendMailBody.getHtmlText());
           ComplaintService cs = new ComplaintService();
            if(cs.addComplaint(c) == true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Query Result:");
            alert.setContentText("Mail sent!");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Query Result:");
            alert.setContentText("Error while handling request :(");
            alert.showAndWait();
        }
        
    }
    
}
