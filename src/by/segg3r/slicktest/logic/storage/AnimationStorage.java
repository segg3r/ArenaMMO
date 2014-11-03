package by.segg3r.slicktest.logic.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class AnimationStorage {

	private String path;
	private Map<String, Animation> animations = new TreeMap<String, Animation>();

	public AnimationStorage(String path) {
		super();
		this.path = path;
	}

	public Animation getAnimation(String animationName) {
		return animations.get(animationName);
	}

	public void loadAnimations() throws SlickException {
		for (AnimationDescriptor descriptor : getAnimationDescriptors()) {
			createAnimation(descriptor.getFileName(), descriptor.getColumns(),
					descriptor.getRows());
		}
	}

	private void createAnimation(String animationName, int columns, int rows)
			throws SlickException {
		String fullFileName = path + animationName + ".png";

		Image image = new Image(fullFileName);
		int columnWidth = image.getWidth() / columns;
		int rowHeight = image.getHeight() / rows;
		SpriteSheet spriteSheet = new SpriteSheet(image, columnWidth, rowHeight);
		Animation animation = new Animation(spriteSheet, 250);

		animations.put(animationName, animation);
	}

	private List<AnimationDescriptor> getAnimationDescriptors() {
		List<AnimationDescriptor> result = new ArrayList<AnimationDescriptor>();

		try {
			File file = new File(path + "/animationDescriptor.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));

			String line;
			while ((line = br.readLine()) != null) {
				String[] parametres;
				parametres = line.split(";");
				if (!parametres[0].equals("*")) {
					result.add(new AnimationDescriptor(parametres[0], Integer
							.parseInt(parametres[1]), Integer
							.parseInt(parametres[2]), Integer
							.parseInt(parametres[3]), Integer
							.parseInt(parametres[4]), Double
							.parseDouble(parametres[5])));
				} else {
					File dir = new File(path);
					File[] files = dir.listFiles();
					for (File f : files) {
						if (f.getPath().matches(
								path.replaceAll("\\\\", "\\\\\\\\")
										+ "\\\\.+\\.png")) {
							String fileName = f.getName().substring(0,
									f.getName().length() - 4);
							result.add(new AnimationDescriptor(fileName,
									Integer.parseInt(parametres[1]), Integer
											.parseInt(parametres[2]), Integer
											.parseInt(parametres[3]), Integer
											.parseInt(parametres[4]), Double
											.parseDouble(parametres[5])));
						}
					}
				}
			}

			br.close();

			return result;
		} catch (Exception e) {
			return new ArrayList<AnimationDescriptor>();
		}
	}

}
