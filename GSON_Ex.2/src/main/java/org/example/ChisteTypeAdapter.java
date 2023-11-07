package org.example;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class ChisteTypeAdapter extends TypeAdapter<Chiste> {
    @Override
    public void write(JsonWriter out, Chiste value) throws IOException {

    }

    @Override
    public Chiste read(JsonReader in) throws IOException {
        in.beginObject();
        while (in.hasNext()) {
            in.nextName();
        }
        in.endObject();
        return null;
    }
}
