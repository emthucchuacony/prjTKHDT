package View;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.ControllerInterface;

import Model.ModelInterface;

import Observer.Observer;
import Test.FinalVariable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameView extends JPanel implements Observer {
	ModelInterface model;
	ControllerInterface controller;
	JFrame viewFrame ;

	Thread gameThread;
	Image image;
	Graphics graphics;
	FinalVariable var;
	JPanel panel;
	JButton start, help, more, exit;
	JTextField txtPongGame;
	boolean isRunning;
	private boolean gameStarted = false;

	public GameView(ModelInterface model, ControllerInterface controller) {

		this.model = model;
		this.controller = controller;
		this.viewFrame = new JFrame();
		model.registerObs((Observer) this);
		createView();
		createControl();

	}

	public void createView() {
		var = new FinalVariable();

		setBounds(100, 100, 1000, 550);

		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		panel.setLayout(null);

		start = new JButton("START");
		start.setForeground(new Color(255, 255, 255));
		start.setFont(new Font("Lucida Console", Font.PLAIN, 55));
		start.setBorder(new EmptyBorder(0, 0, 0, 0));

		start.setBackground(new Color(0, 0, 0));
		start.setBounds(402, 160, 194, 62);
		panel.add(start);

		more = new JButton("MORE");
		more.setFont(new Font("Lucida Console", Font.PLAIN, 55));
		more.setBackground(new Color(0, 0, 0));
		more.setForeground(new Color(255, 255, 255));
		more.setBorder(new EmptyBorder(0, 0, 0, 0));

		more.setBounds(402, 250, 194, 62);
		panel.add(more);

		help = new JButton("HELP");
		help.setForeground(new Color(255, 255, 255));
		help.setFont(new Font("Lucida Console", Font.PLAIN, 55));
		help.setBackground(new Color(0, 0, 0));
		help.setBorder(new EmptyBorder(0, 0, 0, 0));

		help.setBounds(402, 340, 194, 62);
		panel.add(help);

		exit = new JButton("Exit");

		exit.setForeground(new Color(255, 255, 255));
		exit.setFont(new Font("Lucida Console", Font.PLAIN, 55));
		exit.setBackground(new Color(0, 0, 0));
		exit.setBorder(new EmptyBorder(0, 0, 0, 0));

		exit.setBounds(402, 430, 194, 62);

		panel.add(exit);
		txtPongGame = new JTextField();
		txtPongGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtPongGame.setFont(new Font("Lucida Console", Font.BOLD, 80));
		txtPongGame.setForeground(new Color(255, 255, 255));
		txtPongGame.setText("PONG GAME");
		txtPongGame.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPongGame.setEditable(false);
		txtPongGame.setEnabled(false);
		txtPongGame.setBackground(new Color(0, 0, 10));
		txtPongGame.setBounds(221, 10, 537, 162);

		txtPongGame.setColumns(20);
		panel.add(txtPongGame);
		viewFrame.add(panel);
		viewFrame.setFocusable(true);

		viewFrame.setPreferredSize(var.SCREEN_SIZE);
		

		viewFrame.setTitle("Pong Game");
		viewFrame.setResizable(false);
		
		viewFrame.setBackground(Color.BLACK);
		viewFrame.setDefaultCloseOperation(viewFrame.EXIT_ON_CLOSE);
		viewFrame.pack();
		viewFrame.setVisible(true);
		viewFrame.setLocationRelativeTo(null);
		
	}

	public void createControl() {
		
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			        controller.startGame();
			     

		        
		        

			}
		});
		more.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.openMore();

			}
		});
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.openHelp();

			}
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.exitGame();

			}
		});

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

//	@Override
//	public void run() {
//
//		long lastTime = System.nanoTime();
//		double amountOfTicks = 60.0;
//		double ns = 1000000000 / amountOfTicks;
//		double delta = 0;
//
//		// game loop
//
//		while (isRunning) {
//
//			long now = System.nanoTime();
//			delta += (now - lastTime) / ns;
//			lastTime = now;
//			if (delta >= 1) {
//				updateGameLogic();
//
//				delta--;
//			}
//			repaint();
//		}
//
//	}
//
//	private void updateGameLogic() {
//	    if (gameStarted) {
//	        model.move();
//	        model.checkColision();
//
//	        if (model.isGameOver()) {
//	            isRunning = false;
//	            showGameOverMessage();
//	        }
//	    }
//	}

//	private void showGameOverMessage() {
//		JOptionPane.showMessageDialog(null, "Game over!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
//	}


	public void moreMenu() {
		JOptionPane.showMessageDialog(null, "Welcome to Pong Game123!\n\n"
				+ "The objective of the game is to score points by hitting the ball past your opponent's paddle.\n"
				+ "Use the up and down arrow keys to move your paddle up and down.\n"
				+ "The first player to reach 10 points wins the game.\n\n" + "Good luck and have fun!", "Help",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public void exitMenu() {
		System.exit(0);
	}

	public void helpMenu() {
		String message = "Welcome to the Pong Game Help Menu12345! \n\n"
				+ "To control the left paddle, use the W key to move up and the S key to move down.\n"
				+ "To control the right paddle, use the Up Arrow key to move up and the Down Arrow key to move down.\n"
				+ "To pause the game, press the P key.\n" + "To resume the game, press the R key.\n\n"
				+ "Enjoy playing!";

		JOptionPane.showMessageDialog(null, message, "Help Menu", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void paintComponent(Graphics g) {

		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}

	
	public void draw(Graphics g) {
	    if (gameStarted) {
	        model.getPaddle1().draw(g);
	        model.getPaddle2().draw(g);
	        model.getBall().draw(g);
	        model.getScore().draw(g);
	        viewFrame.repaint(); // Vẽ lại giao diện trên viewFrame
	    }
	}



	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			controller.keyPressed(e);

		}

		public void keyReleased(KeyEvent e) {
			controller.keyReleased(e);

		}
	}

}
