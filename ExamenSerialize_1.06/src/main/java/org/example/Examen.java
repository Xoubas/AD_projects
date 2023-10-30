package org.example;

import com.google.gson.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Examen {

    private String materia;
    private LocalDateTime fecha;
    private List<String> participantes;

    public Examen() {
        // Constructor vacío necesario para JSON-B
    }

    public Examen(String materia, LocalDateTime fecha, List<String> participantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.participantes = participantes;
    }

    // Métodos getter y setter
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Materia: ").append(materia)
                .append("\nFecha: ").append(fecha)
                .append("\nParticipantes: ").append(participantes);
        return sb.toString();
    }

    public static void main(String[] args) {

        // Crear Examen
        Examen Examen = new Examen("Acceso a Datos",
                LocalDateTime.of(2023, 11, 12, 9, 45),
                List.of("Gabriela Mistral",
                        "Silvina Ocampo",
                        "Juana de Ibarbourou",
                        "Carmen Conde",
                        "Claribel Alegría"));

        System.out.println(Examen);

        // Convertir Examen a JSON y guardarlo en un archivo
        saveExamToJSON(Examen, "accesoADatos.json");

        // Mostrar contenido del archivo por pantalla
        showFile("accesoADatos.json");

        // Recuperar Examen desde el archivo
        Examen exameFromJson = getExamenFromJSON("accesoADatos.json");

        // Mostrar el Examen recuperado por pantalla
        System.out.println("\nExamen Recuperado:");
        System.out.println(exameFromJson);
    }

    private static void saveExamToJSON(Examen examen, String nombreArchivo) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerizalize())
                .create(); //yyyy-MM-dd'T'HH:mm:ss.SSSZ

        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(nombreArchivo))) {
            gson.toJson(examen, bw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showFile(String nombreArchivo) {
        try {
            String contenido = Files.readString(Path.of(nombreArchivo));
            System.out.println("\nContenido del archivo "
                    + nombreArchivo + " JSON:" + System.lineSeparator()
                    + contenido);
        } catch (IOException e) {
            System.err.println("Error ES: " + e.getMessage());
        }
    }

    private static Examen getExamenFromJSON(String nombreArchivo) {
//        var gson = new Gson();
        var gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                    @Override
                    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

                        LocalDateTime fecha = null;
                        String fechastr = json.getAsString();
                        System.out.println("Fecha: " + fechastr);
                        String[] campos = fechastr.split("[\\s:-]");
                        fecha = LocalDateTime.of(parseInt(campos[0]), parseInt(campos[1]), parseInt(campos[2]), parseInt(campos[3]), parseInt(campos[4]));
                        return fecha;
                    }
                })
                .create(); //yyyy-MM-dd'T'HH:mm:ss
        try {
            String examenJSON = Files.readString(Path.of(nombreArchivo));
            return gson.fromJson(examenJSON, Examen.class);
        } catch (IOException e) {
            System.err.println("Error ES: " + e.getMessage());
        }
        return null;
    }
}
