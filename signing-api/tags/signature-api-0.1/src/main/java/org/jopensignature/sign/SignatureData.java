package org.jopensignature.sign;

import java.awt.image.BufferedImage;

import javax.imageio.stream.ImageInputStream;

/**
 *  
 * @author <a href="mailto:c.koehler@levigo.de">Carolin Köhler</a>
 * @author <a href="mailto:f.fernandes@levigo.de">Francois Fernandes</a>
 */
public interface SignatureData {

	public BufferedImage getSignatureImage();
	
	public Signature getSignature();

	public ImageInputStream getSignedDocumentStream();

}