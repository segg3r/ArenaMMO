package by.segg3r.slicktest.logic.storage;

public class TileDescriptor 
{
	private String name;
	private int startColumns;
	private int startRows;
	private int numberClumns;
	private int numberRows;
	private int xSize;
	private int ySize;

	public TileDescriptor(String name, int startColumns, int startRows, int numberClumns,
			int numberRows, int xSize, int ySize) {
		super();
		this.name = name;
		this.startColumns = startColumns;
		this.startRows = startRows;
		this.numberClumns = numberClumns;
		this.numberRows = numberRows;
		this.xSize = xSize;
		this.ySize = ySize;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getNumberClumns() {
		return numberClumns;
	}
	public void setNumberClumns(int numberClumns) {
		this.numberClumns = numberClumns;
	}
	public int getNumberRows() {
		return numberRows;
	}
	public void setNumberRows(int numberRows) {
		this.numberRows = numberRows;
	}
	public int getxSize() {
		return xSize;
	}
	public void setxSize(int xSize) {
		this.xSize = xSize;
	}
	public int getySize() {
		return ySize;
	}
	public void setySize(int ySize) {
		this.ySize = ySize;
	}
	
	@Override
	public String toString() {
		return "\nTileDescriptor [startColumns=" + startColumns + ", startRows="
				+ startRows + ", numberClumns=" + numberClumns
				+ ", numberRows=" + numberRows + ", xSize=" + xSize
				+ ", ySize=" + ySize + "]";
	}
	
}
