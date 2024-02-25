package org.example.dao;

import com.google.gson.*;
import org.example.model.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SerDesJuego implements JsonSerializer<Juego>, JsonDeserializer<Juego> {
    @Override
    public JsonElement serialize(Juego src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("idJuego", src.getIdJuego());
        JsonObject generoJson = new JsonObject();
        Genero genero = src.getGenero();
        if (genero != null) {
            generoJson.addProperty("idGenero", genero.getIdGenero());
            generoJson.addProperty("nombre", genero.getNombre());
        }
        jsonObject.add("genero", generoJson);

        JsonObject plataformaJson = new JsonObject();
        Plataforma plataforma = src.getPlataforma();
        if (plataforma != null) {
            plataformaJson.addProperty("plataforma", plataforma.getPlataforma());
            plataformaJson.addProperty("nombre", plataforma.getNombre());
        }
        jsonObject.add("plataforma", plataformaJson);

        jsonObject.addProperty("idPlataforma", src.getIdPlataforma());
        jsonObject.addProperty("titulo", src.getTitulo());
        jsonObject.addProperty("miniatura", src.getMiniatura());
        jsonObject.addProperty("descripcionCorta", src.getDescripcionCorta());
        jsonObject.addProperty("descripcion", src.getDescripcion());
        jsonObject.addProperty("url", src.getUrl());
        jsonObject.addProperty("editor", src.getEditor());
        jsonObject.addProperty("desarrollador", src.getDesarrollador());

        // Serialize LocalDate using a formatter
        if (src.getFecha() != null) {
            jsonObject.addProperty("fecha", src.getFecha().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }

        JsonObject requisitosJson = new JsonObject();
        Requisitos requisitos = src.getRequisitos();

        if (requisitos != null) {
            requisitosJson.addProperty("almacenamiento", requisitos.getAlmacenamiento());
            requisitosJson.addProperty("graficos", requisitos.getGraficos());
            requisitosJson.addProperty("memoria", requisitos.getMemoria());
            requisitosJson.addProperty("os", requisitos.getOs());
            requisitosJson.addProperty("procesador", requisitos.getProcesador());
            jsonObject.add("requisitosJuego", requisitosJson);
        }

        // Serialize the list of Imagen
//        JsonArray imagenesArray = new JsonArray();
//        if (src.getImagenes() != null) {
//            for (Imagen imagen : src.getImagenes()) {
//                JsonObject imagenJson = new JsonObject();
//                imagenJson.addProperty("idImagen", imagen.getIdImagen());
//                imagenJson.addProperty("idJuego", imagen.getJuego()); // This might be redundant if already clear from the context
//                imagenJson.addProperty("url", imagen.getUrl());
//                imagenesArray.add(imagenJson);
//            }
//        }
//        jsonObject.add("imagenes", imagenesArray);

        return jsonObject;
    }

    @Override
    public Juego deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        Juego juego = new Juego();
        juego.setIdJuego(jsonObject.get("idJuego").getAsInt());
        juego.setTitulo(jsonObject.get("titulo").getAsString());
        juego.setMiniatura(jsonObject.get("miniatura").getAsString());
        juego.setDescripcionCorta(jsonObject.get("descripcionCorta").getAsString());
        juego.setDescripcion(jsonObject.get("descripcion").getAsString());
        juego.setUrl(jsonObject.get("url").getAsString());
        juego.setEditor(jsonObject.get("editor").getAsString());
        juego.setDesarrollador(jsonObject.get("desarrollador").getAsString());

        if (jsonObject.has("fecha")) {
            LocalDate fecha = LocalDate.parse(jsonObject.get("fecha").getAsString(), DateTimeFormatter.ISO_LOCAL_DATE);
            juego.setFecha(fecha);
        }

        // Deserialize Genero
        JsonObject generoJson = jsonObject.getAsJsonObject("genero");
        if (generoJson != null) {
            Genero genero = new Genero();
            genero.setIdGenero(generoJson.get("idGenero").getAsString());
            genero.setNombre(generoJson.get("nombre").getAsString());
            juego.setGenero(genero);
        }

        // Deserialize Plataforma
        JsonObject plataformaJson = jsonObject.getAsJsonObject("plataforma");
        if (plataformaJson != null) {
            Plataforma plataforma = new Plataforma();
            plataforma.setPlataforma(plataformaJson.get("plataforma").getAsString());
            plataforma.setNombre(plataformaJson.get("nombre").getAsString());
            juego.setPlataforma(plataforma);
        }

        // Deserialize RequisitosJuego
        JsonObject requisitosJson = jsonObject.getAsJsonObject("requisitosJuego");
        if (requisitosJson != null) {
            Requisitos requisitos = new Requisitos();
            // Assuming Requisitos class has setters for each field
            requisitos.setAlmacenamiento(requisitosJson.get("almacenamiento").getAsInt());
            requisitos.setGraficos(requisitosJson.get("graficos").getAsString());
            requisitos.setMemoria(requisitosJson.get("memoria").getAsString());
            requisitos.setOs(requisitosJson.get("os").getAsString());
            requisitos.setProcesador(requisitosJson.get("procesador").getAsString());
            juego.setRequisitos(requisitos);
        }

        // Deserialize list of Imagen
//        if (jsonObject.has("imagenes")) {
//            JsonArray imagenesArray = jsonObject.getAsJsonArray("imagenes");
//            List<Imagen> imagenes = new ArrayList<>();
//            for (JsonElement elem : imagenesArray) {
//                JsonObject imagenJson = elem.getAsJsonObject();
//                Imagen imagen = new Imagen();
//                imagen.setIdImagen(imagenJson.get("idImagen").getAsInt());
//                imagen.setIdJuego(imagenJson.get("idJuego").getAsInt()); // Adjust based on actual Imagen class structure
//                imagen.setUrl(imagenJson.get("url").getAsString());
//                imagenes.add(imagen);
//            }
//            juego.setImagenes(imagenes);
//        }

        return juego;
    }
}
