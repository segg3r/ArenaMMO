package by.segg3r.slicktest.logic.actions;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.arenaobjects.Char;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Path;

public class PathAction extends Action {

	private Char character;
	private Path path;

	public PathAction(ActionQueue queue, Char character, Path path) {
		super(queue, path.getSize());
		this.character = character;
		this.path = path;
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
