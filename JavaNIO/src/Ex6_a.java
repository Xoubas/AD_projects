import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/*
Emplea un JFileChooser para seleccionar la carpeta a explorar. Además, debe
realizar la comprobación de la existencia y de que es un directorio.
Realiza un programa que muestre el listado del contenido de un directorio de
los siguientes modos:
a) Repite el ejercicio anteriormente realizado que muestre el contenido de todos los
archivos y directorios de una carpeta dada con el método listFiles() de File, pero a
partir de un Path.
El método listFiles() devuelve una array de objetos File que son el contenido
del directorio:
b) De manera recursiva muestre todo el contenido, incluidos subdirectorios:
Crea un ArrayList para guardar las rutas.
Crea un método recorrer, que, de manera recursiva recoja el archivo o
directorio:
 */
public class Ex6_a {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(null);


        if (result == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();

            if (Files.isDirectory(file) && Files.exists(file))
                System.out.println("The chosen file is a directory");

            else
                System.err.println("The chosen file isn't a directory");

            File[] fa = file.toFile().listFiles();

            for(File f : fa)
                System.out.println(f);
        }
    }
}
