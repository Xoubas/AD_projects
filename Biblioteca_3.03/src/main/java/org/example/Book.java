package org.example;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBook;
    private String isbn;
    private String titulo;
    private String autor;
    private int ano;
    private boolean disponible;
    private byte[] portada;

    public Book() {
    }

    public Book(String isbn, String titulo, String autor, int ano, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponible = disponible;
    }

    public Book(long idBook, String isbn, String titulo, String autor, int ano, boolean disponible, byte[] portada) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponible = disponible;
        this.portada = portada;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(byte[] portada) {
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
        if (disponible) {
            return "Book{" +
                    "titulo='" + titulo + '\'' +
                    ", autor='" + autor + '\'' +
                    ", ano=" + ano +
                    '}';
        } else {
            return "*";
        }
    }
}

