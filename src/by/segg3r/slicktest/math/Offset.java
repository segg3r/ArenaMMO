package by.segg3r.slicktest.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.logic.Arena;
import by.segg3r.slicktest.logic.Renderable;
import by.segg3r.slicktest.math.paths.OffsetDistanceComparator;
import by.segg3r.slicktest.math.paths.OffsetSequenceItem;

public class Offset implements Renderable {

	public int left;
	public int top;

	public Offset(int left, int top) {
		super();
		this.left = left;
		this.top = top;
	}

	public int distanceTo(Offset o2) {
		Cube c1 = toCube();
		Cube c2 = o2.toCube();
		return Math.max(
				Math.max(Math.abs(c1.x - c2.x),
						Math.abs(c1.y - c2.y)),
				Math.abs(c1.z - c2.z));
	}

	public Cube toCube() {
		int x = left - (top + (top & 1)) / 2;
		int z = top;
		int y = -x - z;
		return new Cube(x, y, z);
	}

	public Point toPoint() {
		Arena arena = Arena.get();
		boolean isOdd = top % 2 == 0;
		int pointX = (int) (arena.getPosition().x + left
				* arena.getCellSize() + (isOdd ? arena.getCellSize() / 2 : 0));
		int pointY = (int) (arena.getPosition().y + top
				* arena.getCellSize());

		return new Point(pointX, pointY);
	}

	public Point toHalfPoint() {
		Arena arena = Arena.get();
		Point point = toPoint();
		return new Point(point.x + arena.getCellSize() / 2, point.y
				+ arena.getCellSize() / 2);
	}

	public boolean isInArena() {
		Arena arena = Arena.get();

		return top >= 0 && top < arena.getHeight() && left >= 0
				&& left < arena.getWidth();
	}

	public Path pathTo(Offset finish) {
		Offset start = this;
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
		if (offset.isInArena() && freeOffsets.get(offset)) {
			offsetQueue.add(new OffsetSequenceItem(offset, item));
			freeOffsets.put(offset, false);
		}
	}

	private static List<Offset> getNeighbors(Offset offset) {
		Cube cube = offset.toCube();
		return Arrays.asList(new Offset[] {
				new Cube(cube.x, cube.y + 1, cube.z - 1)
						.toOffset(),
				new Cube(cube.x + 1, cube.y, cube.z - 1)
						.toOffset(),
				new Cube(cube.x + 1, cube.y - 1, cube.z)
						.toOffset(),
				new Cube(cube.x, cube.y - 1, cube.z + 1)
						.toOffset(),
				new Cube(cube.x - 1, cube.y, cube.z + 1)
						.toOffset(),
				new Cube(cube.x - 1, cube.y + 1, cube.z)
						.toOffset() });
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + left;
		result = prime * result + top;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Offset))
			return false;
		Offset other = (Offset) obj;
		if (left != other.left)
			return false;
		if (top != other.top)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offset [left=" + left + ", top=" + top + "]";
	}

	@Override
	public void render(Graphics g) {
		Arena arena = Arena.get();
		Point point = toPoint();
		g.fillRect((int) point.x, (int) point.y, arena.getCellSize(),
				arena.getCellSize());
	}
	
}
