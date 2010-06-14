package org.jopensignature.sign;

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
