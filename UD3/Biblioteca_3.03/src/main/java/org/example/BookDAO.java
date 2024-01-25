package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {


    public List<Book> getAllBooks() {

        try (EntityManager em = EntityManagerUtil.createInstance();) {

            ArrayList<Book> books = (ArrayList<Book>) em.createQuery("SELECT b FROM Book b", Book.class).getResultList();

            return books;
        }
    }

    public Book getBookById(long id) {

        try (EntityManager em = EntityManagerUtil.createInstance();) {

            Book book = em.find(Book.class, id);

            return book;
        }
    }

    public void insertOneBook(Book b) {
        try (EntityManager em = EntityManagerUtil.createInstance();) {

            em.getTransaction().begin();
            em.persist(b);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertListOfBooks(List<Book> books) {

    }

    public void deleteBook(Book b) {
        try (EntityManager em = EntityManagerUtil.createInstance();) {
            em.getTransaction().begin();
            em.remove(b);
            em.getTransaction().commit();
        }
    }

    public void updateBook(Book b) {
        try (EntityManager em = EntityManagerUtil.createInstance();) {
            em.getTransaction().begin();
            em.merge(b);
            em.getTransaction().commit();
        }
    }


}