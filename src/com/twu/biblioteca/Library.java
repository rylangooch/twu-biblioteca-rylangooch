package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by rylangooch on 12/04/2017.
 */

public class Library {

    private ArrayList<LibraryItem> itemList = new ArrayList<LibraryItem>();

    Library() {
        itemList.add(new Book("Zero To One", "Peter Thiel", "2014"));
        itemList.add(new Book("Mastery", "Robert Greene", "2012"));
        itemList.add(new Movie("Django Unchained", "Quentin Tarantino", "2012", "7"));
        itemList.add(new Movie("Manchester By The Sea", "Kenneth Lonergan", "2016", "8"));
    }

    void listBooks() {
        for(LibraryItem item : itemList) {
            if(item.getAvailability() && item instanceof Book) {
                System.out.println(item.printDetails());
            }
        }
    }

    void listMovies() {
        for(LibraryItem item : itemList) {
            if(item.getAvailability() && item instanceof Movie) {
                System.out.println(item.printDetails());
            }
        }
    }

    void checkout(String bookTitle) {
            if(isProcessable(bookTitle, true)) {
                processBook(bookTitle, true);
                System.out.println("Thank you! Enjoy the item.");
            } else {
                System.out.println("That item is not available.");
            }
        }

    void returnItem(String bookTitle) {
        if(isProcessable(bookTitle, false)) {
            processBook(bookTitle, false);
            System.out.println("Thank you for returning the item.");
        } else {
            System.out.println("That is not a valid item to return.");
        }
    }

    private boolean isProcessable(String bookTitle, boolean isForCheckout) {
        for(LibraryItem item : itemList) {
            if(areTitlesMatching(item, bookTitle) && areCheckoutStatusesMatching(item, isForCheckout)) {
                return true;
            }
        }
        return false;
    }

    private void processBook(String bookName, boolean isForCheckout) {
        for(LibraryItem item : itemList) {
            if(areTitlesMatching(item, bookName) && areCheckoutStatusesMatching(item, isForCheckout)) {
                item.switchAvailability();
                break;
            }
        }
    }

    private boolean areTitlesMatching(LibraryItem item, String title) {
        return item.getTitle().equals(title);
    }

    private boolean areCheckoutStatusesMatching(LibraryItem item, boolean forCheckout) {
        return item.getAvailability() == forCheckout;
    }
}
