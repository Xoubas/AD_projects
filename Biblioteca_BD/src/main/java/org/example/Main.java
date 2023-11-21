package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        LibraryConnectionManager lc = LibraryConnectionManager.getInstance();
        Connection con = lc.getConnection();

        if (con != null) {
            System.out.println("Conexión establecida");
        } else {
            System.out.println("Nanai");
        }

        try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet rs = st.executeQuery("SELECT * FROM Book");
            while (rs.next()) {
                System.out.println(rs.getString("title"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}