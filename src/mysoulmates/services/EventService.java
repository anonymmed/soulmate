/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import mysoulmates.entities.Event;
import mysoulmates.utils.Bd;

/**
 *
 * @author ss
 */
public class EventService {

    static Bd ds = Bd.getInstance();
    private PreparedStatement ps;
    
    public void AjouterEvent(Event v, String mail) throws SQLException {
        String req = "INSERT INTO `event`(`name`, `description`, `location`, `startDate`, `endDate`, `participants`, `email`,`checked`,`image`) VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement prs = ds.getConnection().prepareStatement(req);
        prs.setString(1, v.getNom());
        prs.setString(2, v.getDescription());
        prs.setString(3, v.getLocation());
        prs.setDate(4, v.getDatedebut());
        prs.setDate(5, v.getDatefin());
        prs.setInt(6, 1);
        prs.setString(7, mail);
        prs.setInt(8, 0);
        prs.setString(9, v.getImage());

        prs.executeUpdate();
    }
       public static  ResultSet afficherEvent()  {
        ResultSet result = null;
        String req = "SELECT name,location,description,startDate,endDate,participants,image,id FROM event where checked =1 and endDate > now()";
        try {
         PreparedStatement prs = ds.getConnection().prepareStatement(req);

            result = prs.executeQuery(req);

        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public ObservableList afficher1Event() throws SQLException {
        String req = "select * from event";
        ObservableList<Event> listevent = FXCollections.observableArrayList();
    PreparedStatement ste = ds.getConnection().prepareStatement(req);
        ResultSet resultat = ste.executeQuery(req);
        Button b1=new Button("inscrire");

        while (resultat.next()) {
          //  listevent.add(new Event(resultat.getString("name"), resultat.getString("location"), resultat.getString("description"), resultat.getDate("startDate"), resultat.getDate("endDate"), resultat.getInt("participants")));

        }
        return listevent;
    }

}
