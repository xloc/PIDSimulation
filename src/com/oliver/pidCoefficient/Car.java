package com.oliver.pidCoefficient;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Car {
	private static final int SYMBOL_SIZE = 20;

	private Sensor s;
	
	private Arrow direction;
	
	private Arrow location;
	
	private Arrow velocity;
	
	private Arrow acceleration;
	
	public Car() {
		//set the original location of the car
		location = new Arrow(100,200);
		velocity = new Arrow(1,3);
		
		s = new Sensor(new Arrow(0,100),new Arrow(0,1).rot(Math.toRadians(45))
				,new Rectangle2D.Double(0,0,70,50),this);
		
		s.addPicker(new Picker(new Arrow(-70,0)));
		s.addPicker(new Picker(new Arrow(-50,0)));
		s.addPicker(new Picker(new Arrow(  0,0)));
		s.addPicker(new Picker(new Arrow( 50,0)));
		s.addPicker(new Picker(new Arrow( 70,0)));
		
		
	}



	public void paint(Graphics g) {
		Color c = g.getColor();
		
		// the Modification of color
		g.setColor(Color.cyan);
		// draw Car itself
		g.fillRect((int)location.getX()-SYMBOL_SIZE/2, (int)location.getY()+SYMBOL_SIZE/2
				, SYMBOL_SIZE, SYMBOL_SIZE);
		// draw the sensor of it
		s.paint(g,location);
		
		g.setColor(c);
	}
	
	public void move(){
		location.addToMe(velocity);
	}
}
