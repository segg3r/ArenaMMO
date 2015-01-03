package by.segg3r.slicktest.logic.buffs;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.arenaobjects.Char;

public abstract class Buff {

	private int turnsLeft;
	private Sprite icon;

	public Buff(int turnsLeft, Sprite icon) {
		super();
		this.turnsLeft = turnsLeft;
		this.icon = icon;
	}
	
	public abstract void apply(Char character);
	public abstract void remove(Char character);

	public void endTurn() {
		this.turnsLeft--;
	}
	
	public int getTurnsLeft() {
		return turnsLeft;
	}

	public void setTurnsLeft(int turnsLeft) {
		this.turnsLeft = turnsLeft;
	}

	public Sprite getIcon() {
		return icon;
	}

	public void setIcon(Sprite icon) {
		this.icon = icon;
	}

}
