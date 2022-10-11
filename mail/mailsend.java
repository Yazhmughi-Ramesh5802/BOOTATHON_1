package mail;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;  
import javax.mail.internet.*;  
  
public class mailsend {  
    public static boolean mail(String email, String otp)
    {
        String to = email;
        String from = "aristovince75@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("aristovince75@gmail.com", "jlbavqikwslfdiep");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("This message is to verify the login credintials in Database Management System");
            message.setText("The OTP is " + otp);
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
    }
    public static boolean sendpdf(String email, String path)
    {
        String to = email;
        String from = "aristovince75@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("aristovince75@gmail.com", "jlbavqikwslfdiep");
            }
        });
        try
        {
            MimeMessage message = new MimeMessage(session);    
            message.setFrom(new InternetAddress(from));     
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
            message.setSubject("Message Aleart");       
            BodyPart messageBodyPart1 = new MimeBodyPart();     
            messageBodyPart1.setText("This is message body");                
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();       
            DataSource source = new FileDataSource(path);    
            messageBodyPart2.setDataHandler(new DataHandler(source));    
            messageBodyPart2.setFileName(path);             
            Multipart multipart = new MimeMultipart();    
            multipart.addBodyPart(messageBodyPart1);     
            multipart.addBodyPart(messageBodyPart2);         
            message.setContent(multipart );            
            Transport.send(message);    
            return true; 
        }
        catch (MessagingException ex) 
        {
            ex.printStackTrace();
            return false;
        }  
    }
} 