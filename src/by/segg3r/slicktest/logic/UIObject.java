package by.segg3r.slicktest.logic;

import by.segg3r.slicktest.math.Point;

public abstract class UIObject implements Renderable {

	private static final Point ZERO_POSITION = new Point(0, 0);

	@Override
	public Layer getLayer() {
		return Layer.UI;
	}

	@Override
	public Point getPosition() {
		return ZERO_POSITION;
	}
}
