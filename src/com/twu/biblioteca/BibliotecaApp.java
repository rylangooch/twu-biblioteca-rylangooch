package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private boolean userIsQuitting = false;
    private Librarian lib;

    BibliotecaApp(Librarian bookManager) {
        lib = bookManager;
    }

    BibliotecaApp() {
        lib = new Librarian();
    }

    public static void main(String[] args) {
        Librarian lib = new Librarian();
        BibliotecaApp app = new BibliotecaApp(lib);
        app.welcomeMessage();
        app.start();
    }

    void start() {
        while(!userIsQuitting) {
            showMenu();
            String menuChoice = getUserInput();
            selectMenuChoice(menuChoice);
        }
    }

    void welcomeMessage() {
        System.out.println("Welcome to The Bangalore Public Library");
    }

    void showMenu() {
        System.out.println("Main Menu - Choose a number:\n1. List Books\n2. Checkout Book\n3. Exit");
    }

    String getUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    void selectMenuChoice(String input) {
        if(input.equals("1")) {
            lib.listBooks();
        } else if(input.equals("2")) {
            System.out.println("Please provide the title of the book you'd like to checkout:");
            String bookTitle = getUserInput();
            lib.checkout(bookTitle);
        } else if(input.equals("3")) {
            userIsQuitting = true;
            System.out.println("Thank you for visiting The Bangalore Public Library. Goodbye.");
        } else {
            System.out.println("Select a valid option!");
        }
    }
 }
