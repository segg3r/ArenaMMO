package by.segg3r.slicktest.logic.storage.animation;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.logic.storage.Descriptor;
import by.segg3r.slicktest.logic.storage.RootDescriptor;
import by.segg3r.slicktest.logic.storage.Storage;

public abstract class AnimationStorage<T extends RootDescriptor<String, Animation>> extends Storage<String, Animation> {

	private static final long serialVersionUID = 1L;

	public AnimationStorage(String path) {
		super(path);
	}

	@Override
	public void load() throws SlickException {
		for (Descriptor<String, Animation> subdescriptor : getRootDescriptor().create()) {
			put(subdescriptor.getKey(), subdescriptor.create());
		}
	}
	
	protected abstract T getRootDescriptor() throws SlickException;

}
