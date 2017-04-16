package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rylangooch on 16/04/2017.
 */
public class UserDatabaseTest {

    UserDatabase userDatabase1 = new UserDatabase();

    @Test
    public void checkUserDetailsSuccessTest() {
        User currentUser = userDatabase1.checkUserDetails("409-2983", "riberty4");
        assertEquals(User.class, currentUser.getClass());
    }

    @Test
    public void checkUserDetailsFailTest() {
        User currentUser = userDatabase1.checkUserDetails("341-1112", "april33");
        assertEquals(null, currentUser);
    }
}
