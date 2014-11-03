package by.segg3r.slicktest.math;

import by.segg3r.slicktest.logic.Arena;

public class Point {
	
	public double x;
	public double y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double directionTo(Point p2) {
		return Math.atan2(p2.y - y, p2.x - x);
	}

	public Offset toOffset() {
		Arena arena = Arena.get();
		
		int top = (int) (y - arena.getPosition().y) / arena.getCellSize();
		int left = (int) (x - (arena.getPosition().x + (top % 2 == 0 ? arena
				.getCellSize() / 2 : 0)))
				/ arena.getCellSize();

		return new Offset(left, top);
	}
	
	public double distanceTo(Point p2) {
		return Math.sqrt((x-p2.x)*(x-p2.x) + (y-p2.y)*(y-p2.y));
	}

	public boolean isInArena() {
		Arena arena = Arena.get();
		Offset offset = toOffset();
		return offset.isInArena() && x >= arena.getPosition().x + (offset.top % 2 == 0 ? arena.getCellSize() / 2 : 0) && y >= arena.getPosition().y;
	}

}
