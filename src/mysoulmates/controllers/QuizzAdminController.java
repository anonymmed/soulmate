/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mysoulmates.entities.Quiz;
import mysoulmates.entities.Validator;
import mysoulmates.services.ServicesQuiz;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class QuizzAdminController implements Initializable {

    static int id;
    static Quiz selectedQuiz;
    static String theme = "";
    JFXTextField txtQuestion;
    @FXML
    private JFXTextField questionEdit;
    @FXML
    private StackPane deptStackPane;

    @FXML
    private TableView<Quiz> quizztable;
    @FXML
    private TableColumn<Quiz, String> themeCol;
    @FXML
    private TableColumn<Quiz, String> questionCol;
    @FXML
    private JFXButton sportbtn;
    @FXML
    private JFXButton culturebtn;
    @FXML
    private JFXButton filmbtn;
    @FXML
    private JFXButton seriesbtn;
    @FXML
    private JFXButton travelbtn;
    @FXML
    private JFXButton hobbiesbtn;
    @FXML
    private JFXButton deleteBtn;
    @FXML
    private JFXButton updatebtn;
    @FXML
    private GridPane gpview;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            selectedQuiz = new Quiz();
            buldTableViewQuiz();
            EventGetData();
        } catch (SQLException ex) {
            Logger.getLogger(QuizzAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO
    }

    private void buldTableViewQuiz() throws SQLException {

        questionCol.setCellValueFactory(new PropertyValueFactory<>("question"));
        themeCol.setCellValueFactory(new PropertyValueFactory<>("theme"));

        ServicesQuiz servicesQuiz = new ServicesQuiz();
        ObservableList<Quiz> data = servicesQuiz.displayQuiz();

        quizztable.setItems(data);

    }

    private void EventGetData() {
        quizztable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Quiz> observable,
                Quiz oldValue,
                Quiz newValue) -> {
            if (newValue == null) {

                return;
            }

            id = newValue.getId();
            selectedQuiz = newValue;

        });
    }

    @FXML
    private void actionsport(ActionEvent event) {
        theme = "Sport";
        add();
        //  deptStackPane.getChildren().select(questionsAdd);
    }

    @FXML
    private void actionCulture(ActionEvent event) {
        theme = "Culture";
        add();
    }

    @FXML
    private void actionFilm(ActionEvent event) {
        theme = "Film";
        add();
    }

    @FXML
    private void actionSerie(ActionEvent event) {
        theme = "Serie";
        add();
    }

    @FXML
    private void actionTravel(ActionEvent event) {
        theme = "Travel";
        add();
    }

    @FXML
    private void actionHobbies(ActionEvent event) {
        theme = "Hobbies";
        add();
    }

    private void add() {
        //Body Input text
        txtQuestion = new JFXTextField();
        txtQuestion.setPromptText("Enter new question");
        txtQuestion.setLabelFloat(false);
        txtQuestion.setPrefSize(150, 50);
        txtQuestion.setPadding(new Insets(10, 5, 10, 5));
        txtQuestion.setStyle("-fx-font-size:13px; -fx-font-weight:bold;-fx-text-fill:#00B3A0");
        // Heading text
        Text t = new Text("Add New Question");
        t.setStyle("-fx-font-size:14px;");

        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(t);
        dialogLayout.setBody(txtQuestion);

        JFXDialog dialog = new JFXDialog(deptStackPane, dialogLayout, JFXDialog.DialogTransition.CENTER);
        // close button
        JFXButton closeButton = new JFXButton("Dismiss");
        closeButton.setStyle("-fx-button-type: RAISED;-fx-background-color: rgb(77,102,204);-fx-font-size: 14px;-fx-text-fill: WHITE;");
        //Add button
        JFXButton addBtn = new JFXButton("Add");
        addBtn.setStyle("-fx-button-type: RAISED;-fx-background-color: rgb(77,102,204);-fx-font-size: 14px;-fx-text-fill: WHITE;"
                + "");
        closeButton.setOnAction((ActionEvent event1) -> {
            dialog.close();
        });
        addBtn.setOnAction((ActionEvent event1) -> {
            System.out.println(txtQuestion.getText());
            if (Validator.validate(Validator.regexType.QUESTION, txtQuestion.getText()) == false) {
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "Verify your data ", ButtonType.OK);
                alert.showAndWait();
            } else {
                Quiz quiz = new Quiz(txtQuestion.getText(), theme);
                ServicesQuiz servicesQuiz;
                try {
                    servicesQuiz = new ServicesQuiz();
                    servicesQuiz.addQuiz(quiz);
                    buldTableViewQuiz();
                } catch (SQLException ex) {
                    Logger.getLogger(QuizzAdminController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            dialog.close();
        });

        HBox box = new HBox();
        box.setSpacing(20);
        box.setPrefSize(200, 50);
        box.setAlignment(Pos.CENTER_RIGHT);
        box.getChildren().addAll(addBtn, closeButton);

        dialogLayout.setActions(box);

        dialog.show();

    }

    @FXML
    private void deleteQuestion(ActionEvent event) throws SQLException {
        ServicesQuiz servicesQuiz = new ServicesQuiz();
        servicesQuiz.deleteQuiz(id);
        buldTableViewQuiz();
    }

    @FXML
    private void UpdateQuestion(ActionEvent event) throws SQLException {
         questionEdit.setText(selectedQuiz.getQuestion());
       
    }

    @FXML
    private void EditQuestion(ActionEvent event) throws SQLException {
         if (Validator.validate(Validator.regexType.QUESTION, questionEdit.getText()) == false) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Verify your data ", ButtonType.OK);
            alert.showAndWait();
        } else {

            ServicesQuiz servicesQuiz = new ServicesQuiz();
            Quiz quiz = new Quiz(selectedQuiz.getId(), questionEdit.getText());
           

            servicesQuiz.edit(quiz);
             buldTableViewQuiz();

        }
    }
}
