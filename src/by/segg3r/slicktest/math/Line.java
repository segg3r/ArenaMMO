package by.segg3r.slicktest.math;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Arena;
import by.segg3r.slicktest.logic.UIObject;

public class Line extends UIObject {

	private Offset from;
	private Offset to;

	public Line(Offset from, Offset to) {
		super();
		this.from = from;
		this.to = to;
	}

	@Override
	public void render(Graphics g) {
		Arena arena = Arena.get();
		for (Offset offset : getOffsets()) {
			Point point = offset.toPoint();
			g.fillRect((float) point.x, (float) point.y, arena.getCellSize(),
					arena.getCellSize());
		}
	}

	public List<Offset> getOffsets() {
		List<Offset> result = new ArrayList<Offset>();

		int distance = from.distanceTo(to);
		Point fromPoint = from.toHalfPoint();
		Point toPoint = to.toHalfPoint();

		if (distance == 0) {
			result.add(from);
		} else {
			for (int i = 0; i <= distance; i++) {
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

}
