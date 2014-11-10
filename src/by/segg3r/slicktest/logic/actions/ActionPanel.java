package by.segg3r.slicktest.logic.actions;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Layer;
import by.segg3r.slicktest.logic.Renderable;
import by.segg3r.slicktest.math.Point;

public class ActionPanel implements Renderable {

	private ActionFactory activeActionFactory;
	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	private Point position;

	public ActionPanel(Point position) {
		super();
		this.position = position;
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
			ActionFactory actionFactory = actionFactories.get(i);
			actionFactory.getIcon()
					.draw((float) position.x, (float) position.y);
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
