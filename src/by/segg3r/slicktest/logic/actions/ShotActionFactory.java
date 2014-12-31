package by.segg3r.slicktest.logic.actions;

import java.util.Arrays;
import java.util.List;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.UIObject;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Sector;

public class ShotActionFactory extends SkillActionFactory {

	public ShotActionFactory(Sprite icon) {
		super(icon, ShotAction.ENERGY_COST, ShotAction.ACTION_COST);
		setName("Shot");
	}

	@Override
	protected List<String> getDescriptions() {
		return Arrays.asList(new String[] {"Deals damage in small sector"});
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
		int radius = ShotAction.RADIUS;
		double angle = offset.toHalfPoint().directionTo(gameState.getActiveOffset().toHalfPoint());
		double sectorSize = ShotAction.SECTOR_SIZE;
		return new Sector(offset, radius, angle, sectorSize);
	}

	@Override
	public Action produceSkill(GameState gameState) {
		return new ShotAction(getIcon(), gameState.getActionQueue(), createSector(gameState));
	}

}
