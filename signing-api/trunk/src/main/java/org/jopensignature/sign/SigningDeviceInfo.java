package org.jopensignature.sign;

import java.awt.image.BufferedImage;

/**
 * General {@link SigningDevice} information which may be used in user interfaces.
 */
public interface SigningDeviceInfo {

  public String getDescription();

  /**
   * Returns a serial number for the {@link SigningDevice} or <code>null</code> if not applicable.
   * The serial number is a vendor specific identifier for a particular device which could but
   * doesn't have to be unique.
   * 
   * @return
   */
  public String getSerialNumber();

  /**
   * Returns a UI-usable Image or <code>null</code>. This image can be used to for example to
   * present a "Device Selection Dialog".
   * <p>
   * Although not specified the recommended size of the image is 400 x 400 Pixel.
   * 
   * @return either a {@link BufferedImage} or <code>null</code>
   */
  public BufferedImage getImage();

  /**
   * Returns the firmware version of the {@link SigningDevice} if applicable or <code>null</code>
   * otherwise. The format of the version string is vendor dependent.
   * 
   * @return
   */
  public Version getFirmwareVersion();

  /**
   * Returns a name for the {@link SigningDevice} that may be used in a user interface.
   * 
   * @return
   */
  public String getName();

  public Vendor getVendor();
}