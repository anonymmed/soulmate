/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class homeAdminController implements Initializable {

    @FXML
    private JFXHamburger hamburger;
    @FXML
    private AnchorPane holderPane;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private Label txtCurrentWindow;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (drawer.isShown()) {
                drawer.close();
            } else {
                drawer.open();
            }

        });
        try {
            VBox sidePane = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/menuAdmin.fxml"));
            AnchorPane welcome = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/welcomeAdmin.fxml"));
            AnchorPane members = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/memberAdmin.fxml"));
//            AnchorPane wedding = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/weddingAdmin.fxml"));
            AnchorPane complaints = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/complaintsAdmin.fxml"));
            AnchorPane events = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/eventAdmin.fxml"));
            AnchorPane quizzs = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/quizzAdmin.fxml"));
            AnchorPane orders = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/ordersAdmin.fxml"));
            setNode(welcome);
            drawer.setSidePane(sidePane);

            for (Node node : sidePane.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent ev) -> {
                        switch (node.getAccessibleText()) {
                            case "homeMenu":
                                drawer.close();
                                setNode(welcome);
                                break;
                            case "membersMenu":
                                drawer.close();
                                setNode(members);
                                break;
                            case "weddingMenu":
                                drawer.close();
                        {
                            try {
                                setNode( FXMLLoader.load(getClass().getResource("/mysoulmates/Views/weddingAdmin.fxml")));
                            } catch (IOException ex) {
                                Logger.getLogger(homeAdminController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                                break;
                            case "complaintMenu":
                                drawer.close();
                                setNode(complaints);
                                break;
                            case "eventMenu":
                                drawer.close();
                                setNode(events);
                                break;

                            case "quizzMenu":
                                drawer.close();
                                setNode(quizzs);
                                break;

                            case "ordersMenu":
                                drawer.close();
                                setNode(events);
                                break;

                        }
                    });
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(homeAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
    }

}
