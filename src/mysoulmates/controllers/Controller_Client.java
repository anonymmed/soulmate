/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import java.util.ArrayList;
import java.util.List;
import mysoulmates.entities.Client;
import mysoulmates.services.service_Client;

/**
 *
 * @author Mohamed
 */
public class Controller_Client {
 
    
    
        public static void likeClient(Client c1,Client c2)
        {
            service_Client.likeClient(c1, c2);
        }
        
            public static List<Client> DisplayLikes(Client c)
            {
                List<Client>l1 = new ArrayList<Client>();
                l1=service_Client.DisplayLikes(c);
                return l1;
            }
            
                public static void DeleteLike(Client c1,Client c2)
                {
                    service_Client.DeleteLike(c1, c2);
                }
}
