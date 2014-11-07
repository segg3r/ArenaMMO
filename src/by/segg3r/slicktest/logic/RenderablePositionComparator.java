package by.segg3r.slicktest.logic;

import java.util.Comparator;

public class RenderablePositionComparator implements Comparator<Renderable> {

	@Override
	public int compare(Renderable r1, Renderable r2) {
		if (r1 == r2) return 0;
		if (r1.getLayer().equals(r2.getLayer())) {
			return (int) (r1.getPosition().y - r2.getPosition().y == 0 ? 1 : r1.getPosition().y - r2.getPosition().y);
		}
		return r1.getLayer().ordinal() - r2.getLayer().ordinal();
	}

}
