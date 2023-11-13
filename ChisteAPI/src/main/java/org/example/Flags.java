package org.example;

public enum Flags {

    NSFW("nsfw"), RELIGIOUS("religioso"),
    POLITICAL("politico"), RACIST("racista"),
    SEXIST("sexista"), EXPLICIT("explicito");


    private String name;

    Flags(String name) {
        this.name = name;
    }
}
