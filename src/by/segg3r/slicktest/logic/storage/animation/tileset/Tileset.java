package by.segg3r.slicktest.logic.storage.animation.tileset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.logic.storage.animation.SpriteStorage;

public class Tileset extends SpriteStorage<TilesetDescriptor> {

	private static final long serialVersionUID = 1L;

	public Tileset(String path) {
		super(path);
	}

	@Override
	protected TilesetDescriptor getRootDescriptor() throws SlickException {
		try {
			File file = new File(getPath());
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
			String[] parameters = br.readLine().split(";");
			br.close();

			return new TilesetDescriptor(getPath(), parameters[0],
					Integer.valueOf(parameters[1]),
					Integer.valueOf(parameters[2]));
		} catch (Exception e) {
			throw new SlickException(e.getMessage());
		}
	}

}
