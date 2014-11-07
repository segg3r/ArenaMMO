package by.segg3r.slicktest.logic.arenaobjects;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.ArenaObject;
import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.actions.PathAction;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Path;
import by.segg3r.slicktest.math.Point;

public class Char extends ArenaObject {

	private Path path;
	private int currentPathOffsetIndex;
	private Point destination;
	private PathAction pathAction;

	public Char(Offset offset, Sprite sprite) {
		super(offset);
		this.setSprite(sprite);
		this.destination = getPosition();
	}

	@Override
	public void render(Graphics g) {
		double direction = getDirection();
		SideDirection sideDirection = SideDirection.fromDirection(direction);

		if (getSpeed() == 0
				|| getSprite().getFrame() > sideDirection.getMaxImage()
				|| getSprite().getFrame() < sideDirection.getMinImage()) {
			getSprite().setCurrentFrame(sideDirection.getMinImage());
		}

		super.render(g);

		g.drawString(String.valueOf(getDirection()), 5, 55);
		g.drawString(SideDirection.fromDirection(0).toString(), 5, 75);
	}

	@Override
	public void update(double delta) {
		super.update(delta);

		setOffset(getPosition().toOffset());

		if (path != null) {
			Offset currentPathOffset = path.getOffset(currentPathOffsetIndex);
			Point currentPathPoint = currentPathOffset.toHalfPoint();
			destination = currentPathPoint;
		} else {
			destination = getPosition();
		}

		if (!getPosition().equals(destination)) {
			if (getPosition().distanceTo(destination) > Math.max(
					getSpeed() / 1000., 1)) {
				setDirection(getPosition().directionTo(destination));
				setSpeed(60);
			} else {
				currentPathOffsetIndex++;
				if (path != null && currentPathOffsetIndex >= path.getSize()) {
					currentPathOffsetIndex = 0;
					path = null;
					pathAction.finish();
					setSpeed(0);
				}

				setPosition(destination);
			}
		}
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
		this.currentPathOffsetIndex = 0;
	}

	public void setPathAction(PathAction pathAction) {
		this.pathAction = pathAction;
	}

}
