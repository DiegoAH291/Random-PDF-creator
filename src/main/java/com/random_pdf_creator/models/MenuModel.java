package com.random_pdf_creator.models;

import java.util.Scanner;

public class MenuModel {
    public MenuModel() {

    }

    public int showMenu() {
        try {
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);

            System.out.println(
                    "Write the number of the option you want to select: \n 1 - create PDF \n 2 - Exit application");

            String value = scanner.nextLine();

            if (value.isEmpty()) {
                System.out.println("Error: The field is empty");
                return 0;
            } else if (!value.matches("\\d+")) {
                System.out.println("Error: The value must be a number");
                return 0;
            } else {
                Integer option = Integer.parseInt(value);
                return option;
            }

        } catch (Exception error) {
            throw new Error(error.getMessage());
        }
    }
}
