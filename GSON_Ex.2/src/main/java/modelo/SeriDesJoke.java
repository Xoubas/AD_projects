package modelo;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SeriDesJoke implements JsonSerializer<Joke>, JsonDeserializer<Joke> {
    @Override
    public Joke deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jo = json.getAsJsonObject();
        Boolean error = jo.get("error").getAsBoolean();
        String cat = jo.get("category").getAsString();
        if (cat.equals("Misc")) {
            cat = "miscellaneous";
        }
        Category category = Category.valueOf(cat);
        String type = jo.get("type").getAsString();
        String setup = jo.get("setup").getAsString();
        String delivery = jo.get("delivery").getAsString();
        //Object flags
        JsonObject flags = jo.get("flags").getAsJsonObject();
        ArrayList<Flag> returnFlags = new ArrayList<Flag>();
        String[] nombres = {"nsfw", "religious", "political", "racist", "sexist", "explicit"};
        for (int i = 0; i < nombres.length; i++) {
            if (flags.get(nombres[i]).getAsBoolean()) {
                returnFlags.add(Flag.valueOf(nombres[i]));
            }
        }
        Boolean safe = jo.get("safe").getAsBoolean();
        int id = jo.get("id").getAsInt();
        String lang = jo.get("lang").getAsString();

        return new Joke();
    }

    @Override
    public JsonElement serialize(Joke src, Type typeOfSrc, JsonSerializationContext context) {
        JsonElement error = src.isError().getAs;

        return null;
    }
}
