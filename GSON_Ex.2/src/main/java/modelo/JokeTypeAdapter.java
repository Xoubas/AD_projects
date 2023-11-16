package modelo;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JokeTypeAdapter extends TypeAdapter<Joke> {
    @Override
    public void write(JsonWriter writer, Joke joke) throws IOException {
        writer.beginObject();

        writer.name("error").value(joke.isError());
        writer.name("category").value(joke.getCategory().name());
        writer.name("type").value(joke.getType());
        writer.name("setup").value(joke.getSetup());
        writer.name("delivery").value(joke.getDelivery());
        writer.name("flags");
        writeFlags(writer, joke.getFlags());
        writer.name("safe").value(joke.isSafe());
        writer.name("id").value(joke.getId());
        writer.name("lang").value(joke.getLang());
        writer.endObject();
    }

    private void writeFlags(JsonWriter writer, List<Flag> list) throws IOException {
        writer.beginObject();
        for (Flag flag : list) {
            writer.name(flag.name()).value(true);
        }
    }

    @Override
    public Joke read(JsonReader reader) throws IOException {
        Joke joke = new Joke();
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        reader.beginObject();
        String attribute;
        while (reader.hasNext()) {
            attribute = reader.nextName();
            switch (attribute) {
                case ("error") -> {
                    joke.setError(reader.nextBoolean());
                }
                case ("category") -> {
                    joke.setCategory(Category.valueOf(reader.nextString().toUpperCase()));
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
                    joke.setFlags(walkFlags(reader));
                    reader.endObject();
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

    private ArrayList<Flag> walkFlags(JsonReader reader) throws IOException {
        ArrayList<Flag> list = new ArrayList<Flag>();
        String flag;
        while (reader.hasNext()) {
            flag = reader.nextName();
            if (reader.nextBoolean()) {
                switch (flag) {
                    case ("nsfw") -> {
                        list.add(Flag.NSFW);
                    }
                    case ("religious") -> {
                        list.add(Flag.RELIGIOUS);
                    }
                    case ("political") -> {
                        list.add(Flag.POLITICAL);
                    }
                    case ("racist") -> {
                        list.add(Flag.RACIST);
                    }
                    case ("sexist") -> {
                        list.add(Flag.SEXIST);
                    }
                    case ("explicit") -> {
                        list.add(Flag.EXPLICIT);
                    }
                }
            }
        }
        return list;
    }
}
