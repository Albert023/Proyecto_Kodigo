package com.banco.clases.clasesImpresion;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;
import com.banco.interfaces.Imprimir;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class imprimirPdf implements Imprimir {

  Image image;

  private void imagenPDF(String nombre) {
    String imFile = "src/main/java/com/banco/recursos/"+nombre+".png";
    //String imFile = "../recursos/BancoABANK.png";
    ImageData data = null;
    try {
      data = ImageDataFactory.create(imFile);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
    image = new Image(data);
    image.setPadding(20);
    image.setMarginTop(20);
    image.setWidth(200);
    image.setMaxHeight(250);
    image.setAutoScale(false);
    image.setTextAlignment(TextAlignment.LEFT);
    //document.add(image);
  }

  public void imprimir(Cuenta cuenta, Banco banco, double deposito, double total ,String transaccion) {
    String dest = "Recibo " + cuenta.getNombre() + ".pdf";
    PdfWriter writer;
    try {
      writer = new PdfWriter(dest);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    // Creating a PdfDocument
    PdfDocument pdfDoc = new PdfDocument(writer);
    // Adding a new page
    pdfDoc.addNewPage();
    // Creating a Document
    Document document = new Document(pdfDoc);
    // Add Content
    Paragraph paragraph1 = new Paragraph(banco.getNombreBanco());
    Paragraph paragraph2 = new Paragraph(banco.getDireccion());
    Paragraph paragraph3 = new Paragraph(transaccion);
    Paragraph paragraph4 = new Paragraph(cuenta.getNombre() + " | " + cuenta.getNumCuenta());
    Paragraph paragraph5 = new Paragraph("Monto "+transaccion+": ");
    Paragraph paragraph6 = new Paragraph(String.valueOf(deposito));
    Paragraph paragraph7 = new Paragraph("Monto en Cuenta: ");
    Paragraph paragraph8 = new Paragraph(String.valueOf(cuenta.getSaldo()));
    Paragraph paragraph9 = new Paragraph("Total: ");
    Paragraph paragraph10 = new Paragraph(String.valueOf(total));
    //
    paragraph1.setFontSize(14);
    paragraph1.setTextAlignment(TextAlignment.RIGHT);

    paragraph2.setTextAlignment(TextAlignment.CENTER);
    paragraph3.setTextAlignment(TextAlignment.CENTER);
    paragraph4.setTextAlignment(TextAlignment.CENTER);
    paragraph5.setTextAlignment(TextAlignment.LEFT);
    paragraph6.setTextAlignment(TextAlignment.RIGHT);
    paragraph7.setTextAlignment(TextAlignment.LEFT);
    paragraph8.setTextAlignment(TextAlignment.RIGHT);
    paragraph9.setTextAlignment(TextAlignment.LEFT);
    paragraph10.setTextAlignment(TextAlignment.RIGHT);

    paragraph1.setBorder(Border.NO_BORDER);
    paragraph1.setFirstLineIndent(20);
    paragraph1.setBold();
    //paragraph1.setMargin(10);
    paragraph1.setPaddingLeft(10);
    paragraph1.setPaddingRight(10);
    paragraph1.setWidth(1000);
    paragraph1.setHeight(100);
    //
     imagenPDF(banco.getNombreBanco());
    //añadiendo parrafos
    document.add(image);
    document.add(paragraph1);
    document.add(paragraph2);
    document.add(paragraph3);
    document.add(paragraph4);
    document.add(paragraph5);
    document.add(paragraph6);
    document.add(paragraph7);
    document.add(paragraph8);
    document.add(paragraph9);
    document.add(paragraph10);
    // Closing the document
    document.close();
  }
}
