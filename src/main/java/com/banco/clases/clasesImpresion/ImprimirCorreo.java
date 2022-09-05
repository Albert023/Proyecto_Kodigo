package com.banco.clases.clasesImpresion;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.interfaces.Imprimir;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class ImprimirCorreo implements Imprimir {

  public void imprimir(Cuenta cuenta, Banco banco, Transacciones transaccion) {

    Imprimir generarPDF = new imprimirPdf();
    generarPDF.imprimir(cuenta, banco, transaccion);

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session sesion = Session.getDefaultInstance(props);

    String correoRemitente = "proyecto.kodigo.1@gmail.com";
    String contrasenia = "jlqbwoutyqejyhzu";
    String destinatario = cuenta.getEmail();
    String asunto = "Recibo";
    String mensaje = "recibo";
    MimeMessage mail = new MimeMessage(sesion);
    try {
      mail.setFrom(new InternetAddress(correoRemitente));
      mail.addRecipients(
          Message.RecipientType.TO, String.valueOf(new InternetAddress(destinatario)));
      mail.setSubject(asunto);
      // mail.setText(mensaje);

      MimeBodyPart mbp1 = new MimeBodyPart();
      mbp1.setText(mensaje);
      MimeBodyPart mbp2 = new MimeBodyPart();
      mbp2.attachFile("Recibo " + cuenta.getNombre() + ".pdf");

      Multipart mp = new MimeMultipart();
      mp.addBodyPart(mbp1);
      mp.addBodyPart(mbp2);

      mail.setContent(mp);
      mail.setSentDate(new Date());

      Transport transport = sesion.getTransport("smtp");
      transport.connect(correoRemitente, contrasenia);
      transport.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
      transport.close();

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
