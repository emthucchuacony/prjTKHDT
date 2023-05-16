package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Observer.Observer;
import Test.FinalVariable;

public class GameModel implements ModelInterface {
	Paddle paddle1;
	Paddle paddle2;
	FinalVariable var;
	Score score;
	Ball ball;
	Random random;
	private List<Observer> observers = new ArrayList<Observer>();

	public GameModel() {
		newPaddles();
		newScore();
		newBall();
	}

	@Override
	public void registerObs(Observer o) {
		observers.add(o);

	}

	@Override
	public void removeObs(Observer o) {
		observers.remove(o);
	}

	public void notityObs() {
		for (Observer obs : observers) {
			obs.update();
		}
	}

	@Override
	public void newBall() {
		random = new Random();
		ball = new Ball((var.GAME_WIDTH / 2) - (var.BALL_DIAMETER / 2),
				random.nextInt(var.GAME_HEIGHT - var.BALL_DIAMETER), var.BALL_DIAMETER, var.BALL_DIAMETER);
	}

	@Override
	public void newPaddles() {
		paddle1 = new Paddle(0, (var.GAME_HEIGHT / 2) - (var.PADDLE_HEIGHT / 2), var.PADDLE_WIDTH, var.PADDLE_HEIGHT,
				1);
		paddle2 = new Paddle(var.GAME_WIDTH - var.PADDLE_WIDTH, (var.GAME_HEIGHT / 2) - (var.PADDLE_HEIGHT / 2),
				var.PADDLE_WIDTH, var.PADDLE_HEIGHT, 2);
	}

	public Paddle getPaddle1() {
		return paddle1;
	}

	public Paddle getPaddle2() {
		return paddle2;
	}

	@Override
	public void newScore() {
		score = new Score(var.GAME_WIDTH, var.GAME_HEIGHT);

	}

	@Override
	public Score getScore() {

		return score;
	}

	@Override
	public Ball getBall() {

		return ball;
	}

	@Override
	public void move() {
		getPaddle1().move();
		getPaddle2().move();
		getBall().move();
	}

	@Override
	public void checkColision() {
//		//bounce ball off top & bottom window edges
		if (ball.y <= 0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if (ball.y >= var.GAME_HEIGHT - var.BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
		// bounce ball off paddles
		if (ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; // optional for more difficulty
			if (ball.yVelocity > 0)
				ball.yVelocity++; // optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		if (ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; // optional for more difficulty
			if (ball.yVelocity > 0)
				ball.yVelocity++; // optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		// stops paddles at window edges
		if (paddle1.y <= 0)
			paddle1.y = 0;
		if (paddle1.y >= (var.GAME_HEIGHT - var.PADDLE_HEIGHT))
			paddle1.y = var.GAME_HEIGHT - var.PADDLE_HEIGHT;
		if (paddle2.y <= 0)
			paddle2.y = 0;
		if (paddle2.y >= (var.GAME_HEIGHT - var.PADDLE_HEIGHT))
			paddle2.y = var.GAME_HEIGHT - var.PADDLE_HEIGHT;
		// give a player 1 point and creates new paddles & ball
		if (ball.x <= 0) {
			score.player2++;
			newPaddles();
			newBall();
			System.out.println("Player 2: " + score.player2);
		}
		if (ball.x >= var.GAME_WIDTH - var.BALL_DIAMETER) {
			score.player1++;
			newPaddles();
			newBall();
			System.out.println("Player 1: " + score.player1);
		}
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

}
