package com.twu.biblioteca;

import sun.jvm.hotspot.HelloWorld;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.welcomeMessage();
    }

    public void welcomeMessage() {
        System.out.print("Welcome to Biblioteca");
    }
}
