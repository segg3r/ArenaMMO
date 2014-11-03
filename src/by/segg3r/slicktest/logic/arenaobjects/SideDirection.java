package by.segg3r.slicktest.logic.arenaobjects;

public enum SideDirection {

	LEFT, UP, DOWN, RIGHT;
	
	public static SideDirection fromDirection(double direction) {
		if ((direction > Math.PI * -1. / 4. && direction <= 0) || (direction < Math.PI * 1. / 4. && direction >= 0)) {
			return SideDirection.RIGHT;
		} else if ((direction >= Math.PI * 3. / 4. && direction <= Math.PI) || (direction < Math.PI * -3. / 4. && direction >= -Math.PI)) {
			return SideDirection.LEFT;
		} else if (direction >= Math.PI * 1. / 4. && direction < Math.PI * 3. / 4.) {
			return SideDirection.DOWN;
		} else {
			return SideDirection.UP;
		}
	}
	
	public int getMinImage() {
		if (this == LEFT) {
			return 4;
		} else if (this == RIGHT) {
			return 8;
		} else if (this == DOWN) {
			return 0;
		} else {
			return 12;
		}
	}
	
	public int getMaxImage() {
		if (this == LEFT) {
			return 7;
		} else if (this == RIGHT) {
			return 11;
		} else if (this == DOWN) {
			return 3;
		} else {
			return 15;
		}
	}
	
}
