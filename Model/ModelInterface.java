package Model;

import Observer.Observer;

public interface ModelInterface {
	void registerObs(Observer o);
	void removeObs(Observer o);
	void newBall();
	void newPaddles();
	void newScore();
	Paddle getPaddle1();
	Paddle getPaddle2();
	Score getScore();
	Ball getBall();
	void move();
	void checkColision();
	boolean isGameOver();
	

}
