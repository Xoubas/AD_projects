package org.example;

public enum Flag {
    NSFW("trabajo"), RELIGIOUS("religión"), RACIST("sexista"), SEXIST("sexista"), EXPLICIT("explicito");

    private final String nombre;

    private Flag(String nombre) {
        this.nombre = nombre;
    }
}
