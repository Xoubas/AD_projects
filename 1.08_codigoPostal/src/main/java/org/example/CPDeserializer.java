package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;

public class CPDeserializer implements JsonSerializer<CodigoPostal>, JsonDeserializer<CodigoPostal> {
    @Override
    public CodigoPostal deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String codigoPostal = jsonObject.get("post code").getAsString();
        String pais = jsonObject.get("country").getAsString();
        String abrebiaturaPais = jsonObject.get("country abbreviation").getAsString();
        JsonArray lugares = jsonObject.get("places").getAsJsonArray();
        CodigoPostal cp = new CodigoPostal(codigoPostal, pais, abrebiaturaPais);

        for (JsonElement lugar : lugares) {
            JsonObject obj = lugar.getAsJsonObject();
            String nome = obj.get("place name").getAsString();
            Double longitude = Double.parseDouble(obj.get("longitude").getAsString());
            String estado = obj.get("state").getAsString();
            String abrebiaturaEstado = obj.get("state abbreviation").getAsString();
            Double latitude = Double.parseDouble(obj.get("latitude").getAsString());


        }

        //return new CodigoPostal(codigoPostal, pais, abrebiaturaPais);
    }

    @Override
    public JsonElement serialize(CodigoPostal src, Type typeOfSrc, JsonSerializationContext context) {
        return null;
    }
}
