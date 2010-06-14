package de.test.signing;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.jopensignature.sign.MetaInfoField;
import org.jopensignature.sign.Signature;
import org.jopensignature.sign.SignatureContext;
import org.jopensignature.sign.SignatureData;
import org.jopensignature.sign.SignatureListener;
import org.jopensignature.sign.SignatureResult;
import org.jopensignature.sign.Signer;
import org.jopensignature.sign.SigningDevice;
import org.jopensignature.sign.SignatureResult.State;

public class TestSigner implements Signer {

	private class SignatureEmulatorTask implements Runnable {
		SignatureContext context;
		SignatureListener listener;
		boolean fail;
		int bogusIndex;

		public SignatureEmulatorTask(SignatureContext context,
				SignatureListener listener, boolean fail, int imgIndex) {
			this.context = context;
			this.listener = listener;
			this.fail = fail;
			this.bogusIndex = imgIndex;
		}

		public void run() {
			BufferedImage signBogus = signBogusImages[bogusIndex];
			int step = 200;
			int stepSize = Math
					.round((1f * signBogus.getWidth()) / (1f * step));

			for (int i = 1; i <= step; i++) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// ignore
				}
				
				BufferedImage img = new BufferedImage(signBogus.getWidth(), signBogus
						.getHeight(), BufferedImage.TYPE_INT_ARGB);
				
				Graphics2D g = img.createGraphics();
				int blindRegionStart = signBogus.getWidth() - (step - i) * stepSize;
				g.setClip(new Rectangle(0,0,blindRegionStart, signBogus.getHeight()));
				g.drawImage(signBogus, null, 0, 0);
				g.dispose();
				
//				BufferedImage subimage = signBogus.getSubimage(0, 0, blindRegionStart, signBogus.getHeight());
				listener.updateRendering(img);
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// ignore
			}
			final SignatureResult result;
			if (false && fail)
				result = new SignatureResult(State.FAILED, null);
			else
				result = new SignatureResult(State.DONE, new SignatureData() {

					public ImageInputStream getSignedDocumentStream() {
						// Für diese kleine Demo einfach Datenstrom zurück
					  //fixme
						return context.getDocumentStream();
					}

					public BufferedImage getSignatureImage() {
						return signBogusImages[bogusIndex];
					}

					public Signature getSignature() {
						// Für diese kleine Demo kein Rückgabewert.
						return null;
					}
				});
			listener.signatureFinished(result);
		}
	}

	private final static BufferedImage[] signBogusImages;
	static int index; 
	
	static{
		try {
		signBogusImages = new BufferedImage []{
				ImageIO.read(TestSigner.class
						.getResourceAsStream("/sig4.png")),
				ImageIO.read(TestSigner.class
						.getResourceAsStream("/sig3.png")),
				ImageIO.read(TestSigner.class
						.getResourceAsStream("/sig2.png")),
				ImageIO.read(TestSigner.class
						.getResourceAsStream("/sig1.png"))
		};
		} catch (IOException e) {
			throw new Error("Keine Unterschriften da!",e);
		}
		index = (int)((Math.random() * 4)%4);
	}
	private Random random;

	public TestSigner() {
		random = new SecureRandom();
	}

	public void close() {
		// do nothing
	}

	public Dimension getPadBackgroundImageSize() {
		return null;
	}

	public Signature[] getSignatures(ImageInputStream documentStream) {
		if (documentStream == null)
			throw new IllegalArgumentException(
					"documentStream may not be null.");
		throw new UnsupportedOperationException(
				"This feature is not supported right now.");
	}

	public SigningDevice getSigningDevice() {
		throw new UnsupportedOperationException(
				"This feature is not supported right now.");
	}

	public void startSigning(SignatureContext context,
			SignatureListener listener) {

		if (context == null)
			throw new IllegalArgumentException("context may not be null.");
		if (listener == null)
			throw new IllegalArgumentException("listener may not be null.");

		index = Math.abs((random.nextInt()))%4;
		SignatureEmulatorTask task = new SignatureEmulatorTask(context,
				listener, random.nextBoolean(),index);
		new Thread(task).start();
	}

	public boolean isMetaInfoFieldSupported(
			Class<? extends MetaInfoField> fieldType) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isSigningSupportedFor(ImageInputStream documentStream) {
		// TODO Auto-generated method stub
		return true;
	}

}
