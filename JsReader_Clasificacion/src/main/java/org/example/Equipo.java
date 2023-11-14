/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package org.example;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author pepecalo
 */
public class Equipo implements Comparable<Equipo>, Serializable {

    // nombre, victorias, derrotas, puntos a favor, puntos en contra.
    private final String nome;
    private String cidade;
    private int vitorias;
    private int derrotas;
    private int puntosFavor;
    private int puntosEnContra;

    public Equipo(String nome) {
        this.nome = nome;
    }

    public Equipo(String nome, int vitorias, int derrotas, int puntosFavor,
                  int puntosEnContra) {
        this.nome = nome;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.puntosFavor = puntosFavor;
        this.puntosEnContra = puntosEnContra;
    }

    public int getPartidosJugados() {
        return vitorias + derrotas;
    }

    public int getDiferenciaPuntos() {
        return puntosFavor - puntosEnContra;
    }

    public String getCidade() {
        return cidade;
    }

    public Equipo setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public int getPuntosEnContra() {
        return puntosEnContra;
    }

    public Equipo setPuntosEnContra(int puntosEnContra) {
        if (puntosEnContra >= 0) {
            this.puntosEnContra = puntosEnContra;
        }
        return this;
    }

    public int getPuntosFavor() {
        return puntosFavor;
    }

    public Equipo setPuntosFavor(int puntosFavor) {
        this.puntosFavor = puntosFavor;
        return this;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public Equipo setDerrotas(int derrotas) {
        this.derrotas = derrotas;
        return this;
    }

    public int getVitorias() {
        return vitorias;
    }

    public Equipo setVitorias(int vitorias) {
        this.vitorias = vitorias;
        return this;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int compareTo(Equipo equipo) {
        if (equipo == null) {
            throw new IllegalArgumentException("Non podes pasar nulos");
        }
        //return (puntosFavor > equipo.puntosFavor) ? 1 : ((puntosFavor == equipo.puntosFavor) ? 0 : -1);
        return Integer.compare(puntosFavor, equipo.puntosFavor);
    }

    @Override
    public String toString() {
        return String.format("%-20s %2d  %2d  %2d  %6d  %6d  %6d", nome.toUpperCase(),
                getPartidosJugados(), vitorias, derrotas, puntosFavor,
                puntosEnContra, getDiferenciaPuntos());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Equipo)) {
            return false;
        }
        return this.nome.equalsIgnoreCase(((Equipo) obj).nome);
    }

}
