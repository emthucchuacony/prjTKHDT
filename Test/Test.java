package Test;

import Controller.GameController;
import Model.GameModel;
import View.GameView;

public class Test {
	public static void main(String[] args) {
		GameModel model = new GameModel();
		GameController controller = new GameController(model);
		GameView view = new GameView(model, controller);
	
		
	
		
	}

}
