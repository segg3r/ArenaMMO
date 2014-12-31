package by.segg3r.slicktest.logic.actions;

import java.util.Arrays;
import java.util.List;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.UIObject;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Sector;

public class BigShotActionFactory extends SkillActionFactory {

	public BigShotActionFactory(Sprite icon) {
		super(icon, BigShotAction.COOLDOWN, BigShotAction.ENERGY_COST,
				BigShotAction.ACTION_COST);
		setName("Powerful shot");
	}
	
	@Override
	protected List<String> getDescriptions() {
		return Arrays.asList(new String[] {"Powerful shot that deals damage in", "big sector"});
	}

	@Override
	public boolean isAppliable(GameState gameState) {
		return super.isAppliable(gameState)
				&& gameState.getActiveOffset() != null
				&& gameState.getActiveOffset().isInArena();
	}

	@Override
	public UIObject getUIObject(GameState gameState) {
		return createSector(gameState);
	}

	private Sector createSector(GameState gameState) {
		Offset offset = gameState.getActionQueue().getLastOffset();
		int radius = BigShotAction.RADIUS;
		double angle = offset.toHalfPoint().directionTo(
				gameState.getActiveOffset().toHalfPoint());
		double sectorSize = BigShotAction.SECTOR_SIZE;
		return new Sector(offset, radius, angle, sectorSize);
	}

	@Override
	public Action produceSkill(GameState gameState) {
		return new ShotAction(getIcon(), gameState.getActionQueue(),
				createSector(gameState));
	}

}
