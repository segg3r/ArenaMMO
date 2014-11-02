package by.segg3r.slicktest.logic.storage;

public class AnimationDescriptor {

	private String fileName;
	private int columns;
	private int rows;

	public AnimationDescriptor(String fileName, int columns, int rows) {
		super();
		this.fileName = fileName;
		this.columns = columns;
		this.rows = rows;
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
