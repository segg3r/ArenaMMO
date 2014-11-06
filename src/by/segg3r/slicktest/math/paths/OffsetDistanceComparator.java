package by.segg3r.slicktest.math.paths;

import java.util.Comparator;

import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Point;

public class OffsetDistanceComparator implements Comparator<OffsetSequenceItem> {

	private Offset finish;

	public OffsetDistanceComparator(Offset finish) {
		super();
		this.finish = finish;
	}

	@Override
	public int compare(OffsetSequenceItem o1, OffsetSequenceItem o2) {
		Point p1 = o1.getOffset().toHalfPoint();
		Point p2 = o2.getOffset().toHalfPoint();
		Point finishPoint = finish.toHalfPoint();

		return (int) (p1.distanceTo(finishPoint) + o1.getTraversed() - (p2
				.distanceTo(finishPoint) + o2.getTraversed()));
	}
}
