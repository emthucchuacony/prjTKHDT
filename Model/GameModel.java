package Model;

import java.util.ArrayList;
import java.util.List;

import Observer.Observer;

public class GameModel implements ModelInterface {
	private List<Observer> observers = new ArrayList<Observer>();

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
	

}
