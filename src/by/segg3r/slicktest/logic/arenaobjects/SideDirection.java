package by.segg3r.slicktest.logic.arenaobjects;

public enum SideDirection {

	LEFT, UP, DOWN, RIGHT;
	
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
