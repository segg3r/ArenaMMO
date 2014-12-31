package by.segg3r.slicktest.logic.actions;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.UIObject;
import by.segg3r.slicktest.logic.listener.ActionListener;
import by.segg3r.slicktest.logic.listener.ActionType;

public abstract class ActionFactory implements ActionListener {

	private Sprite icon;
	private int cooldown;
	private int currentCooldown;

	public ActionFactory(Sprite icon) {
		this(icon, 0);
	}

	public ActionFactory(Sprite icon, int cooldown) {
		super();
		this.setIcon(icon);
		this.setCooldown(cooldown);
	}

	@Override
	public void perform(ActionType actionType, GameState gameState) {
		if (actionType == ActionType.TURN_END) {
			if (currentCooldown > 0) {
				currentCooldown--;
			}
		}
	}

	public boolean isAppliable(GameState gameState) {
		return currentCooldown <= 0;
	}

	public abstract Action produceAction(GameState gameState);

	public abstract UIObject getUIObject(GameState gameState);

	public Sprite getIcon() {
		return icon;
	}

	public void setIcon(Sprite icon) {
		this.icon = icon;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	public int getCurrentCooldown() {
		return currentCooldown;
	}

	public void setCurrentCooldown(int currentCooldown) {
		this.currentCooldown = currentCooldown;
	}

}
