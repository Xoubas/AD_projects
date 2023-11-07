package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(CodigoPostal.class, new CPDeserializer())
                .registerTypeAdapter(Lugar.class, LugarDeserializer)
                .create();

        URL url = new URL("https://api.zippopotam.us/es" +
                "/GA/Santiago%20De%20Compostela");

        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        CodigoPostal codigoPostal = gson.fromJson(reader, CodigoPostal.class);

        System.out.println(codigoPostal);
    }
}