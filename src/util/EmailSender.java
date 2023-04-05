package util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    private String fromEmail;
    private String password;
    private String toEmail;
    private Properties properties;

    public EmailSender(String fromEmail, String password, String toEmail) {
        this.fromEmail = fromEmail;
        this.password = password;
        this.toEmail = toEmail;

        // Set SMTP server properties
        properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
    }

    public void sendEmail(String subject, String messageBody) {
        // Get session object with authentication
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, password);
                    }
                });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From: header field of the header
            message.setFrom(new InternetAddress(fromEmail));

            // Set To: header field of the header
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));

            // Set Subject: header field
            message.setSubject(subject);

            // Set the actual message
            message.setText(messageBody);

            // Send message
            Transport.send(message);

            System.out.println("Email sent successfully...");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
