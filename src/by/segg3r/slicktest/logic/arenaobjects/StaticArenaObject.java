package by.segg3r.slicktest.logic.arenaobjects;

import by.segg3r.slicktest.logic.ArenaObject;
import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.math.Offset;

public class StaticArenaObject extends ArenaObject {

	public StaticArenaObject(Offset offset, Sprite sprite) {
		super(offset);
		this.setSprite(sprite);
	}

	@Override
	public void update(double delta) {
		super.update(delta);
	}

}
