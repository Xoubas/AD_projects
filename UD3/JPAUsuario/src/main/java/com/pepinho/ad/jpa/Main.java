package com.pepinho.ad.jpa;

import jakarta.persistence.EntityManager;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        EntityManager em = JPAUtil.getEntityManager();

//        Usuario user = new Usuario("Pepe", "Calo", "pepecalo@iessanclemente.net", "unavacaloca");

        em.getTransaction().begin();
        Usuario user = em.find(Usuario.class, 2);
//        em.persist(user);
        em.getTransaction().commit();
        System.out.println(user);



    }
}