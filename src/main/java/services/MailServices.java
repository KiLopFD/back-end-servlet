package services;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

/**
 * Handling all the mail function
 */
public class MailServices {
    // Email and password from which you want to send the email

    final private String senderMail = "tuyenquanghpkt@gmail.com";
    final private String password = "hzaewwzitvdmtrnk";
    private Properties prop;
    private Session session;
    public MailServices() {
        // Setting up mail server properties
        prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        // Creating a new session with an authenticator
        session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, password);
            }
        });
    }

    /**
     *
     * @param fullName
     * @param userName
     * @param email
     * @Function Send an email to a user email address
     */
   public void sendMailToUser(String fullName, String userName,String email){


       try {
           // Create a default MimeMessage object
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(senderMail)); // Use your actual sender's email address here
           message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email)); // 'email' is the recipient's email address
           message.setSubject("Account Creation Successful for " + userName);

            // Create the content of the email
           String content = "Dear " + fullName + ",\n\n" +
                   "Congratulations! Your account '" + userName + "' has been successfully created.\n\n" +
                   "You can now login and start using our services. If you have any questions or need assistance, feel free to contact our support team.\n\n" +
                   "Best Regards,\n" +
                   "TS Tech\n";

           message.setText(content);
           // Send message
           Transport.send(message);

           System.out.println("Sent message successfully....");

       } catch (MessagingException e) {
           e.printStackTrace();
       }
   }
    public void sendContact(String fullName, String email){

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderMail)); // Use your actual sender's email address here
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email)); // 'email' is the recipient's email address
            message.setSubject("Account Creation Successful for " + fullName);

            // Create the content of the email
            String content = "Dear " + fullName + ",\n\n" +
                    "Congratulations! Your Contact \n" +
                    "You can now sign up and start using our services. If you have any questions or need assistance, feel free to contact our support team.\n\n" +
                    "Best Regards,\n" +
                    "TS Tech\n";

            message.setText(content);
            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
