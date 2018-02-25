/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import mysoulmates.entities.Quiz;
import mysoulmates.entities.Reponse;
import mysoulmates.entities.Session;
import mysoulmates.entities.User;
import mysoulmates.services.ServiceReponse;
import mysoulmates.services.ServicesQuiz;
import mysoulmates.services.UserService;

/**
 * FXML Controller class
 *
 * @author ss
 */
public class QuizzMemberController implements Initializable {

    static List<Reponse> listReponses;
    @FXML
    private JFXRadioButton rbsport1;
    @FXML
    private JFXRadioButton rbsport2;
    @FXML
    private JFXRadioButton rbsport3;
    @FXML
    private JFXRadioButton rbsport4;
    @FXML
    private JFXRadioButton rbFilm1;
    @FXML
    private JFXRadioButton rbFilm2;
    @FXML
    private JFXRadioButton rbFilm3;
    @FXML
    private JFXRadioButton rbFilm4;
    @FXML
    private JFXRadioButton rbTravel1;
    @FXML
    private JFXRadioButton rbTravel2;
    @FXML
    private JFXRadioButton rbTravel3;
    @FXML
    private JFXRadioButton rbTravel4;
    @FXML
    private JFXRadioButton rbCulture1;
    @FXML
    private JFXRadioButton rbCulture2;
    @FXML
    private JFXRadioButton rbCulture3;
    @FXML
    private JFXRadioButton rbCulture4;
    @FXML
    private JFXRadioButton rbSerie1;
    @FXML
    private JFXRadioButton rbSerie2;
    @FXML
    private JFXRadioButton rbSerie3;
    @FXML
    private JFXRadioButton rbSerie4;
    @FXML
    private JFXRadioButton rbHobbies1;
    @FXML
    private JFXRadioButton rbHobbies2;
    @FXML
    private JFXRadioButton rbHobbies3;
    @FXML
    private JFXRadioButton rbHobbies4;
    @FXML
    private JFXButton submitBtn;
    @FXML
    private Label sportQ1;
    @FXML
    private Label sportQ2;
    @FXML
    private Label filmQ1;
    @FXML
    private Label filmQ2;
    @FXML
    private Label travelQ1;
    @FXML
    private Label travelQ2;
    @FXML
    private Label cultureQ1;
    @FXML
    private Label cultureQ2;
    @FXML
    private Label serieQ1;
    @FXML
    private Label serieQ2;
    @FXML
    private Label hobbieQ1;
    @FXML
    private Label hobbieQ2;

    /**
     * Initializes the controller class.
     */
         
      UserService us = new UserService();
    Integer idad = Session.getCurrentSession();
        User u = us.findById(idad);       

