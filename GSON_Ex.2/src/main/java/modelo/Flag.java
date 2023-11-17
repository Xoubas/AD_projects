package modelo;

public enum Flag {
    NSFW("trabajo"), RELIGIOUS("religión"),
    RACIST("sexista"), SEXIST("sexista"),
    EXPLICIT("explicito"), POLITICAL("politica");
    private final String nombre;

    private Flag(String nombre) {
        this.nombre = nombre;
    }
}
