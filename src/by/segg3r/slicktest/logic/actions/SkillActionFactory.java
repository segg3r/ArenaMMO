package by.segg3r.slicktest.logic.actions;

import java.util.HashMap;
import java.util.Map;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.arenaobjects.Char;
import by.segg3r.slicktest.logic.vitals.Vitals;

public abstract class SkillActionFactory extends ActionFactory {

	private Map<Vitals, Double> costs;

	public SkillActionFactory(Sprite icon, int cooldown, double mpCost, double apCost) {
		super(icon, cooldown);
		Map<Vitals, Double> costs = new HashMap<Vitals, Double>();

		costs.put(Vitals.MP, mpCost);
		costs.put(Vitals.AP, apCost);

		this.costs = costs;
	}
	
	public SkillActionFactory(Sprite icon, double mpCost, double apCost) {
		this(icon, 0, mpCost, apCost);
	}
	
	protected String getNameString() {
		String result = super.getNameString();
		result += "; E: " + costs.get(Vitals.MP).intValue() + "; AP: " + costs.get(Vitals.AP).intValue();
		return result;
	}

	@Override
	public boolean isAppliable(GameState gameState) {
		if (!super.isAppliable(gameState))
			return false;
		Char character = gameState.getCharacter();
		if (character == null)
			return false;

		for (Map.Entry<Vitals, Double> cost : costs.entrySet()) {
			if (!character.getVital(cost.getKey()).has(cost.getValue())) {
				return false;
			}
		}

		return true;
	}

	@Override
	public Action produceAction(GameState gameState) {
		Char character = gameState.getCharacter();
		for (Map.Entry<Vitals, Double> cost : costs.entrySet()) {
			character.getVital(cost.getKey()).reduce(cost.getValue());
		}

		setCurrentCooldown(getCooldown());
		return produceSkill(gameState);
	}

	public abstract Action produceSkill(GameState gameState);

}
