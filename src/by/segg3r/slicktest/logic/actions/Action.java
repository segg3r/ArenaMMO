package by.segg3r.slicktest.logic.actions;

import by.segg3r.slicktest.logic.Renderable;
import by.segg3r.slicktest.math.Offset;

public abstract class Action implements Renderable {

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
