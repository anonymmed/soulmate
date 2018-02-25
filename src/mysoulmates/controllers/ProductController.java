/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mysoulmates.entities.Produit;
import mysoulmates.services.ProduitService;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class ProductController implements Initializable {

    /**
     * ********************************
     * view Product * *********************************
     */
    public  static int id;
    @FXML
    private GridPane gpview;
    private static int endCount = 0;
    private static int idProduct;
    Produit p=new Produit();
    @FXML
            private JFXButton nextBtn;
            List<String> x=new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    ProduitService pS = new ProduitService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayGrid();

    }

    public void displayGrid() {
        ResultSet rs = ProduitService.selectProduits(endCount);
        int i = 0;
        int j = 0;

        try {
            while (rs.next()) {
                AnchorPane ap = new AnchorPane();
                ap.setPrefWidth(348);
                ap.setPrefHeight(191);
                /*Product Image*/
                ImageView im = new ImageView(new Image("/mysoulmates/images/" + rs.getString(7)));
                im.setFitWidth(100);
                im.setFitHeight(100);
                im.setLayoutX(80);
                im.setLayoutY(38);
                 /*Add To Cart*/
                ImageView cart = new ImageView(new Image(getClass().getResourceAsStream("/mysoulmates/images/like.png")));
                cart.setFitWidth(50);
                cart.setFitHeight(50);
                cart.setLayoutX(270);
                cart.setLayoutY(120);
if(i !=0){
    

                Separator separator2 = new Separator();
                separator2.setOrientation(Orientation.VERTICAL);
                separator2.setPrefHeight(160);
                separator2.setPrefWidth(0);
                separator2.setLayoutY(38);
                separator2.setStyle(" -fx-border-color: red");
                separator2.setStyle(" -fx-border-width: 1");
                                ap.getChildren().add(separator2);

                }
                Button bouton = new Button("More");
                try {
                    bouton.setAccessibleHelp(Integer.toString(rs.getInt(1)));
                } catch (SQLException ex) {
                    Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                }
                id=Integer.parseInt(bouton.getAccessibleHelp());
                bouton.setFont(new Font("Cambria", 15));
                bouton.setTextFill(Color.web("#ad4979"));
                bouton.setLayoutX(10);
                bouton.setLayoutY(135);
                bouton.setOnAction((ActionEvent e) -> {
                    

                    AnchorPane home;
                    try {
                       // int k=getCurrentProduct();
                   // System.out.println(k);
                        home = FXMLLoader.load(getClass().getResource("/mysoulmates/Views/infoProduct.fxml"));
                        Scene scene = new Scene(home);
                        Stage App1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
                        App1.setScene(scene);
                        App1.show();
                    } catch (IOException ex) {
                        Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                );
                /*Product Name*/
                Label l = new Label(rs.getString(2));
                l.setLayoutX(90);
                l.setLayoutY(11);
                l.setFont(new Font("Cambria", 20));
                l.setTextFill(Color.web("#ad4979"));
                /*Product Rating*/
                final Rating rating = new Rating();
              rating.ratingProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        String note = newValue.toString();
                        System.out.println(note);
                       
                        x.add(note);
                        System.out.println(x.get(x.size()-1));

                    } 

                
                        });
              // double note = rating.getRating();
               // System.out.println(valueOf(rating.getRating()));
                rating.setLayoutX(75);
                rating.setLayoutY(138);
                rating.setUpdateOnHover(true);
                /*Ajout dans Grid*/
                ap.getChildren().add(rating);
                ap.getChildren().add(im);
                ap.getChildren().add(cart);
                ap.getChildren().add(bouton);
                ap.getChildren().add(l);

                gpview.add(ap, i, j);

                i++;
                if (i == 3) {
                    j++;
                    i = 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void nextPage(ActionEvent event) {
        int k=ProduitService.count();
        
       if(endCount<k)
       {
        gpview.getChildren().clear();
        if(endCount+9<=k)
        {
        endCount += 9;            
        }
        else
        {
            endCount+=(k-endCount);
        }

        displayGrid();
       
       
    }
       if(endCount==k)
       {
          nextBtn.setVisible(false);
       }
        System.out.println(endCount);
    }

    @FXML
    private void previousPage(ActionEvent event) {

       
       
       if (endCount >= 9) {
            endCount -= 9;
             gpview.getChildren().clear();
        
          
        }
        displayGrid();

    }

    public static int getCurrentProduct() {
        if (idProduct != -1) {
            return idProduct;
        }
        return -1;

    }
}
