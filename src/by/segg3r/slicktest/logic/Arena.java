package by.segg3r.slicktest.logic;

import org.newdawn.slick.Graphics;

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
				Point point = new Offset(j, i).toPoint();

				g.drawRect((int) point.x, (int) point.y, cellSize,
						cellSize);
			}
		}
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
