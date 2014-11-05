package by.segg3r.slicktest.logic.storage;

import java.util.List;

import org.newdawn.slick.SlickException;

public abstract class RootDescriptor<T, P> {

	private T key;

	public RootDescriptor(T key) {
		super();
		this.setKey(key);
	}

	public abstract List<Descriptor<T, P>> create() throws SlickException;

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

}
