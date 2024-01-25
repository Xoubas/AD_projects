package org.example;

import jakarta.persistence.EntityManager;
import org.example.model.Xogador;

public class AppBasket {
    public static void main(String[] args) {
        System.out.println("Creando EntityManager");
        EntityManager em = JPAUtil.getEntityManager();
        Xogador xogador = new Xogador("Pepe", 69);

        em.getTransaction().begin();
        em.persist(xogador);
        em.getTransaction().commit();
    }
}
