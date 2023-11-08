package org.example;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class JokeTypeAdapter extends TypeAdapter<Joke> {
    @Override
    public void write(JsonWriter out, Joke value) throws IOException {

    }

    @Override
    public Joke read(JsonReader in) throws IOException {
        in.beginObject();
        while (in.hasNext()) {
            in.nextName();
        }
        in.endObject();
        return null;
    }
}
