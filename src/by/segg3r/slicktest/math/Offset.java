package by.segg3r.slicktest.math;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Arena;
import by.segg3r.slicktest.logic.Renderable;

public class Offset implements Renderable {

	private int left;
	private int top;

	public Offset(int left, int top) {
		super();
		this.left = left;
		this.top = top;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + left;
		result = prime * result + top;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Offset))
			return false;
		Offset other = (Offset) obj;
		if (left != other.left)
			return false;
		if (top != other.top)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offset [left=" + left + ", top=" + top + "]";
	}
	

	@Override
	public void render(Graphics g) {
		Arena arena = Arena.get();
		Point activeOffsetPoint = arena.getArenaPointByOffset(this);
		g.fillRect((int) activeOffsetPoint.getX(), (int) activeOffsetPoint.getY(),
				arena.getCellSize(), arena.getCellSize());
	}

}
