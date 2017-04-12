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
            if(checkForBook(bookTitle)) {
                for(Book book : bookList) {
                    book.switchCheckedOutStatus();
                    System.out.println("Thank you! Enjoy the book");
                    break;
                }
            } else {
                System.out.println("That book is not available.");
            }
        }

    boolean checkForBook(String title) {
        for(Book book : bookList) {
            if(book.getTitle().equals(title)) { return true; }
        }
        return false;
    }
}
