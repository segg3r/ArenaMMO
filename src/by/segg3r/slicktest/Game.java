package by.segg3r.slicktest;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.logic.Arena;
import by.segg3r.slicktest.logic.ArenaObject;
import by.segg3r.slicktest.logic.Entity;
import by.segg3r.slicktest.logic.Renderable;
import by.segg3r.slicktest.logic.actions.ActionQueue;
import by.segg3r.slicktest.logic.actions.PathAction;
import by.segg3r.slicktest.logic.arenaobjects.Char;
import by.segg3r.slicktest.logic.arenaobjects.StaticArenaObject;
import by.segg3r.slicktest.logic.storage.animation.character.CharacterAnimationStorage;
import by.segg3r.slicktest.logic.storage.animation.tileset.Tileset;
import by.segg3r.slicktest.math.Line;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Path;
import by.segg3r.slicktest.math.Point;

public class Game extends BasicGame implements Renderable {

	private CharacterAnimationStorage charactersAnimationStorage = new CharacterAnimationStorage(
			"res\\img\\characters\\");
	private Tileset grassTileset = new Tileset(
			"res\\img\\tilesets\\grassland.txt");

	private ActionQueue actionQueue;
	private List<Renderable> renderables;
	public static List<ArenaObject> entities = new ArrayList<ArenaObject>();
	private Offset activeOffset;
	private Char character;

	private Line line;

	public Game(String title) {
		super(title);
		this.renderables = new ArrayList<Renderable>();
	}

	@Override
	public void init(GameContainer gameContainer) throws SlickException {
		charactersAnimationStorage.load();
		grassTileset.load();

		StaticArenaObject cuttedTree = new StaticArenaObject(new Offset(3, 3),
				grassTileset.get("cutted_tree"));
		entities.add(cuttedTree);
		renderables.add(cuttedTree);

		StaticArenaObject tree = new StaticArenaObject(new Offset(4, 0),
				grassTileset.get("tree"));
		entities.add(tree);
		renderables.add(tree);

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
				entities.add(character);
				renderables.add(character);
				renderables.add(actionQueue);
			} else {
				Path path = actionQueue.getLastOffset().pathTo(activeOffset);
				if (path != null) {
					actionQueue.addAction(new PathAction(actionQueue,
							character, path));
				}
			}
		}
		if (character != null && activeOffset != null) {
			line = new Line(actionQueue.getLastOffset(), activeOffset);
		}

		for (Entity entity : entities) {
			entity.update(delta / 1000.);
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
