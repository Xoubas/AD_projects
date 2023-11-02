package org.example;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PoemaJsonReader {

    // Método principal de entrada
    public List<Poema> readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readArrayPoemas(reader);
        } finally {
            reader.close();
        }
    }

    /**
     * Devuelve la lista de poemas del JSON
     * */
    public List<Poema> readArrayPoemas(JsonReader reader) throws IOException {
        // Guardar la lista de poemas del JSON
        List<Poema> poemas = new ArrayList<>();

        reader.beginArray(); // Leemos el  [
        while (reader.hasNext()) { // para cade elemento de array de poemas
            poemas.add(readPoema(reader));
        }
        reader.endArray(); // Leemos el ]
        return poemas;
    }

    public Poema readPoema(JsonReader reader) throws IOException {
        long id = -1;
        String poema = null; // el nombre del poema
        Poeta poeta = null; // El poeta es un objeto
        List<Double> localizacion = null; // Es un array JSON de double

        reader.beginObject(); // Lectura  {
        while (reader.hasNext()) { // Mientras haya atributos
            String nome = reader.nextName();
            if (nome.equals("id")) {
                id = reader.nextLong();
            } else if (nome.equals("poema")) {
                poema = reader.nextString();
            } else if (nome.equals("localizacion")
                    // peek devuelve el siguiente elemento sin consumirlo
                    // (no salta al siguiente). Es un array.
                    && reader.peek() != JsonToken.NULL) {
                localizacion = readArrayDouble(reader);
            } else if (nome.equals("poeta")) {
                poeta = readPoeta(reader);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject(); // Lectura  {
        return new Poema(id, poema, poeta, localizacion);
    }

    public List<Double> readArrayDouble(JsonReader reader) throws IOException {
        List<Double> doubles = new ArrayList<>();

        reader.beginArray(); // [
        while (reader.hasNext()) {
            doubles.add(reader.nextDouble());
        }
        reader.endArray(); // ]
        return doubles;
    }

    public Poet readPoeta(JsonReader reader) throws IOException {
        String nome = null;
        int anoNacemento = -1;
        int numeroSeguidores = -1;

        reader.beginObject();
        while (reader.hasNext()) {
            String fieldName = reader.nextName();
            if (fieldName.equals("nome")) {
                nome = reader.nextString();
            } else if (fieldName.equals("anoNacemento")) {
                anoNacemento = reader.nextInt();
            } else if (fieldName.equals("numeroSeguidores")) {
                numeroSeguidores = reader.nextInt();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Poet(nome, anoNacemento, numeroSeguidores);
    }
}
