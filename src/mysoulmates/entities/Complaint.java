/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.entities;

import java.sql.Date;

/**
 *
 * @author ss
 */

    public class Complaint {
    
    private int id;
    private String email;
    private java.sql.Date complaint_date;
    private int state;
    private String subject;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getComplaint_date() {
        return complaint_date;
    }

    public void setComplaint_date(Date complaint_date) {
        this.complaint_date = complaint_date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    

    public Complaint(String email, Date complaint_date, String subject, String content) {
        this.email = email;
        this.complaint_date = complaint_date;
        this.subject = subject;
        this.content = content;
    }

    public Complaint(int id, String email, Date complaint_date, String subject, String content) {
        this.id = id;
        this.email = email;
        this.subject = subject;
        this.content = content;
        this.complaint_date = complaint_date;
    }
    
    }
