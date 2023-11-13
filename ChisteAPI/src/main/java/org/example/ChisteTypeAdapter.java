package org.example;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;

public class ChisteTypeAdapter extends TypeAdapter<Chiste> {
    @Override
    public void write(JsonWriter out, Chiste value) throws IOException {

    }

    @Override
    public Chiste read(JsonReader reader) throws IOException {
        Chiste chiste = new Chiste();
        reader.beginObject();
        while (reader.hasNext()) {
            String atributo = reader.nextName();
            switch (atributo) {
                case ("category") -> {
                    chiste.setCategory(reader.nextString());
                }
                case ("type") -> {
                    chiste.setType(reader.nextString());
                }
                case ("setup") -> {
                    chiste.setSetup(reader.nextString());
                }
                case ("delivery") -> {
                    chiste.setDelivery(reader.nextString());
                }
                case ("flags") -> {
                    reader.beginObject();
                    ArrayList<Flag> listaFlags = null;
                    while (reader.hasNext()) {
                        listaFlags = new ArrayList<Flag>();
                        String atributoFlag = reader.nextName();
                        if (reader.nextBoolean()) {
                            switch (atributoFlag) {
                                case ("nsfw") -> {
                                    listaFlags.add(Flag.NSFW);
                                }
                                case ("religious") -> {
                                    listaFlags.add(Flag.RELIGIOUS);
                                }
                                case ("political") -> {
                                    listaFlags.add(Flag.POLITICAL);
                                }
                                case ("racist") -> {
                                    listaFlags.add(Flag.RACIST);
                                }
                                case ("sexist") -> {
                                    listaFlags.add(Flag.SEXIST);
                                }
                                case ("explicit") -> {
                                    listaFlags.add(Flag.EXPLICIT);
                                }
                            }
                        }
                        reader.endObject();
                    }
                    chiste.setFlags(listaFlags);
                }
                case ("safe") -> {
                    chiste.setSafe(reader.nextBoolean());
                }
                case ("id") -> {
                    chiste.setId(reader.nextInt());
                }
                case ("lang") -> {
                    chiste.setLang(reader.nextString());
                }
            }
        }
        reader.endObject();
        return chiste;
    }
}
