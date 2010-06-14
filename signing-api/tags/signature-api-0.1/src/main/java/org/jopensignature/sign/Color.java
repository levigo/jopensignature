package org.jopensignature.sign;

public class Color {
	private final int red;
	private final int green;
	private final int blue;
	public Color(int red, int green, int blue) {
		super();
		if (red < 0 || red > 255)
			throw new IllegalArgumentException("red is out of range (valid: 0-255): "
					+ red);
		if (green < 0 || green > 255)
			throw new IllegalArgumentException(
					"green is out of range (valid: 0-255): " + green);
		if (blue < 0 || blue > 255)
			throw new IllegalArgumentException(
					"blue is out of range (valid: 0-255): " + blue);
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public int getBlue() {
		return blue;
	}
	public int getGreen() {
		return green;
	}
	public int getRed() {
		return red;
	}
}
