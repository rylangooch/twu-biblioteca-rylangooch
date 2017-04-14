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

public class LibraryTest {

    private Library lib = new Library();
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
    public void listMoviesTest() {
        lib.listMovies();
        String moviesList = "Django Unchained | Quentin Tarantino | 2012 | 7\nManchester By The Sea | Kenneth Lonergan | 2016 | 8\n";
        assertEquals(moviesList, myOut.toString());
    }

    @Test
    public void checkoutRemovesBookFromPrintedListTest() {
        String input = "Mastery";
        lib.checkout(input);
        lib.listBooks();
        assertThat(myOut.toString(), not(containsString(input)));
    }

    @Test
    public void checkoutRemovesMovieFromPrintedListTest() {
        String input = "Django Unchained";
        lib.checkout(input);
        lib.listMovies();
        assertThat(myOut.toString(), not(containsString(input)));
    }

    @Test
    public void cannotCheckoutBookTwiceInARowTest() {
        String input = "Mastery";
        lib.checkout(input);
        lib.checkout(input);
        String unsuccessfulCheckoutMessage = "That item is not available.";
        assertThat(myOut.toString(), containsString(unsuccessfulCheckoutMessage));
    }

    @Test
    public void cannotCheckoutMovieTwiceInARowTest() {
        String input = "Mastery";
        lib.checkout(input);
        lib.checkout(input);
        String unsuccessfulCheckoutMessage = "That item is not available.";
        assertThat(myOut.toString(), containsString(unsuccessfulCheckoutMessage));
    }

    @Test
    public void successfulCheckoutMessageTest() {
        String input = "Zero To One";
        lib.checkout(input);
        String successfulCheckoutMessage = "Thank you! Enjoy the item.";
        assertThat(myOut.toString(), containsString(successfulCheckoutMessage));
    }

    @Test
    public void unsuccessfulCheckoutMessageTest() {
        String input = "Vagabonding";
        lib.checkout(input);
        String unsuccessfulCheckoutMessage = "That item is not available.";
        assertThat(myOut.toString(), containsString(unsuccessfulCheckoutMessage));
    }

    @Test
    public void returnItemAddsItemToPrintedListTest() {
        String input = "Mastery";
        lib.checkout(input);
        lib.returnItem(input);
        lib.listBooks();
        assertThat(myOut.toString(), containsString(input));
    }

    @Test
    public void successfulReturnBookMessageTest() {
        String input = "Zero To One";
        lib.checkout(input);
        lib.returnItem(input);
        String successfulCheckoutMessage = "Thank you for returning the item.";
        assertThat(myOut.toString(), containsString(successfulCheckoutMessage));
    }

    @Test
    public void unsuccessfulReturnItemMessageTest() {
        String input = "Vagabonding";
        lib.returnItem(input);
        String unsuccessfulCheckoutMessage = "That is not a valid item to return.";
        assertThat(myOut.toString(), containsString(unsuccessfulCheckoutMessage));
    }

    public void cannotReturnItemTwiceInARowTest() {
        String input = "Mastery";
        lib.checkout(input);
        lib.returnItem(input);
        lib.returnItem(input);
        String unsuccessfulCheckoutMessage = "That is not a valid item to return.";
        assertThat(myOut.toString(), containsString(unsuccessfulCheckoutMessage));
    }

    public void cannotReturnMovieTwiceInARowTest() {
        String input = "Mastery";
        lib.checkout(input);
        lib.returnItem(input);
        lib.returnItem(input);
        String unsuccessfulCheckoutMessage = "That is not a valid item to return.";
        assertThat(myOut.toString(), containsString(unsuccessfulCheckoutMessage));
    }
}
