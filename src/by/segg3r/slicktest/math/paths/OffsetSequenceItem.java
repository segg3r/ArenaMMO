package by.segg3r.slicktest.math.paths;

import by.segg3r.slicktest.math.Offset;

public class OffsetSequenceItem {

	private Offset offset;
	private OffsetSequenceItem previousOffsetSequenceItem;
	private double traversed;

	public OffsetSequenceItem(Offset offset, OffsetSequenceItem item,
			double traversed) {
		super();
		this.offset = offset;
		this.previousOffsetSequenceItem = item;
		this.setTraversed(traversed);
	}

	public Offset getOffset() {
		return offset;
	}

	public void setOffset(Offset offset) {
		this.offset = offset;
	}

	public OffsetSequenceItem getPreviousOffsetSequenceItem() {
		return previousOffsetSequenceItem;
	}

	public void setPreviousOffset(OffsetSequenceItem previousOffsetSequenceItem) {
		this.previousOffsetSequenceItem = previousOffsetSequenceItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offset == null) ? 0 : offset.hashCode());
		result = prime
				* result
				+ ((previousOffsetSequenceItem == null) ? 0
						: previousOffsetSequenceItem.hashCode());
		long temp;
		temp = Double.doubleToLongBits(traversed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OffsetSequenceItem other = (OffsetSequenceItem) obj;
		if (offset == null) {
			if (other.offset != null)
				return false;
		} else if (!offset.equals(other.offset))
			return false;
		if (previousOffsetSequenceItem == null) {
			if (other.previousOffsetSequenceItem != null)
				return false;
		} else if (!previousOffsetSequenceItem
				.equals(other.previousOffsetSequenceItem))
			return false;
		if (Double.doubleToLongBits(traversed) != Double
				.doubleToLongBits(other.traversed))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OffsetSequenceItem [offset=" + offset + ", traversed="
				+ traversed + "]";
	}

	public double getTraversed() {
		return traversed;
	}

	public void setTraversed(double traversed) {
		this.traversed = traversed;
	}

}
