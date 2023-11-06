package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CP_seriDeseri implements JsonSerializer<CodigoPostal>, JsonDeserializer<CodigoPostal> {
    @Override
    public CodigoPostal deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String codigoPostal = jsonObject.get("post code").getAsString();
        String pais = jsonObject.get("country").getAsString();
        String abrebiaturaPais = jsonObject.get("country abbreviation").getAsString();
        JsonArray lugares = jsonObject.get("places").getAsJsonArray();
<<<<<<< HEAD:1.08_codigoPostal/src/main/java/org/example/CPDeserializer.java
        CodigoPostal cp = new CodigoPostal(codigoPostal, pais, abrebiaturaPais);
        ArrayList<Lugar> al = new ArrayList<Lugar>();
=======
        ArrayList<Lugar> todosLugares = new ArrayList<Lugar>();
>>>>>>> 528ac8aa4a6ea8aa764e1344d1a4e154cbead6d1:CodigoPostal_1.08/src/main/java/org/example/CP_seriDeseri.java

        for (JsonElement lugar : lugares) {
            JsonObject obj = lugar.getAsJsonObject();
            String nome = obj.get("place name").getAsString();
            Double longitude = Double.parseDouble(obj.get("longitude").getAsString());
            String estado = obj.get("state").getAsString();
            String abrebiaturaEstado = obj.get("state abbreviation").getAsString();
            Double latitude = Double.parseDouble(obj.get("latitude").getAsString());
<<<<<<< HEAD:1.08_codigoPostal/src/main/java/org/example/CPDeserializer.java
            al.add(new Lugar(nome,))

        }

        return new CodigoPostal(codigoPostal, pais, abrebiaturaPais);
=======

            todosLugares.add(new Lugar(nome, longitude, estado, abrebiaturaEstado, latitude));
        }

        return new CodigoPostal(codigoPostal, pais, abrebiaturaPais, todosLugares);
>>>>>>> 528ac8aa4a6ea8aa764e1344d1a4e154cbead6d1:CodigoPostal_1.08/src/main/java/org/example/CP_seriDeseri.java
    }

    @Override
    public JsonElement serialize(CodigoPostal src, Type typeOfSrc, JsonSerializationContext context) {
        return null;
    }
}
