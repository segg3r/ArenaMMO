package by.segg3r.slicktest.logic.storage.animation.character;

import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.logic.storage.animation.AnimationStorage;


public class CharacterAnimationStorage extends
		AnimationStorage<RootCharacterAnimationDescriptor> {

	private static final long serialVersionUID = 1L;

	public CharacterAnimationStorage(String path) {
		super(path);
	}

	@Override
	protected RootCharacterAnimationDescriptor getRootDescriptor() throws SlickException {
		return new RootCharacterAnimationDescriptor(getPath());
	}

}
