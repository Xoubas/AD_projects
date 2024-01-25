package com.pepinho.programacion.biblioteca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {

    private static volatile EntityManager emfInstance;

    private EntityManagerUtil() {
    }

    public static EntityManager createInstance() {

        if (emfInstance == null) {
            synchronized (EntityManager.class) {
                if (emfInstance == null) {
                    emfInstance = Persistence.createEntityManagerFactory("bookJPA").createEntityManager();
                }
            }
        }
        return emfInstance;
    }
}
