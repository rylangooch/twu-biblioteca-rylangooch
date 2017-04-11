package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    ArrayList<Book> bookList = new ArrayList<Book>();
    boolean userIsQuitting = false;

    public BibliotecaApp() {
       bookList.add(new Book("Zero To One", "Peter Thiel", "2014"));
       bookList.add(new Book("Mastery", "Robert Greene", "2012"));
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.welcomeMessage();
        app.start();
    }

    public void start() {
        while(userIsQuitting == false) {
            showMenu();
            String menuChoice = getMenuChoice();
            selectMenuChoice(menuChoice);
        }
    }

    public void welcomeMessage() {
        System.out.println("Welcome to The Bangalore Public Library");
    }

    public void showMenu() {
        System.out.println("Main Menu - Choose a number:\n1. List Books\n2. Exit");
    }

    public String getMenuChoice() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public void selectMenuChoice(String input) {
        if(input.equals("1")) {
            listBooks();
        } else if(input.equals("2")) {
            userIsQuitting = true;
            System.out.println("Thank you for visiting The Bangalore Public Library. Goodbye.");
        } else {
            System.out.println("Select a valid option!");
        }
    }

    public void listBooks() {
        for(Book book : bookList) {
            System.out.println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearPublished());
        }
    }
 }
