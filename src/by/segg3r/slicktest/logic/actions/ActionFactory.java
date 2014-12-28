package by.segg3r.slicktest.logic.actions;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.UIObject;

public abstract class ActionFactory {

	private Sprite icon;
	
	public ActionFactory(Sprite icon) {
		super();
		this.setIcon(icon);
	}

	public abstract boolean isAppliable(GameState gameState);

	public abstract Action produceAction(GameState gameState);

	public abstract UIObject getUIObject(GameState gameState);

	public Sprite getIcon() {
		return icon;
	}

	public void setIcon(Sprite icon) {
		this.icon = icon;
	}

}
