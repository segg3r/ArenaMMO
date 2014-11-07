package by.segg3r.slicktest.logic.storage.animation.character;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.storage.Descriptor;
import by.segg3r.slicktest.logic.storage.RootDescriptor;
import by.segg3r.slicktest.math.Point;

public class RootAnimationDescriptor extends
		RootDescriptor<String, Sprite> {

	public RootAnimationDescriptor(String key) {
		super(key);
	}

	@Override
	public List<Descriptor<String, Sprite>> create() throws SlickException {
		List<Descriptor<String, Sprite>> result = new ArrayList<Descriptor<String, Sprite>>();

		try {
			File file = new File(getKey() + "/animationDescriptor.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));

			String line;
			while ((line = br.readLine()) != null) {
				String[] parametres;
				parametres = line.split(";");
				if (!parametres[0].equals("*")) {
					result.add(new AnimationDescriptor(getKey(),
							parametres[0], Integer.parseInt(parametres[1]),
							Integer.parseInt(parametres[2]), new Point(Integer
									.parseInt(parametres[3]), Integer
									.parseInt(parametres[4])), Integer
									.parseInt(parametres[5])));
				} else {
					File dir = new File(getKey());
					File[] files = dir.listFiles();
					for (File f : files) {
						if (f.getPath().matches(
								getKey().replaceAll("\\\\", "\\\\\\\\")
										+ ".+\\.png")) {
							String fileName = f.getName().substring(0,
									f.getName().length() - 4);
							result.add(new AnimationDescriptor(
									getKey(), fileName, Integer
											.parseInt(parametres[1]), Integer
											.parseInt(parametres[2]),
									new Point(Integer.parseInt(parametres[3]),
											Integer.parseInt(parametres[4])),
									Integer.parseInt(parametres[5])));
						}
					}
				}
			}

			br.close();

			return result;
		} catch (Exception e) {
			throw new SlickException(e.getMessage());
		}
	}

}
