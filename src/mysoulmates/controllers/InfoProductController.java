/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXTextField;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static mysoulmates.controllers.ProductController.id;
import mysoulmates.services.ProduitService;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class InfoProductController implements Initializable, MapComponentInitializedListener {

    @FXML
    private GoogleMapView mapView;
    @FXML
    private ImageView productImage;
    @FXML
    private Label nameProduct;
    @FXML
    private Label descriptionProduct;
    @FXML
    private Label priceproduct;
    @FXML
    private TextField recherche;
    private GoogleMap map;
    private GeocodingService geocodingService;
     private final StringProperty address = new SimpleStringProperty();
    @FXML
    private JFXTextField from;
    @FXML
    private JFXTextField to;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        to.setVisible(false);
        from.setVisible(false);
        recherche.setVisible(false);
        ProduitService ps=new ProduitService();
        ResultSet rs=ProduitService.selectInfo(id);
          mapView.addMapInializedListener(this);

        address.bind(recherche.textProperty());
        try {
            while(rs.next())
            {
                descriptionProduct.setText(rs.getString(7));
                priceproduct.setText(rs.getString(6));
                productImage= new ImageView(new Image(getClass().getResourceAsStream("/mysoulmates/images/" + rs.getString(7))));
                nameProduct.setText(rs.getString(2));
                from.setText(rs.getString(5));
                to.setText(rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InfoProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }    

    @Override
    public void mapInitialized() {
   geocodingService = new GeocodingService();
        MapOptions mapOptions = new MapOptions();
       
            LatLong Location = new LatLong(Double.parseDouble(to.getText()),Double.parseDouble(from.getText()));
            MarkerOptions markerOptions1 = new MarkerOptions();
            //LatLong x = new LatLong(36.898392,10.189732);
            Marker m = new Marker(markerOptions1);
            System.out.println(Location);
            mapOptions.center(Location)
                    .mapType(MapTypeIdEnum.ROADMAP)
                    .overviewMapControl(false)
                    .panControl(false)
                    .rotateControl(false)
                    .scaleControl(false)
                    .streetViewControl(false)
                    .zoomControl(false)
                    .zoom(12);
map = mapView.createMap(mapOptions);

            map.addMouseEventHandler(UIEventType.click, (GMapMouseEvent event) -> {
                LatLong latLong = event.getLatLong();
                from.setText(String.valueOf(latLong.getLatitude()));
                to.setText(String.valueOf(latLong.getLongitude()));
                //ADR= recherche.getText();
                markerOptions1.position(latLong)
                        .visible(true)
                        .title("helllo");
                m.setOptions(markerOptions1);

                map.addMarker(m);
            });    }
    

}
