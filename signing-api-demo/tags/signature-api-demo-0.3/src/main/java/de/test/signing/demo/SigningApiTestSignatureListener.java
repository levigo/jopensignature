package de.test.signing.demo;

import java.awt.image.BufferedImage;

import javax.swing.SwingUtilities;

import org.jopensignature.sign.SignatureListener;
import org.jopensignature.sign.SignatureResult;

public class SigningApiTestSignatureListener implements SignatureListener {

	private final SigningApiTestLabel label;

	public SigningApiTestSignatureListener(SigningApiTestLabel label) {
		this.label = label;
	}

	public void signatureFinished(final SignatureResult result) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				switch (result.getState()) {
				case DONE:
					label.doSignatureDone(result.getData());
				case CANCEL:
				case FAILED:
					label.doSignatureFailed(result);

				}
			}
		});
	}

	public void updateRendering(final BufferedImage img) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				label.doUpdateRendering(img);
			}
		});
	}
}
