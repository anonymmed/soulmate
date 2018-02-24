/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.lynden.gmapsfx.GoogleMapView;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import mysoulmates.entities.Event;
import mysoulmates.entities.Session;
import mysoulmates.entities.User;
import mysoulmates.services.EventService;
import mysoulmates.services.UserService;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class EventMemberController implements Initializable {

    @FXML
    private ImageView imgEvent;
    @FXML
    private GoogleMapView mapEvent;
    @FXML
    private JFXTextField nameEvent;
    @FXML
    private JFXTextField locationEvent;
    @FXML
    private JFXTextArea descriptionEvent;
    @FXML
    private JFXDatePicker startDate;
    @FXML
    private JFXDatePicker endDate;
    @FXML
    private JFXButton savebtn;
    
   private File file;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddEvent(ActionEvent event) {
         UserService us = new UserService();
    Integer idad = Session.getCurrentSession();
        User u = us.findById(idad);
          EventService se = new EventService();
        LocalDate localDate = startDate.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        java.util.Date date = Date.from(instant);
        java.sql.Date dtSql = new java.sql.Date(date.getTime());
        
        LocalDate localDate1 = endDate.getValue();
        Instant instant1 = Instant.from(localDate1.atStartOfDay(ZoneId.systemDefault()));
        java.util.Date date1 = Date.from(instant1);
        java.sql.Date dtSql1 = new java.sql.Date(date1.getTime());
        
        String myimg;

        if (file != null) {
            String[] tmp = file.toURI().toString().split("/");
            myimg = (tmp[tmp.length - 1]);

        } else {
            myimg = "NONE";
        }
        Event e = new Event(nameEvent.getText(),descriptionEvent.getText(),locationEvent.getText(),dtSql,dtSql1,myimg);
        
        try {
            se.AjouterEvent(e,u.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(EventMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void uploadImage(MouseEvent event) {
         FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image img = new Image(file.toURI().toString(),
                    100, 150, true, true);
            imgEvent.imageProperty().unbind();
            imgEvent.setImage(img);
            imgEvent.setFitWidth(200);
            imgEvent.setFitHeight(150);

        } 
    }
    
}
