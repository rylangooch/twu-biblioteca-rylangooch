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
    public void checkoutRemovesBookFromPrintedListTest() {
        String input = "Mastery";
        lib.checkout(input);
        lib.listBooks();
        assertThat(myOut.toString(), not(containsString(input)));
    }

    @Test
    public void cannotCheckoutBookTwiceInARowTest() {
        String input = "Mastery";
        lib.checkout(input);
        lib.checkout(input);
        String unsuccessfulCheckoutMessage = "That book is not available.";
        assertThat(myOut.toString(), containsString(unsuccessfulCheckoutMessage));
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
        String unsuccessfulCheckoutMessage = "That book is not available.";
        assertThat(myOut.toString(), containsString(unsuccessfulCheckoutMessage));
    }

    @Test
    public void returnBookAddsBookToPrintedListTest() {
        String input = "Mastery";
        lib.checkout(input);
        lib.returnBook(input);
        lib.listBooks();
        assertThat(myOut.toString(), containsString(input));
    }

    @Test
    public void successfulReturnMessageTest() {
        String input = "Zero To One";
        lib.checkout(input);
        lib.returnBook(input);
        String successfulCheckoutMessage = "Thank you for returning the book.";
        assertThat(myOut.toString(), containsString(successfulCheckoutMessage));
    }

    @Test
    public void unsuccessfulReturnMessageTest() {
        String input = "Vagabonding";
        lib.returnBook(input);
        String unsuccessfulCheckoutMessage = "That is not a valid book to return.";
        assertThat(myOut.toString(), containsString(unsuccessfulCheckoutMessage));
    }

    public void cannotReturnBookTwiceInARowTest() {
        String input = "Mastery";
        lib.checkout(input);
        lib.returnBook(input);
        lib.returnBook(input);
        String unsuccessfulCheckoutMessage = "That is not a valid book to return.";
        assertThat(myOut.toString(), containsString(unsuccessfulCheckoutMessage));
    }
}
