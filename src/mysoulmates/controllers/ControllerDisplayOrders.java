/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class ControllerDisplayOrders implements Initializable {

        
    @Override
    
    public void initialize(URL url, ResourceBundle rb) 
        {

        }

       
        @FXML
        public void deleteItem()
        {

        }
        
        
        
        
        @FXML 
        private void switchhome()
        {
        try {
           setNode(new FXMLLoader().load(getClass().getResource("/mysoulmates/Views/welcome.fxml")));
        } catch (IOException ex) 
        {
       
           Logger.getLogger(ControllerDisplayOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
        
        
        
        
                    private void setNode(Node node)
    {

    }

    @FXML
    private void ConfirmWishlist(ActionEvent event) {

        }
    

}
