package by.segg3r.slicktest.logic.storage;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import by.segg3r.slicktest.logic.OffsettedAnimation;
import by.segg3r.slicktest.math.Point;

public class CharacterAnimationDescriptor extends Descriptor<String, Animation> {

	private String path;
	private int columns;
	private int rows;
	private Point offset;
	private int imageSpeed = 1;

	public CharacterAnimationDescriptor(String path, String key, int columns, int rows,
			Point offset, int imageSpeed) {
		super(key);
		this.path = path + "/" + key;
		this.columns = columns;
		this.rows = rows;
		this.offset = offset;
		this.imageSpeed = imageSpeed;
	}

	@Override
	public Animation create() throws SlickException {
		String fullFileName = path + ".png";

		Image image = new Image(fullFileName);
		int columnWidth = image.getWidth() / columns;
		int rowHeight = image.getHeight() / rows;
		SpriteSheet spriteSheet = new SpriteSheet(image, columnWidth, rowHeight);
		Animation animation = new OffsettedAnimation(spriteSheet,
				imageSpeed, offset);
		
		return animation;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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
