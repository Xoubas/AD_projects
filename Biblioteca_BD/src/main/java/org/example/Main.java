package org.example;

import java.io.OutputStream;
import java.io.Writer;
import java.sql.*;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void simpleQuery(Connection con) {
        String query = "SELECT idBook,title,isbn,author,pubYear from Book";
        try {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String idBook = rs.getString("idBook");
                String title = rs.getString("title");
                String isbn = rs.getString("isbn");
                System.out.println(idBook + " " + title + " " + isbn);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rowQuery(Connection con) {
        String query = "SELECT idBook,title,isbn,author,pubYear from Book";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + " " + rs.getString(2)
                        + " " + rs.getString(3)
                        + " " + rs.getString(4)
                        + " " + rs.getInt(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void batchInsertion(Connection con) throws SQLException {
        try (Statement st = con.createStatement()) {
            st.addBatch("INSERT INTO Book (title, isbn, author, pubYear)" +
                    "VALUES('Viaje al Centro de la Tierra', '1234567890', 'Julio Verne', 1944)");
            st.addBatch("INSERT INTO Book (title, isbn, author, pubYear)" +
                    "VALUES('Capitán de 15 años', '1234879590', 'Julio Verne', 1960)");
            st.addBatch("INSERT INTO Book (title, isbn, author, pubYear)" +
                    "VALUES('20000 Leguas de Viaje Submarino', '1287167890', 'Julio Verne', 1921)");

            int[] updateBooks = st.executeBatch();
            con.commit();
        } catch (BatchUpdateException b) {
            throw new RuntimeException(b);
        } finally {
            con.setAutoCommit(true);
        }

    }

    public static void preparedInsertion(Connection con) throws SQLException {
        con.setAutoCommit(false);
        PreparedStatement st = con.prepareStatement("INSERT INTO Book (title, isbn, author, pubYear)" +
                "VALUES(?,?,?,?)");

        st.setString(1, "Piedra de Viaje");
        st.setString(2, "5153546513779");
        st.setString(3, "José Pérez");
        st.setInt(4, 2000);
        st.addBatch();

        st.setString(1, "Cielo azul");
        st.setString(2, "554716513783");
        st.setString(3, "Luisa González");
        st.setInt(4, 2015);
        st.addBatch();

        int[] updateBooks = st.executeBatch();
        con.commit();
        con.setAutoCommit(true);
    }

    public static void preparedUpdate(Connection con) {
        String query = "SELECT idBook,title,isbn,author,pubYear from Book";
        try {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String idBook = rs.getString("idBook");
                String title = rs.getString("title");
                String isbn = rs.getString("isbn");
                System.out.println(idBook + " " + title + " " + isbn);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //This is where the prepareStatement starts
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce title: ");
        String book = sc.nextLine();
        System.out.println("Change title of: ");
        int idBook = sc.nextInt();

        String updateBook = "UPDATE Book SET title=? WHERE idBook=?";
        try (PreparedStatement ps = con.prepareStatement(updateBook)) {
            con.setAutoCommit(false);
            ps.setString(1, book);
            ps.setInt(2, idBook);
            ps.executeUpdate();

            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    //Clob objects
    public void addDescripcionProducto(String nome, String nomeArquivo, Connection con) throws SQLException {
        // Cfreación del objeto Clob:
        Clob clobDescripcion = con.createClob();

        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO Producto VALUES(?,?)");
             Writer clobWriter = clobDescripcion.setCharacterStream(1);) {
            // setCharacterStream devuelve un objeto Writer y recibe un entero que indica la posición inicial del Clob.

            String str = readFile(nomeArquivo, clobWriter); // Lee el conteido del archivo.
            System.out.println("Escribo el texto: " + clobWriter.toString());

            // Si el archivo es demasiado grande, se puede escribir en el Clob en trozos.
            clobDescripcion.setString(1, str);

            System.out.println("Longitud del clob: " + clobDescripcion.length());
            pstmt.setString(1, nome);
            pstmt.setClob(2, clobDescripcion); // Se añade el Clob al PreparedStatement.
            pstmt.executeUpdate();

        } catch (SQLException sqlex) {
            // Gestión de excepciones.
        } catch (Exception ex) {
            System.out.println("Excepción no esperada: " + ex.toString());
        }
    }

    public String getDescripcion(String nome, int numeroCaracteres, Connection con) throws SQLException {

        String descripcion = null;
        Clob clobDescripcion = null;
        String sql = "select descripcion from Producto where nome = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                clobDescripcion = rs.getClob(1);
                System.out.println("Lonxitude do Clob: " + clobDescripcion.length());
            }
            descripcion = clobDescripcion.getSubString(1, numeroCaracteres);
        } catch (SQLException sqlex) {
            // Tratamiento de excepciones.
        } catch (Exception ex) {
            System.out.println("Excepción: " + ex.toString());
        }
        return descripcion;
    }

    //Blob object
    public void addImagenProducto(String nome, String nomeArquivo, Connection con) throws SQLException {
        // Creación del objeto Blob:
        Blob blobImagen = con.createBlob();

        try (PreparedStatement pstmt = this.con.prepareStatement("INSERT INTO Producto VALUES(?,?)");
             OutputStream blobOutputStream = blobImagen.setBinaryStream(1);) {
            // setBinaryStream devuelve un objeto OutputStream y recibe un entero que indica la posición inicial del Blob.

            byte[] bytes = readFile(nomeArquivo, blobOutputStream); // Lee el conteido del archivo.
            System.out.println("Escribo el texto: " + blobOutputStream.toString());

            // Si el archivo es demasiado grande, se puede escribir en el Blob en trozos.
            blobImagen.setBytes(1, bytes);

            System.out.println("Longitud del blob: " + blobImagen.length());
            pstmt.setString(1, nome);
            pstmt.setBlob(2, blobImagen); // Se añade el Blob al PreparedStatement.
            pstmt.executeUpdate();

        } catch (SQLException sqlex) {
            // Gestión de excepciones.
        } catch (Exception ex) {
            System.out.println("Excepción no esperada: " + ex.toString());
        }
    }

    private String readFile(String nomeArquivo, Writer writer) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String nextLine = "";
            StringBuffer sb = new StringBuffer();
            while ((nextLine = br.readLine()) != null) {
                System.out.println("Escribiendo: " + nextLine);
                writer.write(nextLine);
                sb.append(nextLine);
            }
            // Convertir el contenido en una cadena
            String datosClob = sb.toString();
            // devolución de los datos.
            return datosClob;
        }
    }

    public static void main(String[] args) throws SQLException {
        LibraryConnectionManager lc = LibraryConnectionManager.getInstance();
        Connection con = lc.getConnection();

        if (con != null) {
            System.out.println("Conexión establecida");
        } else {
            System.out.println("Nanai");
            throw new RuntimeException("Error de conexión");
        }

        Scanner sc = new Scanner(System.in);

        DatabaseMetaData estructura = con.getMetaData();

        try (ResultSet rs = estructura.getTables(null, null, null, new String[]{"TABLE"})) {
            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }
        }
//        simpleQuery(con);
//        rowQuery(con);
//        batchInsertion(con);
//        preparedInsertion(con);
//        preparedUpdate(con);
        addImagenProducto();


//    System.out.println("Introduce un titulo: ");
//    String titulo = sc.nextLine();
//
//    if (con != null && !con.isClosed()) {


//            try (PreparedStatement
//                         st = con.prepareStatement("Select idBook, titulo FROM Book")) {
//                ResultSet rs = st.executeQuery();
//
//                if (rs.next()) {
//                    System.out.println(rs.getString("idBook") + "" + rs.getString("titulo"));
//                    while (rs.next()) {
//                        System.out.println(rs.getString("idBook") + "" + rs.getString("titulo"));
//                    }
//                    rs.absolute(1);
//                    rs.next();
//                }
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
//                System.out.println(rs.getString("title"));
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }

    }
}