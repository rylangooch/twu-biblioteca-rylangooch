package com.twu.biblioteca;

/**
 * Created by rylangooch on 10/04/2017.
 */
public class Book extends LibraryItem {
    private String author;

    public Book(String t, String a, String y) {
        super(t, y);
        this.author = a;
    }

    public String printDetails() {
        return getTitle() + " | " + getAuthor() + " | " + getYear();
    }

    public String getAuthor() { return author; }
}
