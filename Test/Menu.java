package Test;

import java.awt.Color;

import javax.swing.JFrame;

import Controller.GameController;
import Model.GameModel;
import View.GameMenu;
import View.GameView;

public class Menu {
    public static void main(String[] args) {
        GameModel model = new GameModel();
        GameMenu menu = new GameMenu();
        GameController control = new GameController(model, menu);
        menu.setVisible(true);
        
//		GameModel model = new GameModel();
//		GameController controller = new GameController(model);
//		GameView view = new GameView(model, controller);
//		JFrame frame = new JFrame();
//		frame.add(view);
//		frame.setTitle("Pong Game");
//		frame.setResizable(false);
//		frame.setBackground(Color.BLACK);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.pack();
//		frame.setVisible(true);
//		frame.setLocationRelativeTo(null);
    }
}