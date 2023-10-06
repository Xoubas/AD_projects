import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class WithURL {
	public static void main(String[] args) throws IOException {
		InputStream in = null;
		FileOutputStream out = null;

		do {
			try {
				String url = JOptionPane.showInputDialog(null, "Introduce URL: ");
				URL urlIn = new URL(url);
				in = urlIn.openStream();
				break;
			} catch (MalformedURLException e) {
				JOptionPane.showMessageDialog(null, "ERROR");
			}
		} while (true);

		JFileChooser save = new JFileChooser();

		do {
			save.showSaveDialog(null);
		} while (save.APPROVE_OPTION != save.showSaveDialog(null));

		File fileOut = save.getSelectedFile();
		out = new FileOutputStream(fileOut);

		int c;
		while ((c = in.read()) != -1)
			out.write(c);

		if (in != null)
			in.close();
		if (out != null)
			out.close();
	}
}
