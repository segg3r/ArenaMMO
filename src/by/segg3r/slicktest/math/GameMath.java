package by.segg3r.slicktest.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import by.segg3r.slicktest.logic.Arena;
import by.segg3r.slicktest.logic.arenaobjects.SideDirection;
import by.segg3r.slicktest.math.paths.OffsetDistanceComparator;
import by.segg3r.slicktest.math.paths.OffsetSequenceItem;

public class GameMath {

	public static boolean isOdd(int value) {
		return Math.abs(value) % 2 == 0;
	}

	public static Cube getCubeFromOffset(Offset offset) {
		int x = offset.getLeft()
				- (offset.getTop() + (offset.getTop() & 1)) / 2;
		int z = offset.getTop();
		int y = -x - z;
		return new Cube(x, y, z);
	}

	public static Offset getOffsetFromCube(Cube cube) {
		return new Offset(cube.getX() + (cube.getZ() + (cube.getZ() & 1)) / 2,
				cube.getZ());
	}
	
	public static double getPointDistance(Point p1, Point p2) {
		return Math.sqrt((p1.getX()-p2.getX())*(p1.getX()-p2.getX()) + (p1.getY()-p2.getY())*(p1.getY()-p2.getY()));
	}

	public static int getOffsetDistance(Offset o1, Offset o2) {
		Cube c1 = getCubeFromOffset(o1);
		Cube c2 = getCubeFromOffset(o2);
		return Math.max(
				Math.max(Math.abs(c1.getX() - c2.getX()),
						Math.abs(c1.getY() - c2.getY())),
				Math.abs(c1.getZ() - c2.getZ()));
	}

	public static List<Offset> getCircleItems(Circle circle) {
		List<Offset> result = new ArrayList<Offset>();

		for (int i = 0; i < Arena.get().getHeight(); i++) {
			for (int j = 0; j < Arena.get().getWidth(); j++) {
				Offset offset = new Offset(j, i);
				if (getOffsetDistance(offset, circle.getOffset()) <= circle
						.getRadius()) {
					result.add(offset);
				}
			}
		}

		return result;
	}

	public static Path getPath(Offset start, Offset finish) {
		Queue<OffsetSequenceItem> offsetQueue = new PriorityQueue<OffsetSequenceItem>(
				10, new OffsetDistanceComparator(finish));
		Map<Offset, Boolean> freeOffsets = getFreeOffsetsMap();

		OffsetSequenceItem item = new OffsetSequenceItem(start, null);
		freeOffsets.put(start, false);
		while (!item.getOffset().equals(finish)) {
			List<Offset> neighbors = getNeighbors(item.getOffset());
			for (Offset offset : neighbors) {
				addOffsetToQueue(offsetQueue, freeOffsets, offset, item);
			}
			item = offsetQueue.poll();
		}

		Path path = new Path();
		do {
			path.addOffset(item.getOffset());
			item = item.getPreviousOffsetSequenceItem();
		} while (item != null && item.getPreviousOffsetSequenceItem() != null);
		if (item != null) {
			path.addOffset(item.getOffset());
		}
		path.reverse();

		return path;
	}

	private static void addOffsetToQueue(Queue<OffsetSequenceItem> offsetQueue,
			Map<Offset, Boolean> freeOffsets, Offset offset,
			OffsetSequenceItem item) {
		if (Arena.get().isOffsetInArena(offset) && freeOffsets.get(offset)) {
			offsetQueue.add(new OffsetSequenceItem(offset, item));
			freeOffsets.put(offset, false);
		}
	}

	private static List<Offset> getNeighbors(Offset offset) {
		Cube cube = getCubeFromOffset(offset);
		return Arrays.asList(new Offset[] {
				getOffsetFromCube(new Cube(cube.getX(), cube.getY() + 1, cube
						.getZ() - 1)),
				getOffsetFromCube(new Cube(cube.getX() + 1, cube.getY(), cube
						.getZ() - 1)),
				getOffsetFromCube(new Cube(cube.getX() + 1, cube.getY() - 1,
						cube.getZ())),
				getOffsetFromCube(new Cube(cube.getX(), cube.getY() - 1, cube
						.getZ() + 1)),
				getOffsetFromCube(new Cube(cube.getX() - 1, cube.getY(), cube
						.getZ() + 1)),
				getOffsetFromCube(new Cube(cube.getX() - 1, cube.getY() + 1,
						cube.getZ())) });
	}

	private static Map<Offset, Boolean> getFreeOffsetsMap() {
		Map<Offset, Boolean> result = new HashMap<Offset, Boolean>();
		for (int i = 0; i < Arena.get().getHeight(); i++) {
			for (int j = 0; j < Arena.get().getWidth(); j++) {
				result.put(new Offset(j, i), true);
			}
		}
		return result;
	}

	public static SideDirection getSideDirection(double direction) {
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
	
	public static double getPointDirection(Point p1, Point p2) {
		return Math.atan2(p2.getY() - p1.getY(), p2.getX() - p1.getX());
	}

}
