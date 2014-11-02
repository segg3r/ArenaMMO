package by.segg3r.slicktest.logic.storage;

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
			createAnimation(descriptor.getFileName(), descriptor.getColumns(), descriptor.getRows());
		}
	}

	private List<AnimationDescriptor> getAnimationDescriptors() {
		//вернуть список описаний анимаций из файла в папке, путь к которой указан в path		
		List<AnimationDescriptor> result = new ArrayList<AnimationDescriptor>();
		result.add(new AnimationDescriptor("001-Fighter01", 4, 4));
		return result;
	}

	private void createAnimation(String animationName, int columns, int rows) throws SlickException {
		String fullFileName = path + animationName + ".png";
		
		Image image = new Image(fullFileName);
		int columnWidth = image.getWidth() / columns;
		int rowHeight = image.getHeight() / rows;
		SpriteSheet spriteSheet = new SpriteSheet(image, columnWidth, rowHeight);
		Animation animation = new Animation(spriteSheet, 20);
		
		animations.put(animationName, animation);
	}
	
}
