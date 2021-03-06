package by.segg3r.slicktest.logic.actions;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.arenaobjects.Char;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Path;

public class PathAction extends Action {

	private Char character;
	private Path path;

	public PathAction(Sprite icon, ActionQueue queue, Char character, Path path) {
		super(icon, queue, path.getSize() - 1);
		this.character = character;
		this.path = path;
	}

	@Override
	public void drawActionForQueue(Graphics g, int drawX, int drawY,
			int cellSize, boolean active) {
		super.drawActionForQueue(g, drawX, drawY, cellSize, active);
		if (path.getSize() - 1 > 1) {
			Color textColor = active ? Color.black : Color.white;
			g.setColor(textColor);
			g.drawString("" + (path.getSize() - 1), drawX + 3, drawY + 1);
			g.setColor(Color.white);
		}
	}

	@Override
	public void render(Graphics g) {
		path.render(g);
	}

	@Override
	public void start() {
		super.start();
		character.setPath(path);
		character.setPathAction(this);
	}

	@Override
	public Offset getLastOffset() {
		return path.getOffset(path.getSize() - 1);
	}

	public Char getCharacter() {
		return character;
	}

	public void setCharacter(Char character) {
		this.character = character;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

}
