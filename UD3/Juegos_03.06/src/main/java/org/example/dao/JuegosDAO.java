package org.example.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.Juego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class JuegosDAO implements DAO<Juego> {
    private final Gson gson;

    public JuegosDAO() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .registerTypeAdapter(Juego.class, new SerDesJuego())
                .create();
    }

    @Override
    public Juego getOne(String code) {
        BufferedReader reader = null;
        try {
            URL url = new URL("https://www.freetogame.com/api/game?id=" + code);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            return gson.fromJson(reader, Juego.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to connect to API", e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException("Failed to close the stream", e);
            }
        }
    }
}
