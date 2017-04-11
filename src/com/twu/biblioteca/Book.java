package com.twu.biblioteca;

/**
 * Created by rylangooch on 10/04/2017.
 */
public class Book {
    String title;
    String author;
    String yearPublished;
    boolean isCheckedOut;

    public Book(String name, String writer, String year) {
        title = name;
        author = writer;
        yearPublished = year;
        isCheckedOut = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public boolean getCheckedOutStatus() {
        return isCheckedOut;
    }

    public void switchCheckedOutStatus() {
        isCheckedOut ^= true;
    }
}
