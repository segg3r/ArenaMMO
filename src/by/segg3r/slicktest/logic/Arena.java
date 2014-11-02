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
			arena = new Arena(25, 25, 10, 10, 20);
		}
		return arena;
	}
	
	private Arena(int x, int y, int width, int height, int cellSize) {
		super(x, y);
		this.width = width;
		this.height = height;
		this.cellSize = cellSize;
	}

	@Override
	public void render(Graphics g) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Point point = getArenaPointByOffset(new Offset(j, i));
				
				g.drawRect(point.getX(), point.getY(), cellSize, cellSize);
			}
		}
	}

	public boolean isPointInArena(Point mousePoint) {
		Offset offset = getOffsetByPoint(mousePoint);
		return isOffsetInArena(offset) &&
				mousePoint.getX() >= getX() + (GameMath.isOdd(offset.getTop()) ? cellSize / 2 : 0) && mousePoint.getY() >= getY();
	}
	
	public boolean isOffsetInArena(Offset offset) {
		return offset.getTop() >= 0 && offset.getTop() < height &&
				offset.getLeft() >= 0 && offset.getLeft() < width;
	}

	public Offset getOffsetByPoint(Point mousePoint) {
		int top = (mousePoint.getY() - getY()) / cellSize;
		int left = (mousePoint.getX() - (getX() + (GameMath.isOdd(top) ? cellSize / 2 : 0))) / cellSize;
		
		return new Offset(left, top);
	}

	public Point getArenaPointByOffset(Offset offset) {
		boolean isOdd = GameMath.isOdd(offset.getTop());
		int pointX = getX() + offset.getLeft() * cellSize + (isOdd ? cellSize / 2 : 0);
		int pointY = getY() + offset.getTop() * cellSize;
		
		return new Point(pointX, pointY); 
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
