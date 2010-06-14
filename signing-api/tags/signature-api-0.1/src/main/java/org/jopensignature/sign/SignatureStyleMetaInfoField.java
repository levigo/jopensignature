package org.jopensignature.sign;

public class SignatureStyleMetaInfoField implements MetaInfoField {

	private final Color signatureColor;

	public SignatureStyleMetaInfoField(Color signatureColor) {
		super();
		this.signatureColor = signatureColor;
	}

	public Color getSignatureColor() {
		return signatureColor;
	}

	public String getType() {
		return getClass().getName();
	}

}
