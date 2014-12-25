package by.segg3r.slicktest;

import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.logic.storage.animation.character.AnimationStorage;
import by.segg3r.slicktest.logic.storage.animation.tileset.Tileset;

public class Storages {

	public static AnimationStorage CHARACTERS_ANIMATIONS = new AnimationStorage(
			"res\\img\\characters\\");
	public static Tileset GRASS_TILESET = new Tileset(
			"res\\img\\tilesets\\grassland.txt");
	public static AnimationStorage EFFECTS_STORAGE = new AnimationStorage(
			"res\\img\\effects\\");
	public static Tileset ICON_SET = new Tileset(
			"res\\img\\tilesets\\iconset.txt");

	public static void init() throws SlickException {
		CHARACTERS_ANIMATIONS.load();
		GRASS_TILESET.load();
		EFFECTS_STORAGE.load();
		ICON_SET.load();
	}

}
