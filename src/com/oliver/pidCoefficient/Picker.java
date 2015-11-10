package com.oliver.pidCoefficient;

import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Point2D;

public class Picker {
	Point2D location;
	Shape sampleRange;
	
	public Picker(Point2D location, Shape sampleRange) {
		this.location = location;
		this.sampleRange = sampleRange;
	}
	
	public byte pick(Image range) {
		return 0;

	}

	
}
