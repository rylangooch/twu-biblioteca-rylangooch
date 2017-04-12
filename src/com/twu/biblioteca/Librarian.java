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
            if(isProcessable(bookTitle, true)) {
                processBook(bookTitle, true);
                System.out.println("Thank you! Enjoy the book");
            } else {
                System.out.println("That book is not available.");
            }
        }

    void returnBook(String bookTitle) {
        if(isProcessable(bookTitle, false)) {
            processBook(bookTitle, false);
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    private boolean isProcessable(String title, boolean isForCheckout) {
        for(Book book : bookList) {
            if(book.getTitle().equals(title) && (book.getCheckedOutStatus() == isForCheckout)) {
                return true;
            }
        }
        return false;
    }

    private void processBook(String bookName, boolean isForCheckout) {
        for(Book book : bookList) {
            if(book.getTitle().equals(bookName) && (book.getCheckedOutStatus() == isForCheckout)) {
                book.switchCheckedOutStatus();
                break;
            }
        }
    }
}
