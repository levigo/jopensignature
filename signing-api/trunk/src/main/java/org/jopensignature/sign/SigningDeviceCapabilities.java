package org.jopensignature.sign;

/**
 */
public abstract class SigningDeviceCapabilities {

  /**
   * Determines whether the {@link SigningDevice} supports colors other than black and white. This
   * includes even grayscale colors.
   * 
   * @return <code>false</code> if only black and white are supported, or <code>true</code> if any
   *         kind of non black and white colors are supported.
   */
  public abstract boolean isColorSupported();

  /**
   * The physical display size.
   * 
   * @return
   */
  public abstract Dimension getDisplaySize();

  /**
   * The number of pixels that can effectivly be displayed.
   * 
   * @return
   */
  public abstract java.awt.Dimension getDisplayPixelSize();

}