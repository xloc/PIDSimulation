package com.oliver.pidCoefficient;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Sensor {
	
	private Car parent;
	
	private Arrow location;
	
	private Arrow direction;
	
	private ArrayList <Picker> pickers = new ArrayList<Picker>();
	
	private Rectangle2D sampleRange;
	
	public Sensor(Arrow location, Rectangle2D sampleRange) {
		this(location, new Arrow(0,1),sampleRange);
	}
	
	public Sensor(Arrow location, Arrow direction, Rectangle2D sampleRange) {
		this.location = location;
		this.direction = direction;
		this.sampleRange = sampleRange;
		
		Arrow d = direction.normalize();
		double width = sampleRange.getWidth();
		
		System.out.println("(width , height) = "+sampleRange.getWidth()+" , "+sampleRange.getHeight());
		System.out.println("g.drawLine("+(int)(-width * d.getY())+", "+(int)(-width * d.getX())+", "+
				(int)(width * d.getY())+", "+(int)(width * d.getX())+")");
		System.out.println("direction: " + Math.toDegrees(direction.getDir()));
	}
	
	public Sensor(Arrow location, Arrow direction, Rectangle2D sampleRange, Car parent) {
		this(location, direction, sampleRange);
		this.parent = parent;
	}
	
	public void addPicker(Picker p) {
		pickers.add(p);
		p.setParent(this);
	}

	public void paint(Graphics g, Arrow position) {
		Color c = g.getColor();
		g.setColor(Color.black);
		
		position = position.add(location);
		g.translate((int)position.getX(), (int)position.getY());
		
		Arrow d = direction.normalize();
		double width = sampleRange.getWidth();
		g.drawLine((int)(-width * d.getY()), (int)(-width * d.getX()),
				(int)(width * d.getY()), (int)(width * d.getX()));
		
		for(Picker p:pickers){
			p.draw(g,direction);
		}
		
		g.setColor(c);
	}
}