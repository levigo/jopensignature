package de.test.signing;

import java.util.Locale;

import org.jopensignature.sign.Signer;
import org.jopensignature.sign.SigningDevice;
import org.jopensignature.sign.SigningDeviceCapabilities;
import org.jopensignature.sign.SigningDeviceInfo;

public abstract class AbstractSigningDevice implements SigningDevice {
  private final SigningDeviceCapabilities capabilities;
  private final SigningDeviceInfo defaultInfos;

  public AbstractSigningDevice(SigningDeviceCapabilities capabilities, SigningDeviceInfo defaultInfos) {
    super();
    this.capabilities = capabilities;
    this.defaultInfos = defaultInfos;
  }

  public SigningDeviceCapabilities getCapabilities() {
    return capabilities;
  }

  public SigningDeviceInfo getInfo(Locale locale) {
    return defaultInfos;
  }

  protected abstract Signer createSigner();
}
