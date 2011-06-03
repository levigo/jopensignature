package org.jopensignature.sign;

import java.awt.Dimension;

import javax.imageio.stream.ImageInputStream;

/**
 * A {@link SignatureContext} instance have to accompany a signature request at
 * a {@link Signer} due to a call of the method
 * {@link Signer#startSigning(SignatureContext, SignatureListener)}.
 * <p>
 * It provides several necessary informations and constraints the {@link Signer}
 * instance need to know to provide a successful signing request. The provided
 * constraints are described in the javadoc of the constructor and the getter
 * methods of this class.
 * 
 * @author <a href="mailto:c.koehler@levigo.de">Carolin Köhler</a>
 * @author <a href="mailto:f.fernandes@levigo.de">Francois Fernandes</a>
 */
public class SignatureContext {

	private final ImageInputStream documentInputStream;
	private final MetaInfoField[] metaInfos;
	private final int pageNumber;
	private final Rectangle signRectangle;
	private final boolean required;
	private boolean autofitSignature;
	private String signatureIdentifier; // 256 Zeichen Länge???
	private Dimension signatureImageSizeHint;

	// FIXME: we must document the following fields.
	// double resolution
	// Dimension signImageSize
	// Rectangle2D signRectangle

	/**
	 * 
	 * @param is
	 * @param metaInfos
	 * @param pageNumber
	 * @param resolution
	 * @param signImageSize
	 * @param signRectangle
	 * @param required
	 */
	public SignatureContext(ImageInputStream is, MetaInfoField[] metaInfos,
			int pageNumber, Rectangle signRectangle, boolean required) {
		this.documentInputStream = is;
		this.metaInfos = metaInfos;
		this.pageNumber = pageNumber;
		this.signRectangle = signRectangle;
		this.required = required;
	}

	public ImageInputStream getDocumentStream() {
		return documentInputStream;
	}

	public MetaInfoField[] getMetaInfoFields() {
		return metaInfos;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public Rectangle getSignatureRectangle() {
		return signRectangle;
	}

	public boolean isRequired() {
		return required;
	}

	public String getSignatureIdentifier() {
		return signatureIdentifier;
	}

	public void setSignatureIdentifier(String signatureIdentifier) {
		this.signatureIdentifier = signatureIdentifier;
	}

	public void setAutofitSignature(boolean autofitSignature) {
		this.autofitSignature = autofitSignature;
	}
	
	public boolean isAutofitSignature() {
		return autofitSignature;
	}

	/**
	 * Sets a signature image pixel size hint. This value is meant as an image
	 * pixel size hint for the {@link Signer} when
	 * {@link SignatureListener#updateRendering(java.awt.image.BufferedImage)
	 * updated signature renderings} are produced. The initial value is
	 * <code>null</code>, which means that it is up to the {@link Signer}
	 * implementation to choose any particular image pixel size.
	 * <p>
	 * Even if this value has been set, the {@link Signer} may choose to ignore it
	 * and calculate the image size based on some internal logic.
	 * 
	 * @param signatureImageSizeHint the signature image pixel size hint
	 */
	public void setSignatureImageSizeHint(Dimension signatureImageSizeHint) {
		this.signatureImageSizeHint = signatureImageSizeHint;
	}
	
	/**
	 * Returns the current signature image size hint. See
	 * {@link #setSignatureImageSizeHint(Dimension)}
	 * 
	 * @return the current signature image size hint
	 */
	public Dimension getSignatureImageSizeHint() {
		return signatureImageSizeHint;
	}

}