package by.segg3r.slicktest.logic.buffs;

import by.segg3r.slicktest.Storages;
import by.segg3r.slicktest.logic.arenaobjects.Char;

public class DefenseBuff extends Buff {

	public static final int DURATION = 1;
	
	public DefenseBuff() {
		super(DURATION, Storages.ICON_SET.get("defenseAction"));
	}

	@Override
	public void apply(Char character) {
		character.getDefense().addMultiplier(2.);
	}

	@Override
	public void remove(Char character) {
		character.getDefense().removeMultiplier(2.);
	}

}
