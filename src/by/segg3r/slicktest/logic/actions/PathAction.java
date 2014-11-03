package by.segg3r.slicktest.logic.actions;

import by.segg3r.slicktest.logic.arenaobjects.Char;
import by.segg3r.slicktest.math.Offset;

public class PathAction extends Action {

	private Char character;
	private Offset from;
	private Offset to;

	public PathAction(ActionQueue queue, Char character, Offset to) {
		super(queue);
		this.character = character;
		this.from = queue.getLastOffset();
		this.to = to;
	}

	@Override
	public void start() {
		character.setPath(from.pathTo(to));
		character.setPathAction(this);
	}

	@Override
	public Offset getLastOffset() {
		return to;
	}

	public Char getCharacter() {
		return character;
	}

	public void setCharacter(Char character) {
		this.character = character;
	}

	public Offset getFrom() {
		return from;
	}

	public void setFrom(Offset from) {
		this.from = from;
	}

	public Offset getTo() {
		return to;
	}

	public void setTo(Offset to) {
		this.to = to;
	}

}
