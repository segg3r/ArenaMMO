package by.segg3r.slicktest.math;

import java.util.ArrayList;
import java.util.List;

public class Path {

	private List<Offset> offsets = new ArrayList<Offset>();
	
	public Path() {
		super();
	}
	
	public void addOffset(Offset offset) {
		offsets.add(offset);
	}
	
	public Offset getOffset(int i) {
		return offsets.get(i);
	}
	
	public int getSize() {
		return offsets.size();
	}
	
}
