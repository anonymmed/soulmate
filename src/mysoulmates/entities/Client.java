/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.entities;

/**
 *
 * @author Mohamed
 */
public class Client {
    private String email;
    private Wishliste wishliste;
    private String type;
    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Client(String email) {
        this.email = email;
    }
   public static final int MAX = 20;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setWishListe(Wishliste wishliste)
    {
        this.wishliste=wishliste;
    }

    @Override
    public String toString() {
        return "Client{" + "email=" + email + '}';
    }
    
}
