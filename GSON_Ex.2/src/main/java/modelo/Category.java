package modelo;

public enum Category {
    PROGRAMMING("programming"), MISC("misc"),
    DARK("dark"), PUN("pun"), SPOOKY("spooky"),
    CHRISTMAS("christmas");


    private String name;

    Category(String name) {
        this.name = name;
    }
}
