import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ex3 {
    /*
    Escribid un programa en Java que, empleando las clases de Java NIO 2, liste los
    archivos de un directorio por medio del método list(). Debe mostrar sólo los
    archivos fuente Java, no los directorios que contiene. Recuerda el uso de filtros en
    Stream y de forEach.
     */
    public static void showFiles(Path directory) {
        if (!Files.isDirectory(directory) && directory.getFileName().toString().endsWith(".java")) {
            System.out.println(directory.toString());
        } else if (Files.isDirectory(directory)) {
            Stream<Path> paths = null;
            try {
                paths = Files.list(directory);
                //Same as p->showFiles(p);
                paths.forEach(Ex3::showFiles);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                paths.close();
            }
        }
    }

    public static void main(String[] args) {
        Path p = Paths.get("/home/stx/Documents");
        Ex3.showFiles(p);
    }
}
