package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library lib = new Library();
        UserDatabase userDatabase = new UserDatabase();
        Menu menu = new Menu(lib, userDatabase);
        BibliotecaApp app = new BibliotecaApp();
        app.welcomeMessage();
        menu.start();
    }

    void welcomeMessage() {
        System.out.println("Welcome to The Bangalore Public Library");
    }
 }
