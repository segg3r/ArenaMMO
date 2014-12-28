package by.segg3r.slicktest.logic.actions;

import by.segg3r.slicktest.logic.Layer;
import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.UIObject;
import by.segg3r.slicktest.math.Offset;

public abstract class Action extends UIObject {

	private ActionQueue queue;
	private boolean started;
	private double apCost;
	private Sprite icon;
	private boolean wasLast;

	public Action(Sprite icon, ActionQueue queue, double apCost) {
		super();
		this.icon = icon;
		this.queue = queue;
		this.setApCost(apCost);
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

	public double getApCost() {
		return apCost;
	}

	public void setApCost(double apCost) {
		this.apCost = apCost;
	}

	public Sprite getIcon() {
		return this.icon;
	}

	public boolean isWasLast() {
		return wasLast;
	}

	public void setWasLast(boolean wasLast) {
		this.wasLast = wasLast;
	}

}
