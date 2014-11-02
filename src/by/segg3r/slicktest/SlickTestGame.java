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
import by.segg3r.slicktest.logic.renderable.RenderableCircle;
import by.segg3r.slicktest.logic.renderable.RenderableOffset;
import by.segg3r.slicktest.logic.renderable.RenderablePath;
import by.segg3r.slicktest.logic.storage.AnimationStorage;
import by.segg3r.slicktest.math.GameMath;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Point;

public class SlickTestGame extends BasicGame implements Renderable {

	private List<Renderable> renderables;
	private RenderableOffset activeOffset;
	private RenderablePath renderablePath;
	private RenderableCircle renderableCircle;
	public SlickTestGame(String title) {
		super(title);
		this.renderables = new ArrayList<Renderable>();
	}

	@Override
	public void init(GameContainer gameContainer) throws SlickException {
		addRenderable(Arena.get());
	}

	@Override
	public void render(GameContainer gameContainer, Graphics g)
			throws SlickException {
		render(g);

		if (activeOffset != null) {
			activeOffset.render(g);
		}
		if (renderablePath != null) {
			renderablePath.render(g);
		}
		if (renderableCircle != null) {
			renderableCircle.render(g);
		}
		AnimationStorage.getCharacterAnimation("res/img/001-Fighter01.png").draw(100, 100);
	}

	@Override
	public void update(GameContainer gameContainer, int delta)
			throws SlickException {
		Input input = gameContainer.getInput();
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		Point mousePoint = new Point(mouseX, mouseY);
		activeOffset = Arena.get().isPointInArena(mousePoint) ? new RenderableOffset(Arena.get().getOffsetByPoint(mousePoint)) : null;
		
		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON) && activeOffset != null) {
			renderablePath = new RenderablePath(GameMath.getPath(new Offset(0, 0), activeOffset));
			renderableCircle = new RenderableCircle(activeOffset, 2);
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
