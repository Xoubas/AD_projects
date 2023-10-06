import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;

public class Classmain {
	public static void main(String[] args) {
		JFileChooser jf = new JFileChooser("e:\\");
		int val = jf.showOpenDialog(null);
		if (val == JFileChooser.APPROVE_OPTION)
			JOptionPane.showMessageDialog(null, "Pulsaches " + jf.getSelectedFile());
	}
}
