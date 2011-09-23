package de.test.signing;

import org.jopensignature.sign.Vendor;

public class JOpenSignatureVendor extends Vendor {

  @Override
  public String getName() {
    return "jopensignature";
  }

}
