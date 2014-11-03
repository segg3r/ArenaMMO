package by.segg3r.slicktest.logic.storage;

import by.segg3r.slicktest.math.Point;

public class AnimationDescriptor {

	private String fileName;
	private int columns;
	private int rows;
	private Point offset;
	private int imageSpeed = 1;

	public AnimationDescriptor(String fileName, int columns, int rows,
			Point offset, int imageSpeed) {
		super();
		this.fileName = fileName;
		this.columns = columns;
		this.rows = rows;
		this.offset = offset;
		this.imageSpeed = imageSpeed;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getImageSpeed() {
		return imageSpeed;
	}

	public void setImageSpeed(int imageSpeed) {
		this.imageSpeed = imageSpeed;
	}

	public Point getOffset() {
		return offset;
	}

	public void setOffset(Point offset) {
		this.offset = offset;
	}

}
