package by.segg3r.slicktest.math;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.UIObject;

public class Path extends UIObject {

	private List<Offset> offsets = new ArrayList<Offset>();

	public Path() {
		super();
	}

	public void addOffset(Offset offset) {
		offsets.add(offset);
	}

	public Offset getOffset(int i) {
		return offsets.get(i);
	}

	public int getSize() {
		return offsets.size();
	}

	@Override
	public void render(Graphics g) {
		for (int i = 0; i < getSize() - 1; i++) {
			Offset o1 = getOffset(i);
			Offset o2 = getOffset(i + 1);
			Point p1 = o1.toHalfPoint();
			Point p2 = o2.toHalfPoint();
			g.drawLine((float) p1.x, (float) p1.y, (float) p2.x, (float) p2.y);
		}
	}

	public void reverse() {
		List<Offset> result = new ArrayList<Offset>();
		for (int i = offsets.size() - 1; i >= 0; i--) {
			result.add(offsets.get(i));
		}
		offsets = result;
	}

}
