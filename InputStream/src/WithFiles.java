import java.io.*;
import javax.swing.*;

public class WithFiles {
	public static void main(String[] args) throws IOException {
		String fileIn = JOptionPane.showInputDialog(null, "Introduce URL: ");
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			JFileChooser save = new JFileChooser();
			in = new FileInputStream(fileIn);

//			do {
//				save.showSaveDialog(null);
//			} while (save.APPROVE_OPTION != 0);

			File fileOut = save.getSelectedFile();
			out = new FileOutputStream(fileOut);

			int c;
			while ((c = in.read()) != -1)
				out.write(c);

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "ERROR");
			System.exit(1);
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}
}
