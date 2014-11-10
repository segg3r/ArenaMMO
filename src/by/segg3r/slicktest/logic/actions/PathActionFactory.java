package by.segg3r.slicktest.logic.actions;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.UIObject;
import by.segg3r.slicktest.math.Line;

public class PathActionFactory extends ActionFactory {

	public PathActionFactory(Sprite icon) {
		super(icon);
	}

	@Override
	public boolean isAppliable(GameState gameState) {
		return gameState.getCharacter() != null
				&& gameState.getActiveOffset() != null
				&& gameState.getActiveOffset().isInArena();
	}

	@Override
	public Action produceAction(GameState gameState) {
		return new PathAction(gameState.getActionQueue(),
				gameState.getCharacter(), gameState.getActiveOffset());
	}

	@Override
	public UIObject getUIObject(GameState gameState) {
		return new Line(gameState.getActionQueue().getLastOffset(),
				gameState.getActiveOffset());
	}

}
