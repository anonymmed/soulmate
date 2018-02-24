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
public class Quiz {
    
     private int id;
     private String question;
     private String theme;
     

    public Quiz(int id, String question) {
        this.id = id;
        this.question = question;
        
    }
     
     

    public Quiz(String question, String theme) {
        this.question = question;
        this.theme = theme;
        
    }
    
    public Quiz(int id,String question, String theme) {
        this.question = question;
        this.theme = theme;       
        this.id =id;
    }

    public Quiz() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    
     
     
     
}
