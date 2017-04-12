package com.twu.biblioteca;

/**
 * Created by rylangooch on 10/04/2017.
 */
public class Book {
    String title;
    String author;
    String yearPublished;
    boolean isCheckedOut;

    Book(String name, String writer, String year) {
        title = name;
        author = writer;
        yearPublished = year;
        isCheckedOut = true;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

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
