package de.test.signing.demo;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SigningApiTest extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		// init gui just on edt!
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				initialiseGUI(args);
			}
		});
	}

	protected static void initialiseGUI(String[] args) {
		SigningApiTest testFrame = new SigningApiTest();
		testFrame.setTitle("Signing API Test");
		testFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		testFrame.setSize(250, 300);

		testFrame.setContentPane(new SigningApiTestLabel());

		testFrame.setVisible(true);
	}

}
