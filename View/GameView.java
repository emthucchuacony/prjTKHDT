package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.ControllerInterface;
import FinalVariable.FinalVariable;
import Model.Ball;
import Model.ModelInterface;
import Model.Paddle;
import Model.Score;
import Observer.Observer;
import java.awt.*;

public class GameView  extends JFrame implements Observer , Runnable{
	ModelInterface model;
	ControllerInterface controller;
	JFrame viewFrame;
	JPanel viewPanel;
	Ball ball;
	Paddle paddleLeft;
	Paddle paddleRight;
	Score score;
	Thread gameThread;
	Image image;
	Graphics graphics;
	FinalVariable var;
	
	
	

	public GameView(ModelInterface model, ControllerInterface controller) {
		
		this.model = model;
		this.controller = controller;
		model.registerObs((	Observer) this);
		
	}
	public void createView() {
		// create all Swing components here
		newPaddles();
		viewFrame = new JFrame();
		
		
		
		viewFrame.setTitle("Pong Game");
		viewFrame.setResizable(false);

		viewFrame.setBackground(Color.BLACK);
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.pack();
		
		viewFrame.setLocationRelativeTo(null);
		viewFrame.setPreferredSize(var.SCREEN_SIZE);
		gameThread = new Thread(this);
		gameThread.start();
		viewFrame.setVisible(true);
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
//				model.move();
//				model.checkCollision();
				repaint();
				delta--;
			}
		}

	}
	public void newPaddles() {
		paddleLeft = new Paddle(0, (FinalVariable.GAME_HEIGHT / 2) - (FinalVariable.PADDLE_HEIGHT / 2), FinalVariable.PADDLE_WIDTH, FinalVariable.PADDLE_HEIGHT,
				1);
		paddleRight = new Paddle(FinalVariable.GAME_WIDTH - FinalVariable.PADDLE_WIDTH, (FinalVariable.GAME_HEIGHT / 2) - (FinalVariable.PADDLE_HEIGHT / 2),
				FinalVariable.PADDLE_WIDTH, FinalVariable.PADDLE_HEIGHT, 2);
	}
	public void paint(Graphics g) {
		image =createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	public void draw(Graphics g) {
		paddleLeft.draw(g);
		paddleRight.draw(g);


	}
		
	

}
