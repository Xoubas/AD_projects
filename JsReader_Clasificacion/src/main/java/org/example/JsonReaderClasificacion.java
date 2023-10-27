package org.example;

import com.google.gson.stream.JsonReader;

import java.io.IOException;

public class JsonReaderClasificacion {

    public static Clasificacion readClasificacion(JsonReader reader) throws IOException {
        reader.beginObject();
        reader.nextName();
        reader.beginArray();
        do {
            Equipo e = readEquipo(reader);
        } while (reader.hasNext());

        return null;
    }

    public static Equipo readEquipo(JsonReader reader) throws IOException {
        String nomeEquipo = null;
        int victorias = 0, derrotas = 0, puntosFavor = 0, puntosContra = 0;
        reader.beginObject();
        do {
            String fieldName = reader.nextName();
            switch (fieldName) {
                case "nome" -> nomeEquipo = reader.nextString();
                case "victorias" -> victorias = reader.nextInt();
                case "derrotas" -> derrotas = reader.nextInt();
                case "puntosFavor" -> puntosFavor = reader.nextInt();
                case "puntosContra" -> puntosContra = reader.nextInt();
            }
        } while (reader.hasNext());

        reader.endObject();

        return new Equipo(nomeEquipo, victorias, derrotas, puntosFavor, puntosContra);
    }
}
