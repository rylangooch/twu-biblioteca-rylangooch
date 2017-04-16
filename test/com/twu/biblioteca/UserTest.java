package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rylangooch on 15/04/2017.
 */
public class UserTest {

    User user1 = new User("Rylan", "rylan@biblioteca.com", "07482388920", "409-2983", "riberty4");

    @Test
    public void getInformationTest() {
        assertEquals("Rylan | rylan@biblioteca.com | 07482388920", user1.getInformation());
    }

    @Test
    public void successfulcheckUsernameTest() {
        assertEquals(true, user1.checkLibraryNumber("409-2983"));
    }

    @Test
    public void unsuccessfulCheckUsernameTest() {
        assertEquals(false, user1.checkLibraryNumber("111-1111"));
    }

    @Test
    public void successfulCheckPasswordTest() {
        assertEquals(true, user1.checkPassword("riberty4"));
    }

    @Test
    public void unsuccessfulCheckPasswordTest() {
        assertEquals(false, user1.checkPassword("1111"));
    }
}
