package by.segg3r.slicktest.logic.renderable;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Arena;
import by.segg3r.slicktest.logic.Renderable;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Path;
import by.segg3r.slicktest.math.Point;

public class RenderablePath extends Path implements Renderable {

	private Path path;

	public RenderablePath(Path path) {
		super();
		this.path = path;
	}
	
	@Override
	public void render(Graphics g) {
		Arena arena = Arena.get();
		for (int i = 0; i < path.getSize(); i++) {
			Offset offset = path.getOffset(i);
			Point point = arena.getArenaPointByOffset(offset);
			g.fillRect(point.getX(), point.getY(), arena.getCellSize(), arena.getCellSize());
		}
	}

}
