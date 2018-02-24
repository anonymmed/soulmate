/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.entities;

import java.sql.Date;
import javafx.scene.control.Button;

/**
 *
 * @author ss
 */
public class Event {

    private int id;
    private String nom;
    private String description;
    private String location;
    private Date datedebut;
    private Date datefin;
    private int nbreParticipants;
    private int checked;
    private String email;
    private String image;

    public Event(int id, String nom, String description, String location, Date datedebut, Date datefin, int nbreParticipants, int checked, String email, String image) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.location = location;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nbreParticipants = nbreParticipants;
        this.checked = checked;
        this.email = email;
        this.image = image;
    }

    public Event(String nom, String description, Date datedebut, Date datefin, int nbreParticipants, int checked, String email, String image) {
        this.nom = nom;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nbreParticipants = nbreParticipants;
        this.checked = checked;
        this.email = email;
        this.image = image;
    }

    public Event(String nom, String description, String location, Date datedebut, Date datefin, String image) {
        this.nom = nom;
        this.description = description;
        this.location = location;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public int getNbreParticipants() {
        return nbreParticipants;
    }

    public void setNbreParticipants(int nbreParticipants) {
        this.nbreParticipants = nbreParticipants;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    

}
