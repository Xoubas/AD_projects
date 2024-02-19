package org.example;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idGenero;
    private String nombre;
}
