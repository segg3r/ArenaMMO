package by.segg3r.slicktest.logic.actions;

import by.segg3r.slicktest.logic.arenaobjects.Char;
import by.segg3r.slicktest.math.Offset;

public class GameState {

	private ActionQueue actionQueue;
	private Char character;
	private Offset activeOffset;

	public GameState(ActionQueue actionQueue, Char character,
			Offset activeOffset) {
		super();
		this.actionQueue = actionQueue;
		this.character = character;
		this.activeOffset = activeOffset;
	}

	public ActionQueue getActionQueue() {
		return actionQueue;
	}

	public void setActionQueue(ActionQueue actionQueue) {
		this.actionQueue = actionQueue;
	}

	public Char getCharacter() {
		return character;
	}

	public void setCharacter(Char character) {
		this.character = character;
	}

	public Offset getActiveOffset() {
		return activeOffset;
	}

	public void setActiveOffset(Offset activeOffset) {
		this.activeOffset = activeOffset;
	}
	
}
