import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex2 {
    /*
    Escribir un programa en Java que, empleando las clases de Java NIO 2 Path y
    File, cree un directorio (con toda la ruta) y un archivo vacío dentro de ese directorio.
     */
    public static void main(String[] args) {
        Path dirPath = Paths.get("C:\\Users\\quinb\\Desktop");

        try {
            Files.createDirectories(dirPath);
            String file = "cosa.txt";

            Path filePath = Path.of(dirPath.toString(), file);
            Files.createFile(filePath);
            System.out.println("File created: " + file);

        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
