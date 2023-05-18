package Test;

import java.awt.Color;

import javax.swing.JFrame;

import Controller.GameController;
import Model.GameModel;
import View.GameView;

public class Test {
	public static void main(String[] args) {
		GameModel model = new GameModel();
		GameController controller = new GameController(model);
		GameView view = new GameView(model, controller);
		JFrame frame = new JFrame();
		frame.add(view);
		frame.setTitle("Pong Game");
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

}
