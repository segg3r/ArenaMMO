package by.segg3r.slicktest.logic;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

import by.segg3r.slicktest.math.Point;
import by.segg3r.slicktest.math.Rectangle;

public class Sprite extends Animation {

	private Point offset;
	private Rectangle mask;

	public Sprite(SpriteSheet spriteSheet, int duration, Point offset) {
		this(spriteSheet, duration, offset, new Rectangle(0, 0, 0, 0));
	}

	public Sprite(SpriteSheet spriteSheet, int duration, Point offset,
			Rectangle mask) {
		super(spriteSheet, duration);
		this.offset = offset;
		this.mask = mask;
	}

	public Sprite(Image tileImage, Point offset) {
		this(tileImage, offset, new Rectangle(0, 0, 0, 0));
	}

	public Sprite(Image tileImage, Point offset, Rectangle mask) {
		this(new SpriteSheet(tileImage, 1, 1), 20, offset, mask);
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

	public Rectangle getMask() {
		return mask;
	}

	public void setMask(Rectangle mask) {
		this.mask = mask;
	}

}
