package by.segg3r.slicktest.logic.actions;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.Storages;

public class PassAction extends Action {

	public PassAction(ActionQueue queue, double apCost) {
		super(Storages.ICON_SET.get("passAction"), queue, apCost);
	}
	
	@Override
	public void start() {
		super.start();
		finish();
	}
	
	@Override
	public void drawActionForQueue(Graphics g, int drawX, int drawY,
			int cellSize, boolean active) {
		super.drawActionForQueue(g, drawX, drawY, cellSize, active);
		if (getApCost() > 1) {
			Color textColor = active ? Color.black : Color.white;
			g.setColor(textColor);
			g.drawString("" + (int) getApCost(), drawX + 3, drawY + 1);
			g.setColor(Color.white);
		}
	}

	@Override
	public void render(Graphics g) {
		return;
	}

}
