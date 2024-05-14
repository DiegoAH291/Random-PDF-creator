package com.random_pdf_creator.models;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PdfModel {

    public PdfModel() {

    }

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

                // Generate random text

                byte leftLimit = 97;
                byte rightLimit = 122;
                short stringLength = 2000;

                Random random = new Random();
                StringBuilder buffer = new StringBuilder(stringLength);

                for (int i = 0; i < stringLength; i++) {
                    int randomLimited = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
                    buffer.append((char) randomLimited);
                }

                String randomInformation = buffer.toString();

                try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                    contentStream.beginText();
                    contentStream.setFont(PDType1Font.HELVETICA, 12);
                    contentStream.newLineAtOffset(100, 700);
                    contentStream.showText(randomInformation);
                    contentStream.endText();
                }

                document.save(filePath);
                document.close();
                System.out.println("PDF created successfully at: " + filePath);
            }

        } catch (IOException error) {
            error.printStackTrace();
            throw new RuntimeException("Error creating PDF: " + error.getMessage());
        }
    }
}
