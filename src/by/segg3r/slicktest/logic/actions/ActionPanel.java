package by.segg3r.slicktest.logic.actions;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Layer;
import by.segg3r.slicktest.logic.Renderable;
import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.math.Point;

public class ActionPanel implements Renderable {

	private ActionFactory activeActionFactory;
	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	private Point position;
	private int cellSize;

	public ActionPanel(Point position, int cellSize) {
		super();
		this.position = position;
		this.cellSize = cellSize;
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
			g.drawRect((float) position.x + i * cellSize, (float) position.y, cellSize, cellSize);
			if (i == actionFactories.indexOf(activeActionFactory)) {
				g.fillRect((float) position.x + i * cellSize, (float) position.y, cellSize, cellSize);
			}
			
			ActionFactory actionFactory = actionFactories.get(i);
			Sprite icon = actionFactory.getIcon();
			int width = icon.getWidth();
			int height = icon.getHeight();
			
			icon.draw((float) (position.x + (i + 0.5) * cellSize - width / 2.), (float) (position.y + cellSize * 0.5 - height / 2.));

			Color numberColor = i == actionFactories.indexOf(activeActionFactory) ? Color.black : Color.white;
			g.setColor(numberColor);
			g.drawString("" + (i + 1), (int) (position.x + i * cellSize + 1), (int) (position.y));
			g.setColor(Color.white);
		}
	}

	@Override
	public Layer getLayer() {
		return Layer.UI;
	}

	@Override
	public Point getPosition() {
		return position;
	}

}
