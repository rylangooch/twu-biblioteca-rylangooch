package com.twu.biblioteca;

/**
 * Created by rylangooch on 10/04/2017.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book1 = new Book("Zero To One", "Peter Thiel", "2014");

    @Test
    public void hasATitle() {
        assertEquals("Zero To One", book1.getTitle());
    }

    @Test
    public void hasAnAuthor() {
        assertEquals("Peter Thiel", book1.getAuthor());
    }

    @Test
    public void hasAYearPublished() {
        assertEquals("2014", book1.getYearPublished());
    }
}
