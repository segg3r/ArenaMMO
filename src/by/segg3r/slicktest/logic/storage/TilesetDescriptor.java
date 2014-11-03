package by.segg3r.slicktest.logic.storage;

import java.util.ArrayList;
import java.util.List;

public class TilesetDescriptor {
	private String fileName;
	private int numberClumns;
	private int numberRows;
	private List<TileDescriptor> descriptors;

	public TilesetDescriptor(String fileName, int numberClumns, int numberRows) {
		super();
		this.fileName = fileName;
		this.numberClumns = numberClumns;
		this.numberRows = numberRows;
		descriptors = new ArrayList<TileDescriptor>();
	}

	public List<TileDescriptor> getDescriptors() {
		return descriptors;
	}

	public void setDescriptors(List<TileDescriptor> descriptors) {
		this.descriptors = descriptors;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	@Override
	public String toString() {
		return "TilesetDescriptor [\nfileName=" + fileName + ", \nnumberClumns="
				+ numberClumns + ", \nnumberRows=" + numberRows
				+ ", \ndescriptors=" + descriptors + "\n]";
	}
	
	
}
