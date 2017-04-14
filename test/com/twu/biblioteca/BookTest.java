package com.twu.biblioteca;

/**
 * Created by rylangooch on 10/04/2017.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book1 = new Book("Zero To One", "Peter Thiel", "2014");

    @Test
    public void hasATitleTest() {
        assertEquals("Zero To One", book1.getTitle());
    }

    @Test
    public void hasAnAuthorTest() {
        assertEquals("Peter Thiel", book1.getAuthor());
    }

    @Test
    public void hasAYearPublishedTest() {
        assertEquals("2014", book1.getYear());
    }

    @Test
    public void hasACheckedOutStatusTest() {
        assertEquals(true, book1.getAvailability());
    }

    @Test
    public void switchCheckedOutStatusTest() {
        book1.switchAvailability();
        assertEquals(false, book1.getAvailability());
    }
}
