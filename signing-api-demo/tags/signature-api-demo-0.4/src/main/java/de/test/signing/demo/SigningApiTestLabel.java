package de.test.signing.demo;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.jopensignature.sign.Rectangle;
import org.jopensignature.sign.SignatureContext;
import org.jopensignature.sign.SignatureData;
import org.jopensignature.sign.SignatureResult;
import org.jopensignature.sign.SignatureServiceProvider;
import org.jopensignature.sign.SignatureServiceProviderLookUp;
import org.jopensignature.sign.Signer;


public class SigningApiTestLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	
	private Signer signer;
	private SignatureServiceProvider serviceProvider;
	private Random random;

	private class MouseHandler extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			if (signer == null)
				startSigning();
		}
	}

	public SigningApiTestLabel() {
		super("Click to start signing!", JLabel.CENTER);
		// Set the position of the text, relative to the icon:
		setVerticalTextPosition(JLabel.BOTTOM);
		setHorizontalTextPosition(JLabel.CENTER);

		serviceProvider = SignatureServiceProviderLookUp
				.getDefaultSignatureServiceProvider();
		if (serviceProvider == null)
			throw new IllegalStateException(
					"No Signature Service Provider available.");

		addMouseListener(new MouseHandler());
		random = new SecureRandom();
	}

	public void startSigning() {
		signer = serviceProvider.createSigner();
		if (signer == null) {
			JOptionPane.showMessageDialog(this, "Kein Signer vorhanden.",
					"Signatur nicht möglich.", JOptionPane.INFORMATION_MESSAGE);

			throw new IllegalStateException(
					"No Signature Service Provider available.");
		}

		setText("Signature started.");
		signer.startSigning(
				new SignatureContext(
						null, // ImageInputStream is, 
						null, // MetaInfoField[] metaInfos,
						0, // int pageNumber, 
						new Rectangle(
								Toolkit.getDefaultToolkit().getScreenResolution(), // just a symbolic value here fore the demo
								0,0,getWidth(),getHeight()), //Rectangle signRectangle, 
								random.nextBoolean()),// required, here a random value just for the demo
				new SigningApiTestSignatureListener(this)// listener
				);
	}

	public void stopSigning() {
		if (signer != null) {
			signer.close();
		}
		signer = null;
	}

	public void doSignatureDone(final SignatureData result) {
		stopSigning();
		setIcon(new ImageIcon(result.getSignatureImage()));
		setText("Signature successful done! Click to retry...");
	}

	public void doSignatureFailed(SignatureResult state) {
		stopSigning();
		setIcon(null);
		setText("Signature failed! Click to retry...");
	}

	public void doUpdateRendering(final BufferedImage img) {
		setIcon(new ImageIcon(img));
		setText("Signature in process...");
	}

}
