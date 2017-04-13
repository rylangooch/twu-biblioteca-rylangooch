package com.twu.biblioteca;

/**
 * Created by rylangooch on 10/04/2017.
 */
public class Book {
    private String title;
    private String author;
    private String yearPublished;
    private boolean isCheckedOut;

    Book(String name, String writer, String year) {
        this.title = name;
        this.author = writer;
        this.yearPublished = year;
        isCheckedOut = true;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() { return author; }

    String getYearPublished() {
        return yearPublished;
    }

    boolean getCheckedOutStatus() {
        return isCheckedOut;
    }

    void switchCheckedOutStatus() {
        isCheckedOut ^= true;
    }
}
