package org.example;

import jakarta.persistence.*;

public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPelicula;
    @Embedded
    @AttributeOverride(name = "pais", column = @Column(name ="paisPelicula"))
    private InfoContenido informacion;

    public Pelicula() {
    }

    public Pelicula(long idPelicula, InfoContenido informacion) {
        this.idPelicula = idPelicula;
        this.informacion = informacion;
    }

    public long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public InfoContenido getInformacion() {
        return informacion;
    }

    public void setInformacion(InfoContenido informacion) {
        this.informacion = informacion;
    }
}
