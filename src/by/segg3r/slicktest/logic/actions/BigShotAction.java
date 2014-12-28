package by.segg3r.slicktest.logic.actions;

import by.segg3r.slicktest.Storages;
import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Point;
import by.segg3r.slicktest.math.Sector;

public class BigShotAction extends AnimatedAction {

	public static final int RADIUS = 3;
	public static final double SECTOR_SIZE = Math.PI / 3;
	public static final double ENERGY_COST = 60;
	public static final double ACTION_COST = 1;

	private Sprite sprite;
	private Sector sector;
	private boolean looped;

	public BigShotAction(Sprite icon, ActionQueue actionQueue, Sector sector) {
		super(icon, actionQueue, ACTION_COST);
		this.sector = sector;
	}

	@Override
	public void start() {
		super.start();
		sprite = Storages.EFFECTS_STORAGE.get("Fire01").copy();
		sprite.setCurrentFrame(0);
	}

	@Override
	public void renderAnimation() {
		for (Offset offset : sector.getOffsets()) {
			Point point = offset.toHalfPoint();
			sprite.draw((float) point.x, (float) point.y);
		}
		if (sprite.getFrame() == sprite.getFrameCount() - 1) {
			looped = true;
		} else if (sprite.getFrame() == 0 && looped) {
			finish();
		}
	}

}
