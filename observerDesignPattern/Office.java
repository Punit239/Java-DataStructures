// PUNIT SHARMA 3/24/2015
// CLASS IMPLEMENTING SUBJECT. THIS IS THE OBJECT
// EVERY ObserverOfSubject IS OBSERVING. AS IT CHANGES ITS
// STATE, IT NOTIFIES ALL REGISTERED ObserverOfSubjectS ABOUT IT. 

package observerDesignPattern;

import java.util.ArrayList;

public class Office extends Subject {

	public Office(String state){
		
		super.state = state;
	}
	
	ArrayList<ObserverOfSubject> registeredEmployees = new ArrayList<ObserverOfSubject>(); 
	
	@Override
	public void register(ObserverOfSubject o) {
		// TODO Auto-generated method stub
		registeredEmployees.add(o);
	}

	@Override
	public void unregister(ObserverOfSubject o) {
		// TODO Auto-generated method stub
		registeredEmployees.remove(o);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(ObserverOfSubject o : registeredEmployees)
			o.update();
	}

	public void setState(String state) {
		super.setState(state);
		notifyObservers();
	}

}
