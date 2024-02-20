package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class Juego {
    @Id
    private int idJuego;
    @ManyToOne
    @JoinColumn(name = "idGenero")
    private Genero genero;
    @ManyToOne
    @JoinColumn(name="idPlataforma")
    private Plataforma plataforma;
    private int idPlataforma;
    private String titulo;
    private String miniatura;
    private String descripcionCorta;
    private String descripcion;
    private String url;
    private String editor;
    private String desarrollador;
    private LocalDate fecha;
    @OneToMany(mappedBy = "juego")
    private List<Imagen> imagenes;
}