    @FXML
    private void Submit(ActionEvent event) throws SQLException {
        ServiceReponse sr = new ServiceReponse();
        listReponses = new ArrayList<>();
        String reponse ="No";
       
        
        int id = u.getId();
          if(rbCulture1.isSelected()){ reponse = "Yes"; rbCulture2.setSelected(false); }
        if(rbCulture2.isSelected()){ reponse = "No"; rbCulture1.setSelected(false);}
        listReponses.add(new Reponse(cultureQ1.getText(), reponse, "Culture", id));
        
        if(rbCulture3.isSelected()){ reponse = "Yes"; rbCulture4.setSelected(false);}
        if(rbCulture4.isSelected()){ reponse = "No"; rbCulture3.setSelected(false);}
        listReponses.add(new Reponse(cultureQ2.getText(), reponse, "Culture", id));
        
        
        
        if(rbFilm1.isSelected()){ reponse = "Yes"; rbFilm2.setSelected(false);}
        if(rbFilm2.isSelected()){ reponse = "No"; rbFilm1.setSelected(false);}
        listReponses.add(new Reponse(filmQ1.getText(), reponse, "Film", id));
        
        if(rbFilm3.isSelected()){ reponse = "Yes"; rbFilm4.setSelected(false);}
        if(rbFilm4.isSelected()){ reponse = "No"; rbFilm3.setSelected(false);}
        listReponses.add(new Reponse(filmQ2.getText(), reponse, "Film", id));
        
        if(rbHobbies1.isSelected()){ reponse = "Yes"; rbHobbies1.setSelected(false);}
        if(rbHobbies2.isSelected()){ reponse = "No"; rbHobbies1.setSelected(false);}
        listReponses.add(new Reponse(hobbieQ1.getText(), reponse, "Hobies", id));
        
        if(rbHobbies3.isSelected()){ reponse = "Yes"; rbHobbies4.setSelected(false);}
        if(rbHobbies4.isSelected()){ reponse = "No"; rbHobbies3.setSelected(false);}
        listReponses.add(new Reponse(hobbieQ2.getText(), reponse, "Hobies", id));
        
        if(rbSerie1.isSelected()){ reponse = "Yes"; rbSerie2.setSelected(false);}
        if(rbSerie2.isSelected()){ reponse = "No"; rbSerie1.setSelected(false);}
        listReponses.add(new Reponse(serieQ1.getText(), reponse, "Serie", id));
        
        if(rbSerie3.isSelected()){ reponse = "Yes"; rbSerie4.setSelected(false);}
        if(rbSerie4.isSelected()){ reponse = "No"; rbSerie3.setSelected(false);}
        listReponses.add(new Reponse(serieQ2.getText(), reponse, "Serie", id));
        
        if(rbsport1.isSelected()){ reponse = "Yes"; rbsport2.setSelected(false);}
        if(rbsport2.isSelected()){ reponse = "No"; rbsport1.setSelected(false);}
        listReponses.add(new Reponse(sportQ1.getText(), reponse, "Sport", id));
        
        if(rbsport3.isSelected()){ reponse = "Yes"; rbsport4.setSelected(false);}
        if(rbsport4.isSelected()){ reponse = "No"; rbsport3.setSelected(false);}
        listReponses.add(new Reponse(sportQ2.getText(), reponse, "Sport", id));
        
        
        if(rbTravel1.isSelected()){ reponse = "Yes";rbTravel2.setSelected(false); }
        if(rbTravel2.isSelected()){ reponse = "No";rbTravel1.setSelected(false); }
        listReponses.add(new Reponse(travelQ1.getText(), reponse, "Travel", id));
        
        if(rbTravel3.isSelected()){ reponse = "Yes";rbTravel4.setSelected(false); }
        if(rbTravel4.isSelected()){ reponse = "No";rbTravel3.setSelected(false); }
        listReponses.add(new Reponse(travelQ2.getText(), reponse, "Travel", id));
        if(!rbCulture1.isSelected() & !rbCulture2.isSelected() || 
           !rbCulture3.isSelected() & !rbCulture4.isSelected() ||
           !rbTravel1.isSelected() & !rbTravel2.isSelected() || 
           !rbTravel3.isSelected() & !rbTravel4.isSelected() ||
           !rbSerie1.isSelected() & !rbSerie2.isSelected() || 
           !rbSerie3.isSelected() & !rbSerie4.isSelected() ||
           !rbsport1.isSelected() & !rbsport2.isSelected() || 
           !rbsport3.isSelected() & !rbsport4.isSelected() ||
           !rbHobbies1.isSelected() & !rbHobbies2.isSelected() || 
           !rbHobbies3.isSelected() & !rbHobbies4.isSelected() ||
           !rbFilm1.isSelected() & !rbFilm2.isSelected() || 
           !rbFilm3.isSelected() & !rbFilm4.isSelected()){
            Alert alert = new Alert(Alert.AlertType.WARNING, 
                    "Please fill all answers!", ButtonType.OK);
            alert.showAndWait();
        }else{
        sr.addReponses(listReponses);

    }
    
}
      @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
         ToggleGroup cultureGroup1 = new ToggleGroup(), cultureGroup2 = new ToggleGroup(), 
                    sportGroup1  = new ToggleGroup(),  sportGroup2  = new ToggleGroup(),
                    filmGroup1   = new ToggleGroup(),  filmGroup2   = new ToggleGroup(), 
                    serieGroup1  = new ToggleGroup(),  serieGroup2  = new ToggleGroup(),
                    tavelGroup1  = new ToggleGroup(),  tavelGroup2  = new ToggleGroup(), 
                    hobieGroup1   = new ToggleGroup(), hobieGroup2   = new ToggleGroup();
        
