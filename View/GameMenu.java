package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.ControllerInterface;
import Controller.GameController;
import Model.GameModel;
import Model.ModelInterface;
import Observer.Observer;
import Test.Test;

public class GameMenu extends JFrame implements Observer {

	JPanel contentPane;
	ImageIcon backgroundImg;
	JTextField txtPongGame;
	ControllerInterface controller;
	GameModel model;
	JButton start, help, more, exit;

	/**
	 * Launch the application.
	 */
	public GameMenu(ModelInterface model, ControllerInterface controller) {

		this.model = (GameModel) model;
		this.controller = controller;
		model.registerObs((Observer) this);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameMenu frame = new GameMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 555);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		start = new JButton("START");
		start.setForeground(new Color(255, 255, 255));
		start.setFont(new Font("Lucida Console", Font.PLAIN, 55));
		start.setBorder(new EmptyBorder(0, 0, 0, 0));
		start.setBackground(new Color(0, 0, 0));
		start.setBounds(402, 160, 194, 62);
		contentPane.add(start);

		more = new JButton("MORE");
		more.setFont(new Font("Lucida Console", Font.PLAIN, 55));
		more.setBackground(new Color(0, 0, 0));
		more.setForeground(new Color(255, 255, 255));
		more.setBorder(new EmptyBorder(0, 0, 0, 0));
		more.setBounds(402, 250, 194, 62);
		contentPane.add(more);

		help = new JButton("HELP");
		help.setForeground(new Color(255, 255, 255));
		help.setFont(new Font("Lucida Console", Font.PLAIN, 55));
		help.setBackground(new Color(0, 0, 0));
		help.setBorder(new EmptyBorder(0, 0, 0, 0));

		help.setBounds(402, 340, 194, 62);
		contentPane.add(help);

		exit = new JButton("Exit");
		exit.setForeground(new Color(255, 255, 255));
		exit.setFont(new Font("Lucida Console", Font.PLAIN, 55));
		exit.setBackground(new Color(0, 0, 0));
		exit.setBorder(new EmptyBorder(0, 0, 0, 0));

		exit.setBounds(402, 430, 194, 62);
		contentPane.add(exit);

		txtPongGame = new JTextField();
		txtPongGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtPongGame.setFont(new Font("Lucida Console", Font.BOLD, 80));
		txtPongGame.setForeground(new Color(255, 255, 255));
		txtPongGame.setText("PONG GAME");
		txtPongGame.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPongGame.setEditable(false);
		txtPongGame.setEnabled(false);
		txtPongGame.setBackground(new Color(0, 0, 0));
		txtPongGame.setBounds(221, 10, 537, 62);
		contentPane.add(txtPongGame);
		txtPongGame.setColumns(10);

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startGame();

			}
		});
		more.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moreMenu();

			}
		});
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				helpMenu();

			}
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.exitGame();

			}
		});
	}

	public void moreMenu() {
		JOptionPane.showMessageDialog(null,
				"Pong is a classic electronic game that was first developed in 1972 by Atari.\n" + "\n"
						+ "The game is played by controlling two horizontal bars on the screen and hitting a ball towards the opponent.\n"
						+ "The objective of the game is to score points by making the opponent miss the ball.\n" + "\n"
						+ "Pong is a simple yet highly addictive and fun game.\n"
						+ "It became an icon of the 1970s and is one of the most beloved classic electronic games in history.\n"
						+ "\n"
						+ "To this day, Pong remains a popular game and has been recreated on many different platforms,\n"
						+ "from handheld electronic games to mobile phone apps. With updated graphics and sound,\n"
						+ "the game still retains its appeal and is a great choice for those looking to experience \n "
						+ "a challenging and enjoyable classic electronic game.",
				"More", JOptionPane.INFORMATION_MESSAGE);

	}

	public void exitMenu() {
		System.exit(0);
	}

	public void helpMenu() {
		String message = "The game is played by two players, each controlling a horizontal bar on either side of the screen.\n"
				+ "The ball will start in the middle of the screen and will be served by one of the players.\n"
				+ "The objective of the game is to hit the ball past the opponent's bar and score points.\n"
				+ "The player who fails to hit the ball loses a point.\n"
				+ "The first player to reach a certain number of points (usually 11 or 21) wins the game.\n"
				+ "Here is a brief guide on how to play Pong:\n" + "\n"
				+ "To control the left paddle, use the W key to move up and the S key to move down.\n"
				+ "To control the right paddle, use the Up Arrow key to move up and the Down Arrow key to move down.\n"
				+ "To pause the game, press the P key.\n" + "To resume the game, press the R key.\n\n"
				+ "Enjoy playing!";

		JOptionPane.showMessageDialog(null, message, "Help Menu", JOptionPane.INFORMATION_MESSAGE);
	}

	public void startGame() {
		hidee();
		GameModel model = new GameModel();
		GameController controller = new GameController(model);
		GameView view = new GameView(model, controller);
		JFrame frame = new JFrame();
		frame.getContentPane().add(view);
		frame.setTitle("Pong Game");
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	public void hidee() {
		// TODO Auto-generated method stub
		setVisible(false);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
