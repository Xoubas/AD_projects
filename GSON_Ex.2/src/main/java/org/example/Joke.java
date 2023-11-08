package org.example;

import java.util.List;

public class Joke {
    private boolean error;
    private List<Category> categories;
    private String type;
    private String setup;
    private String delivery;
    private List<Flag> flags;
    private boolean safe;
    private int id;
    private String lang;

    public Joke(boolean error, List<Category> categories, String type, String setup, String delivery, boolean safe, int id, String lang) {
        this.error = error;
        this.categories = categories;
        this.type = type;
        this.setup = setup;
        this.delivery = delivery;
        this.safe = safe;
        this.id = id;
        this.lang = lang;
    }

    public Joke() {
    }

    private boolean isError() {
        return error;
    }

    private void setError(boolean error) {
        this.error = error;
    }

    private List<Category> getCategory() {
        return categories;
    }

    private void setCategory(List<Category> categories) {
        this.categories = categories;
    }

    private String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    private String getSetup() {
        return setup;
    }

    private void setSetup(String setup) {
        this.setup = setup;
    }

    private String getDelivery() {
        return delivery;
    }

    private void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    private boolean isSafe() {
        return safe;
    }

    private void setSafe(boolean safe) {
        this.safe = safe;
    }

    private int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    private String getLang() {
        return lang;
    }

    private void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Joke{" +
                " Category: " + categories + System.lineSeparator() +
                " type: " + type + System.lineSeparator() +
                " setup: " + setup + System.lineSeparator() +
                " delivery: " + delivery + System.lineSeparator() +
                " flags=" + flags + System.lineSeparator() +
                " safe: " + safe + System.lineSeparator() +
                " id: " + id + System.lineSeparator() +
                " lang: " + lang + System.lineSeparator() +
                '}');
        return sb.toString();
    }
}
