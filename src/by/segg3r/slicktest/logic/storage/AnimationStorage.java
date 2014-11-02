package by.segg3r.slicktest.logic.storage;

import java.util.Map;
import java.util.TreeMap;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class AnimationStorage {

	private static Map<String, Animation> animations = new TreeMap<String, Animation>();

	public static Animation getAnimation(String fileName, int columns, int rows) throws SlickException {
		if (animations.get(fileName) == null) {
			Image image = new Image(fileName);
			int columnWidth = image.getWidth() / columns;
			int rowHeight = image.getHeight() / rows;
			SpriteSheet spriteSheet = new SpriteSheet(image, columnWidth, rowHeight);
			Animation animation = new Animation(spriteSheet, 20);
			
			animations.put(fileName, animation);
		} 
		return animations.get(fileName);
	}
	
	public static Animation getCharacterAnimation(String fileName) throws SlickException {
		return getAnimation(fileName, 4, 4);
	}
	
}
