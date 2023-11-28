package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LibraryConnectionManager {
    private static volatile LibraryConnectionManager instance;
    private Connection connection;

    private LibraryConnectionManager() {
    }

    public static LibraryConnectionManager getInstance() {
        if (instance == null) {
            synchronized (LibraryConnectionManager.class) {
                if (instance == null) {
                    instance = new LibraryConnectionManager();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:/home/stx/Documents/AD/AD_projects/BasesDatos/Library?user=admin&password=abc123.");
//            String user = "admin";
//            String password = "abc123.";
//            String databaseURL = "jdbc:h2:/home/sanclemente.local/a21javierbq/Documentos/AD/AD_projects/Bases de datos/Biblioteca";
//            DriverManager.getConnection(databaseURL, user, password);
        } catch (SQLException e) {
            System.err.println("Error getting connection" + e.getMessage());
        }
        return connection;
    }
}
