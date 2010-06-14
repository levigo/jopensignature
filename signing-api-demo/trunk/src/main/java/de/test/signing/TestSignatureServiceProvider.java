package de.test.signing;

import org.jopensignature.sign.SignatureServiceProvider;
import org.jopensignature.sign.Signer;


public class TestSignatureServiceProvider implements SignatureServiceProvider {

	public Signer createSigner() {
		return new TestSigner();
	}

//	public Verifier createVerifier() {
//		throw new UnsupportedOperationException("Verifier not supported right now.");
//	}

}
