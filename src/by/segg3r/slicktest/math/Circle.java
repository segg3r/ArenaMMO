package by.segg3r.slicktest.math;

public class Circle {

	private Offset offset;
	private int radius;

	public Circle(Offset offset, int radius) {
		super();
		this.offset = offset;
		this.radius = radius;
	}

	public Offset getOffset() {
		return offset;
	}

	public void setOffset(Offset offset) {
		this.offset = offset;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
