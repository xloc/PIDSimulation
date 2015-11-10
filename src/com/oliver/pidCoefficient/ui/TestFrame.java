package com.oliver.pidCoefficient.ui;

import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestFrame extends JFrame{

	private PlaygroundPanel playGroundPannel = new PlaygroundPanel();

	public TestFrame() throws HeadlessException {
		launch();
	}
	
	private void launch() {
		setSize(PlaygroundPanel.P_WIDTH + 150,PlaygroundPanel.P_HEIGHT);
		setLocation(200,200);
		
		add(playGroundPannel);
		
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
				
				playGroundPannel.stopRepaint();
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new TestFrame();
	}
	
}
