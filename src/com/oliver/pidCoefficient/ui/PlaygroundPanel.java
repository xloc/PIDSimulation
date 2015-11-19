package com.oliver.pidCoefficient.ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import com.oliver.pidCoefficient.Car;
import com.oliver.pidCoefficient.DefaultCarFactory;
import com.oliver.pidCoefficient.PlayGround;

public class PlaygroundPanel extends JPanel{
	
	private static final long serialVersionUID = -8665907165267037999L;

	public static final int P_WIDTH = 1000;
	public static final int P_HEIGHT = 1000;
	
	PlayGround playground = new PlayGround();
	Thread refreshThread;
	public boolean repaintFlag = true;
	
	public PlaygroundPanel() {
		launch();
	}
	
	private void launch() {
		setSize(P_WIDTH, P_HEIGHT);
		
		refreshThread = new Thread(){
			
			public void run() {
				while (repaintFlag) {
					repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		};
		refreshThread.start();
	}
	
	@Override
	public void paint(Graphics g) {
		playground.paint(g);
	}

	public void stopRepaint() {
		repaintFlag = false;
		System.out.println("paint stoped");
	}
	
	
}
