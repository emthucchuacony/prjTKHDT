package Controller;

import java.awt.event.KeyEvent;

public interface ControllerInterface {
	
	void keyPressed(KeyEvent e);
	 void keyReleased(KeyEvent e);
	void startGame();
	void openMore();
	void openHelp();
	void exitGame();
}
