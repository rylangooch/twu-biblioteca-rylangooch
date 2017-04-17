package com.twu.biblioteca;

/**
 * Created by rylangooch on 15/04/2017.
 */
public class User {
    private String name;
    private String email;
    private String telephone;
    private String libraryNumber;
    private String password;

    public User(String n, String e, String t, String ln, String p) {
        this.name = n;
        this.email = e;
        this.telephone = t;
        this.libraryNumber = ln;
        this.password = p;
    }

    public String getInformation() {
        return this.name + " | " + this.email + " | " + this.telephone;
    }

    public boolean checkLibraryNumber(String number) {
        return number.equals(this.libraryNumber);
    }

    public boolean checkPassword(String pass) {
        return pass.equals(this.password);
    }
}
