package com.pepinho.ad.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = // equivalencia SessionFactory
            Persistence.createEntityManagerFactory("miUnidadDePersistencia");

    public static EntityManager getEntityManager(){ // equivalencia Session
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
