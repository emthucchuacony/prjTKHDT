package Controller;

import java.awt.Color;
import java.awt.Menu;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.GameModel;
import Model.ModelInterface;
import View.GameMenu;
import View.GameView;

public class GameController implements ControllerInterface {
	GameView view;
	GameMenu menu;
	ModelInterface model ;
	GameController control;
	
	public GameController(GameModel model) {
		this.model = model;
		view = new GameView(model, this);
		}
	public GameController(GameModel model, GameMenu menu) {
		this.model = model;
		menu = new GameMenu(model, this);
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

	@Override
	public void startGame() {
		menu.hidee();
}

	@Override
	public void openMore() {
		menu.moreMenu();
		
	}

	@Override
	public void openHelp() {
	    menu.helpMenu();
	}


	@Override
	public void exitGame() {
		menu.exitMenu();
		
	}
	
	
	

}
