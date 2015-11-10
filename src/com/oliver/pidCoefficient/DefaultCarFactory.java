package com.oliver.pidCoefficient;

public class DefaultCarFactory {
	
	private static DefaultCarFactory singleton = new DefaultCarFactory();
	
	private DefaultCarFactory(){}

	public static DefaultCarFactory get() {
		return singleton;
	}
	
	public Car getCar() {
		
		
		return null;
	}

}
