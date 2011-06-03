package de.test.signing;

import java.awt.image.BufferedImage;

import org.jopensignature.sign.SigningDeviceInfo;
import org.jopensignature.sign.Vendor;

public class SimpleSigningDeviceInfos implements SigningDeviceInfo {

  private Vendor vendor = new JOpenSignatureVendor();

  public String getDescription() {
    return "A virtual testing signing device which has some simple signature templates that will be rendered automatically";
  }

  public String getIdentifier() {
    return "1B-E8-BA-79-2F-85";
  }

  public BufferedImage getImage() {
    return null;
  }

  public String getName() {
    return "Simple Virtual Device";
  }

  public Vendor getVendor() {
    return vendor ;
  }

}
