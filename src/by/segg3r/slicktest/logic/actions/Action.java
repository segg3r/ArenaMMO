package by.segg3r.slicktest.logic.actions;

import org.newdawn.slick.Graphics;

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
	
	public void drawActionForQueue(Graphics g, int drawX, int drawY, int cellSize, boolean active) {
		Sprite icon = getIcon();
		int width = icon.getWidth();
		int height = icon.getHeight();

		if (active) {
			g.fillRect(drawX, drawY, cellSize, cellSize);
		} else {
			g.drawRect(drawX, drawY, cellSize, cellSize);
		}

		icon.draw((float) (drawX + (0.5) * cellSize - width / 2.),
				(float) (drawY + cellSize * 0.5 - height / 2.));

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
