/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import mysoulmates.StripePayment.PaymentOrder;
import com.jfoenix.controls.JFXTextField;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import mysoulmates.entities.User;
import mysoulmates.services.service_Command;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class Controller_PaymentWishList implements Initializable {

    /**
     * Initializes the controller class.
     */
        
        public static User client=null;
        @FXML
    private JFXTextField name,cc,cvv,exp_y,exp_m;
        FXMLLoader fxmlLLoader_success;
        @FXML
                FXMLLoader fxmlLLoader_error;
        @FXML
    private AnchorPane holderPane;
    public void initialize(URL url, ResourceBundle rb) {
        fxmlLLoader_success = new FXMLLoader(getClass().getResource("/mysoulmates/views/PaymentConfirmed.fxml"));
        fxmlLLoader_error = new FXMLLoader(getClass().getResource("/mysoulmates/views/PaymentDeclined.fxml"));

        // TODO
    }   

    @FXML
            public  void createPayment() throws IOException, MessagingException
            {

                if (client!=null)
                {
                   Map<String,Object>mybillinfo = new HashMap<String,Object>();
                           mybillinfo=service_Command.getCommandInfo(client);

                           PaymentOrder payment = new PaymentOrder(cc.getText(), cvv.getText(),exp_m.getText(), exp_y.getText(),(double)mybillinfo.get("ammount"), (String)mybillinfo.get("contact_email"), (String)mybillinfo.get("city"), (String)mybillinfo.get("state"), (String)mybillinfo.get("address"), (String)mybillinfo.get("country"), (String)mybillinfo.get("zip"));
                    try {
                       Charge charge = payment.createCharge("sk_test_FVEeqrph8YVjQOYUS5kj6kdr",payment.getAmmount(),payment.getName(),payment.getCardnumber(),payment.getExp_month(),payment.getExp_year(),payment.getCvv(),payment.getAddress(),payment.getCity(),payment.getState(),payment.getCountry(),payment.getZip(),payment.getEmail());
                        System.out.println("charge : "+charge.getStatus());            
                        if(charge.getStatus().equalsIgnoreCase("succeeded"))
                   {
                        Parent root = fxmlLLoader_success.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                        Controller_SendMail.sendMail((String)mybillinfo.get("contact_email"),"Payment Successfull", "Order Successful :\n Description :\n Ammount: "+mybillinfo.get("ammount"));
                   }

                    }
                    catch (AuthenticationException | InvalidRequestException | APIConnectionException | CardException | APIException ex) {
                        if (ex.getMessage()!=null || !(ex.getMessage().equals("")))
                        {
                        Parent root1 = fxmlLLoader_error.load();
                        Stage stage1 = new Stage();
                        stage1.setScene(new Scene(root1));
                        stage1.show();
                            System.out.println("erro med " +ex.getMessage());
 
                        }
                    }

                }
                  
            }
}
