package org.jopensignature.sign;

import java.awt.image.BufferedImage;

/**
 * General {@link SigningDevice} information which may be used in user interfaces.
 */
public interface SigningDeviceInfo {

  public String getDescription();

  /**
   * Returns a unique identifier of the SigningDevice. The {@link SignatureServiceProvider}
   * implementation has to ensure that all the {@link SigningDevice}s it returns have a unique
   * identifier. Identifiers for {@link SigningDevice}s coming from different
   * {@link SignatureServiceProvider}s might have overlapping identifiers.
   * 
   * @return
   */
  public String getIdentifier();

  /**
   * Returns a UI-usable Image or <code>null</code>. This image can be used to for example to
   * present a "Device Selection Dialog".
   * <p>
   * Although not specified the recommended size of the image is 400 x 400 Pixel.
   * 
   * @return either a {@link BufferedImage} or <code>null</code>
   */
  public BufferedImage getImage();

  public String getName();

  public Vendor getVendor();
}