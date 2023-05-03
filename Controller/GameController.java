package Controller;

import Model.ModelInterface;
import View.GameView;

public class GameController implements ControllerInterface {
	GameView view;
	ModelInterface model ;
	public GameController(ModelInterface model) {
		
		this.model = model;
		view = new GameView(model, this);
		view.createView();
		System.out.println("GameView created and displayed");
	}
	

}
