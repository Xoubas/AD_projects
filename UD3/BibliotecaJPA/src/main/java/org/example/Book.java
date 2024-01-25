package org.example;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="Book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBook;
    private String isbn;
    private String titulo;
    private String autor;
    private Integer ano;
    private Boolean disponible;
    private byte[] portada;

    public Book() {
    }

    public Book(String isbn, String titulo, String autor, Integer ano, Boolean disponible, byte[] portada) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponible = disponible;
        this.portada = portada;
    }

    public Book(long idBook, String isbn, String titulo, String autor, Integer ano, Boolean disponible, byte[] portada) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponible = disponible;
        this.portada = portada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        if (disponible == true) {
            return
                    "titulo='" + titulo +
                            ", autor='" + autor +
                            ", ano=" + ano;
        } else {
            return "titulo='" + titulo +
                    ", autor='" + autor +
                    ", ano=" + ano + "*";
        }

    }
}
