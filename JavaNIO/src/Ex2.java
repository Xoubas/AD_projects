import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Ex2 {
    /*
    Escribir un programa en Java que, empleando las clases de Java NIO 2 Path y
    File, cree un directorio (con toda la tura) y un archivo vacío dentro de ese directorio.
     */
    public static void main(String[] args) {
        String directory = "/home/stx/Desktop";
        Path dirPath = Paths.get(directory);

        try {
            Files.createDirectories(dirPath);
            String fileName = "file.txt";
            Path filePath = Paths.get(directory, fileName);

            Files.createFile(filePath);
            System.out.println("File created: " + fileName);

        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
