package by.segg3r.slicktest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.logic.Arena;
import by.segg3r.slicktest.logic.ArenaObject;
import by.segg3r.slicktest.logic.Background;
import by.segg3r.slicktest.logic.Entity;
import by.segg3r.slicktest.logic.Renderable;
import by.segg3r.slicktest.logic.RenderablePositionComparator;
import by.segg3r.slicktest.logic.UIObject;
import by.segg3r.slicktest.logic.actions.ActionPanel;
import by.segg3r.slicktest.logic.actions.ActionQueue;
import by.segg3r.slicktest.logic.actions.BigShotActionFactory;
import by.segg3r.slicktest.logic.actions.GameState;
import by.segg3r.slicktest.logic.actions.PathActionFactory;
import by.segg3r.slicktest.logic.actions.ShotActionFactory;
import by.segg3r.slicktest.logic.arenaobjects.Char;
import by.segg3r.slicktest.logic.arenaobjects.StaticArenaObject;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Point;

public class Game extends BasicGame {

	public static final int AP_PER_TURN = 3;
	
	private ActionQueue actionQueue;
	private Set<Renderable> renderables = new TreeSet<Renderable>(
			new RenderablePositionComparator());
	public static List<ArenaObject> entities = new ArrayList<ArenaObject>();
	private Offset activeOffset;
	public static Char character;

	private ActionPanel actionPanel;
	private UIObject uiObject;

	public Game(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer gameContainer) throws SlickException {
		Storages.init();

		StaticArenaObject cuttedTree = new StaticArenaObject(new Offset(3, 3),
				Storages.GRASS_TILESET.get("cutted_tree"));
		entities.add(cuttedTree);
		renderables.add(cuttedTree);

		StaticArenaObject tree = new StaticArenaObject(new Offset(4, 0),
				Storages.GRASS_TILESET.get("tree"));
		entities.add(tree);
		renderables.add(tree);

		addRenderable(Arena.get());

		Arena arena = Arena.get();
		for (int i = 0; i < arena.getHeight(); i++) {
			for (int j = 0; j < arena.getWidth(); j++) {
				renderables.add(new Background(new Offset(j, i),
						Storages.GRASS_TILESET.get("grassBg")));
			}
		}

		actionPanel = new ActionPanel(new Point(20, 350), 36);
		renderables.add(actionPanel);

		actionPanel.addActionFactory(new PathActionFactory(Storages.ICON_SET
				.get("stepAction")));
		actionPanel.addActionFactory(new ShotActionFactory(Storages.ICON_SET
				.get("shotAction")));
		actionPanel.addActionFactory(new BigShotActionFactory(Storages.ICON_SET
				.get("bigShotAction")));
	}

	@Override
	public void render(GameContainer gameContainer, Graphics g)
			throws SlickException {
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

		GameState gameState = getGameState();

		if (actionPanel.getActiveActionFactory() != null
				&& actionPanel.getActiveActionFactory().isAppliable(gameState)) {
			resetUIObject(actionPanel.getActiveActionFactory().getUIObject(
					gameState));
		} else {
			resetUIObject(null);
		}

		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)
				&& activeOffset != null) {
			if (character == null) {
				character = new Char(activeOffset,
						Storages.CHARACTERS_ANIMATIONS.get("001-Fighter01"));
				actionQueue = new ActionQueue(activeOffset);
				entities.add(character);
				renderables.add(character);
				renderables.add(actionQueue);
			} else {
				if (actionPanel.getActiveActionFactory() != null
						&& actionPanel.getActiveActionFactory().isAppliable(
								gameState)) {
					actionQueue.addAction(actionPanel.getActiveActionFactory()
							.produceAction(gameState));
				}
			}
		}

		if (input.isKeyPressed(Input.KEY_1)) {
			actionPanel.setActionActionFactory(0);
		} else if (input.isKeyPressed(Input.KEY_2)) {
			actionPanel.setActionActionFactory(1);
		} else if (input.isKeyPressed(Input.KEY_3)) {
			actionPanel.setActionActionFactory(2);
		}

		for (Entity entity : entities) {
			entity.update(delta / 1000.);
		}
	}

	private GameState getGameState() {
		return new GameState(actionQueue, character, activeOffset);
	}

	private void resetUIObject(UIObject uiObject) {
		if (this.uiObject != null) {
			renderables.remove(this.uiObject);
		}
		this.uiObject = uiObject;
		if (this.uiObject != null) {
			renderables.add(this.uiObject);
		}
	}

	private void addRenderable(Renderable renderable) {
		this.renderables.add(renderable);
	}

	private void render(Graphics g) {
		for (Renderable renderable : renderables) {
			renderable.render(g);
		}
	}

}
