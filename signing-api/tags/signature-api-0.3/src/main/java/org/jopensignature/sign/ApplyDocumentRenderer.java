package org.jopensignature.sign;

/**
 * Instruct a {@link SigningDevice} to use the provided {@link DocumentRenderer} as a render
 * callback.
 */
public class ApplyDocumentRenderer extends BaseMessage {

  private final DocumentRenderer documentRenderer;

  /**
   * @param documentRenderer the {@link DocumentRenderer} to be used, or <code>null</code> if a
   *          previously registered {@link DocumentRenderer} shall be deregistered.
   */
  public ApplyDocumentRenderer(DocumentRenderer documentRenderer) {
    super();
    this.documentRenderer = documentRenderer;
  }

  public DocumentRenderer getDocumentRenderer() {
    return documentRenderer;
  }

}