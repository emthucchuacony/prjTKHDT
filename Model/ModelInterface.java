package Model;

import Observer.Observer;

public interface ModelInterface {
	void registerObs(Observer o);
	void removeObs(Observer o);
	

}
