package org.invisibleFriend;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import io.github.cdimascio.dotenv.Dotenv;
import org.invisibleFriend.users.Person;
import org.invisibleFriend.users.PersonCollector;

public class EmailSender {

    // Objetos
    Dotenv dotenv;

    // Tipos genericos
    private Person concreteUser;
    private String sender;  // tu correo Gmail
    private String key;     // contraseña de aplicación (se genera en google, está asociada a la cuenta sender"

    public EmailSender() {
        dotenv = Dotenv.load();
        sender = dotenv.get("SENDER_EMAIL");
        key = dotenv.get("SENDER_EMAIL_KEY");
    }

    public EmailSender(Person user) {
        this();
        this.concreteUser = user;
    }

    public EmailSender(PersonCollector people) {
        this();
    }

    public void sendEmail(Person personEmailed) {

        // Propiedades del servidor SMTP de Gmail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Crear sesión
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, key);
            }
        });

        try {
            // Crear el mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(personEmailed.getPersonEmail()));
            message.setSubject("Amigo invisible");
            message.setText("Hola " + personEmailed.getPersonName() + ", debes hacer un regalo a " + personEmailed.getNextGiftPerson().getPersonName());
            // Para mandar html setContent() en vez de setText().

            // Enviar
            Transport.send(message);
            System.out.println("Correo enviado correctamente.");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }

    }

    //========== Getter and setter ==========
    public Person getConcreteUser() {
        return concreteUser;
    }

    public void setConcreteUser(Person concreteUser) {
        this.concreteUser = concreteUser;
    }

}
