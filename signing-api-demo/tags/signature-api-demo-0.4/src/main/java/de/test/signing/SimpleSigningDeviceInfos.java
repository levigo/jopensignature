package de.test.signing;

import java.awt.image.BufferedImage;

import org.jopensignature.sign.SigningDeviceInfo;
import org.jopensignature.sign.Vendor;
import org.jopensignature.sign.Version;

public class SimpleSigningDeviceInfos implements SigningDeviceInfo {

  private Vendor vendor = new JOpenSignatureVendor();

  public String getDescription() {
    return "A virtual testing signing device which has some simple signature templates that will be rendered automatically";
  }

  public Version getFirmwareVersion() {
    return null;
  }
  
  public String getSerialNumber() {
    return "296-5991646-0606";
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
