package com.twu.biblioteca;

/**
 * Created by rylangooch on 14/04/2017.
 */
public class Movie {
    private String name;
    private String director;
    private String yearReleased;
    private String rating;
    private boolean isCheckedOut;

    Movie(String name, String director, String year, String rating) {
        this.name = name;
        this.director = director;
        this.yearReleased = year;
        this.rating = rating;
        isCheckedOut = true;
    }

    String getName() {
        return name;
    }

    String getDirector() { return director; }

    String getYearReleased() {
        return yearReleased;
    }

    String getYearRating() {
        return rating;
    }

    boolean getCheckedOutStatus() {
        return isCheckedOut;
    }

    void switchCheckedOutStatus() {
        isCheckedOut ^= true;
    }
}
