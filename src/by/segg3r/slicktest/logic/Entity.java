package by.segg3r.slicktest.logic;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.math.Point;

public abstract class Entity implements Renderable {

	private Point position;
	private double direction;
	private double speed;
	private Sprite sprite;
	private Layer layer;

	public Entity() {
		super();
	}

	public Entity(Point position, Layer layer) {
		super();
		this.position = position;
		this.setLayer(layer);
	}

	public Entity(Point position) {
		this(position, Layer.OBJECT);
	}

	public void update(double delta) {
		position.x += Math.cos(direction) * delta * speed;
		position.y += Math.sin(direction) * delta * speed;
	}

	@Override
	public void render(Graphics g) {
		sprite.draw((float) position.x, (float) position.y);
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Layer getLayer() {
		return layer;
	}

	public void setLayer(Layer layer) {
		this.layer = layer;
	}

}
