package com.random_pdf_creator;

import com.random_pdf_creator.controllers.AppController;
import com.random_pdf_creator.models.MenuModel;

public class App {
    public static void main(String[] args) {
        MenuModel menu = new MenuModel();
        int option = menu.showMenu();

        AppController.menuController(option);

    }
}
