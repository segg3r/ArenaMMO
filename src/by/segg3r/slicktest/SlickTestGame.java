package by.segg3r.slicktest;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.logic.Arena;
import by.segg3r.slicktest.logic.Renderable;
import by.segg3r.slicktest.logic.Updatable;
import by.segg3r.slicktest.logic.actions.ActionQueue;
import by.segg3r.slicktest.logic.actions.PathAction;
import by.segg3r.slicktest.logic.arenaobjects.Char;
import by.segg3r.slicktest.logic.storage.CharacterAnimationStorage;
import by.segg3r.slicktest.math.Line;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Point;

public class SlickTestGame extends BasicGame implements Renderable {

	private CharacterAnimationStorage charactersAnimationStorage = new CharacterAnimationStorage(
			"res\\img\\characters\\");

	private ActionQueue actionQueue;
	private List<Renderable> renderables;
	private List<Updatable> updatables;
	private Offset activeOffset;
	private Char character;

	private Line line;

	public SlickTestGame(String title) {
		super(title);
		this.renderables = new ArrayList<Renderable>();
		this.updatables = new ArrayList<Updatable>();
	}

	@Override
	public void init(GameContainer gameContainer) throws SlickException {
		charactersAnimationStorage.load();

		addRenderable(Arena.get());
	}

	@Override
	public void render(GameContainer gameContainer, Graphics g)
			throws SlickException {
		if (activeOffset != null) {
			activeOffset.render(g);
		}
		if (line != null) {
			line.render(g);
		}

		render(g);
	}

	@Override
	public void update(GameContainer gameContainer, int delta)
			throws SlickException {
		Input input = gameContainer.getInput();
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		Point mousePoint = new Point(mouseX, mouseY);
		activeOffset = mousePoint.isInArena() ? mousePoint.toOffset() : null;

		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)
				&& activeOffset != null) {
			if (character == null) {
				character = new Char(activeOffset,
						charactersAnimationStorage.get("001-Fighter01"));
				actionQueue = new ActionQueue(activeOffset);
				updatables.add(character);
				renderables.add(character);
				renderables.add(actionQueue);
			} else {
				actionQueue.addAction(new PathAction(actionQueue, character,
						activeOffset));
			}
		}
		if (character != null && activeOffset != null) {
			line = new Line(actionQueue.getLastOffset(), activeOffset);
		}

		for (Updatable updatable : updatables) {
			updatable.update(delta / 1000.);
		}
	}

	private void addRenderable(Renderable renderable) {
		this.renderables.add(renderable);
	}

	@Override
	public void render(Graphics g) {
		for (Renderable renderable : renderables) {
			renderable.render(g);
		}
	}

}
