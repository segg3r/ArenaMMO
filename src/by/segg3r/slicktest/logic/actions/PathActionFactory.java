package by.segg3r.slicktest.logic.actions;

import java.util.Arrays;
import java.util.List;

import by.segg3r.slicktest.Game;
import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.UIObject;
import by.segg3r.slicktest.math.Line;
import by.segg3r.slicktest.math.Path;

public class PathActionFactory extends ActionFactory {

	public PathActionFactory(Sprite icon) {
		super(icon);
		setName("Movement");
	}
	
	@Override
	protected List<String> getDescriptions() {
		return Arrays.asList(new String[] {"Moves character by one cell per AP"});
	}

	@Override
	public boolean isAppliable(GameState gameState) {
		if (gameState.getActiveOffset() == null
				|| !gameState.getActiveOffset().isInArena())
			return false;

		if (gameState.getActionQueue().getLastOffset()
				.equals(gameState.getActiveOffset()))
			return false;

		Path path = getPath(gameState);

		return super.isAppliable(gameState)
				&& gameState.getCharacter() != null
				&& path != null
				&& (path.getSize() - 1) <= gameState.getCharacter()
						.getActionPoints().getCurrentValue();
	}

	private Path getPath(GameState gameState) {
		return gameState.getActionQueue().getLastOffset()
				.pathTo(gameState.getActiveOffset());
	}

	@Override
	public Action produceAction(GameState gameState) {
		Path path = getPath(gameState);

		gameState.getCharacter().getActionPoints().reduce(path.getSize() - 1);
		return new PathAction(getIcon(), gameState.getActionQueue(),
				gameState.getCharacter(), path);
	}

	@Override
	public UIObject getUIObject(GameState gameState) {
		return getLine(gameState);
	}

	private Line getLine(GameState gameState) {
		return new Line(gameState.getActionQueue().getLastOffset(),
				gameState.getActiveOffset(), Game.AP_PER_TURN);
	}

}
