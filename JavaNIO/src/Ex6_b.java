import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

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

c) A modo de repaso de Stream, hazlo aplicando el mismo método, pero creando un
Stream con el array de archivos.
i. Stream<File> flujo = Stream.of(new File(dir).listFiles()); // Crea un
Stream
ii. Aplica un filtro para ver si es archivo o directorio.
iii. Aplica un mapa obtener el nombre de los archivos.
iv. Muestra los archivos recorriéndolos.
 */
public class Ex6_b {
    public static ArrayList<String> walkDirectories(File file) {
        ArrayList<String> allFiles = new ArrayList<>();
        if (file.isDirectory()) {
            File[] fa = file.listFiles();
            if (fa != null) {
                for (File f : fa)
                    allFiles.addAll(walkDirectories(f));
            }
        } else {
            allFiles.add(file.getName());
        }
        return allFiles;
    }

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            ArrayList<String> allFiles = walkDirectories(file);
            for (String s : allFiles) {
                System.out.println(s);
            }
        }


    }
}
