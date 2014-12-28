package by.segg3r.slicktest.logic.actions;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Sprite;

public abstract class AnimatedAction extends Action {

	public AnimatedAction(Sprite icon, ActionQueue queue, double apCost) {
		super(icon, queue, apCost);
	}

	@Override
	public void render(Graphics g) {
		if (isStarted()) {
			renderAnimation();
		}
	}

	protected abstract void renderAnimation();

	
}
