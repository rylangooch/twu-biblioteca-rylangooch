package com.twu.biblioteca;

/**
 * Created by rylangooch on 12/04/2017.
 */

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.io.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

public class LibrarianTest {

    private Librarian lib = new Librarian();
    private final ByteArrayOutputStream myOut = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(myOut));
    }

    @Test
    public void listBooksTest() {
        lib.listBooks();
        String booksList = "Zero To One | Peter Thiel | 2014\nMastery | Robert Greene | 2012\n";
        assertEquals(booksList, myOut.toString());
    }

    @Test
    public void checkoutRemovesBookFromListTest() {
        String input = "Zero To One";
        lib.checkout(input);
        lib.listBooks();
        assertThat(myOut.toString(), not(containsString(input)));
    }

    @Test
    public void successfulCheckoutMessageTest() {
        String input = "Zero To One";
        lib.checkout(input);
        String successfulCheckoutMessage = "Thank you! Enjoy the book";
        assertThat(myOut.toString(), containsString(successfulCheckoutMessage));
    }

    @Test
    public void unsuccessfulCheckoutMessageTest() {
        String input = "Vagabonding";
        lib.checkout(input);
        String successfulCheckoutMessage = "That book is not available.";
        assertThat(myOut.toString(), containsString(successfulCheckoutMessage));
    }
}
