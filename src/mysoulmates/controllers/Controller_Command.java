/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import mysoulmates.entities.Client;
import mysoulmates.services.service_Command;

/**
 *
 * @author Mohamed
 */
public class Controller_Command {
    
    public static void insertBillingInformation(Client c)
    {
        service_Command.insertBillingInformation(c);
    }

    
}
