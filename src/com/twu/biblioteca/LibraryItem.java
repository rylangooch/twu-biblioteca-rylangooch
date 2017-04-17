package com.twu.biblioteca;

/**
 * Created by rylangooch on 14/04/2017.
 */
public abstract class LibraryItem {
    private String title;
    private String year;
    private boolean isAvailable;

    public LibraryItem(String title, String year) {
        this.title = title;
        this.year = year;
        this.isAvailable = true;
    }

    public abstract String printDetails();

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public void switchAvailability() {
        this.isAvailable ^= true;
    }
}
