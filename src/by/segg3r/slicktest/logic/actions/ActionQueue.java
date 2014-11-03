package by.segg3r.slicktest.logic.actions;

import java.util.LinkedList;
import java.util.Queue;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Renderable;
import by.segg3r.slicktest.math.Offset;

public class ActionQueue implements Renderable {

	private Queue<Action> queue = new LinkedList<Action>();
	private Offset lastOffset;
	private Action startedAction;

	public ActionQueue(Offset initialOffset) {
		super();
		this.lastOffset = initialOffset;
	}

	@Override
	public void render(Graphics g) {
		if (startedAction instanceof PathAction) {
			((PathAction) startedAction).getFrom().pathTo(
					((PathAction) startedAction).getTo()).render(g);
		}
		for (Action action : queue) {
			if (action instanceof PathAction) {
				((PathAction) action).getFrom().pathTo(((PathAction) action).getTo()).render(g);
			}
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

}
