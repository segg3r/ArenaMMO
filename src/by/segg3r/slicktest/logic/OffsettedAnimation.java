package by.segg3r.slicktest.logic;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

import by.segg3r.slicktest.math.Point;

public class OffsettedAnimation extends Animation {

	private Point offset;
	
	public OffsettedAnimation(SpriteSheet spriteSheet, int duration, Point offset) {
		super(spriteSheet, duration);
		this.offset = offset;
	}
	
	@Override
	public void draw(float x, float y) {
		super.draw(x - (float) offset.x, y - (float) offset.y);
	}

	public Point getOffset() {
		return offset;
	}

	public void setOffset(Point offset) {
		this.offset = offset;
	}
	
}
