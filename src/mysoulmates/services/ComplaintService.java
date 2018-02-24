/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mysoulmates.entities.Complaint;
import mysoulmates.utils.Bd;

/**
 *
 * @author ss
 */
public class ComplaintService {

    static Bd ds = Bd.getInstance();
    private PreparedStatement ps;

    public boolean addComplaint(Complaint c) {
        String req = "insert into complaint (email,complaint_date,subject,content,state) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);

            ps.setString(1, c.getEmail());
            ps.setDate(2, c.getComplaint_date());
            ps.setString(3, c.getSubject());
            ps.setString(4, c.getContent());
            ps.setInt(5, c.getId());

            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }

    //complaint non traité:state0:non traite
    public ObservableList<Complaint> PendingComplaint() throws ParseException {

        ObservableList<Complaint> list = FXCollections.observableArrayList();
        ResultSet rs;
        String req = "SELECT * FROM complaint WHERE state=0 ";

        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);
            rs = ps.executeQuery(req);

            while (rs.next()) {
                Complaint c
                        = new Complaint(rs.getInt("id"), rs.getString("email"), rs.getDate("complaint_date"), rs.getString("subject"), rs.getString("content"));

                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComplaintService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    //traiter complaint
    public ObservableList<Complaint> accptedComplaint() throws ParseException {

        ObservableList<Complaint> list = FXCollections.observableArrayList();
        ResultSet rs;
        String req = "SELECT * FROM complaint WHERE state=1 ";

        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);
            rs = ps.executeQuery(req);

            while (rs.next()) {
                Complaint c
                        = new Complaint(rs.getInt("id"), rs.getString("email"), rs.getDate("complaint_date"), rs.getString("subject"), rs.getString("content"));

                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComplaintService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public void accept(int id) {
        String req = "UPDATE complaint SET state= 1 WHERE id=" + String.valueOf(id);

        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);

            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(int id) {
        String req = "delete from complaint where id =?";
        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit(Complaint c) {
        String req = "UPDATE complaint SET email='" + c.getEmail() + "',subject='" + c.getSubject() + "',content='" + c.getContent() + "',complaint_date='" + String.valueOf(c.getComplaint_date()) + "'WHERE id=" + c.getId();

        try {
            PreparedStatement ps = ds.getConnection().prepareStatement(req);

            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
