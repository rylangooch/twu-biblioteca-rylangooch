package com.twu.biblioteca;

import sun.jvm.hotspot.HelloWorld;

import java.util.ArrayList;

public class BibliotecaApp {

    ArrayList<Book> bookList = new ArrayList<Book>();

    public BibliotecaApp() {
       bookList.add(new Book("Zero To One", "Peter Thiel", "2014"));
       bookList.add(new Book("Mastery", "Robert Greene", "2012"));
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.welcomeMessage();
        app.listBooks();
    }

    public void welcomeMessage() {
        System.out.println("Welcome to Biblioteca");
    }

    public void listBooks() {
        for(Book book : bookList) {
            System.out.println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearPublished());
        }
    }
 }
