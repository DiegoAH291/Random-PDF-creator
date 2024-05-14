package com.random_pdf_creator.models;

import java.util.Scanner;

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
                System.out.println("PDF created successfully");
            }

        } catch (Exception error) {
            throw new Error(error.getMessage());
        }
    }
}
