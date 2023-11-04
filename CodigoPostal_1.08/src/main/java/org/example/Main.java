package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URL;
import java.nio.Buffer;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main implements Serializable {
    public static void writeJson(CodigoPostal cp) throws IOException {
        var gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter bw = null;
        try {
            bw = Files.newBufferedWriter(Paths.get("CP.json"));
            gson.toJson(cp, bw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            assert bw != null;
            bw.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(CodigoPostal.class, new CP_seriDeseri())
                .registerTypeAdapter(Lugar.class, new Lugar_seriDeseri())
                .create();

        URL url = new URL("https://api.zippopotam.us/es/32002");

        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        CodigoPostal codigoPostal = gson.fromJson(reader, CodigoPostal.class);
        writeJson(codigoPostal);
    }
}