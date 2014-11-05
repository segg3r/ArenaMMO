package by.segg3r.slicktest.logic.storage;

import org.newdawn.slick.SlickException;

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
