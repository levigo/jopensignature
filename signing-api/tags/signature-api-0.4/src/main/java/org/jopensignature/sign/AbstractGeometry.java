package org.jopensignature.sign;

/**
 * Abstract resolution based geometry base class.
 */
public abstract class AbstractGeometry {

	private final double resolution;

	public AbstractGeometry(double resolution) {
		super();
		this.resolution = resolution;
	}
	
	
	public double getResolution() {
		return resolution;
	}
}
