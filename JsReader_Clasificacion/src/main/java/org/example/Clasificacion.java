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
 *
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

    /**
     * Versión estática que recoge archivo y objeto a guardar.
     *
     * @param archivo nombre del archivo.
     * @param c Objeto de tipo Clasificación a guardar.
     * @return
     */
    public static boolean saveClasificion(String archivo, Clasificacion c) {
        try ( ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(archivo)));) {
            oos.writeObject(c);
        } catch (IOException ex) {
            System.out.println("Erro de Entrada/Saída");
            return false;
        }
        return true;
    }

    /**
     * Versión de instancia. Recoge sólo el nombre del archivo y guarda el
     * propio objeto.
     *
     * @param archivo archivo con la ruta.
     * @return si lo ha guardado o no.
     */
    public boolean saveClasificion(String archivo) {
        return saveClasificion(archivo, this);
    }

    /**
     * Método estático que devuelve la clasificación guardada en el archivo
     * recogido como parámetro.
     *
     * @param archivo nombre del archivo. Inclida la ruta.
     * @return la clasificación guardada en el archivo.
     */
    public static Clasificacion loadClasificacion(String archivo) {
        Clasificacion clasificacion = null;
        try ( ObjectInputStream oos = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(archivo)));) {
            clasificacion = (Clasificacion) oos.readObject();
        } catch (IOException ex) {
            System.out.println("Erro de Entrada/Saída");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase non atopada");
        }
        return clasificacion;
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
