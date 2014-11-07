package by.segg3r.slicktest.logic.storage.animation.character;

import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.logic.storage.animation.SpriteStorage;


public class AnimationStorage extends
		SpriteStorage<RootAnimationDescriptor> {

	private static final long serialVersionUID = 1L;

	public AnimationStorage(String path) {
		super(path);
	}

	@Override
	protected RootAnimationDescriptor getRootDescriptor() throws SlickException {
		return new RootAnimationDescriptor(getPath());
	}

}
