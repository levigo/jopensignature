package org.jopensignature.sign;

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
}