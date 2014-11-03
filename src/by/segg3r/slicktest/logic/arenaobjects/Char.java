package by.segg3r.slicktest.logic.arenaobjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.ArenaObject;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Path;
import by.segg3r.slicktest.math.Point;

public class Char extends ArenaObject {

	private Path path;
	private int currentPathOffsetIndex;
	private Point destination;
	
	public Char(Offset offset, Animation animation) {
		super(offset);
		this.setAnimation(animation);
		this.destination = getPosition();
	}

	@Override
	public void render(Graphics g) {
		double direction = getDirection();
		SideDirection sideDirection = SideDirection.fromDirection(direction);
		
		if (getSpeed() == 0 || getAnimation().getFrame() > sideDirection.getMaxImage() || getAnimation().getFrame() < sideDirection.getMinImage()) {
			getAnimation().setCurrentFrame(sideDirection.getMinImage());
		}
		
		super.render(g);
		
		if (path != null) {
			path.render(g);
		}
		g.drawString(String.valueOf(getDirection()), 5, 55);
		g.drawString(SideDirection.fromDirection(0).toString(), 5, 75);
	}
	
	@Override
	public void update(double delta) {
		super.update(delta);

		if (path != null) {
			Offset currentPathOffset = path.getOffset(currentPathOffsetIndex);
			Point currentPathPoint = currentPathOffset.toHalfPoint();
			destination = currentPathPoint;
		} else {
			destination = getPosition();
		}
		
		if (!getPosition().equals(destination)) {
			if (getPosition().distanceTo(destination) > getSpeed() / 1000.) {
				setDirection(getPosition().directionTo(destination));
				setSpeed(60);
			} else {
				currentPathOffsetIndex++;
				if (path != null && currentPathOffsetIndex >= path.getSize()) {
					currentPathOffsetIndex = 0;
					path = null;
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
	
	

}
