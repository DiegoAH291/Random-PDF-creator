package com.random_pdf_creator.models;

import java.io.File;
import java.util.Random;
import java.util.Scanner;
import com.random_pdf_creator.App;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public class PdfModel {

    public PdfModel() {

    }

    // Generate random text
    public static String generateTextPDF() {
        byte leftLimit = 97;
        byte rightLimit = 122;
        short textLength = 2000;

        Random random = new Random();
        StringBuilder buffer = new StringBuilder(textLength);

        for (short i = 0; i < textLength; i++) {
            int randomLimited = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimited);
        }

        String result = buffer.toString();

        return result;
    }

    // Config information PDF
    public static void configPDF(PDDocument document, PDPage page) {
        String randomText = PdfModel.generateTextPDF();

        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.newLineAtOffset(25, 700);
            contentStream.setLeading(14.5f);
            contentStream.showText(randomText);
            contentStream.endText();

            contentStream.close();
        } catch (Exception error) {
            error.printStackTrace();
            throw new RuntimeException("Error creating PDF: " + error.getMessage());
        }
    }

    // Create PDF
    public static void creator() {

        try {
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);

            System.out.println("Write a title for your file");
            String title = scanner.nextLine();

            if (title.isEmpty()) {
                System.out.println("Error: the field is empty");
                creator();
            } else {

                File folder = new File("files");
                PDDocument document = new PDDocument();
                PDPage page = new PDPage();
                document.addPage(page);

                if (!folder.exists()) {
                    folder.mkdirs();
                }

                String filePath = folder.getAbsolutePath().concat("/").concat(title).concat(".pdf");

                PdfModel.configPDF(document, page);

                document.save(filePath);
                document.close();

                System.out.println("PDF created successfully");

                App.main(null);
            }

        } catch (Exception error) {
            error.printStackTrace();
            throw new RuntimeException("Error creating PDF: " + error.getMessage());
        }
    }
}
