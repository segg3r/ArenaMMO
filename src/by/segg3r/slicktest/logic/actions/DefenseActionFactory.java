package by.segg3r.slicktest.logic.actions;

import java.util.Arrays;
import java.util.List;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.UIObject;

public class DefenseActionFactory extends SkillActionFactory {

	public DefenseActionFactory(Sprite icon) {
		super(icon, DefenseAction.COOLDOWN, DefenseAction.ENERGY_COST,
				DefenseAction.ACTION_COST);
		setName("Defense");
	}
	
	@Override
	protected List<String> getDescriptions() {
		return Arrays.asList(new String[] {"Defense stance, that decreases", "incoming damage for next turn"});
	}

	@Override
	public Action produceSkill(GameState gameState) {
		return new DefenseAction(getIcon(), gameState.getActionQueue(), gameState.getCharacter());
	}

	@Override
	public UIObject getUIObject(GameState gameState) {
		return null;
	}

}
