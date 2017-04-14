package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by rylangooch on 13/04/2017.
 */
public class Menu {
    
    private boolean userIsQuitting = false;
    private Library lib;

    Menu(Library bookManager) {
        this.lib = bookManager;
    }

    Menu() {
        this.lib = new Library();
    }

    void start() {
        while(!userIsQuitting) {
            showMenu();
            String menuChoice = getUserInput();
            selectMenuChoice(menuChoice);
        }
    }

    void showMenu() {
        System.out.println("Main Menu - Choose a number:\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. Exit");
    }

    String getUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    void selectMenuChoice(String input) {
        if(input.equals("1")) {
            lib.listBooks();
        } else if(input.equals("2")) {
            checkoutBook();
        } else if(input.equals("3")) {
            bookReturn();
        } else if(input.equals("4")) {
            userExit();
        } else {
            System.out.println("Select a valid option!");
        }
    }

    private void checkoutBook() {
        System.out.println("Please provide the title of the book you'd like to checkout:");
        String bookTitle = getUserInput();
        lib.checkout(bookTitle);
    }

    private void bookReturn() {
        System.out.println("Please provide the title of the book you'd like to return:");
        String bookTitle = getUserInput();
        lib.returnBook(bookTitle);
    }

    private void userExit () {
        userIsQuitting = true;
        System.out.println("Thank you for visiting The Bangalore Public Library. Goodbye.");
    }
}
