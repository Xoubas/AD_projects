package org.example;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

//        URL url = new URL();
//        new InputStreamReader(url.openStream());
        JsonReader reader = new JsonReader(Files.newBufferedReader(Paths.get("accesoADatos.")));

        while (reader.hasNext()) {
            JsonToken siguienteToken = reader.peek(); // devuelve el siguiente, sin consumirlo.
            System.out.println(siguienteToken);

            if (null != siguienteToken) {
                switch (siguienteToken) {
                    case BEGIN_OBJECT -> // Si es un objeto, consumimos las llaves {
                            reader.beginObject();
                    case NAME -> {
                        // Si es un nombre de atributo, lo imprimimos.
                        String nomeAtributo = reader.nextName();
                        System.out.println(nomeAtributo);
                    }
                    case STRING -> {
                        // si es una cadena, recuperamos String y la imprimimos
                        String valorString = reader.nextString();
                        System.out.println(valorString);
                    }
                    case NUMBER -> {
                        // Si es un número, OJO con los tipos...
                        long valorNumero = reader.nextLong();
                        System.out.println(valorNumero);
                    }
                    default -> {
                    }
                }
            }
        }
    }
}