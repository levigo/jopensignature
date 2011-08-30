package org.jopensignature.sign;

import java.awt.image.BufferedImage;

/**
 * Generic structure for vendor information.
 */
public abstract class Vendor {
  public abstract String getName();

  /**
   * Returns a vendor specific {@link BufferedImage image} for e.g. the company sign. If no such
   * {@link BufferedImage image} is available, <code>null</code> may be returned. This image can be
   * used to for example to present a "Device Selection Dialog".
   * <p>
   * <i>NOTE</i>: The default implementation will return <code>null</code>. Override this method if
   * a custom {@link BufferedImage image} shall be returned.
   * 
   * @return
   */
  public BufferedImage getImage() {
    return null;
  }
}
