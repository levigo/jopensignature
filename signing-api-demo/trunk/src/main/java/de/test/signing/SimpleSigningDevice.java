package de.test.signing;

import org.jopensignature.sign.BaseMessage;
import org.jopensignature.sign.Signer;


public class SimpleSigningDevice extends AbstractSigningDevice {
  public SimpleSigningDevice() {
    super(new SimpleSigningDeviceCapabilities(), new SimpleSigningDeviceInfos());
  }

  public void send(BaseMessage message) throws UnsupportedMessageException {
    throw new UnsupportedMessageException(message);
  }

  @Override
  protected Signer createSigner() {
    return new TestSigner(this);
  }
}
