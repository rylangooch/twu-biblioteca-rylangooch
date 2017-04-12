package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by rylangooch on 12/04/2017.
 */

public class Librarian {

    private ArrayList<Book> bookList = new ArrayList<Book>();

    Librarian() {
        bookList.add(new Book("Zero To One", "Peter Thiel", "2014"));
        bookList.add(new Book("Mastery", "Robert Greene", "2012"));
    }

    void listBooks() {
        for(Book book : bookList) {
            if(book.getCheckedOutStatus()) {
                System.out.println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearPublished());
            }
        }
    }

    void checkout(String bookTitle) {
        for(Book book : bookList) {
            if(book.getTitle().equals(bookTitle)) {
                book.switchCheckedOutStatus();
                System.out.println("Checkout successful - enjoy!");
                break;
            }
        }
    }
}
