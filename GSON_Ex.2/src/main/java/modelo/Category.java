package modelo;

public enum Category {
    PROGRAMMING("Programming"), MISC("Misc"),
    DARK("Dark"), PUN("Pun"), SPOOKY("Spooky"),
    CHRISTMAS("Christmas");


    private String name;

    Category(String name) {
        this.name = name;
    }
}
