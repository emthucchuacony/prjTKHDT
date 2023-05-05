package View;


import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.ControllerInterface;



import Model.ModelInterface;

import Observer.Observer;
import Test.FinalVariable;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameView extends JPanel implements Observer, Runnable {
	ModelInterface model;
	ControllerInterface controller;
	JFrame viewFrame;

	Thread gameThread;
	Image image;
	Graphics graphics;
	FinalVariable var;

	public GameView(ModelInterface model, ControllerInterface controller) {

		this.model = model;
		this.controller = controller;
		model.registerObs((Observer) this);
		createView();	
		createControl();

	}

	public void createView() {
		// create all Swing components here
		model.newScore();
		model.newPaddles();
		model.newBall();
		this.setFocusable(true);

		this.setPreferredSize(var.SCREEN_SIZE);

	}
	public void createControl() {
		this.addKeyListener(new AL());
		gameThread = new Thread(this);
		gameThread.start();
	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;

		// game loop

		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				model.move();
				model.checkColision();
				repaint();
				delta--;
			}
		}

	}

	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}

	public void draw(Graphics g) {
		model.getPaddle1().draw(g);
		model.getPaddle2().draw(g);
		model.getScore().draw(g);
		model.getBall().draw(g);

	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			controller.keyPressed(e);
			
		}
		public void keyReleased(KeyEvent e) {
			controller.keyReleased(e);
			
		}
	}
	

}
