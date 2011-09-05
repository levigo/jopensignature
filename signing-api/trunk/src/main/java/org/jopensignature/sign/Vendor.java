package org.jopensignature.sign;

import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * Generic structure for vendor information.
 */
public abstract class Vendor {
  
  /**
   * Returns the name of the vendor. This method must never return <code>null</code>.
   * @return the name of the vendor.
   */
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
  
  /**
   * Returns a URL to a vendor homepage. This is optional and can be <code>null</code>.
   * 
   * @return a URL to a vendor homepage or <code>null</code>
   */
  public URL getURL() {
    return null;
  }
}
