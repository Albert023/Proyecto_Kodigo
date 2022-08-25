package com.banco;

import lombok.AllArgsConstructor;
import lombok.Generated;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Recibo {

    double saldo;

    public Recibo(double saldo) {
        this.saldo = saldo;
    }

    public void generarRecibo(Cuenta cuenta){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session sesion = Session.getDefaultInstance(props);

    String correoRemitente = "proyecto.kodigo.1@gmail.com";
        String contrasenia = "jdwmpifsthrmhleb";
        String destinatario = cuenta.email;
        String asunto = "Recibo";
        String mensaje = "recibo";
        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress(correoRemitente));
            mail.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(destinatario)));
            mail.setSubject(asunto);
            mail.setText(mensaje);

            Transport transport = sesion.getTransport("smtp");
            transport.connect(correoRemitente,contrasenia);
            transport.sendMessage(mail,mail.getRecipients(Message.RecipientType.TO));
            transport.close();

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }

}