package by.segg3r.slicktest.logic;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.math.GameMath;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Point;

public class Arena extends Entity {

	private static Arena arena;

	private int width;
	private int height;
	private int cellSize;

	public static Arena get() {
		if (arena == null) {
			arena = new Arena(new Point(20, 20), 10, 10, 20);
		}
		return arena;
	}

	private Arena(Point position, int width, int height, int cellSize) {
		super(position);
		this.width = width;
		this.height = height;
		this.cellSize = cellSize;
	}

	@Override
	public void render(Graphics g) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Point point = getArenaPointByOffset(new Offset(j, i));

				g.drawRect((int) point.getX(), (int) point.getY(), cellSize,
						cellSize);
			}
		}
	}

	public boolean isPointInArena(Point mousePoint) {
		Offset offset = getOffsetByPoint(mousePoint);
		return isOffsetInArena(offset)
				&& mousePoint.getX() >= getPosition().getX()
						+ (GameMath.isOdd(offset.getTop()) ? cellSize / 2 : 0)
				&& mousePoint.getY() >= getPosition().getY();
	}

	public boolean isOffsetInArena(Offset offset) {
		return offset.getTop() >= 0 && offset.getTop() < height
				&& offset.getLeft() >= 0 && offset.getLeft() < width;
	}

	public Offset getOffsetByPoint(Point mousePoint) {
		int top = (int) (mousePoint.getY() - getPosition().getY()) / cellSize;
		int left = (int) (mousePoint.getX() - (getPosition().getX() + (GameMath
				.isOdd(top) ? cellSize / 2 : 0))) / cellSize;

		return new Offset(left, top);
	}

	public Point getArenaPointByOffset(Offset offset) {
		boolean isOdd = GameMath.isOdd(offset.getTop());
		int pointX = (int) (getPosition().getX() + offset.getLeft() * cellSize + (isOdd ? cellSize / 2
				: 0));
		int pointY = (int) (getPosition().getY() + offset.getTop() * cellSize);

		return new Point(pointX, pointY);
	}
	
	public Point getArenaHalfPointByOffset(Offset offset) {
		Point point = getArenaPointByOffset(offset);
		return new Point(point.getX() + cellSize / 2, point.getY() + cellSize / 2);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getCellSize() {
		return cellSize;
	}

	public void setCellSize(int cellSize) {
		this.cellSize = cellSize;
	}

}
