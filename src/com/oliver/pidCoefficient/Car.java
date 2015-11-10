package com.oliver.pidCoefficient;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

public class Car {
	private static final int SYMBOL_SIZE = 20;

	private Sensor s;
	
	private Point2D location;
	
	private double dircection;
	private double velocity;
	
	public Car() {
		s = new Sensor();
		
		location = new Point2D.Double(1,2);
	}



	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.cyan);
		g.fillRect((int)location.getX()-SYMBOL_SIZE/2, (int)location.getY()+SYMBOL_SIZE/2
				, SYMBOL_SIZE, SYMBOL_SIZE);
		
		s.paint(g);
		
		g.setColor(c);
	}
}
