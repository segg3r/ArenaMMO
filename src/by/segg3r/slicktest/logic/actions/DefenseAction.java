package by.segg3r.slicktest.logic.actions;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.arenaobjects.Char;
import by.segg3r.slicktest.logic.buffs.DefenseBuff;

public class DefenseAction extends Action {

	public static final double ENERGY_COST = 60;
	public static final double ACTION_COST = 1;
	public static final int COOLDOWN = 2;
	private Char character;

	public DefenseAction(Sprite icon, ActionQueue actionQueue, Char character) {
		super(icon, actionQueue, ACTION_COST);
		this.character = character;
	}

	@Override
	public void start() {
		super.start();
		character.addBuff(new DefenseBuff());
		finish();
	}

	@Override
	public void render(Graphics g) {
		return;
	}


}
