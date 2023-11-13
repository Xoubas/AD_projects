package org.example;

public class ChisteDAO implements IChisteDAO{
    @Override
    public String getRandomJoke() {
        return "How do you tell HTML from HTML5?\\n- Try it out in Internet Explorer\\n- Did it work?\\n- No?\\n- It's HTML5.";
    }
}
