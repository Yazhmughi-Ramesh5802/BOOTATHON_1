package mail;
import java.util.Properties;  
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
}  