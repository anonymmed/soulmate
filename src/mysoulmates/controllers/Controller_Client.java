/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import java.sql.ResultSet;
import mysoulmates.entities.User;
import mysoulmates.services.UserService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysoulmates.EncryptionHandling.EncryptionHandling;
import mysoulmates.services.service_Command;
import sun.font.StrikeCache;

/**
 *
 * @author Mohamed
 */
public class Controller_Client {
 
    
    
        public static void likeClient(User c1,User c2)
        {
            UserService.likeClient(c1, c2);
        }
        
            public static ResultSet DisplayLikes(User c) throws Exception
            {
                ResultSet rs;
                rs=UserService.DisplayLikes(c);
                return rs;
            }
            
                public static void DeleteLike(User c1,User c2)
                {
                    UserService.DeleteLike(c1, c2);
                }
                public static void createToken(String email)
                {
            try {
                String ip = InetAddress.getLocalHost().getHostAddress();
                String normalToken = ip+email;
                EncryptionHandling encryption = new EncryptionHandling(email);
                try {
                    String enctoken=encryption.encrypt(normalToken);
                    Controller_SendMail.sendMail(email, "token", enctoken);

                } catch (Exception ex) {
                    Logger.getLogger(Controller_Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (UnknownHostException ex) {
                System.out.println(ex.getMessage());
            }
                    
                }
            public static boolean checkToken(String token,String email)
            {
                String encryption = null;
                boolean check = false;
               EncryptionHandling Encryption = new EncryptionHandling(email);
            try {
                String ip = InetAddress.getLocalHost().getHostAddress();
                String normalToken = ip+email;

                encryption = Encryption.encrypt(normalToken);
                if (encryption.equals(token))
                {
                    check = true;
                }
            } catch (Exception ex) {
                Logger.getLogger(Controller_Client.class.getName()).log(Level.SEVERE, null, ex);
            }
                System.out.println(encryption);
            return check;
            }
            
            
            
            public static List<User> displayMatching(User u1,User u2)
            {
                List<User>usl  = new ArrayList<>();
               usl=UserService.displayMatching(u2, u2);
               return  usl;
            }

                
}
