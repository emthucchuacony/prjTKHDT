package Controller;

import java.awt.event.KeyEvent;

import Model.GameModel;
import Model.ModelInterface;
import View.GameView;

public class GameController implements ControllerInterface {
	GameView view;
	ModelInterface model ;
	
	public GameController(GameModel model) {
		
		this.model = model;
		view = new GameView(model, this);
		
		System.out.println("GameView created and displayed");
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	    int speed = model.getPaddle1().getSpeed();

	    if (model.getPaddle1().getid() == 1) {
	        if (e.getKeyCode() == KeyEvent.VK_W) {
	            model.getPaddle1().setYDirection(-speed);
	        }
	        if (e.getKeyCode() == KeyEvent.VK_S) {
	            model.getPaddle1().setYDirection(speed);
	        }
	    } else if (model.getPaddle1().getid() == 2) {
	        if (e.getKeyCode() == KeyEvent.VK_UP) {
	            model.getPaddle1().setYDirection(-speed);
	        }
	        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	            model.getPaddle1().setYDirection(speed);
	        }
	    }

	    if (model.getPaddle2().getid() == 1) {
	        if (e.getKeyCode() == KeyEvent.VK_W) {
	            model.getPaddle2().setYDirection(-speed);
	        }
	        if (e.getKeyCode() == KeyEvent.VK_S) {
	            model.getPaddle2().setYDirection(speed);
	        }
	    } else if (model.getPaddle2().getid() == 2) {
	        if (e.getKeyCode() == KeyEvent.VK_UP) {
	            model.getPaddle2().setYDirection(-speed);
	        }
	        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	            model.getPaddle2().setYDirection(speed);
	        }
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		  

		    if (model.getPaddle1().getid() == 1) {
		        if (e.getKeyCode() == KeyEvent.VK_W) {
		            model.getPaddle1().setYDirection(0);
		        }
		        if (e.getKeyCode() == KeyEvent.VK_S) {
		            model.getPaddle1().setYDirection(0);
		        }
		    } else if (model.getPaddle1().getid() == 2) {
		        if (e.getKeyCode() == KeyEvent.VK_UP) {
		            model.getPaddle1().setYDirection(0);
		        }
		        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		            model.getPaddle1().setYDirection(0);
		        }
		    }

		    if (model.getPaddle2().getid() == 1) {
		        if (e.getKeyCode() == KeyEvent.VK_W) {
		            model.getPaddle2().setYDirection(0);
		        }
		        if (e.getKeyCode() == KeyEvent.VK_S) {
		            model.getPaddle2().setYDirection(0);
		        }
		    } else if (model.getPaddle2().getid() == 2) {
		        if (e.getKeyCode() == KeyEvent.VK_UP) {
		            model.getPaddle2().setYDirection(0);
		        }
		        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		            model.getPaddle2().setYDirection(0);
		        }
		    }
		
	}
	
	
	

}
