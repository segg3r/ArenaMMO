package by.segg3r.slicktest.logic.storage.animation.tileset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.storage.Descriptor;
import by.segg3r.slicktest.logic.storage.RootDescriptor;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Point;

public class TilesetDescriptor extends RootDescriptor<String, Sprite> {

	private String path;
	private int columnsNumber;
	private int rowsNumber;

	public TilesetDescriptor(String path, String key, int columnsNumber,
			int rowsNumber) {
		super(key);
		this.path = path;
		this.columnsNumber = columnsNumber;
		this.rowsNumber = rowsNumber;
	}

	@Override
	public List<Descriptor<String, Sprite>> create() throws SlickException {
		try {
			List<Descriptor<String, Sprite>> result = new ArrayList<Descriptor<String, Sprite>>();
			File file = new File(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
			br.readLine();
			String line;

			Image tilesetImage = new Image(path.substring(0,
					path.lastIndexOf("\\") + 1)
					+ getKey());

			while ((line = br.readLine()) != null) {
				String[] parameters = line.split(";");

				List<Offset> mask = new ArrayList<Offset>();
				for (int i = 7; i < parameters.length; i += 2) {
					mask.add(new Offset(Integer.valueOf(parameters[i]), Integer
							.valueOf(parameters[i + 1])));
				}

				result.add(new TileDescriptor(parameters[0], tilesetImage,
						columnsNumber, rowsNumber, Integer
								.parseInt(parameters[1]), Integer
								.parseInt(parameters[2]), Integer
								.parseInt(parameters[3]), Integer
								.parseInt(parameters[4]), new Point(Integer
								.parseInt(parameters[5]), Integer
								.parseInt(parameters[6])), mask));
			}
			br.close();
			return result;
		} catch (Exception e) {
			throw new SlickException(e.getMessage());
		}
	}
}
