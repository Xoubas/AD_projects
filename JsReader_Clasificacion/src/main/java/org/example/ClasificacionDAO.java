package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClasificacionDAO implements Serializable {
    private static final String OBJECT_FILE = "clasificacion.dat";
    private static final String JSON_FILE = "clasificacion.json";

    /**
     * Versión estática que recoge archivo y objeto a guardar.
     *
     * @param archivo nombre del archivo.
     * @param c       Objeto de tipo Clasificación a guardar.
     * @return
     */
    public static boolean saveToObject(String archivo, Clasificacion c) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(archivo)));) {
            oos.writeObject(c);
        } catch (IOException ex) {
            System.err.println("Erro de Entrada/Saída");
            return false;
        }
        return true;
    }

    public void saveToJson(String archivo, Clasificacion clasificacion) {
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(archivo));) {
            //String json = gson.toJson(clasificacion);
            gson.toJson(clasificacion, writer);
            //Files.writeString(Paths.get(archivo), json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveToJson(Clasificacion clasificacion) {
        saveToJson(JSON_FILE, clasificacion);
    }
    public Clasificacion getFromObject() throws IOException {
        ObjectInputStream ois = null;
        if (Files.exists(Paths.get(OBJECT_FILE))) {
            try {
                ois = new ObjectInputStream(
                        new BufferedInputStream(
                                Files.newInputStream(Paths.get(OBJECT_FILE))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                assert ois != null;
                ois.close();
            }
        } else {
            System.err.println("The file doesn't exist");
        }

        try {
            assert ois != null;
            return (Clasificacion) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Clasificacion getFromJson(String file) {
        if (Files.exists(Path.of(file))) {
            try {
                String json = Files.readString(Path.of(file));
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                return gson.fromJson(json, Clasificacion.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public Clasificacion getFromJson() {
        return getFromJson(JSON_FILE);
    }
}
