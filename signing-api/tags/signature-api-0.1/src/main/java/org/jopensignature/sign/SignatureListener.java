package org.jopensignature.sign;

import java.awt.image.BufferedImage;

/**
 * @author fernanfs
 * @version 1.0
 * @created 17-Dez-2009 16:11:19
 */
public interface SignatureListener {

	/**
	 * 
	 * @param result
	 */
	public void signatureFinished(SignatureResult result);


	/**
	 * 
	 * @param img
	 */
	public void updateRendering(BufferedImage img);

}