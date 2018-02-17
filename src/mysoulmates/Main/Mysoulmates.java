/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.Main;
import mysoulmates.StripePayment.PaymentOrder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;
import com.stripe.net.RequestOptions.RequestOptionsBuilder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mysoulmates.controllers.Controller_SendMail;
import mysoulmates.entities.Client;
import mysoulmates.entities.Produit;
import mysoulmates.entities.Wishliste;
import mysoulmates.services.service_Command;

/**
 *
 * @author Mohamed
 */
public class Mysoulmates extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/mysoulmates/views/Mainfxml.fxml"));
         
        Scene scene = new Scene(root);
       
        
        stage.setScene(scene);
        stage.setTitle("My Soulmate");
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException,Exception {
        launch(args);
                     Wishliste wish = new Wishliste();
             Produit p1 = new Produit("mmmmm","this is my peod",15);
             Client c1 = new Client("mohamed.abdelhafidh@esprit.tn");
             Client c2 = new Client("nidhal.hmandi@esprit.tn");
             c1.setWishListe(wish);
             c1.setEmail("mohamed.abdelhafidh@esprit.tn");
             c2.setEmail("nidhal.hmandi@esprit.tn");
                
           //  wish.addToWishListe(p1);
             
             //Add Product To Wish List
             
             
       //    Controller_Wishlist.addToWishlist(wish.getListe(),c1.getEmail());
             
       
       //Delete From Wish List
           //  Controller_Wishlist.DeleteFromWishList(p1);
           
           
           //Wish List Display
    //   List<Produit>l2 = new ArrayList<Produit>();
      //     l2=Controller_Wishlist.displayWishListe(c1.getEmail());
           
           
           //Wish List Total : 
         //  System.out.println(Controller_Wishlist.CalculatePrix(c1));
          // System.out.println(l2);
          
          
          
          
          //get who i liked
          
       //   Controller_Client.likeClient(c1, c2);
//List<Client>l4= new ArrayList<Client>();
//l4=Controller_Client.DisplayLikes(c1);
 //       System.out.println(l4);


 //Delete Like
      // Controller_Client.DeleteLike(c1, c2);
      
      
      
      
      //test post data
//Create a payment order using stripe : 
/*
        PaymentOrder payment = new PaymentOrder("4000056655665556", "111","11", "2019", 5000.0, "mohamed.abdelhafidh@esprit.tn", "ariana", "ariana", "esprit", "tunisia", "7100");
        payment.createCharge("sk_test_FVEeqrph8YVjQOYUS5kj6kdr",payment.getAmmount(),payment.getName(),payment.getCardnumber(),payment.getExp_month(),payment.getExp_year(),payment.getCvv(),payment.getAddress(),payment.getCity(),payment.getState(),payment.getCountry(),payment.getZip(),payment.getEmail());
*/
//Client c = new Client("mohamed.abdelhafidh@esprit.tn");
        Controller_SendMail.sendMail();
    } 


    }
    

