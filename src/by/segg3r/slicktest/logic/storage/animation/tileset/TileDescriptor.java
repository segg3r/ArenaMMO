package by.segg3r.slicktest.logic.storage.animation.tileset;

import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.logic.Sprite;
import by.segg3r.slicktest.logic.storage.Descriptor;
import by.segg3r.slicktest.math.Offset;
import by.segg3r.slicktest.math.Point;

public class TileDescriptor extends Descriptor<String, Sprite> {

	private int startColumns;
	private int startRows;
	private int imageColumnsNumber;
	private int imageRowsNumber;
	private Point offset;
	private Image image;
	private int columnsNumber;
	private int rowsNumber;
	private List<Offset> mask;

	public TileDescriptor(String key, Image image, int columnsNumber,
			int rowsNumber, int startColumns, int startRows,
			int imageColumnsNumber, int imageRowsNumber, Point offset,
			List<Offset> mask) {
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
		Sprite sprite = new Sprite(tileImage, offset, mask);
		sprite.setName(getKey());
		return sprite;
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


}
