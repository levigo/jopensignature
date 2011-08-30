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

  /**
   * Register a {@link DocumentRendererListener} for this {@link DocumentRenderer}.
   * <p>
   * <i>IMPORTANT</i>: once a {@link DocumentRenderer} is not used anymore (because of a
   * {@link ApplyDocumentRenderer "apply document renderer message"} or some other reason) <b>a
   * registered listener has to be removed</b>.
   * 
   * @param listener the {@link DocumentRendererListener} to be registered.
   */
  void addListener(DocumentRendererListener listener);

  /**
   * Remove a registered {@link DocumentRendererListener} for this {@link DocumentRenderer}.
   * 
   * @param listener the {@link DocumentRendererListener} to be deregistered.
   */
  void removeListener(DocumentRendererListener listener);
}