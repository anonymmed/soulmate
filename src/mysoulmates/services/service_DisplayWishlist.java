/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.services;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;
import mysoulmates.controllers.Controller_Wishlist;
import mysoulmates.entities.User;
import mysoulmates.entities.Product;

/**
 *
 * @author Mohamed
 */
public class service_DisplayWishlist {
    
    
    
    public static void DisplayWishList(JFXListView<String> ProductDisplayList,User c)
    {
        Button b = new Button("med");
                
                
        ObservableList<String> ProductDisplayFillList = FXCollections.observableArrayList();
                          for (Product p : Controller_Wishlist.displayWishListe(c.getEmail()))
                              {
                                  ProductDisplayFillList.add(p.getNom());

                                          
        ProductDisplayList.setCellFactory(new Callback<ListView<String>,ListCell<String>>(){
            @Override
            
            public ListCell<String> call(ListView<String> param) {
                ListCell<String> cell = new ListCell<String>(){
                 @Override
                 protected void updateItem(String item,boolean empty)
                 {
                     if (item != null)
                     {
                         Image img =   new Image(getClass().getResource("/mysoulmates/img/"+item+".png").toExternalForm());
                         ImageView imgview = new ImageView(img);
                                  setText(item);
                                  
                                 setAlignment(Pos.TOP_LEFT);
                                          setGraphic(imgview);
                     }
                 }
                };
                return cell;
                
            }

            
    });
                              }
        
        

      
        ProductDisplayList.setItems(ProductDisplayFillList);
    }
    
    
    public  void ConfirmWishList(JFXButton confirmbtn) throws IOException
    {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/mysoulmates/views/InforWishList.fxml"));        
        Parent root1 =  fXMLLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
              
                
                stage.show();
}
    
    
    

}