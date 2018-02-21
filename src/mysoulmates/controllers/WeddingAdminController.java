/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import mysoulmates.entities.Category;
import mysoulmates.entities.Produit;
import mysoulmates.services.CategoryService;
import mysoulmates.services.ProduitService;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class WeddingAdminController implements Initializable {

    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField price;
    @FXML
    private JFXTextArea description;
    @FXML
    private ImageView picview;
    @FXML
    private JFXComboBox<String> category;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXButton addproductBtn;
    @FXML
    private JFXButton uploadBtn;

    private File file;
    private int id;

    CategoryService cService = new CategoryService();
    ProduitService pS = new ProduitService();

    ObservableList<String> list = FXCollections.observableArrayList();
    ObservableList<Produit> listP = FXCollections.observableArrayList();
    ObservableList<Category> listC = FXCollections.observableArrayList();

    @FXML
    private TableView<Produit> table;
    @FXML
    private TableColumn<Produit, String> imageCol;
    @FXML
    private TableColumn<Produit, String> nameCol;
    @FXML
    private TableColumn<Produit, String> categoryCol;
    @FXML
    private TableColumn<Produit, String> descriptionCol;
    @FXML
    private TableColumn<Produit, Float> priceCol;
    @FXML
    private TableColumn<Produit, String> addressCol;
    @FXML
    private JFXButton editBtn;
    @FXML
    private JFXButton viewBtn;
    @FXML
    private JFXButton categoryBtn;
    @FXML
    private TableView<Category> categoryTable;
    @FXML
    private JFXButton viewCategoryBtn;
    @FXML
    private TableColumn<Category, Integer> idCol;
    @FXML
    private TableColumn<Category, String> nameCategoryCol;
    @FXML
    private JFXTextField categoryName;
    @FXML
    private Tab manageTab;
    @FXML
    private JFXTabPane weddingTabPane;
    @FXML
    private JFXButton deleteBtn;
    @FXML
    private JFXButton update;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Affichage categorie dans comboBox
        list = cService.selectCategory();
        category.setItems(list);
        listproduct();
    }

    @FXML
    private void addProduct(ActionEvent event) {
        String myimg;

        if (file != null) {
            String[] tmp = file.toURI().toString().split("/");
            myimg = (tmp[tmp.length - 1]);

        } else {
            myimg = "NONE";
        }

        Produit p = new Produit(name.getText(), address.getText(), Float.parseFloat(price.getText()), description.getText(), category.getValue(), myimg);

        pS.insererProduit(p);
    }

    @FXML
    private void AddImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image img = new Image(file.toURI().toString(), 100, 150, true, true);
            picview.imageProperty().unbind();
            picview.setImage(img);
            picview.setFitWidth(200);
            picview.setFitHeight(150);
        } else {
            System.out.println("e404");
        }
    }

    public void listproduct() {
        imageCol.setCellValueFactory(new PropertyValueFactory<>("image"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        listP = ProduitService.listProduit();

        table.setItems(listP);

        table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                 name.setText(table.getSelectionModel().getSelectedItem().getName());
                                    address.setText(table.getSelectionModel().getSelectedItem().getAddress());
                                    Object o = (int) table.getSelectionModel().getSelectedItem().getPrice();
                                    price.setText(o.toString());
                                    description.setText(table.getSelectionModel().getSelectedItem().getDescription());
                            category.setValue(table.getSelectionModel().getSelectedItem().getCategory());
                                //    picview=new ImageView(new Image(getClass().getResourceAsStream("../../images/" + table.getSelectionModel().getSelectedItem().getImage())));
                                   setId(table.getSelectionModel().getSelectedItem().getId());
               
                
            }
        });
        System.out.println(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    @FXML
    private void EditProduct(ActionEvent event) {
        weddingTabPane.getSelectionModel().select(manageTab);
    }

    @FXML
    private void displayProduct(ActionEvent event) {
        listproduct();
    }

    @FXML
    private void AddCategory(ActionEvent event) {
        Category c =new Category(categoryName.getText());
        cService.insertCategory(c);
    }

    @FXML
    private void displayCategory(ActionEvent event) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCategoryCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        listC = CategoryService.selectCategories();
        categoryTable.setItems(listC);
    }

    @FXML
    private void DeleteProduct(ActionEvent event) {
          ProduitService.deleteProduct(id);
    }

    @FXML
    private void updateProduct(ActionEvent event) {
        String myimg;
          if (file != null) {
            String[] tmp = file.toURI().toString().split("/");
            myimg = (tmp[tmp.length - 1]);

        } else {
            myimg = "NONE";
        }
            String[] tmp = file.toURI().toString().split("/");

        Produit p = new Produit(name.getText(), address.getText(), Float.parseFloat(price.getText()), description.getText(), category.getValue(),myimg);

        pS.updateProduct(p,id);
    }
}
