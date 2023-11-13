package org.example;

public enum Categoria {
    PROGRAMMING("programming"), MISC("misc"),
    DARK("dark"), PUN("pun"), SPOOKY("spooky"),
    CHRISTMAS("christmas");


    private String name;

    Categoria(String name) {
        this.name = name;
    }
}
