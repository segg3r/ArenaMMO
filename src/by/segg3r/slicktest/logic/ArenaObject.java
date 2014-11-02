package by.segg3r.slicktest.logic;

import by.segg3r.slicktest.math.Offset;

public abstract class ArenaObject extends Entity {

	private Offset offset;

	public ArenaObject() {
		super();
	}
	
	public ArenaObject(Offset offset) {
		super(Arena.get().getArenaHalfPointByOffset(offset));
		this.offset = offset;
	}

	public Offset getOffset() {
		return offset;
	}

	public void setOffset(Offset offset) {
		this.offset = offset;
	}
	
}
