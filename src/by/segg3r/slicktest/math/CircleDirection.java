package by.segg3r.slicktest.math;

public class CircleDirection {

	private double direction;
	
	public CircleDirection(double direction) {
		super();
		this.direction = direction;
	}
	
	public double diffWith(CircleDirection circleDirection) {
		double d1 = direction;
		double d2 = circleDirection.direction;
		
		if (d1 < 0) { d1 += Math.PI * 2; }
		if (d2 < 0) { d2 += Math.PI * 2; }
		
		return Math.abs(d1 - d2);
	}
	
}
