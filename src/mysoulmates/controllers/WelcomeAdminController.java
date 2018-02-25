/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import mysoulmates.services.ServiceReponse;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class WelcomeAdminController implements Initializable {

    @FXML
    private JFXComboBox<String> cbTheme;
    @FXML
    private Pane state;
    @FXML
    private Label caption;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> options = 
    FXCollections.observableArrayList(
        "Sport",
        "Culture",
        "Film",
        "Serie",
        "Hobies",
        "Travel"
    );
    cbTheme.getItems().addAll(options);
       
    }    
    public void showStats(String theme) throws SQLException{
        caption.setVisible(false);
        ServiceReponse sr = new ServiceReponse();
        
        int noes = sr.countNoesForTheme(theme);
        int yesh = sr.countYeshForTheme(theme);
        caption.setTextFill(Color.BLACK);
        caption.setStyle("-fx-font: 24 arial;");
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("No", noes),
                new PieChart.Data("Yes", yesh)
                );
        PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Answers");
        for (final PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        caption.setVisible(true);
                        caption.setLayoutX(e.getSceneX());
                        caption.setLayoutY(e.getSceneY());
                        caption.setText(String.valueOf(Math.floor((data.getPieValue() * 100) / (noes + yesh))) + "%");
                     }
                });
        };
        state.getChildren().clear();
        state.getChildren().add(chart);
    }

    @FXML
    private void changeStats(ActionEvent event) {
    }
    
    
}
