package by.segg3r.slicktest.logic.actions;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.UIObject;
import by.segg3r.slicktest.logic.arenaobjects.Char;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Sector;

public class ShotActionFactory extends ActionFactory {

	public ShotActionFactory(Sprite icon) {
		super(icon);
	}

	@Override
	public boolean isAppliable(GameState gameState) {
		Char character = gameState.getCharacter();
		return character != null
				&& character.getEnergy().has(ShotAction.ENERGY_COST)				
				&& gameState.getActiveOffset() != null
				&& gameState.getActiveOffset().isInArena();
	}

	@Override
	public Action produceAction(GameState gameState) {
		gameState.getCharacter().getEnergy().reduce(ShotAction.ENERGY_COST);
		return new ShotAction(gameState.getActionQueue(), createSector(gameState));
	}

	@Override
	public UIObject getUIObject(GameState gameState) {
		return createSector(gameState);
	}
	
	private Sector createSector(GameState gameState) {
		Offset offset = gameState.getActionQueue().getLastOffset();
		int radius = ShotAction.RADIUS;
		double angle = offset.toHalfPoint().directionTo(gameState.getActiveOffset().toHalfPoint());
		double sectorSize = ShotAction.SECTOR_SIZE;
		return new Sector(offset, radius, angle, sectorSize);
	}

}
