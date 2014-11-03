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
import by.segg3r.slicktest.logic.arenaobjects.Char;
import by.segg3r.slicktest.logic.storage.AnimationStorage;
import by.segg3r.slicktest.math.Circle;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Point;

public class SlickTestGame extends BasicGame implements Renderable {

	private AnimationStorage charactersAnimationStorage = new AnimationStorage("res/img/characters/");
	
	private List<Renderable> renderables;
	private List<Updatable> updatables;
	private Offset activeOffset;
	private Circle renderableCircle;
	private Char character;
	
	public SlickTestGame(String title) {
		super(title);
		this.renderables = new ArrayList<Renderable>();
		this.updatables = new ArrayList<Updatable>();
	}

	@Override
	public void init(GameContainer gameContainer) throws SlickException {
		charactersAnimationStorage.loadAnimations();
		
		addRenderable(Arena.get());
	}

	@Override
	public void render(GameContainer gameContainer, Graphics g)
			throws SlickException {
		if (activeOffset != null) {
			activeOffset.render(g);
		}
		if (renderableCircle != null) {
			renderableCircle.render(g);
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
		
		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON) && activeOffset != null) {			
			if (character == null) {
				character = new Char(activeOffset, charactersAnimationStorage.getAnimation("001-Fighter01"));
				updatables.add(character);
				renderables.add(character);
			}
			character.setPath(character.getPosition().toOffset().pathTo(activeOffset));
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
