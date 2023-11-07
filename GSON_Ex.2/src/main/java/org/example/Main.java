package org.example;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://v2.jokeapi.dev/joke/Programming?lang=es&blacklistFlags=racist,sexist");
    }
}