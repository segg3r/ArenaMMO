package by.segg3r.slicktest.logic.listener;

import by.segg3r.slicktest.logic.actions.GameState;

public interface ActionListener {

	void perform(ActionType actionType, GameState gameState);
	
}
