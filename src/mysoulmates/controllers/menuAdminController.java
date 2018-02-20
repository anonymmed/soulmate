/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import mysoulmates.Main.mysoulmate;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class menuAdminController implements Initializable {

    @FXML
    private JFXButton homeBtn;
    @FXML
    private JFXButton membersBtn;
    @FXML
    private JFXButton weddingBtn;
    @FXML
    private JFXButton complaintBtn;
    @FXML
    private JFXButton eventBtn;
    @FXML
    private JFXButton quizzBtn;
    @FXML
    private JFXButton ordersBtn;
    @FXML
    private JFXButton logoutBtn;
    @FXML
    private JFXButton exitBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void logOut(ActionEvent event) {
        try {
            Stage window = (Stage) exitBtn.getScene().getWindow();
            mysoulmate soulmate = new mysoulmate();
            soulmate.start(new Stage());
            window.close();
        } catch (Exception ex) {
            Logger.getLogger(menuAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }

}
