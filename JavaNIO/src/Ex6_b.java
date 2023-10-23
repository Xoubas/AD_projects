import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

/*
Emplea un JFileChooser para seleccionar la carpeta a explorar. Además, debe
realizar la comprobación de la existencia y de que es un directorio.
Realiza un programa que muestre el listado del contenido de un directorio de
los siguientes modos:

b) De manera recursiva muestre todo el contenido, incluidos subdirectorios:
Crea un ArrayList para guardar las rutas.
Crea un método recorrer, que, de manera recursiva recoja el archivo o
directorio:
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
            System.out.println(allFiles);
        }
    }
}
