package by.segg3r.slicktest.math;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Arena;
import by.segg3r.slicktest.logic.UIObject;

public class Line extends UIObject {

	private Offset from;
	private Offset to;
	private int limit;
	private boolean limited = false;

	public Line(Offset from, Offset to) {
		this(from, to, 0);
	}
	
	public Line(Offset from, Offset to, int limit) {
		super();
		this.from = from;
		this.to = to;
		if (limit > 0) {
			limited = true;
			this.limit = limit;
		}
	}

	@Override
	public void render(Graphics g) {
		Arena arena = Arena.get();
		g.setColor(new Color(255, 255, 255, 90));
		for (Offset offset : getOffsets()) {
			Point point = offset.toPoint();
			g.fillRect((float) point.x, (float) point.y, arena.getCellSize(),
					arena.getCellSize());
		}
		g.setColor(Color.white);
	}

	public List<Offset> getOffsets() {
		List<Offset> result = new ArrayList<Offset>();

		int distance = from.distanceTo(to);
		Point fromPoint = from.toHalfPoint();
		Point toPoint = to.toHalfPoint();

		if (distance == 0) {
			result.add(from);
		} else {
			int maxDistance = limited ? Math.min(limit, distance) : distance;
			
			for (int i = 0; i <= maxDistance; i++) {
				Point offsetPoint = new Point(fromPoint.x
						+ (double) (toPoint.x - fromPoint.x) / distance * i,
						fromPoint.y + (double) (toPoint.y - fromPoint.y)
								/ distance * i);
				result.add(offsetPoint.toOffset());
			}
		}

		return result;
	}

	public Offset getFrom() {
		return from;
	}

	public void setFrom(Offset from) {
		this.from = from;
	}

	public Offset getTo() {
		return to;
	}

	public void setTo(Offset to) {
		this.to = to;
	}

	public Offset getLastOffset() {
		List<Offset> offsets = getOffsets();
		return offsets.get(offsets.size() - 1);
	}

}
