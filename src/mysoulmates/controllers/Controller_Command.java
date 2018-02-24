/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mysoulmates.entities.Command;
import mysoulmates.entities.User;
import mysoulmates.services.service_Command;

/**
 *
 * @author Mohamed
 */
public class Controller_Command {
    
    public static void insertBillingInformation(User c)
    {
        service_Command.insertBillingInformation(c);
    }
    public static ObservableList<Command> getCommandInfo()
    {
        ObservableList <Command> obl = FXCollections.observableArrayList();
        obl = service_Command.getCommandInfo();
        return obl;
    }

    
}
