package by.segg3r.slicktest.logic.renderable;

import java.util.List;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Arena;
import by.segg3r.slicktest.logic.Renderable;
import by.segg3r.slicktest.math.Circle;
import by.segg3r.slicktest.math.GameMath;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Point;

public class RenderableCircle extends Circle implements Renderable {

	public RenderableCircle(Offset offset, int radius) {
		super(offset, radius);
	}
	
	public RenderableCircle(Circle circle) {
		super(circle.getOffset(), circle.getRadius());
	}

	@Override
	public void render(Graphics g) {
		Arena arena = Arena.get();
		
		List<Offset> offsets = GameMath.getCircleItems(this);
		for (Offset offset : offsets) {
			Point point = arena.getArenaPointByOffset(offset);
			g.fillRect(point.getX(), point.getY(), arena.getCellSize(), arena.getCellSize());
		}
	}

}
