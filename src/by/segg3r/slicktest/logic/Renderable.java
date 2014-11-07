package by.segg3r.slicktest.logic;

import org.newdawn.slick.Graphics;

import by.segg3r.slicktest.math.Point;

public interface Renderable {

	void render(Graphics g);
	
	Layer getLayer();
	
	Point getPosition();

}
