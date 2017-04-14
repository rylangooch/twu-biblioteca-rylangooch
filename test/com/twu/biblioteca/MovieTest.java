package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rylangooch on 14/04/2017.
 */
public class MovieTest {

    Movie movie1 = new Movie("Manchester By The Sea", "Kenneth Lonergan", "2016", "8");

    @Test
    public void hasANameTest() {
        assertEquals("Manchester By The Sea", movie1.getTitle());
    }

    @Test
    public void hasADirectorTest() {
        assertEquals("Kenneth Lonergan", movie1.getDirector());
    }

    @Test
    public void hasAYearReleasedTest() {
        assertEquals("2016", movie1.getYear());
    }

    @Test
    public void hasAYearRating() {
        assertEquals("8", movie1.getRating());
    }

    @Test
    public void hasACheckedOutStatusTest() {
        assertEquals(true, movie1.getAvailability());
    }

    @Test
    public void switchCheckedOutStatusTest() {
        movie1.switchAvailability();
        assertEquals(false, movie1.getAvailability());
    }
}
