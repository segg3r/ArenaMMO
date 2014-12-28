package by.segg3r.slicktest.logic.actions;

import java.util.LinkedList;
import java.util.Queue;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.Game;
import by.segg3r.slicktest.logic.Layer;
import by.segg3r.slicktest.logic.UIObject;
import by.segg3r.slicktest.math.Offset;

public class ActionQueue extends UIObject {

	private Queue<Action> queue = new LinkedList<Action>();
	private Offset lastOffset;
	private Action startedAction;
	private double actionPoints;
	private Action lastAction;

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
		actionPoints += action.getApCost();
		if ((int) actionPoints % 3 == 0) {
			lastAction = action;
			Game.character.getActionPoints().add(3);
		}
		queue.add(action);
		lastOffset = action.getLastOffset();
		if (startedAction == null && (int) actionPoints % 3 == 0) {
			startNextAction();
		}
	}

	public void startNextAction() {
		Action action = queue.poll();

		if (action != null) {
			if (queue.contains(lastAction) || action == lastAction) {
				if (action == lastAction) {
					actionPoints -= 3;
				}
				action.start();
				setStartedAction(action);
			}
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
