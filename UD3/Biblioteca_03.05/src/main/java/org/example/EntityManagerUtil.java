package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static volatile EntityManagerFactory emInstance;

    private EntityManagerUtil() {
    }

    public static EntityManagerFactory createInstance() {

        if (emInstance == null) {
            synchronized (EntityManagerUtil.class) {
                if (emInstance == null) {
                    emInstance = Persistence.createEntityManagerFactory("bookJPA");
                }
            }
        }
        return emInstance;
    }
}
