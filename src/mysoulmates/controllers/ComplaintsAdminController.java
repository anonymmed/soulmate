/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mysoulmates.entities.Complaint;
import mysoulmates.services.ComplaintService;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class ComplaintsAdminController implements Initializable {
   static int id;
    static Complaint complaint;
    @FXML
    private TableView<Complaint> treatedComplaint;
    @FXML
    private TableColumn<Complaint, String> emailColT;
    @FXML
    private TableColumn<Complaint, java.sql.Date> dateColT;
    @FXML
    private TableColumn<Complaint, String> subjectColT;
    @FXML
    private TableColumn<Complaint, String> contentColT;
    @FXML
    private TableView<Complaint> pendingTable;
    @FXML
    private TableColumn<Complaint, String> emailColP;
    @FXML
    private TableColumn<Complaint, java.sql.Date> dateColP;
    @FXML
    private TableColumn<Complaint, String> subjectColP;
    @FXML
    private TableColumn<Complaint, String> contentColP;
    @FXML
    private JFXButton acceptBtn;
    @FXML
    private JFXButton updateBtn;
    @FXML
    private JFXButton deleteBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
           buildTableviewData();
             buildTableviewData2();
            EventGetData();
            EventGetData2();
       } catch (ParseException ex) {
           Logger.getLogger(ComplaintsAdminController.class.getName()).log(Level.SEVERE, null, ex);
       }
          
        // TODO
    }    

    @FXML
    private void Accept(ActionEvent event) throws ParseException {
            ComplaintService cs = new ComplaintService();
        cs.accept(id);
        buildTableviewData();
            buildTableviewData2();
    }
    
     private void buildTableviewData2() throws ParseException {
       
    
        contentColP.setCellValueFactory(new PropertyValueFactory<>("content"));
        dateColP.setCellValueFactory(new PropertyValueFactory<>("complaint_date"));
        emailColP.setCellValueFactory(new PropertyValueFactory<>("email"));
        subjectColP.setCellValueFactory(new PropertyValueFactory<>("subject"));          

        ComplaintService cs = new ComplaintService();
        
        ObservableList<Complaint> data = cs.PendingComplaint();
        
        pendingTable.setItems(data);     
        
      }
      private void buildTableviewData() throws ParseException {
       
    
        contentColT.setCellValueFactory(new PropertyValueFactory<>("content"));
        dateColT.setCellValueFactory(new PropertyValueFactory<>("complaint_date"));
        emailColT.setCellValueFactory(new PropertyValueFactory<>("email"));
        subjectColT.setCellValueFactory(new PropertyValueFactory<>("subject"));          

        ComplaintService cs = new ComplaintService();
        
        ObservableList<Complaint> data = cs.accptedComplaint();
        
        treatedComplaint.setItems(data);
      
        
      }
      
       private void EventGetData2() {
        pendingTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Complaint> observable,
                Complaint oldValue,
                Complaint newValue) -> {
            if (newValue == null) {            
                             
               
                return;
            }
            
            id = newValue.getId();
            complaint = newValue;
           
            
        });
    }
    
     private void EventGetData() {
        treatedComplaint.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Complaint> observable,
                Complaint oldValue,
                Complaint newValue) -> {
            if (newValue == null) {            
                             
               
                return;
            }
            
            id = newValue.getId();
            complaint = newValue;
            
        });
    }

    @FXML
    private void Delete(ActionEvent event) throws ParseException {
        ComplaintService cs = new ComplaintService();
        cs.delete(id);
        buildTableviewData();
            buildTableviewData2();
    }

    @FXML
    private void Reply(ActionEvent event) {
    }
    
    
}
