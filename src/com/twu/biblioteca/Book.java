package com.twu.biblioteca;

/**
 * Created by rylangooch on 10/04/2017.
 */
public class Book extends LibraryItem {
    private String author;

    Book(String title, String author, String year) {
        super(title, year);
        this.author = author;
    }

    String printDetails() {
        return getTitle() + " | " + getAuthor() + " | " + getYear();
    }

    String getAuthor() { return author; }
}
