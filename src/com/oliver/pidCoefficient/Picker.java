package com.oliver.pidCoefficient;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Picker {
	private double radius;
	Arrow location;
	Sensor parent;
	
	public Picker(Arrow location,double radius) {
		this.location = location;
		this.radius = radius;
	}
	
	public Picker(Arrow location){
		this(location, 5);
	}
	
	public Picker(Arrow location, Sensor parent){
		this(location, 5);
		this.parent = parent;
	}

	public byte pick(Image range) {
		return 0;
	}

	public void draw(Graphics g, Arrow direction) {
		Color c = g.getColor();
		
		g.setColor(getPickedColor());
		
		Arrow absloc = location.rot(-direction.getDir());
		g.fillOval((int)(absloc.getX()-radius),(int)(absloc.getY()-radius),(int)radius*2,(int)radius*2);
		//TODO maybe use proxy/adapter here
		
		g.setColor(c);
	}

	private Color getPickedColor() {
		return Color.black;
		
	}

	public void setParent(Sensor parent) {
		this.parent = parent;
	}

	
}
