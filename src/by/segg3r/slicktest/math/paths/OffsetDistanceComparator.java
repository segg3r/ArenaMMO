package by.segg3r.slicktest.math.paths;

import java.util.Comparator;

import by.segg3r.slicktest.logic.Arena;
import by.segg3r.slicktest.math.GameMath;
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
		Arena arena = Arena.get();
		Point p1 = arena.getArenaPointByOffset(o1.getOffset());
		Point p2 = arena.getArenaPointByOffset(o2.getOffset());
		Point finishPoint = arena.getArenaPointByOffset(finish);

		return (int) (GameMath.getPointDistance(p1, finishPoint) - GameMath
				.getPointDistance(p2, finishPoint));
	}
}
