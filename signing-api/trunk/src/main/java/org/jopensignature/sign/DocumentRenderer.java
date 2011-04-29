package org.jopensignature.sign;

/**
 */
public interface DocumentRenderer {

  /**
   * 
   * @param pageIndex
   * @throws IndexOutOfBoundsException if pageIndex is out of bounds (either pageIndex < 0 or
   *           pageIndex > {@link #getTotalPageCount()} - 1)
   */
  public Dimension getPageSize(int pageIndex);

  public int getTotalPageCount();

  /**
   * 
   * @param pageIndex
   * @param regionOfInterest
   * @param target
   */
  public void render(int pageIndex, Rectangle regionOfInterest, java.awt.Graphics2D target);

}