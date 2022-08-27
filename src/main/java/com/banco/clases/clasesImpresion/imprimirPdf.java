package com.banco.clases.clasesImpresion;

import com.banco.interfaces.generarPDF;

//import java.io.File;
import java.io.FileNotFoundException;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;


public class imprimirPdf implements generarPDF {

    public void generarPDF() {
        String dest = "example.pdf";
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
        String content = "Lorem ipsum dolor sit amet...";
        Paragraph paragraph = new Paragraph(content);
        paragraph.setFontSize(14);
        paragraph.setTextAlignment(TextAlignment.CENTER);
        paragraph.setBorder(Border.NO_BORDER);
        paragraph.setFirstLineIndent(20);
        paragraph.setItalic();
        paragraph.setBold();
        paragraph.setBackgroundColor(new DeviceRgb(245, 245, 245));
        paragraph.setMargin(10);
        paragraph.setPaddingLeft(10);
        paragraph.setPaddingRight(10);
        paragraph.setWidth(1000);
        paragraph.setHeight(100);
        document.add(paragraph);
        // Adding a list
        List list = new List();
        list.add("Java");
        list.add("Go");
        list.add("React");
        list.add("Apache Kafka");
        list.add("Jenkins");
        list.add("Elastic Search");
        document.add(list);
        // Closing the document
        document.close();
        System.out.println("PDF Created");

    }

}
