package com.twu.biblioteca;

/**
 * Created by rylangooch on 14/04/2017.
 */
public class Movie extends LibraryItem {
    private String director;
    private String rating;

    public Movie(String t, String d, String y, String r) {
        super(t, y);
        this.director = d;
        this.rating = r;
    }

    public String printDetails() {
        return getTitle() + " | " + getDirector() + " | " + getYear() + " | " + getRating();
    }

    public String getDirector() { return director; }

    public String getRating() {
        return rating;
    }
}
