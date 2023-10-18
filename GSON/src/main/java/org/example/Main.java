package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.List;

import static java.lang.System.*;

public class Main {
    private String materia;
    private Date fecha;
    private List<String> participantes;

    public Main() {
        // Constructor vacío necesario para JSON-B
    }

    public Main(String materia, Date fecha, List<String> participantes) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
// Crear exame
        Main exame = new Main("Acceso a Datos",
                Date.from(LocalDateTime.of(2023, 11, 12, 9, 45).atZone(ZoneId.systemDefault()).toInstant()),
                List.of("Gabriela Mistral",
                        "Silvina Ocampo",
                        "Juana de Ibarbourou",
                        "Carmen Conde",
                        "Claribel Alegría"));

        Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat(3).create();
        gson.toJson(exame);
        try {
            Files.createFile(Paths.get("exame.json"));
            Files.write

        } catch (FileAlreadyExistsException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}