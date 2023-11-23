package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        LibraryConnectionManager lc = LibraryConnectionManager.getInstance();
        Connection con = lc.getConnection();

        if (con != null) {
            System.out.println("Conexión establecida");
        } else {
            System.out.println("Nanai");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un titulo: ");
        String titulo = sc.nextLine();

        if (con != null) {
            try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                ResultSet rs = st.executeQuery("SELECT * FROM Book WHERE title LIKE '%" + titulo + "%'");

                if (rs.next()) {
                    System.out.println(rs.getString("idBook") + "" + rs.getString("title"));
                    while (rs.next()) {
                        System.out.println(rs.getString("idBook") + "" + rs.getString("title"));
                    }
                    rs.absolute(1);
                    rs.next();
                }
//
//            if (rs.next()) {
//                System.out.println(rs.getString("idBook") + "" + rs.getString("title"));
//                rs.rowUpdated()
//            }

//            rs.last();
//            do {
//                System.out.println(rs.getString("title"));
//            } while (rs.previous());

                //rs.previous();
                System.out.println(rs.getString("title"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}