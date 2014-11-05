package by.segg3r.slicktest.logic.storage.animation.tileset;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.storage.Descriptor;
import by.segg3r.slicktest.math.Point;
import by.segg3r.slicktest.math.Rectangle;

public class TileDescriptor extends Descriptor<String, Sprite> {

	private int startColumns;
	private int startRows;
	private int imageColumnsNumber;
	private int imageRowsNumber;
	private Point offset;
	private Image image;
	private int columnsNumber;
	private int rowsNumber;
	private Rectangle mask;

	public TileDescriptor(String key, Image image, int columnsNumber,
			int rowsNumber, int startColumns, int startRows,
			int imageColumnsNumber, int imageRowsNumber, Point offset,
			Rectangle mask) {
		super(key);
		this.columnsNumber = columnsNumber;
		this.rowsNumber = rowsNumber;
		this.image = image;
		this.startColumns = startColumns;
		this.startRows = startRows;
		this.imageColumnsNumber = imageColumnsNumber;
		this.imageRowsNumber = imageRowsNumber;
		this.offset = offset;
		this.mask = mask;
	}

	@Override
	public Sprite create() throws SlickException {
		int columnWidth = image.getWidth() / columnsNumber;
		int rowHeight = image.getHeight() / rowsNumber;

		Image tileImage = image.getSubImage(columnWidth * startColumns,
				rowHeight * startRows, columnWidth * imageColumnsNumber,
				rowHeight * imageRowsNumber);
		return new Sprite(tileImage, offset, mask);
	}

	public int getStartColumns() {
		return startColumns;
	}

	public void setStartColumns(int startColumns) {
		this.startColumns = startColumns;
	}

	public int getStartRows() {
		return startRows;
	}

	public void setStartRows(int startRows) {
		this.startRows = startRows;
	}

	public int getImageColumnsNumber() {
		return imageColumnsNumber;
	}

	public void setImageColumnsNumber(int imageColumnsNumber) {
		this.imageColumnsNumber = imageColumnsNumber;
	}

	public int getImageRowsNumber() {
		return imageRowsNumber;
	}

	public void setImageRowsNumber(int imageRowsNumber) {
		this.imageRowsNumber = imageRowsNumber;
	}

	public Point getOffset() {
		return offset;
	}

	public void setOffset(Point offset) {
		this.offset = offset;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getColumnsNumber() {
		return columnsNumber;
	}

	public void setColumnsNumber(int columnsNumber) {
		this.columnsNumber = columnsNumber;
	}

	public int getRowsNumber() {
		return rowsNumber;
	}

	public void setRowsNumber(int rowsNumber) {
		this.rowsNumber = rowsNumber;
	}

	public Rectangle getMask() {
		return mask;
	}

	public void setMask(Rectangle mask) {
		this.mask = mask;
	}

}
