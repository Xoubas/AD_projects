package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "XOGADOR")
public class Xogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idXogador;
    private String nome;
    private int dorsal;

    @Lob
    private byte[] foto;

    private LocalDate dataNacemento;

    public Xogador(String nome, int dorsal) {
        this.nome = nome;
        this.dorsal = dorsal;
        dataNacemento = LocalDate.now();
        foto = new byte[0];
    }

    public Xogador() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public long getIdXogador() {
        return idXogador;
    }

    public void setIdXogador(long idXogador) {
        this.idXogador = idXogador;
    }

    public LocalDate getDataNacemento() {
        return dataNacemento;
    }

    public void setDataNacemento(LocalDate dataNacemento) {
        this.dataNacemento = dataNacemento;
    }



    @Override
    public String toString() {
        return "Xogador{" +
                "idXogador=" + idXogador +
                ", nome='" + nome + '\'' +
                ", dorsal=" + dorsal +
                '}';
    }
}
