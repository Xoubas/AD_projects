package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;

public class Lugar_seriDeseri implements JsonSerializer<Lugar>, JsonDeserializer<Lugar> {
    @Override
    public Lugar deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String placeName = jsonObject.get("place name").getAsString();
        double longitude = jsonObject.get("longitude").getAsDouble();
        String state = jsonObject.get("state").getAsString();
        String stateAbb = jsonObject.get("state abbreviation").getAsString();
        double latitude = jsonObject.get("latitude").getAsDouble();

        return new Lugar(placeName, longitude, state, stateAbb, latitude);
    }

    @Override
    public JsonElement serialize(Lugar src, Type typeOfSrc, JsonSerializationContext context) {
        return null;
    }
}
