package org.example;

public enum Categoria {
    NOVELA,
    POESIA,
    ENSAYO,
    TEATRO,
    OTROS;

    private Categoria() {
    }

    public String getFirstLetters() {
        return this.name().toUpperCase().substring(0, 1) + this.name().toLowerCase().substring(1);
    }
}
