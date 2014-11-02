package by.segg3r.slicktest.math;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Arena;
import by.segg3r.slicktest.logic.Renderable;

public class Path implements Renderable {

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
		Arena arena = Arena.get();
		for (int i = 0; i < getSize() - 1; i++) {
			Offset o1 = getOffset(i);
			Offset o2 = getOffset(i + 1);
			Point p1 = arena.getArenaHalfPointByOffset(o1);
			Point p2 = arena.getArenaHalfPointByOffset(o2);
			g.drawLine((float) p1.getX(), (float) p1.getY(),
					(float) p2.getX(), (float) p2.getY());
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
