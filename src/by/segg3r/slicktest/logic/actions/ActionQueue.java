package by.segg3r.slicktest.logic.actions;

import java.util.LinkedList;
import java.util.Queue;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Layer;
import by.segg3r.slicktest.logic.UIObject;
import by.segg3r.slicktest.math.Offset;

public class ActionQueue extends UIObject {

	private Queue<Action> queue = new LinkedList<Action>();
	private Offset lastOffset;
	private Action startedAction;

	public ActionQueue(Offset initialOffset) {
		super();
		this.lastOffset = initialOffset;
	}

	@Override
	public void render(Graphics g) {
		if (startedAction != null) {
			startedAction.render(g);
		}
		for (Action action : queue) {
			action.render(g);
		}
	}

	public void addAction(Action action) {
		queue.add(action);
		lastOffset = action.getLastOffset();
		if (queue.size() == 1 && startedAction == null) {
			startNextAction();
		}
	}

	public void startNextAction() {
		Action action = queue.poll();
		if (action != null) {
			action.start();
			setStartedAction(action);
		}
	}

	public Offset getLastOffset() {
		return lastOffset;
	}

	public void setLastOffset(Offset lastOffset) {
		this.lastOffset = lastOffset;
	}

	public Action getStartedAction() {
		return startedAction;
	}

	public void setStartedAction(Action startedAction) {
		this.startedAction = startedAction;
	}
	
	@Override
	public Layer getLayer() {
		return Layer.ACTION;
	}

}
