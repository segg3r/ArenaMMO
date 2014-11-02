package by.segg3r.slicktest.logic.renderable;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Arena;
import by.segg3r.slicktest.logic.Renderable;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Point;

public class RenderableOffset extends Offset implements Renderable {

	public RenderableOffset(int left, int top) {
		this(new Offset(left, top));
	}
	
	public RenderableOffset(Offset offset) {
		super(offset.getLeft(), offset.getTop());
	}

	@Override
	public void render(Graphics g) {
		Arena arena = Arena.get();
		Point activeOffsetPoint = arena.getArenaPointByOffset(this);
		g.fillRect(activeOffsetPoint.getX(), activeOffsetPoint.getY(),
				arena.getCellSize(), arena.getCellSize());
	}

}
