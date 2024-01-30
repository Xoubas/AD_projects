/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package org.example;

import jakarta.persistence.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Entity
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBook;
    private String isbn;
    private String titulo;
    private String autor;
    private Integer anho;
    private Boolean disponible;
    private byte[] portada;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private static final long serialVersionUID = 1L;

    public Book() {
    }

    public Book(String titulo, String autor, Integer year, Boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.anho = year;
        this.disponible = disponible;
    }

    public Book(String isbn, String titulo, String autor, Integer year,
                Boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anho = year;
        this.disponible = disponible;
    }

    public Book(String isbn, String titulo, String autor, Integer year,
                Boolean disponible, byte[] portada) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anho = year;
        this.disponible = disponible;
        this.portada = portada;
    }

    public Book(Integer idBook, String isbn, String titulo, String autor,
                Integer year, Boolean disponible, byte[] portada) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anho = year;
        this.disponible = disponible;
        this.portada = portada;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public Book setIdBook(Integer idBook) {
        this.idBook = idBook;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return titulo;
    }

    public Book setTitle(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getAuthor() {
        return autor;
    }

    public Book setAuthor(String autor) {
        this.autor = autor;
        return this;
    }

    public Integer getYear() {
        return anho;
    }

    public Book setAnho(Integer anho) {
        this.anho = anho;
        return this;
    }

    public Boolean isAvailable() {
        return disponible;
    }

    public Book setAvailable(Boolean disponible) {
        this.disponible = disponible;
        return this;
    }

    public byte[] getCover() {
        return portada;
    }

    public Book setCover(byte[] portada) {
        this.portada = portada;
        return this;
    }

    /**
     * Asigna la portada con flujos, leyendo los bytes.
     *
     * @param f
     */
    public Book setPortada(File f) {
        if (f == null || !f.exists())
            return this;
        Path p = Paths.get(f.getAbsolutePath());
        try (BufferedInputStream bi = new BufferedInputStream(Files.newInputStream(p));
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesLidos;
            while ((bytesLidos = bi.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesLidos);
            }

            portada = outputStream.toByteArray();
        } catch (FileNotFoundException ex) {
            System.err.println("Archivo no encontrado: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Erro de E/S: " + ex.getMessage());
        }
        return this;
    }

    /**
     * Asigna la portada con Java NIO, leyendo los bytes.
     *
     * @param file
     */
    public Book setPortada(String file) {
        try {
            Path ruta = Paths.get(file);
            portada = Files.readAllBytes(ruta);
        } catch (IOException ex) {
            System.err.println("Error de E/S: " + ex.getMessage());
        }
        return this;
    }

    public Image getImage() {
        if (portada != null) {
            try (ByteArrayInputStream bis = new ByteArrayInputStream(portada)) {
                return ImageIO.read(bis);
            } catch (IOException e) {
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        return Objects.equals(this.isbn, other.isbn);
    }

    @Override
    public String toString() {
        return idBook + "] [isbn: " + isbn + "] " + titulo + ". "
                + autor + " (" + anho + ") [" + ((disponible) ? '*' : ' ') + ']';
    }

}
