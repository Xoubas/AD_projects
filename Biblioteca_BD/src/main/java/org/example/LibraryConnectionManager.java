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
            //connection = DriverManager.getConnection("jdbc:h2:/home/stx/Databases/Library?user=admin&password=admin;DATABASE_TO_UPPER=false");
            String user = "admin";
            String password = "admin";
            String databaseURL = "jdbc:h2:/home/stx/Databases/Library;DATABASE_TO_UPPER=false";
            connection = DriverManager.getConnection(databaseURL, user, password);
        } catch (SQLException e) {
            System.err.println("Error getting connection" + e.getCause());
//            System.err.println("Error getting connection" + e.getMessage());
//            System.err.println("Error getting connection" + e.getErrorCode());
        }
        return connection;
    }
}
