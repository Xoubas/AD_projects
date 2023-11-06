package org.example;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class CPTypeAdapter extends TypeAdapter<CodigoPostal> {

    @Override
    public void write(JsonWriter out, CodigoPostal value) throws IOException {

    }

    @Override
    public CodigoPostal read(JsonReader in) throws IOException {
        return null;
    }
}
