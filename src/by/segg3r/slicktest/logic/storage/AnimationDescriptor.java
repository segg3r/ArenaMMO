package by.segg3r.slicktest.logic.storage;

public class AnimationDescriptor {

	private String fileName;
	private int columns;
	private int rows;
	private int offsetX;
	private int offsetY;
	private double imageSpeed = 1;

	public double getImageSpeed() {
		return imageSpeed;
	}

	public void setImageSpeed(double imageSpeed) {
		this.imageSpeed = imageSpeed;
	}

	public int getOffsetX() {
		return offsetX;
	}

	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	public int getOffsetY() {
		return offsetY;
	}

	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}

	public AnimationDescriptor(String fileName, int columns, int rows,
			int offsetX, int offsetY, double imageSpeed) {
		super();
		this.fileName = fileName;
		this.columns = columns;
		this.rows = rows;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
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

}
