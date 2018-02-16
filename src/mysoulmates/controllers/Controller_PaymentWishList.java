/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import StripePayment.PaymentOrder;
import com.jfoenix.controls.JFXTextField;
import com.stripe.model.Charge;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import mysoulmates.entities.Client;
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
        
        public static Client client=null;
        @FXML
    private JFXTextField name,cc,cvv,exp_y,exp_m;

   @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    @FXML
            public  void createPayment()
            {
                if (client!=null)
                {
                   Map<String,Object>mybillinfo = new HashMap<String,Object>();
                           mybillinfo=service_Command.getCommandInfo(client);
                           for (Map.Entry<String, Object> entry : mybillinfo.entrySet()) {
                               System.out.println(entry.getKey());
                               System.out.println(entry.getValue());
                        
                    }
                           System.out.println(name.getText());
                           PaymentOrder payment = new PaymentOrder(cc.getText(), cvv.getText(),exp_m.getText(), exp_y.getText(),(double)mybillinfo.get("ammount"), (String)mybillinfo.get("contact_email"), (String)mybillinfo.get("city"), (String)mybillinfo.get("state"), (String)mybillinfo.get("address"), (String)mybillinfo.get("country"), (String)mybillinfo.get("zip"));
                          System.out.println(payment.getAmmount()+" "+payment.getName()+" "+payment.getExp_month()+""+payment.getExp_year());
                               Charge charge =   payment.createCharge("sk_test_FVEeqrph8YVjQOYUS5kj6kdr",payment.getAmmount(),payment.getName(),payment.getCardnumber(),payment.getExp_month(),payment.getExp_year(),payment.getCvv(),payment.getAddress(),payment.getCity(),payment.getState(),payment.getCountry(),payment.getZip(),payment.getEmail());
 
                   System.out.println(charge);
                }

            }
}
