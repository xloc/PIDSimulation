package com.oliver.pidCoefficient;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Sensor {
	
	private Point2D location;
	
	private double direction;
	
	private ArrayList <Picker> pickers = new ArrayList<Picker>();
	
	private Rectangle2D sampleRange;

	public void paint(Graphics g) {
		
	}
}
