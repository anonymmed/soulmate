/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysoulmates.entities.Reponse;
import mysoulmates.utils.Bd;

/**
 *
 * @author Aymen Yahmadi
 */
public class ServiceReponse {
    
    static Bd ds = Bd.getInstance();
    private PreparedStatement ps;

    public ServiceReponse() throws SQLException {
       
    }
    
    public void addReponses(List<Reponse> reponses) throws SQLException{
       
        for (int i=0;i<reponses.size();i++){
            String req = "insert into answer (question,answer,theme,id_user) values (?,?,?,?)";
           PreparedStatement ps = ds.getConnection().prepareStatement(req);
            ps.setString(1, reponses.get(i).getQuestion());        
            ps.setString(2, reponses.get(i).getReponse());  
            ps.setString(3, reponses.get(i).getTheme()); 
            ps.setInt(4, reponses.get(i).getIdUser()); 
            ps.executeUpdate();
        }
       
    }
    
    public void addScore(int idUser, String theme, int score){
         try {
             String req = "INSERT INTO user_score(iduser, theme, score) "
                     + "VALUES (?, ?, ?)";
             PreparedStatement ps = ds.getConnection().prepareStatement(req);
             ps.setInt   (1, idUser);
             ps.setString(2, theme);
             ps.setInt   (3, score);
             
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ServiceReponse.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public int countNoesForTheme(String theme){
        int noes = 0; 
        try {
             String req = "SELECT count(*) FROM reponse r WHERE r.theme = ? AND r.reponse = 'Non'";
             PreparedStatement ps = ds.getConnection().prepareStatement(req);
             ps.setString(1, theme);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 
                 noes = rs.getInt(1);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceReponse.class.getName()).log(Level.SEVERE, null, ex);
         }
        return noes;
    }
    
    public int countYeshForTheme(String theme){
        int yesh = 0; 
        try {
             String req = "SELECT count(*) FROM reponse r WHERE r.theme = ? AND r.reponse = 'Oui'";
             PreparedStatement ps = ds.getConnection().prepareStatement(req);
             ps.setString(1, theme);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 yesh = rs.getInt(1);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceReponse.class.getName()).log(Level.SEVERE, null, ex);
         }
        return yesh;
    }
    
}
