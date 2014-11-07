package by.segg3r.slicktest.logic.actions;

import by.segg3r.slicktest.logic.UIObject;
import by.segg3r.slicktest.math.Offset;

public abstract class Action extends UIObject {

	private ActionQueue queue;

	public Action(ActionQueue queue) {
		super();
		this.queue = queue;
	}

	public abstract void start();

	public void finish() {
		queue.setStartedAction(null);
		queue.startNextAction();
	}

	public Offset getLastOffset() {
		return queue.getLastOffset();
	}

}
