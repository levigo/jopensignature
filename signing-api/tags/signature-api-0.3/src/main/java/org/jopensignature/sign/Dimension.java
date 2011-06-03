package org.jopensignature.sign;

/**
 * A size declaration in relation to a resolution (DPI).
 */
public class Dimension extends AbstractGeometry {

  private final double height;
  private final double width;

  public Dimension(double resolution, double width, double height) {
    super(resolution);
    this.width = width;
    this.height = height;
  }

  public double getHeight() {
    return height;
  }

  public double getWidth() {
    return width;
  }

}