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
        String welcome = "Main Menu - Choose a number:\n1. Login\n2. List Books\n3. Checkout Book\n4. Return Book\n" +
                "5. List Movies\n6. Checkout Movie\n7. Return Movie\n8. Exit\n";
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
    public void selectInvalidMenuOptionTest() {
        String input = "List books";
        String errorMessage = "Select a valid option!\n";
        menu.selectMenuChoice(input);
        assertEquals(errorMessage, myOut.toString());
    }

    @Test
    public void selectMenuChoice2Test() {
        String input = "2";
        String bookList = "Zero To One | Peter Thiel | 2014\n" +
                "Mastery | Robert Greene | 2012\n";
        menu.selectMenuChoice(input);
        assertEquals(bookList, myOut.toString());
    }

    @Test
    public void userAskedToLoginToCheckoutTest() {
        String input = "3";
        String checkoutMessage = "You must login to checkout an item.\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        menu.selectMenuChoice(input);
        assertThat(myOut.toString(), containsString(checkoutMessage));
    }

    @Test
    public void userAskedToLoginToReturnTest() {
        String input = "4";
        String checkoutMessage = "You must login to return an item.\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        menu.selectMenuChoice(input);
        assertThat(myOut.toString(), containsString(checkoutMessage));
    }

    @Test
    public void selectMenuChoice5Test() {
        String input = "5";
        String moviesList = "Django Unchained | Quentin Tarantino | 2012 | 7\n" +
                "Manchester By The Sea | Kenneth Lonergan | 2016 | 8\n";
        menu.selectMenuChoice(input);
        assertEquals(moviesList, myOut.toString());
    }

    @Test
    public void selectMenuChoice6Test() {
        String input = "6";
        String checkoutMessage = "Please provide the name of the movie you'd like to checkout:\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        menu.selectMenuChoice(input);
        assertThat(myOut.toString(), containsString(checkoutMessage));
    }

    @Test
    public void selectMenuChoice7Test() {
        String input = "7";
        String exitMessage = "Please provide the name of the movie you'd like to return:\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        menu.selectMenuChoice(input);
        assertThat(myOut.toString(), containsString(exitMessage));
    }

    @Test
    public void selectMenuChoice8Test() {
        String input = "8";
        String exitMessage = "Thank you for visiting The Bangalore Public Library. Goodbye.\n";
        menu.selectMenuChoice(input);
        assertEquals(exitMessage, myOut.toString());
    }
}
