package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private ArrayList<Book> bookList = new ArrayList<Book>();
    private boolean userIsQuitting = false;

    public BibliotecaApp() {
       bookList.add(new Book("Zero To One", "Peter Thiel", "2014"));
       bookList.add(new Book("Mastery", "Robert Greene", "2012"));
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.welcomeMessage();
        app.start();
    }

    private void start() {
        while(userIsQuitting == false) {
            showMenu();
            String menuChoice = getUserInput();
            selectMenuChoice(menuChoice);
        }
    }

    public void welcomeMessage() {
        System.out.println("Welcome to The Bangalore Public Library");
    }

    public void showMenu() {
        System.out.println("Main Menu - Choose a number:\n1. List Books\n2. Checkout Book\n3. Exit");
    }

    public String getUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void selectMenuChoice(String input) {
        if(input.equals("1")) {
            listBooks();
        } else if(input.equals("2")) {
            checkout();
        } else if(input.equals("3")) {
            userIsQuitting = true;
            System.out.println("Thank you for visiting The Bangalore Public Library. Goodbye.");
        } else {
            System.out.println("Select a valid option!");
        }
    }

    public void checkout() {
        System.out.println("Please provide the title of the book you'd like to checkout:");
        String bookTitle = getUserInput();
        removeBook(bookTitle);
    }

    private void removeBook(String bookTitle) {
        for(Book book : bookList) {
            if(book.getTitle().equals(bookTitle)) {
                book.switchCheckedOutStatus();
                System.out.println("Checkout successful - enjoy!");
                break;
            }
        }
    }

    public void listBooks() {
        for(Book book : bookList) {
            if(book.getCheckedOutStatus()) {
                System.out.println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearPublished());
            }
        }
    }
 }
