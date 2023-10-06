import java.io.IOException;
import javax.swing.*;

class Classmain {
	public static void main(String[] args) {
//		JOptionPane.showMessageDialog(null, "Tururu", "Jajajajaja", 0);
//		String name = JOptionPane.showInputDialog(null, "Introduce your name: ");
//		
//		if (name != null)
//			JOptionPane.showConfirmDialog(null, "Hola " + name);

		int val = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
		if (val == JOptionPane.OK_OPTION)
			System.out.println("Adios");
	}
}