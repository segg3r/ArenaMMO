package by.segg3r.slicktest.logic;

import java.util.HashSet;
import java.util.Set;

import by.segg3r.slicktest.math.Offset;

public abstract class ArenaObject extends Entity {

	private Offset offset;

	public ArenaObject() {
		super();
	}

	public ArenaObject(Offset offset) {
		super(offset.toHalfPoint());
		this.offset = offset;
	}

	public Set<Offset> getMask() {
		Set<Offset> mask = new HashSet<Offset>();

		for (Offset maskOffset : getSprite().getMask()) {
			mask.add(maskOffset.plus(offset));
		}

		return mask;
	}

	public Offset getOffset() {
		return offset;
	}

	public void setOffset(Offset offset) {
		this.offset = offset;
	}

}
