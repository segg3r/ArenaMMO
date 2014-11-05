package by.segg3r.slicktest.logic.storage.animation;

import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.storage.Descriptor;
import by.segg3r.slicktest.logic.storage.RootDescriptor;
import by.segg3r.slicktest.logic.storage.Storage;

public abstract class AnimationStorage<T extends RootDescriptor<String, Sprite>>
		extends Storage<String, Sprite> {

	private static final long serialVersionUID = 1L;

	public AnimationStorage(String path) {
		super(path);
	}

	@Override
	public void load() throws SlickException {
		for (Descriptor<String, Sprite> subdescriptor : getRootDescriptor()
				.create()) {
			put(subdescriptor.getKey(), subdescriptor.create());
		}
	}

	protected abstract T getRootDescriptor() throws SlickException;

}
