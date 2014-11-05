package by.segg3r.slicktest.logic.storage;

import org.newdawn.slick.SlickException;

public abstract class Descriptor<T, P> {

	private T key;

	public Descriptor(T key) {
		super();
		this.setKey(key);
	}
	
	public abstract P create() throws SlickException;

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	
}
