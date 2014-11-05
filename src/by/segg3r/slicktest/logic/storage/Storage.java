package by.segg3r.slicktest.logic.storage;

import java.util.TreeMap;

import org.newdawn.slick.SlickException;

public abstract class Storage<T, P> extends TreeMap<T, P> {

	private static final long serialVersionUID = 1L;

	private String path;

	public Storage(String path) {
		super();
		this.path = path;
	}

	public abstract void load() throws SlickException;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
