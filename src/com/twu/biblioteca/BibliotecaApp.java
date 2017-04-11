package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    ArrayList<Book> bookList = new ArrayList<Book>();

    public BibliotecaApp() {
       bookList.add(new Book("Zero To One", "Peter Thiel", "2014"));
       bookList.add(new Book("Mastery", "Robert Greene", "2012"));
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.welcomeMessage();
        app.showMenu();
        String menuChoice = app.getMenuChoice();
        app.selectMenuChoice(menuChoice);
    }

    public void welcomeMessage() {
        System.out.println("Welcome to Biblioteca");
    }

    public void showMenu() {
        System.out.println("Main Menu - Choose a number:\n1. List Books");
    }

    public String getMenuChoice() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public void selectMenuChoice(String input) {
        if(input.equals("1")) {
            listBooks();
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
