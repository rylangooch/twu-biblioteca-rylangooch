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
        String welcome = "Welcome to The Bangalore Public Library\n";
        assertEquals(welcome, myOut.toString());
    }
}
