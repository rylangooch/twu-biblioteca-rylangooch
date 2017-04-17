package com.twu.biblioteca;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.util.ArrayList;

/**
 * Created by rylangooch on 16/04/2017.
 */
public class UserDatabase {
    private ArrayList<User> DB = new ArrayList<User>();

    public UserDatabase() {
        DB.add(new User("Rylan", "rylan@biblioteca.com", "07958463521", "409-2983", "riberty4"));
        DB.add(new User("Tefe", "tefe@biblioteca.com", "07847553622", "408-2983", "placer990"));
    }

    public User checkUserDetails(String libraryNumber, String password) {
        for(User user : DB) {
            if(user.checkLibraryNumber(libraryNumber) && user.checkPassword(password)) {
                return user;
            }
        }
        return null;
    }
}
