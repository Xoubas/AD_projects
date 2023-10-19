import javax.swing.*;
import java.io.File;

public class Ex1_c {

	public static void main(String[] args) {
		/*
		 * c) Crea un programa Java que recoja una ruta de archivo como entrada del
		 * usuario (con JFileChooser) y muestre el nombre del archivo y su extensión en
		 * una ventana emergente (JOptionPane). Crea un Path y recupera la posición a
		 * partir del nombre del archivo (emplea el método lastIndexOf).
		 */

		// Crear un cuadro de diálogo para que el usuario seleccione un archivo
		JFileChooser fileChooser = new JFileChooser();
		int resultado = fileChooser.showOpenDialog(null);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			// Obtener el archivo seleccionado
			File archivoSeleccionado = fileChooser.getSelectedFile();

			// Obtener el nombre y la extensión del archivo
			String nombreArchivo = archivoSeleccionado.getName();
			String extensionArchivo = obtenerExtension(nombreArchivo);

			// Mostrar el nombre y la extensión en una ventana emergente
			String mensaje = "Nombre del archivo: " + nombreArchivo + "\nExtensión: " + extensionArchivo;
			JOptionPane.showMessageDialog(null, mensaje);
		}
	}

	// Método para obtener la extensión de un archivo a partir del nombre
	private static String obtenerExtension(String nombreArchivo) {
		int lastIndex = nombreArchivo.lastIndexOf(".");
		if (lastIndex > 0 && lastIndex < nombreArchivo.length() - 1) {
			return nombreArchivo.substring(lastIndex + 1);
		}
		return "Sin extensión";
	}
}
