package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by rylangooch on 13/04/2017.
 */
public class MenuTest {

    Menu menu = new Menu();
    private final ByteArrayOutputStream myOut = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(myOut));
    }

    @Test
    public void showMenuTest() {
        menu.showMenu();
        String welcome = "Main Menu - Choose a number:\n1. List Books\n2. Checkout Book\n3. Return Book\n" +
                "4. List Movies\n5. Checkout Movie\n6. Return Movie\n7. Exit\n";
        assertEquals(welcome, myOut.toString());
    }

    @Test
    public void getMenuChoiceTest() {
        String input = "1";
        InputStream myOut = new ByteArrayInputStream(input.getBytes());
        System.setIn(myOut);
        assertEquals("1", menu.getUserInput());
    }

    @Test
    public void selectMenuChoice1Test() {
        String input = "1";
        String booksList = "Zero To One | Peter Thiel | 2014\nMastery | Robert Greene | 2012\n";
        menu.selectMenuChoice(input);
        assertEquals(booksList, myOut.toString());
    }

    @Test
    public void selectInvalidMenuOptionTest() {
        String input = "List books";
        String errorMessage = "Select a valid option!\n";
        menu.selectMenuChoice(input);
        assertEquals(errorMessage, myOut.toString());
    }

    @Test
    public void selectMenuChoice2Test() {
        String input = "2";
        String checkoutMessage = "Please provide the title of the book you'd like to checkout:\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        menu.selectMenuChoice(input);
        assertThat(myOut.toString(), containsString(checkoutMessage));
    }

    @Test
    public void selectMenuChoice3Test() {
        String input = "3";
        String exitMessage = "Please provide the title of the book you'd like to return:\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        menu.selectMenuChoice(input);
        assertThat(myOut.toString(), containsString(exitMessage));
    }

    @Test
    public void selectMenuChoice4Test() {
        String input = "4";
        String moviesList = "Django Unchained | Quentin Tarantino | 2012 | 7\n" +
                "Manchester By The Sea | Kenneth Lonergan | 2016 | 8\n";
        menu.selectMenuChoice(input);
        assertEquals(moviesList, myOut.toString());
    }

    @Test
    public void selectMenuChoice5Test() {
        String input = "5";
        String checkoutMessage = "Please provide the name of the movie you'd like to checkout:\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        menu.selectMenuChoice(input);
        assertThat(myOut.toString(), containsString(checkoutMessage));
    }

    @Test
    public void selectMenuChoice6Test() {
        String input = "6";
        String exitMessage = "Please provide the name of the movie you'd like to return:\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        menu.selectMenuChoice(input);
        assertThat(myOut.toString(), containsString(exitMessage));
    }

    @Test
    public void selectMenuChoice7Test() {
        String input = "7";
        String exitMessage = "Thank you for visiting The Bangalore Public Library. Goodbye.\n";
        menu.selectMenuChoice(input);
        assertEquals(exitMessage, myOut.toString());
    }
}
