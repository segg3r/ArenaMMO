package by.segg3r.slicktest.math;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Arena;
import by.segg3r.slicktest.logic.Renderable;

public class Circle implements Renderable {

	private Offset offset;
	private int radius;

	public Circle(Offset offset, int radius) {
		super();
		this.offset = offset;
		this.radius = radius;
	}
	
	public List<Offset> getOffsets() {
		List<Offset> result = new ArrayList<Offset>();

		for (int i = 0; i < Arena.get().getHeight(); i++) {
			for (int j = 0; j < Arena.get().getWidth(); j++) {
				Offset arenaOffset = new Offset(j, i);
				if (offset.distanceTo(arenaOffset) <= radius) {
					result.add(offset);
				}
			}
		}

		return result;
	}

	public Offset getOffset() {
		return offset;
	}

	public void setOffset(Offset offset) {
		this.offset = offset;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public void render(Graphics g) {
		Arena arena = Arena.get();
		
		List<Offset> offsets = getOffsets();
		for (Offset offset : offsets) {
			Point point = offset.toPoint();
			g.fillRect((int) point.getX(), (int) point.getY(), arena.getCellSize(), arena.getCellSize());
		}
	}

}
