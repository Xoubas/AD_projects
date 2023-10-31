package org.example;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class CP_typeAdapter extends TypeAdapter<Lugar> {


    @Override
    public void write(JsonWriter out, Lugar value) throws IOException {

    }

    @Override
    public Lugar read(JsonReader in) throws IOException {
        return null;
    }
}
