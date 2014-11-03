package by.segg3r.slicktest.logic;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.math.Point;


public abstract class Entity implements Renderable, Updatable {

	private Point position;
	private double direction;
	private double speed;
	private Animation animation;
	
	public Entity() {
		super();
	}

	public Entity(Point position) {
		super();
		this.position = position;
	}
	
	@Override
	public void update(double delta) {
		position.x += Math.cos(direction) * delta * speed;
		position.y += Math.sin(direction) * delta * speed;
	}
	
	@Override
	public void render(Graphics g) {
		animation.draw((int) position.x, (int) position.y);
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
	
	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}	

}
