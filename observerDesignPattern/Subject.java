// PUNIT SHARMA 3/24/2015
// THIS IS THE SUBJECT ABOUT WHICH ALL ObserverOfSubjectS WILL BE NOTIFIED

package observerDesignPattern;

public abstract class Subject {

	public String state;
	
	public abstract void register(ObserverOfSubject o);
	public abstract void unregister(ObserverOfSubject o);
	public abstract void notifyObservers();

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
