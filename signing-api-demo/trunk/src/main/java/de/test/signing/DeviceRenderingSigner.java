package de.test.signing;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jopensignature.sign.DocumentRenderer;
import org.jopensignature.sign.Rectangle;
import org.jopensignature.sign.SignatureContext;
import org.jopensignature.sign.SignatureListener;
import org.jopensignature.sign.SignatureResult;

public class DeviceRenderingSigner extends TestSigner {

  static int imageNum = 0;
  private final RenderingSigningDevice device;
  private final double deviceResolution = 72;
  // we will have a spacing around the signing area of about one inch
  private final double spacing = deviceResolution * 2;


  public DeviceRenderingSigner(RenderingSigningDevice device) {
    super(device);
    this.device = device;
  }

  @Override
  public void startSigning(SignatureContext context, SignatureListener listener) {

    DocumentRenderer renderer = device.getCurrentRenderer();
    File f = new File("C:/temp/___rendered-signature-image" + imageNum++ + ".png");
    if (f.exists())
      f.delete();
    
    if (renderer != null && f.canWrite()) {
      Rectangle rect = context.getSignatureRectangle();

      final double factor = deviceResolution / rect.getResolution();

      double x = (rect.getX() * factor) - spacing;
      double y = (rect.getY() * factor) - spacing;
      double w = (rect.getWidth() * factor) + spacing * 2;
      double h = (rect.getHeight() * factor) + spacing * 2;

      // upper left corner
      Point2D.Double ul = new Point2D.Double(x, y);
      // lower right corner
      Point2D.Double lr = new Point2D.Double(x + w, y + h);

      ul = new Point2D.Double(Math.max(0, ul.x), Math.max(0, ul.y));

      Rectangle renderRect = new Rectangle(deviceResolution, ul.x, ul.y, lr.x - ul.x, lr.y - ul.y);

      BufferedImage bi = new BufferedImage((int) w, (int) h, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2d = bi.createGraphics();
      renderer.render(context.getPageNumber(), renderRect, g2d);


      try {
        ImageIO.write(bi, "PNG", f);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    super.startSigning(context, listener);
  }
}
