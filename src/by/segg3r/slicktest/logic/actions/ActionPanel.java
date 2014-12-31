package by.segg3r.slicktest.logic.actions;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.Game;
import by.segg3r.slicktest.logic.Layer;
import by.segg3r.slicktest.logic.Renderable;
import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.listener.ActionListener;
import by.segg3r.slicktest.logic.listener.ActionType;
import by.segg3r.slicktest.math.Point;

public class ActionPanel implements Renderable, ActionListener {

	private ActionFactory activeActionFactory;
	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	private Point position;
	private int cellSize;
	private ActionFactory mouseActionFactory;

	public ActionPanel(Point position, int cellSize) {
		super();
		this.position = position;
		this.cellSize = cellSize;
		Game.addListener(ActionType.TURN_END, this);
	}

	public void updateMouseActionFactory(int mouseX, int mouseY) {
		int xNumber = (mouseX - (int) position.x) / cellSize;

		if (mouseX >= position.x && xNumber < actionFactories.size()
				&& mouseY >= position.y && mouseY <= position.y + cellSize) {
			mouseActionFactory = getActionFactory(xNumber);
		} else {
			mouseActionFactory = null;
		}
	}

	public void addActionFactory(ActionFactory actionFactory) {
		this.actionFactories.add(actionFactory);
	}

	public void setActionActionFactory(int i) {
		this.activeActionFactory = getActionFactory(i);
	}

	public ActionFactory getActiveActionFactory() {
		return this.activeActionFactory;
	}

	public ActionFactory getActionFactory(int i) {
		if (i < actionFactories.size()) {
			return actionFactories.get(i);
		}
		return null;
	}

	@Override
	public void render(Graphics g) {
		for (int i = 0; i < actionFactories.size(); i++) {
			g.drawRect((float) position.x + i * cellSize, (float) position.y,
					cellSize, cellSize);
			if (i == actionFactories.indexOf(activeActionFactory)) {
				g.fillRect((float) position.x + i * cellSize,
						(float) position.y, cellSize, cellSize);
			}

			ActionFactory actionFactory = actionFactories.get(i);
			Sprite icon = actionFactory.getIcon();
			int width = icon.getWidth();
			int height = icon.getHeight();

			icon.draw((float) (position.x + (i + 0.5) * cellSize - width / 2.),
					(float) (position.y + cellSize * 0.5 - height / 2.));

			Color numberColor = i == actionFactories
					.indexOf(activeActionFactory) ? Color.black : Color.white;
			g.setColor(numberColor);
			g.drawString("" + (i + 1), (int) (position.x + i * cellSize + 1),
					(int) (position.y));
			g.setColor(Color.white);

			if (actionFactory.getCurrentCooldown() > 0) {
				g.setColor(new Color(255, 255, 255, 225));

				g.fillRect((float) position.x + i * cellSize,
						(float) position.y, cellSize, cellSize);
				g.setColor(Color.black);
				g.drawString("" + actionFactory.getCurrentCooldown(),
						(float) (position.x + i * cellSize + 13),
						(float) (position.y + 10));

				g.setColor(Color.white);
			}
		}
		
		if (mouseActionFactory != null) {
			mouseActionFactory.renderDescription(g);
		}
	}

	@Override
	public Layer getLayer() {
		return Layer.ACTION_PANEL;
	}

	@Override
	public Point getPosition() {
		return position;
	}

	@Override
	public void perform(ActionType actionType, GameState gameState) {
		for (ActionFactory factory : actionFactories) {
			factory.perform(actionType, gameState);
		}
	}

}
