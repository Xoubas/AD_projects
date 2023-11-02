import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/*
Emplea un JFileChooser para seleccionar la carpeta a explorar. Además, debe
realizar la comprobación de la existencia y de que es un directorio.
Realiza un programa que muestre el listado del contenido de un directorio de
los siguientes modos:

e) Con Files.walk:
Haz uso del método:
public static Stream<Path> walk(Path start, FileVisitOption... options)
Que devuelve un Stream a recorrer el árbol desde un directorio dado. El
recorrido se hace en profundidad.
 */
public class Ex6_e {
    public static void walkDirectories(Path path) {
        if (Files.isDirectory(path) && Files.exists(path)) {
            try (Stream<Path> files = Files.walk(path, FileVisitOption.FOLLOW_LINKS)) {
                files.forEach(System.out::println);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            Ex6_e.walkDirectories(file.toPath());
        }
    }
}
