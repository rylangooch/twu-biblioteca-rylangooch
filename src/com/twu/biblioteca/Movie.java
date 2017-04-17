package com.twu.biblioteca;

/**
 * Created by rylangooch on 14/04/2017.
 */
public class Movie extends LibraryItem {
    private String director;
    private String rating;

    public Movie(String title, String director, String year, String rating) {
        super(title, year);
        this.director = director;
        this.rating = rating;
    }

    public String printDetails() {
        return getTitle() + " | " + getDirector() + " | " + getYear() + " | " + getRating();
    }

    public String getDirector() { return director; }

    public String getRating() {
        return rating;
    }
}
