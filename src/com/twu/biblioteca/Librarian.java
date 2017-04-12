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
                removeBook(bookTitle);
            } else {
                System.out.println("That book is not available.");
            }
        }

    boolean checkForBook(String title) {
        for(Book book : bookList) {
            if(book.getTitle().equals(title) && book.getCheckedOutStatus()) {
                return true;
            }
        }
        return false;
    }

    void removeBook(String bookName) {
        for(Book book : bookList) {
            if(book.getTitle().equals(bookName)) {
                book.switchCheckedOutStatus();
                System.out.println("Thank you! Enjoy the book");
                break;
            }
        }
    }

    void returnBook(String bookTitle) {
        if(checkForReturn(bookTitle)) {
            addBook(bookTitle);
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    boolean checkForReturn(String title) {
        for(Book book : bookList) {
            if(book.getTitle().equals(title) && !book.getCheckedOutStatus()) {
                return true;
            }
        }
        return false;
    }

    void addBook(String bookName) {
        for(Book book : bookList) {
            if(book.getTitle().equals(bookName) && !book.getCheckedOutStatus()) {
                book.switchCheckedOutStatus();
                System.out.println("Thank you for returning the book.");
                break;
            }
        }
    }

}
