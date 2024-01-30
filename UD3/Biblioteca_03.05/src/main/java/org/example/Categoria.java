package org.example;

public enum Categoria {
    NOVELA("Novela"),
    POESIA("Poesia"),
    ENSAYO("Ensayo"),
    TEATRO("Teatro"),
    OTROS("Otros");
    private String nombre;

    private Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
