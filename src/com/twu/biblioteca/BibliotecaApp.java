package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library lib = new Library();
        Menu menu = new Menu(lib);
        BibliotecaApp app = new BibliotecaApp();
        app.welcomeMessage();
        menu.start();
    }

    void welcomeMessage() {
        System.out.println("Welcome to The Bangalore Public Library");
    }
 }
