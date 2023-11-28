package org.example;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Book implements Serializable {
    private Long idBook;
    private String isbn;
    private String title;
    private String author;
    private Integer year;
    private Boolean available;
    private byte[] cover;

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(idBook, book.idBook) && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(year, book.year) && Objects.equals(available, book.available) && Arrays.equals(cover, book.cover);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idBook, isbn, title, author, year, available);
        result = 31 * result + Arrays.hashCode(cover);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", available=" + available +
                ", cover=" + Arrays.toString(cover) +
                '}';
    }
}
