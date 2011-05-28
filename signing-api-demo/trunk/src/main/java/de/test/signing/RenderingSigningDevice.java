package de.test.signing;

import java.awt.image.BufferedImage;

import org.jopensignature.sign.ApplyDocumentRenderer;
import org.jopensignature.sign.BaseMessage;
import org.jopensignature.sign.Dimension;
import org.jopensignature.sign.DocumentRenderer;
import org.jopensignature.sign.Signer;
import org.jopensignature.sign.SigningDeviceCapabilities;
import org.jopensignature.sign.SigningDeviceInfo;
import org.jopensignature.sign.Vendor;

public class RenderingSigningDevice extends AbstractSigningDevice {

  private static final class Infos implements SigningDeviceInfo {
    public Vendor getVendor() {
      return new JOpenSignatureVendor();
    }

    public String getName() {
      return "Rendering Virtual Device";
    }

    public BufferedImage getImage() {
      return null;
    }

    public String getIdentifier() {
      return "CB-48-D3-09-3B-00";
    }

    public String getDescription() {
      return "A virtual testing signing device which has some simple signature templates that will be rendered automatically";
    }
  }

  private static final class Capabilities extends SigningDeviceCapabilities {

    @Override
    public boolean isColorSupported() {
      return true;
    }

    @Override
    public Dimension getDisplaySize() {
      return new Dimension(72, 5 * 72, 3 * 72);
    }

    @Override
    public java.awt.Dimension getDisplayPixelSize() {
      return new java.awt.Dimension(5 * 100, 3 * 100);
    }

    @Override
    public boolean isMessageSupported(Class<? extends BaseMessage> messageClass) {
      return messageClass == ApplyDocumentRenderer.class;
    }

  }

  public RenderingSigningDevice() {
    super(new Capabilities(), new Infos());
  }

  private volatile DocumentRenderer currentRenderer;

  public void send(BaseMessage message) throws UnsupportedMessageException {
    if (message instanceof ApplyDocumentRenderer) {
      currentRenderer = ((ApplyDocumentRenderer) message).getDocumentRenderer();
    } else {
      throw new UnsupportedMessageException(message);
    }
  }

  public DocumentRenderer getCurrentRenderer() {
    return currentRenderer;
  }

  @Override
  protected Signer createSigner() {
    return new DeviceRenderingSigner(this);
  }

}
