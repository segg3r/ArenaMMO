package by.segg3r.slicktest.logic.actions;

import by.segg3r.slicktest.logic.Layer;
import by.segg3r.slicktest.logic.UIObject;
import by.segg3r.slicktest.math.Offset;

public abstract class Action extends UIObject {

	private ActionQueue queue;
	private boolean started;

	public Action(ActionQueue queue) {
		super();
		this.queue = queue;
	}

	public void start() {
		this.started = true;
	}
	
	public boolean isStarted() {
		return started;
	}

	public void finish() {
		queue.setStartedAction(null);
		queue.startNextAction();
	}

	public Offset getLastOffset() {
		return queue.getLastOffset();
	}
	
	@Override
	public Layer getLayer() {
		return Layer.ACTION;
	}

	public abstract void renderAnimation();

}
