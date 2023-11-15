package modelo;

import java.util.List;

public class Joke {
    private boolean error;
    private Category category;
    private String type;
    private String setup;
    private String delivery;
    private List<Flag> flags;
    private boolean safe;
    private int id;
    private String lang;

    public Joke(boolean error, Category category, String type, String setup, String delivery, boolean safe, int id, String lang) {
        this.error = error;
        this.category = category;
        this.type = type;
        this.setup = setup;
        this.delivery = delivery;
        this.safe = safe;
        this.id = id;
        this.lang = lang;
    }

    public Joke() {
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public List<Flag> getFlags() {
        return flags;
    }

    public void setFlags(List<Flag> flags) {
        this.flags = flags;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Joke{" +
                " Category: " + category + System.lineSeparator() +
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
