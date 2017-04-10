package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BibliotecaAppTest {

    BibliotecaApp app = new BibliotecaApp();
    private final ByteArrayOutputStream myOut = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(myOut));
    }

    @Test
    public void helloWorld() {
        app.welcomeMessage();
        String welcome = "Welcome to Biblioteca";
        assertEquals(welcome, myOut.toString());
    }

}