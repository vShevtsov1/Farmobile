package com.project.Farmobile.mail;

import com.project.Farmobile.users.data.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class emailController {
    @Value("${gmail.mail.username}")
    private String username;
    @Value("${gmail.mail.password}")
    private String password;
    @Value("${mail.activation.link}")
    private String activationLink;
    @Value("${mail.reset.link}")
    private String resetLink;
    private emailTemplates emailTemplates;
    private Properties prop;

    @Autowired
    public emailController() {
        emailTemplates = new emailTemplates();
        prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
    }

    public void SendConfirmationMail(String token, users user)
    {
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail())
            );
            message.setSubject("Посилання для активації профілю для "+user.getEmail());

            String link = emailTemplates.activationTemplate(activationLink+token);
            message.setContent(link, "text/html");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public void SendResetPasswordMail(String token, users user)
    {
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail())
            );
            message.setSubject("Зміна паролю для облікового запису "+user.getEmail());

            String link = emailTemplates.getTamplateResetPassword(resetLink+token);
            message.setContent(link, "text/html");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
