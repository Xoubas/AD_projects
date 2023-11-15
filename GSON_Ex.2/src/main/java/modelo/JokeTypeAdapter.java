package modelo;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;

public class JokeTypeAdapter extends TypeAdapter<Joke> {
    @Override
    public void write(JsonWriter out, Joke value) throws IOException {

    }

    @Override
    public Joke read(JsonReader reader) throws IOException {
        Joke joke = new Joke();
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        reader.beginObject();
        while (reader.hasNext()) {
            String atributo = reader.nextName();
            switch (atributo) {
                case ("error") -> {
                    reader.nextBoolean();
                    joke.setError(reader.nextBoolean());
                }
                case ("category") -> {
                    reader.beginObject();
                    joke.setCategory(Category.valueOf(reader.nextString()));
                }
                case ("type") -> {
                    joke.setType(reader.nextString());
                }
                case ("setup") -> {
                    joke.setSetup(reader.nextString());
                }
                case ("delivery") -> {
                    joke.setDelivery(reader.nextString());
                }
                case ("flags") -> {
                    if (reader.peek() == JsonToken.NULL) {
                        reader.nextNull();
                        return null;
                    }
                    reader.beginObject();
                    ArrayList<Flag> listaFlags = new ArrayList<Flag>();
                    while (reader.hasNext()) {
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
                    joke.setFlags(listaFlags);
                }
                case ("safe") -> {
                    joke.setSafe(reader.nextBoolean());
                }
                case ("id") -> {
                    joke.setId(reader.nextInt());
                }
                case ("lang") -> {
                    joke.setLang(reader.nextString());
                }
            }
        }
        reader.endObject();
        return joke;
    }
}
