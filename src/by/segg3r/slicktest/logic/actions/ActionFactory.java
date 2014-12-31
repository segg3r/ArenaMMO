package by.segg3r.slicktest.logic.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.UIObject;
import by.segg3r.slicktest.logic.listener.ActionListener;
import by.segg3r.slicktest.logic.listener.ActionType;

public abstract class ActionFactory implements ActionListener {

	private Sprite icon;
	private int cooldown;
	private int currentCooldown;
	private String name = "";

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

	public void renderDescription(Graphics g) {
		int drawX = 20;
		int drawY = 335;
		int width = 325;
		int height = 0;
		int perString = 25;

		List<String> strings = getDescriptionStrings();
		drawY -= strings.size() * perString;
		height += strings.size() * perString;

		g.setColor(Color.white);
		g.fillRect(drawX, drawY, width, height);
		g.setColor(Color.black);
		g.drawRect(drawX, drawY, width, height);

		int i = 0;
		for (String s : getDescriptionStrings()) {
			g.drawString(s, drawX + 5, drawY + 5 + i * 20);
			i++;
		}
		g.drawString(getNameString(), drawX + 5, drawY + 5);
		g.setColor(Color.white);
	}

	private List<String> getDescriptionStrings() {
		List<String> result = new ArrayList<String>();
		result.add(getNameString());
		result.addAll(getDescriptions());
		return result;
	}

	protected List<String> getDescriptions() {
		return Arrays.asList(new String[] {});
	}

	protected String getNameString() {
		String result = name;
		if (cooldown > 0) {
			result += "; CD: " + cooldown;
		}

		return result;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
