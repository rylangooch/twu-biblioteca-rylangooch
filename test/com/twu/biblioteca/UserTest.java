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

}
