package org.jopensignature.sign;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;

/**
 * 
 * @author <a href="mailto:c.koehler@levigo.de">Carolin Köhler</a>
 * @author <a href="mailto:f.fernandes@levigo.de">Francois Fernandes</a>
 */
public class StampImageMetaInfoField implements MetaInfoField {

	// FIXME: we should clarify the purpose of this MetaInfoField type and the
	// contained fields/ data.

	public static enum Alignment {
		LEFT, RIGHT, CENTER
	}
	
  /**
   * Per contract assumed as {@link SimpleDateFormat} Date and Time Patterns.
   * This pattern allows textual parts as quoted text using single quotes 
   * (<code>'</code>).
   * @return {@link SimpleDateFormat} Date and Time Patterns
   * @see org.jopensignature.sign.StampImageMetaInfoField.StampText#getTemplateText()
   */
	public static class DateTimeStampText extends AbstractStampText
	{
	  
	  private Color color;
	  private Alignment alignment;
	  
    public DateTimeStampText(Rectangle targetRectangle, String templateText, Alignment alignment, Color color) {
      super(targetRectangle, templateText);
      this.color = color;
      this.alignment = alignment;
    }
    
    public Color getColor()
    {
      return color;
    }
    
    public Alignment getAlignment()
    {
      return alignment;
    }
    
    /**
     * Per contract assumed as {@link SimpleDateFormat} Date and Time Patterns.
     * This pattern allows textual parts as quoted text using single quotes 
     * (<code>'</code>).
     * @return {@link SimpleDateFormat} Date and Time Patterns
     * @see org.jopensignature.sign.StampImageMetaInfoField.StampText#getTemplateText()
     */
    @Override
    public String getTemplateText()
    {
      return super.getTemplateText();
    }
	}
	
	public static abstract class AbstractStampText {
	  
		private final Rectangle targetRectangle;
		private final String templateText;
		
		public AbstractStampText(Rectangle targetRectangle, String templateText) {
			super();
			this.targetRectangle = targetRectangle;
			this.templateText = templateText;
		}
		
		public Rectangle getTargetRectangle() {
			return targetRectangle;
		}
		
		public String getTemplateText() {
			return templateText;
		}
		
	}
	
	private final BufferedImage stampImage;
	// Signature Bereich innerhalb des Stamp Images
	private final Rectangle signatureRectangle;
	private final AbstractStampText[] stampTexts;

	public StampImageMetaInfoField(BufferedImage stampImage,
			Rectangle signatureRectangle, AbstractStampText[] stampTexts) {
		super();
		this.stampImage = stampImage;
		this.signatureRectangle = signatureRectangle;
		this.stampTexts = stampTexts;
	}

	public String getType() {
		return getClass().getName();
	}

	public BufferedImage getStampImage() {
		return stampImage;
	}

	public Rectangle getSignatureRectangle() {
		return signatureRectangle;
	}
	
	public AbstractStampText[] getStampTexts() {
		return stampTexts;
	}
	
}