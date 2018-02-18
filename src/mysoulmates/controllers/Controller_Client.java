/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import java.util.ArrayList;
import java.util.List;
import mysoulmates.entities.User;
import mysoulmates.services.UserService;

/**
 *
 * @author Mohamed
 */
public class Controller_Client {
 
    
    
        public static void likeClient(User c1,User c2)
        {
            UserService.likeClient(c1, c2);
        }
        
            public static List<User> DisplayLikes(User c)
            {
                List<User>l1 = new ArrayList<User>();
                l1=UserService.DisplayLikes(c);
                return l1;
            }
            
                public static void DeleteLike(User c1,User c2)
                {
                    UserService.DeleteLike(c1, c2);
                }
}
