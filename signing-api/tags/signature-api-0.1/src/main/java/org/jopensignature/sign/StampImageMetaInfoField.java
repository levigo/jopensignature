package org.jopensignature.sign;

import java.awt.image.BufferedImage;

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
	
	public static class StampText {
		
		private final Rectangle targetRectangle;
		private final String templateText;
		private final Alignment alignment;
		private final Color color;
		
		public StampText(Rectangle targetRectangle, String templateText, Alignment alignment, Color color) {
			super();
			this.targetRectangle = targetRectangle;
			this.templateText = templateText;
			this.alignment = alignment;
			this.color = color;
		}
		
		public Rectangle getTargetRectangle() {
			return targetRectangle;
		}
		
		public String getTemplateText() {
			return templateText;
		}
		
		public Alignment getAlignment() {
			return alignment;
		}
		
		public Color getColor() {
			return color;
		}
	}
	
	private final BufferedImage stampImage;
	// Signature Bereich innerhalb des Stamp Images
	private final Rectangle signatureRectangle;
	private final StampText[] stampTexts;

	public StampImageMetaInfoField(BufferedImage stampImage,
			Rectangle signatureRectangle, StampText[] stampTexts) {
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
	
	public StampText[] getStampTexts() {
		return stampTexts;
	}
	
}