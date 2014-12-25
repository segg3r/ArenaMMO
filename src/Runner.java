import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.Game;

public class Runner {

	public static void main(String[] args) {
		try {
			Game slickTestGame = new Game("Test");
			AppGameContainer appGameContainer = new AppGameContainer(
					slickTestGame);
			appGameContainer.setDisplayMode(380, 480, false);

			appGameContainer.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
