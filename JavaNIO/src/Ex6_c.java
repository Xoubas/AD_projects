import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/*
Emplea un JFileChooser para seleccionar la carpeta a explorar. Además, debe
realizar la comprobación de la existencia y de que es un directorio.
Realiza un programa que muestre el listado del contenido de un directorio de
los siguientes modos:

c) A modo de repaso de Stream, hazlo aplicando el mismo método, pero creando un
Stream con el array de archivos.
i. Stream<File> flujo = Stream.of(new File(dir).listFiles()); // Crea un
Stream
ii. Aplica un filtro para ver si es archivo o directorio.
iii. Aplica un mapa obtener el nombre de los archivos.
iv. Muestra los archivos recorriéndolos.
 */
public class Ex6_c {
    public static void walkDirectories(Path path) {
        if (Files.isDirectory(path) && Files.exists(path)) {
            try (Stream<Path> allFiles = Files.list(path)) {
                allFiles.forEach(p -> walkDirectories(p));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(path.getFileName().toString());
        }
    }

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            Ex6_c.walkDirectories(file.toPath());
        }
    }
}
