package com.pepinho.ad.hibernate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

@Entity
@Table(name = "Alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlumno;

    private String nombre;

    private String apellidos;

    private int edad;

    private String direccion;

    // Consturctor vacío. Obligatorio para JPA
    public Alumno() {
    }

    // Constructor con todos los campos
    public Alumno(String nombre, String apellidos, int edad, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
    }

    public Alumno(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Alumno {" +
                "idAlumno=" + idAlumno +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
