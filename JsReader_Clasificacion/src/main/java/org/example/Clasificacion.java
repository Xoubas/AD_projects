/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author pepecalo
 */
public class Clasificacion implements Serializable {

    public static final String CABECERA = """
            *******************************************************
            EQUIPO               PJ  VI  DE   FAVOR  CONTRA  DIFER
            *******************************************************
            """;

    private final TreeSet<Equipo> equipos;

    public Clasificacion() {
        equipos = new TreeSet<>();
    }

    public boolean addEquipo(Equipo e) {
        return equipos.add(e);
    }

    public boolean removeEquipo(Equipo e) {
        return equipos.remove(e);
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder(CABECERA);
        for (Equipo e : equipos) {
            cadena.append(e).append(System.lineSeparator());
        }


//        // Con programación funcional
//        equipos.forEach(e -> {
//            cadena.append(e).append(System.lineSeparator());
//        });

        cadena.append(CABECERA);
        return cadena.toString();
    }

}
