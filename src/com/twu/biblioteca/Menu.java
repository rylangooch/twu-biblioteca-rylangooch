package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by rylangooch on 13/04/2017.
 */
public class Menu {
    
    private boolean userIsQuitting = false;
    private Library lib;
    private User currentUser = null;
    private UserDatabase userDatabase;

    public Menu(Library bookManager, UserDatabase database) {
        this.lib = bookManager;
        this.userDatabase = database;
    }

    public Menu() {
        this.lib = new Library();
        this.userDatabase = new UserDatabase();
    }

    public void start() {
        while(!userIsQuitting) {
            showMenu();
            String menuChoice = getUserInput();
            selectMenuChoice(menuChoice);
        }
    }

    public void showMenu() {
        System.out.println("Main Menu - Choose a number:\n" +
                "1. Login\n" +
                "2. List Books\n" +
                "3. Checkout Book\n" +
                "4. Return Book\n" +
                "5. List Movies\n" +
                "6. Checkout Movie\n" +
                "7. Return Movie\n" +
                "8. Show User Information\n" +
                "9. Exit");
    }

    public String getUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void selectMenuChoice(String input) {
        if(input.equals("1")) {
            login();
        } else if(input.equals("2")) {
            lib.listBooks();
        } else if(input.equals("3")) {
            startCheckout();
        } else if(input.equals("4")) {
            startReturn();
        } else if(input.equals("5")) {
            lib.listMovies();
        } else if(input.equals("6")) {
            checkoutMovie();
        } else if(input.equals("7")) {
            movieReturn();
        } else if(input.equals("8")) {
            getUserDetails();
        }else if(input.equals("9")) {
            userExit();
        } else {
            System.out.println("Select a valid option!");
        }
    }

    private void startCheckout() {
        if(checkForUser()) {
            checkoutBook();
        } else {
            System.out.println("You must login to checkout an item.");
        }
    }

    private void startReturn() {
        if(checkForUser()) {
            returnBook();
        } else {
            System.out.println("You must login to return an item.");
        }
    }

    private void login() {
        System.out.println("What is your Library Number (XXX-XXXX):");
        String userLibraryNumber = getUserInput();
        System.out.println("What is your password:");
        String userPassword = getUserInput();
        checkUserCredentials(userLibraryNumber, userPassword);
    }

    private void checkUserCredentials(String number, String pass) {
        currentUser = userDatabase.checkUserDetails(number, pass);
        if(checkForUser()) {
            System.out.println("Please provide valid Library Number and Password");
        } else {
            System.out.println("Login successful");
        }
    }

    private void checkoutBook() {
        System.out.println("Please provide the title of the book you'd like to checkout:");
        String bookTitle = getUserInput();
        lib.checkout(bookTitle);
    }

    private void returnBook() {
        System.out.println("Please provide the title of the book you'd like to return:");
        String bookTitle = getUserInput();
        lib.returnItem(bookTitle);
    }

    private void checkoutMovie() {
        System.out.println("Please provide the name of the movie you'd like to checkout:");
        String movieName = getUserInput();
        lib.checkout(movieName);
    }

    private void movieReturn() {
        System.out.println("Please provide the name of the movie you'd like to return:");
        String movieName = getUserInput();
        lib.returnItem(movieName);
    }

    private void getUserDetails() {
        if(checkForUser()) {
            System.out.println(currentUser.getInformation());
        } else {
            System.out.println("Please login.");
        }
    }

    private void userExit () {
        userIsQuitting = true;
        System.out.println("Thank you for visiting The Bangalore Public Library. Goodbye.");
    }

    private boolean checkForUser() {
        return currentUser != null;
    }
}
