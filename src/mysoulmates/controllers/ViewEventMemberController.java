/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import mysoulmates.services.EventService;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class ViewEventMemberController implements Initializable {

    @FXML
    private GridPane gpEvents;

    /**
     * Initializes the controller class.
     */
    EventService es = new EventService();
    ResultSet rs = EventService.afficherEvent();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        displayProduct();
    }

    public void displayProduct() {

        /*   int page=pageIndex *productPerPage();
        for(int k=page;k< page + productPerPage();k++)
        {*/
        int i = 0;
        int j = 0;
        try {
            while (rs.next()) {

                AnchorPane ap = new AnchorPane();
                ap.setPrefWidth(350);
                ap.setPrefHeight(200);

                ImageView im = new ImageView(new Image("/mysoulmates/images/" + rs.getString(7)));
                im.setFitWidth(100);
                im.setFitHeight(100);
                im.setLayoutX(80);
                im.setLayoutY(38);

                Separator separator2 = new Separator();
                separator2.setOrientation(Orientation.VERTICAL);
                separator2.setPrefHeight(160);
                separator2.setPrefWidth(0);
                separator2.setLayoutY(38);
                separator2.setStyle(" -fx-border-color: red");
                separator2.setStyle(" -fx-border-width: 1");

                Label l = new Label(rs.getString(1));
                l.setLayoutX(90);
                l.setLayoutY(11);
                l.setFont(new Font("Cambria", 20));
                l.setTextFill(Color.web("#ad4979"));
                Label l2 = new Label("Location : ");
                l2.setLayoutX(0);
                l2.setLayoutY(145);
                l2.setFont(new Font("Cambria", 18));
                l2.setTextFill(Color.web("#ad4979"));
                Label l3 = new Label(rs.getString(2));
                l3.setLayoutX(80);
                l3.setLayoutY(145);
                l3.setFont(new Font("Cambria", 18));
                l3.setTextFill(Color.web("#ad4979"));
                Label l4 = new Label("Description : ");
                l4.setLayoutX(0);
                l4.setLayoutY(165);
                l4.setFont(new Font("Cambria", 18));
                l4.setTextFill(Color.web("#ad4979"));
                Label l5 = new Label(rs.getString(3));
                l5.setLayoutX(100);
                l5.setLayoutY(165);
                l5.setFont(new Font("Cambria", 18));
                l5.setTextFill(Color.web("#ad4979"));
                Label l6 = new Label("StartDate : ");
                l6.setLayoutX(0);
                l6.setLayoutY(185);
                l6.setFont(new Font("Cambria", 18));
                l6.setTextFill(Color.web("#ad4979"));
                Label l7 = new Label(rs.getString(4));
                l7.setLayoutX(100);
                l7.setLayoutY(185);
                l7.setFont(new Font("Cambria", 18));
                l7.setTextFill(Color.web("#ad4979"));
                Label l8 = new Label("EndDate : ");
                l8.setLayoutX(0);
                l8.setLayoutY(185);
                l8.setFont(new Font("Cambria", 18));
                l8.setTextFill(Color.web("#ad4979"));
                Label l9 = new Label(rs.getString(5));
                l9.setLayoutX(100);
                l9.setLayoutY(185);
                l9.setFont(new Font("Cambria", 18));
                l9.setTextFill(Color.web("#ad4979"));
                Label l10 = new Label("Participants : ");
                l10.setLayoutX(0);
                l10.setLayoutY(205);
                l10.setFont(new Font("Cambria", 18));
                l10.setTextFill(Color.web("#ad4979"));
                Label l11 = new Label(rs.getString(6));
                l11.setLayoutX(100);
                l11.setLayoutY(205);
                l11.setFont(new Font("Cambria", 18));
                l11.setTextFill(Color.web("#ad4979"));
                Button bouton = new Button("INSCRIRE");
                bouton.setFont(new Font("Cambria", 20));
                bouton.setTextFill(Color.web("#0076a3"));
                bouton.setLayoutY(215);

                /* bouton.setOnAction((ActionEvent e)->{
                    try {
                    Es.increment(new event(rs.getInt(6)),rs.getInt(8));
                    } catch (SQLException ex) {
                        Logger.getLogger(Ajout_eventController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
            });*/
 /* bouton.setOnAction((ActionEvent e) -> {
                         Parent home;
                   try {
                       home = FXMLLoader.load(getClass().getResource("../home/home.fxml"));
                         Scene scene = new Scene(home);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
                   } catch (IOException ex) {
                       Logger.getLogger(HomeBackController.class.getName()).log(Level.SEVERE, null, ex);
                   }
        
      
    
});*/
//ap.getChildren().add(im);
                ap.getChildren().add(bouton);
                ap.getChildren().add(l);
              
                ap.getChildren().add(l2);
                ap.getChildren().add(l3);
                ap.getChildren().add(l4);
                ap.getChildren().add(l5);
                ap.getChildren().add(l6);
                ap.getChildren().add(l7);
                ap.getChildren().add(l8);
                ap.getChildren().add(l9);
                ap.getChildren().add(l10);
                ap.getChildren().add(l11);
                ap.getChildren().add(im);

                gpEvents.add(ap, i, j);

                i++;
                if (i == 2) {
                    j++;
                    i = 0;
                }
            }

        } catch (SQLException ex) {
            System.out.println("404");
            Logger.getLogger(ViewEventMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
