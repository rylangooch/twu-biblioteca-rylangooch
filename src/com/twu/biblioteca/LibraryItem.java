package com.twu.biblioteca;

/**
 * Created by rylangooch on 14/04/2017.
 */
public abstract class LibraryItem {
    private String title;
    private String year;
    private boolean isAvailable;

    LibraryItem(String title, String year) {
        this.title = title;
        this.year = year;
        this.isAvailable = true;
    }

    abstract String printDetails();

    String getTitle() {
        return title;
    }

    String getYear() {
        return year;
    }

    boolean getAvailability() {
        return isAvailable;
    }

    void switchAvailability() {
        this.isAvailable ^= true;
    }
}
