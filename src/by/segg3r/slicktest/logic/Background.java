package by.segg3r.slicktest.logic;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Point;

public class Background implements Renderable {

	private Offset offset;
	private Sprite sprite;

	public Background(Offset offset, Sprite sprite) {
		super();
		this.offset = offset;
		this.sprite = sprite;
	}

	@Override
	public void render(Graphics g) {
		Point point = offset.toHalfPoint();
		sprite.draw((float) point.x, (float) point.y);
	}

	@Override
	public Layer getLayer() {
		return Layer.BACKGROUND;
	}

	@Override
	public Point getPosition() {
		return new Point(0, 0);
	}

}
