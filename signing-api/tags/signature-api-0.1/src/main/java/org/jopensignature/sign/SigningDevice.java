package org.jopensignature.sign;

import java.awt.Dimension;

/**
 */
public interface SigningDevice {
//fixme: --> StepOver javadoc
	
	// in which measuring unit?
	public Dimension getPadBackgroundImageSize();

	// which color levels are possible?
	// is the return type int a good choice?
	public int getPadBackgroundColorLevels();

	public int getPadBackgroundImageResolution();

	public boolean isPadBackgroundColorSupported();

	// description: what is a cropbox? 
	public boolean isPadBackgroundCropBoxSupported();

	public boolean isPadBackgroundImageSupported();
}
