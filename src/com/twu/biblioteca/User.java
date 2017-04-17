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

    public User(String name, String email, String telephone, String libraryNumber, String password) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.libraryNumber = libraryNumber;
        this.password = password;
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
