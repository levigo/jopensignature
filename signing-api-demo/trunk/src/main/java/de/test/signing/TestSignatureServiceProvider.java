package de.test.signing;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.jopensignature.sign.SignatureServiceProvider;
import org.jopensignature.sign.Signer;
import org.jopensignature.sign.SigningDevice;


public class TestSignatureServiceProvider implements SignatureServiceProvider {

  private volatile AbstractSigningDevice defaultDevice;
  private final List<AbstractSigningDevice> signingDevices;

  public TestSignatureServiceProvider() {
    signingDevices = new CopyOnWriteArrayList<AbstractSigningDevice>();

    // register some default devices
    signingDevices.add(new SimpleSigningDevice());
    signingDevices.add(defaultDevice = new RenderingSigningDevice());

  }

  public Signer createSigner() {
    return defaultDevice.createSigner();
  }

  public Signer createSigner(SigningDevice device) {
    return ((AbstractSigningDevice) device).createSigner();
  }

  public SigningDevice[] getSigningDevices() {
    return signingDevices.toArray(new SigningDevice[signingDevices.size()]);
  }

  public SigningDevice findSigningDevice(String identifier) {
    for (SigningDevice sd : signingDevices) {
      if (sd.getIdentifier().equals(identifier))
        return sd;
    }
    return null;
  }

}
