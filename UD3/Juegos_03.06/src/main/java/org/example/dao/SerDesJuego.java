package org.example.dao;

import com.google.gson.*;
import org.example.model.Juego;

import java.lang.reflect.Type;

public class SerDesJuego implements JsonSerializer<Juego>, JsonDeserializer<Juego> {
    @Override
    public JsonElement serialize(Juego juego, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }

    @Override
    public Juego deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
