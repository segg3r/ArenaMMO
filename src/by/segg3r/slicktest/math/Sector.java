package by.segg3r.slicktest.math;

import java.util.ArrayList;
import java.util.List;

import by.segg3r.slicktest.logic.Arena;

public class Sector extends Circle {

	private double angle;
	private double sectorSize;

	public Sector(Offset offset, int radius, double angle, double sectorSize) {
		super(offset, radius);
		this.setAngle(angle);
		this.setSectorSize(sectorSize);
	}

	@Override
	public List<Offset> getOffsets() {
		List<Offset> result = new ArrayList<Offset>();

		for (int i = 0; i < Arena.get().getHeight(); i++) {
			for (int j = 0; j < Arena.get().getWidth(); j++) {
				Offset arenaOffset = new Offset(j, i);
				double direction = getOffset().toHalfPoint().directionTo(
						arenaOffset.toHalfPoint());
				double diff = new CircleDirection(direction)
						.diffWith(new CircleDirection(angle));

				if (getOffset().distanceTo(arenaOffset) <= getRadius()
						&& (direction > angle - sectorSize / 2
								&& direction < angle + sectorSize / 2 || diff <= sectorSize / 2)
						&& !arenaOffset.equals(getOffset())) {
					result.add(arenaOffset);
				}
			}
		}

		return result;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getSectorSize() {
		return sectorSize;
	}

	public void setSectorSize(double sectorSize) {
		this.sectorSize = sectorSize;
	}

}
