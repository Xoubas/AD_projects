package org.example;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Plataforma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String plataforma;
    private String nombre;
}
