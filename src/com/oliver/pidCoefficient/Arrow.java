package com.oliver.pidCoefficient;

public class Arrow {
	private double x,y;
	
	public Arrow(){}
	
	public Arrow(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Rotate an Arrow by modifying itself
	 * @param angle in radius
	 * @return the rotated modified Arrow
	 */
	public Arrow rotMe(double a){
		double[] rot = {Math.cos(a),Math.sin(a),-Math.sin(a),Math.cos(a)};
		return trans(rot,this);
	}
	
	/**
	 * Rotate a Arrow and return a new one
	 * @param angle in radius
	 * @return the rotated new Arrow
	 */
	public Arrow rot(double a){
		double[] rot = {Math.cos(a),Math.sin(a),-Math.sin(a),Math.cos(a)};
		return trans(rot,this.clone());
	}
	
	public static Arrow trans(double[] matrix, Arrow input){
		double tx = matrix[0] * input.x + matrix[1] * input.y;
		double ty = matrix[2] * input.x + matrix[3] * input.y;
		input.x = tx;
		input.y = ty;
		return input;
	}
	
	public Arrow normalize() {
		double magnitude = this.getMagnitude();
		x = x / magnitude;
		y = y / magnitude;
		return this;
	}
	
	public Arrow add(Arrow b){
		return new Arrow(this.x + b.getX(),
				this.y + b.getY());
	}
	
	public Arrow addToMe(Arrow b){
		set(this.x + b.getX(),this.y + b.getY());
		return this;
	}
	
	public double getDir() {		
		return Math.atan(x/(y+Double.MIN_VALUE));
	}
	
	public double getMagnitude() {
		return Math.hypot(x,y);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void set(double x,double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	protected Arrow clone(){
		return new Arrow(x,y);
	}
	
}
