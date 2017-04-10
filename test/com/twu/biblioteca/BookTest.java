package com.twu.biblioteca;

/**
 * Created by rylangooch on 10/04/2017.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book1 = new Book("Zero To One");

    @Test
    public void hasATitle() {
        assertEquals("Zero To One", book1.getTitle());
    }
}
