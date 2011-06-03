package de.test.signing;

import org.jopensignature.sign.BaseMessage;
import org.jopensignature.sign.Dimension;
import org.jopensignature.sign.SigningDeviceCapabilities;

public class SimpleSigningDeviceCapabilities extends SigningDeviceCapabilities {

  @Override
  public boolean isColorSupported() {
    return false;
  }

  @Override
  public Dimension getDisplaySize() {
    return null;
  }

  @Override
  public java.awt.Dimension getDisplayPixelSize() {
    return new java.awt.Dimension(496, 131);
  }

  @Override
  public boolean isMessageSupported(Class<? extends BaseMessage> messageClass) {
    // currently no messages are supported.
    return false;
  }

}
