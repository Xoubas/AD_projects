package org.example;

import java.io.Serializable;

public class Book implements Serializable {
    private Long idBook;
    private String isbn;
    private String title;
    private String author;
    private Integer year;
    private Boolean available;
    private byte[] cover;
}
