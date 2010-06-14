package org.jopensignature.sign;

/**
 *  
 * @author <a href="mailto:c.koehler@levigo.de">Carolin Köhler</a>
 * @author <a href="mailto:f.fernandes@levigo.de">Francois Fernandes</a>
 */
public interface Signature {
	
	long getCreationTimeStamp();
	// 0-based
	int getPageNumber();
	
	// bezogen resolution
	Rectangle getRectangle();
	
	//optional, PDF Fieldname
	String getFieldName();
	
	// optional, customized id
	// Is customized by 
	// org.jopensignature.sign.SignatureContext.signatureIdentifier
	// org.jopensignature.sign.SignatureContext.getSignatureIdentifier()
	// org.jopensignature.sign.SignatureContext.setSignatureIdentifier(String)
	String getIdentifier();
}