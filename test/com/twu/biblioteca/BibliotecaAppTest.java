package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.io.*;

public class BibliotecaAppTest {

    BibliotecaApp app = new BibliotecaApp();
    private final ByteArrayOutputStream myOut = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(myOut));
    }

    @Test
    public void welcomeMessageTest() {
        app.welcomeMessage();
        app.showMenu();
        String welcome = "Welcome to The Bangalore Public Library\nMain Menu - Choose a number:\n1. List Books\n" +
                "2. Checkout Book\n3. Exit\n";
        assertEquals(welcome, myOut.toString());
    }

    @Test
    public void showMenuTest() {
        app.showMenu();
        String welcome = "Main Menu - Choose a number:\n1. List Books\n2. Checkout Book\n3. Exit\n";
        assertEquals(welcome, myOut.toString());
    }

    @Test
    public void getMenuChoiceTest() {
        String input = "1";
        InputStream myOut = new ByteArrayInputStream(input.getBytes());
        System.setIn(myOut);
        assertEquals("1", app.getUserInput());
    }

    @Test
    public void selectMenuChoice1Test() {
        String input = "1";
        String booksList = "Zero To One | Peter Thiel | 2014\nMastery | Robert Greene | 2012\n";
        app.selectMenuChoice(input);
        assertEquals(booksList, myOut.toString());
    }

    @Test
    public void selectInvalidMenuOptionTest() {
        String input = "List books";
        String errorMessage = "Select a valid option!\n";
        app.selectMenuChoice(input);
        assertEquals(errorMessage, myOut.toString());
    }

    @Test
    public void selectMenuChoice2Test() {
        String input = "2";
        String checkoutMessage = "Please provide the title of the book you'd like to checkout:\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        app.selectMenuChoice(input);
        assertEquals(checkoutMessage, myOut.toString());
    }

    @Test
    public void selectMenuChoice3Test() {
        String input = "3";
        String exitMessage = "Thank you for visiting The Bangalore Public Library. Goodbye.\n";
        app.selectMenuChoice(input);
        assertEquals(exitMessage, myOut.toString());
    }
}
