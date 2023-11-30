package org.example;

import java.sql.*;
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

        DatabaseMetaData estructura = con.getMetaData();

        try (ResultSet rs = estructura.getTables(null, null, null, new String[]{"TABLE"})) {
            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }
        }


        System.out.println("Introduce un titulo: ");
        String titulo = sc.nextLine();

        if (con != null && !con.isClosed()) {


            try (PreparedStatement
                         st = con.prepareStatement("Select idBook, titulo FROM Book")) {
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    System.out.println(rs.getString("idBook") + "" + rs.getString("titulo"));
                    while (rs.next()) {
                        System.out.println(rs.getString("idBook") + "" + rs.getString("titulo"));
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