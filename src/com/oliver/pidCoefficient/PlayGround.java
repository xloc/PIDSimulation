package com.oliver.pidCoefficient;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class PlayGround {
	
	Car car = new Car();
	Track track;
	
	public int WIDTH = 900;
	public int HEIGHT = 900;
	
	BufferedImage ground = new BufferedImage(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
	
	public PlayGround() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					next();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
			}
		}).start();
	}

	public void paint(Graphics g) {	
		Graphics rg = ground.createGraphics();
		rg.setColor(Color.white);
		rg.fillRect(0, 0, WIDTH, HEIGHT);
		car.paint(rg);
		
		g.drawImage(ground, 0, 0, WIDTH, HEIGHT, 0, HEIGHT, WIDTH, 0, null);
		
		ground.flush();
		
		//car.paint(g);
	}
	
	
	private void next() {
//		image input
		car.move();
//		monitor.look
//		paint
	}
	
	
}
