/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Manolo
 */
public class Mailer {
    
    public Mailer(){}
        
    public void enviarMail(String emailFrom, String emailTo, String asunto,String mensaje){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Constantes.EMAIL_SMTP, Constantes.PASSWORD_SMTP);
          }
        }); 
        
        try {
            // Define message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailFrom));
            message.setSubject(asunto);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(emailTo));
            message.setText(mensaje);
            // Envia el mensaje
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(Mailer.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
