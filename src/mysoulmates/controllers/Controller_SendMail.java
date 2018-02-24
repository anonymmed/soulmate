/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;
import java.util.Date;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
  



/**
 *
 * @author Mohamed
 */
public class Controller_SendMail
{
    public static void sendMail(String to,String subject,String message) throws MessagingException
    {
  String host="smtp.gmail.com";  
  final String user="mohamed.abdelhafidh@esprit.tn";//change accordingly  
  final String password="P@ssNewlife113!";//change accordingly  
        
  
   //Get the session object  
    Properties props = new Properties();

    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.from",user);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");  

    props.setProperty("mail.debug", "true");

    Session session = Session.getInstance(props, null);
    MimeMessage msg = new MimeMessage(session);

    msg.setRecipients(Message.RecipientType.TO, to);
    msg.setSubject(subject);
    msg.setSentDate(new Date());
    msg.setText(message);

    Transport transport = session.getTransport("smtp");

    transport.connect(user, password);
    transport.sendMessage(msg, msg.getAllRecipients());
    transport.close();
  
   

    }
}
