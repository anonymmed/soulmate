/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.entities;

/**
 *
 * @author Aymen Yahmadi
 */
public class Reponse {
    
    private int id;
    private String Question;
    private String Reponse;
    private String Theme;
    private int idUser;

    public Reponse(String Question, String Reponse, String Theme, int idUser) {
        this.Question = Question;
        this.Reponse = Reponse;
        this.Theme = Theme;
        this.idUser = idUser;
    }

    
    
    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public String getReponse() {
        return Reponse;
    }

    public void setReponse(String Reponse) {
        this.Reponse = Reponse;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String Theme) {
        this.Theme = Theme;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    
    
    
    
    
    
}
