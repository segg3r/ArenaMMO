package by.segg3r.slicktest.logic;

public abstract class Entity implements Renderable {

	private int x;
	private int y;

	public Entity() {
		super();
	}

	public Entity(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
