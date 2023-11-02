package org.example;

import com.google.gson.*;

import java.io.Serializable;
import java.lang.reflect.Type;

public class PlaceSerializer implements JsonSerializer<Lugar>, JsonDeserializer<Lugar> {
    @Override
    public Lugar deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return null;
    }

    @Override
    public JsonElement serialize(Lugar src, Type typeOfSrc, JsonSerializationContext context) {
        return null;
    }
}
