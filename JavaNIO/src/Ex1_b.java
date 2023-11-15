import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Ex1_b {
    /*
     * b) Escribe un programa Java que copie un archivo en otro, sustituyéndolo si
     * existe, y lo mueva un archivo de una ubicación en otra, empleando Files.
     */

    public static void main(String[] args) {
        Path p1 = Paths.get("file.txt");
        if (!Files.exists(p1)) {
            try {
                Files.createFile(p1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Path p2 = Paths.get("file.txt");

        try {
            Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            Files.move(p1, Paths.get("src/fileMove.txt"), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

    }
}
