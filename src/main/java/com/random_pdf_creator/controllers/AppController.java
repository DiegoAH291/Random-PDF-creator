package com.random_pdf_creator.controllers;

import com.random_pdf_creator.App;
import com.random_pdf_creator.models.PdfModel;

public class AppController {

    public AppController() {
    };

    public static void menuController(int option) {
        switch (option) {
            case 1:
                PdfModel.creator();
                break;
            case 2:
                System.exit(0);
                break;
            case 0:
                App.main(null);
                break;
            default:
                System.out.println("Error: Wrong option");
                App.main(null);

        }
    }
}
