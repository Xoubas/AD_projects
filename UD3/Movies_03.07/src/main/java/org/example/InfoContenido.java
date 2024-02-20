package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class InfoContenido {
    private String titulo;
    private String genero;
    private String pais;
    private int duracion;
    @Column(name = "ano")
    private int año;
    private String sinopsis;

    public InfoContenido() {
    }

    public InfoContenido(String titulo, String genero, String pais, int duracion, int año, String sinopsis) {
        this.titulo = titulo;
        this.genero = genero;
        this.pais = pais;
        this.duracion = duracion;
        this.año = año;
        this.sinopsis = sinopsis;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
