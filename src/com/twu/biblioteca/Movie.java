package com.twu.biblioteca;

/**
 * Created by rylangooch on 14/04/2017.
 */
public class Movie extends LibraryItem {
    private String director;
    private String rating;

    Movie(String title, String director, String year, String rating) {
        super(title, year);
        this.director = director;
        this.rating = rating;
    }

    String getDirector() { return director; }

    String getRating() {
        return rating;
    }
}
