package org.jopensignature.sign;

import java.util.EventListener;
import java.util.EventObject;

public interface DocumentRendererListener extends EventListener {

  public static abstract class AbstractDocumentRendererEvent extends EventObject {
    private static final long serialVersionUID = 1L;

    public AbstractDocumentRendererEvent(DocumentRenderer renderer) {
      super(renderer);
    }

    @Override
    public DocumentRenderer getSource() {
      return (DocumentRenderer) super.getSource();
    }
  }

  public static class TotalPageCountChangedEvent extends AbstractDocumentRendererEvent {

    private static final long serialVersionUID = 1L;
    private final int oldPageCount;
    private final int newPageCount;

    public TotalPageCountChangedEvent(DocumentRenderer renderer, int oldPageCount, int newPageCount) {
      super(renderer);
      this.oldPageCount = oldPageCount;
      this.newPageCount = newPageCount;
    }

    public int getNewPageCount() {
      return newPageCount;
    }

    public int getOldPageCount() {
      return oldPageCount;
    }

  }

  public static class PageContentsChangedEvent extends AbstractDocumentRendererEvent {

    private static final long serialVersionUID = 1L;
    private final int pageIndex;

    public PageContentsChangedEvent(DocumentRenderer renderer, int pageIndex) {
      super(renderer);
      this.pageIndex = pageIndex;
    }

    public int getPageIndex() {
      return pageIndex;
    }
  }

  /**
   * Will be called if the number of total pages changed.
   * 
   * @param e
   */
  void totatPageCountChanged(TotalPageCountChangedEvent e);

  /**
   * Will be called if the page contents changed. Such changes include the size and the contents of
   * the page.
   * 
   * @param e
   */
  void pageContentsChanged(PageContentsChangedEvent e);
}
