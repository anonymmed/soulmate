/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Date;
import javax.activation.*;  
import java.util.*;

import com.sun.mail.smtp.*;
import javax.mail.Message.RecipientType;


/**
 *
 * @author Mohamed
 */
public class Controller_SendMail
{
    public static void sendMail()
    {
      String to = "mohamed.abdelhafidh@esprit.tn";//change accordingly  
      String from = "bakbek123@gmail.com";//change accordingly  
      String host = "localhost";//or IP address  
  
     //Get the session object  
      Properties properties = System.getProperties();  
      properties.setProperty("smtp.gmail.com", host);  
      Session session = Session.getDefaultInstance(properties);  
  
     //compose the message  
      try{  
         MimeMessage message = new MimeMessage(session);  
         message.setFrom(new InternetAddress(from));  
         message.addRecipient(RecipientType.TO,new InternetAddress(to));  
         message.setSubject("Ping");  
         message.setText("Hello, this is example of sending email  ");  
  
         // Send message  
         Transport.send(message);  
         System.out.println("message sent successfully....");  
  
      }catch (MessagingException mex) {}  

    }
}
