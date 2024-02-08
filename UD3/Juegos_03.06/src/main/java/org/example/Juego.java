package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public class Juego {
    private int idJuego;
    @OneToOne
    @Column(name = "id_genero")
    private Genero genero;
    private int idPlataforma;
    private String titulo;
    private String miniatura;
    private String descripcionCorta;
    private String descripcion;
    private String url;
    private String editor;
    private String desarrollador;
    private LocalDate fecha;

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
