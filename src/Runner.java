import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import by.segg3r.slicktest.SlickTestGame;

public class Runner {

	public static void main(String[] args) {
		try {
			SlickTestGame slickTestGame = new SlickTestGame("Test");
			AppGameContainer appGameContainer = new AppGameContainer(slickTestGame);
			appGameContainer.setDisplayMode(800, 600, false);
			
			//wtf mthf
			
			appGameContainer.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
