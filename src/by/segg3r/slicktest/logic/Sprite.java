package by.segg3r.slicktest.logic;

import java.util.Arrays;
import java.util.List;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Point;

public class Sprite extends Animation {

	private Point offset;
	private List<Offset> mask;
	private String name;

	public Sprite(SpriteSheet spriteSheet, int duration, Point offset) {
		this(spriteSheet, duration, offset, Arrays
				.asList(new Offset[] { new Offset() }));
	}

	public Sprite(SpriteSheet spriteSheet, int duration, Point offset,
			List<Offset> mask) {
		super(spriteSheet, duration);
		this.offset = offset;
		this.setMask(mask);
	}

	public Sprite(Image tileImage, Point offset) {
		this(tileImage, offset, Arrays.asList(new Offset[] { new Offset() }));
	}

	public Sprite(Image tileImage, Point offset, List<Offset> mask) {
		this(new SpriteSheet(tileImage, tileImage.getWidth(),
				tileImage.getHeight()), 20, offset, mask);
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

	public List<Offset> getMask() {
		return mask;
	}

	public void setMask(List<Offset> mask) {
		this.mask = mask;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Sprite [name=" + name + "]";
	}

}
