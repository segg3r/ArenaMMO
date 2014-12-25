package by.segg3r.slicktest.logic.arenaobjects;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.ArenaObject;
import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.actions.PathAction;
import by.segg3r.slicktest.logic.vitals.Vital;
import by.segg3r.slicktest.logic.vitals.Vitals;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Path;
import by.segg3r.slicktest.math.Point;

public class Char extends ArenaObject {
	
	private Path path;
	private int currentPathOffsetIndex;
	private Point destination;
	private PathAction pathAction;
	
	private Map<Vitals, Vital> vitals = new HashMap<Vitals, Vital>();

	public Char(Offset offset, Sprite sprite) {
		super(offset);
		this.setSprite(sprite);
		this.destination = getPosition();
		initVitals();
	}
	
	private void initVitals() {
		vitals.put(Vitals.HP, new Vital(100, 30));
		vitals.put(Vitals.MP, new Vital(100, 24));
	}
	
	public Vital getVital(Vitals vitals) {
		return this.vitals.get(vitals);
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
		
		int maxIndicatorWidth = 335;		
		g.drawString("HP:", 20, 390);
		g.drawString("Energy:", 20, 430);
		Vital hp = vitals.get(Vitals.HP);
		Vital mp = vitals.get(Vitals.MP);
		g.setColor(Color.red);
		g.fillRect(20, 410, (int) (maxIndicatorWidth * hp.getCurrentValue() / hp.getMaxValue()), 15);
		g.setColor(Color.orange);
		g.fillRect(20, 450, (int) (maxIndicatorWidth * mp.getCurrentValue() / hp.getMaxValue()), 15);
		
		g.setColor(Color.white);
		
		super.render(g);
	}

	@Override
	public void update(double delta) {
		super.update(delta);

		for (Map.Entry<Vitals, Vital> entry : vitals.entrySet()) {
			entry.getValue().update(delta);
		}
		
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
