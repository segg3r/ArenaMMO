package by.segg3r.slicktest.logic.actions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.Game;
import by.segg3r.slicktest.logic.Layer;
import by.segg3r.slicktest.logic.Sprite;
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

		renderTurns(g);
	}

	public void addAction(Action action) {
		actionPoints += action.getApCost();
		if ((int) actionPoints % Game.AP_PER_TURN == 0) {
			lastAction = action;
			action.setWasLast(true);
			Game.character.getActionPoints().add(3);
		}
		queue.add(action);
		lastOffset = action.getLastOffset();
		if (startedAction == null && (int) actionPoints % Game.AP_PER_TURN == 0) {
			startNextAction();
		}
	}

	public void startNextAction() {
		Action action = queue.poll();

		if (action != null) {
			if (queue.contains(lastAction) || action == lastAction) {
				action.start();
				setStartedAction(action);
			}
		}
	}

	private void renderTurns(Graphics g) {
		int drawY = 515;
		int drawX = 20;
		int cellSize = 36;
		int turnGap = 20;
		boolean pointBased = false;
		double turnPoints = 0;
		List<Action> list = (LinkedList<Action>) queue;

		if (startedAction != null) {
			Sprite icon = startedAction.getIcon();
			int width = icon.getWidth();
			int height = icon.getHeight();
			g.fillRect(drawX, drawY, cellSize, cellSize);
			icon.draw((float) (drawX + (0.5) * cellSize - width / 2.),
					(float) (drawY + cellSize * 0.5 - height / 2.));
			drawX += cellSize;

			if (startedAction.isWasLast()) {
				drawX += turnGap;
				pointBased = true;
			}
		}

		for (Action action : list) {
			if (pointBased) {
				turnPoints += action.getApCost();
			}

			Sprite icon = action.getIcon();
			int width = icon.getWidth();
			int height = icon.getHeight();

			g.drawRect(drawX, drawY, cellSize, cellSize);
			icon.draw((float) (drawX + (0.5) * cellSize - width / 2.),
					(float) (drawY + cellSize * 0.5 - height / 2.));

			drawX += cellSize;

			if (action.isWasLast()) {
				drawX += turnGap;
				pointBased = true;
			} else if (pointBased && turnPoints == 3) {
				turnPoints = 0;
				drawX += turnGap;
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
