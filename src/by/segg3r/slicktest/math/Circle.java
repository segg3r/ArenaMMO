package by.segg3r.slicktest.math;

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
		
		List<Offset> offsets = GameMath.getCircleItems(this);
		for (Offset offset : offsets) {
			Point point = arena.getArenaPointByOffset(offset);
			g.fillRect((int) point.getX(), (int) point.getY(), arena.getCellSize(), arena.getCellSize());
		}
	}

}
