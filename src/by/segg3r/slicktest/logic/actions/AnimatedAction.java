package by.segg3r.slicktest.logic.actions;

import org.newdawn.slick.Graphics;

public abstract class AnimatedAction extends Action {

	public AnimatedAction(ActionQueue queue, double apCost) {
		super(queue, apCost);
	}

	@Override
	public void render(Graphics g) {
		if (isStarted()) {
			renderAnimation();
		}
	}

	protected abstract void renderAnimation();

	
}