            rbCulture1.setToggleGroup(cultureGroup1);
            rbCulture2.setToggleGroup(cultureGroup1);
            rbCulture3.setToggleGroup(cultureGroup2);
            rbCulture4.setToggleGroup(cultureGroup2);

            rbsport1.setToggleGroup(sportGroup1);
            rbsport2.setToggleGroup(sportGroup1);
            rbsport3.setToggleGroup(sportGroup2);
            rbsport4.setToggleGroup(sportGroup2);

            rbFilm1.setToggleGroup(filmGroup1);
            rbFilm2.setToggleGroup(filmGroup1);
            rbFilm3.setToggleGroup(filmGroup2);
            rbFilm4.setToggleGroup(filmGroup2);

            rbSerie1.setToggleGroup(serieGroup1);
            rbSerie2.setToggleGroup(serieGroup1);
            rbSerie3.setToggleGroup(serieGroup2);
            rbSerie4.setToggleGroup(serieGroup2);

            rbHobbies1.setToggleGroup(hobieGroup1);
            rbHobbies2.setToggleGroup(hobieGroup1);
            rbHobbies3.setToggleGroup(hobieGroup2);
            rbHobbies4.setToggleGroup(hobieGroup2);

            rbTravel1.setToggleGroup(tavelGroup1);
            rbTravel2.setToggleGroup(tavelGroup1);
            rbTravel3.setToggleGroup(tavelGroup2);
            rbTravel4.setToggleGroup(tavelGroup2);
             // TODO
             ServicesQuiz sq;
        
            sq = new ServicesQuiz();
             List<Quiz> questionFilm = sq.getQuestionsByTheme("Film");
              List<Quiz> questionSport = sq.getQuestionsByTheme("Sport");
             List<Quiz> questionCulture = sq.getQuestionsByTheme("Culture");
             List<Quiz> questionSerie = sq.getQuestionsByTheme("Serie");
             List<Quiz> questionTravel = sq.getQuestionsByTheme("Travel");
             List<Quiz> questionHobies = sq.getQuestionsByTheme("Hobbies");
             
             cultureQ1.setText("Question 1:  "+ questionCulture.get(new Random().nextInt(questionCulture.size())).getQuestion());
             cultureQ2.setText("Question 2:  "+ questionCulture.get(new Random().nextInt(questionCulture.size())).getQuestion());

             filmQ1.setText("Question 1:  "+ questionFilm.get(new Random().nextInt(questionFilm.size())).getQuestion());
             filmQ2.setText("Question 2:  "+ questionFilm.get(new Random().nextInt(questionFilm.size())).getQuestion());

             hobbieQ1.setText("Question 1:  "+ questionHobies.get(new Random().nextInt(questionHobies.size())).getQuestion());
             hobbieQ2.setText("Question 2:  "+ questionHobies.get(new Random().nextInt(questionHobies.size())).getQuestion());
             
             serieQ1.setText("Question 1:  "+ questionSerie.get(new Random().nextInt(questionSerie.size())).getQuestion());
             serieQ2.setText("Question 2:  "+ questionSerie.get(new Random().nextInt(questionSerie.size())).getQuestion());
             
             travelQ1.setText("Question 1:  "+ questionTravel.get(new Random().nextInt(questionTravel.size())).getQuestion());
             travelQ2.setText("Question 2:  "+ questionTravel.get(new Random().nextInt(questionTravel.size())).getQuestion());
             
             sportQ1.setText("Question 1:  "+ questionSport.get(new Random().nextInt(questionSport.size())).getQuestion());
             sportQ2.setText("Question 2:  "+ questionSport.get(new Random().nextInt(questionSport.size())).getQuestion());
    
        } catch (SQLException ex) {
            Logger.getLogger(QuizzMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
     
}
