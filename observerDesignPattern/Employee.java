// PUNIT SHARMA 3/24/2015
// CLASS IMPLEMENTING OBSERVER. THIS IS OUR OBSERVER

package observerDesignPattern;

public class Employee extends ObserverOfSubject{

	private String name;
	
	public Employee(Subject s, String name) {

		this.name = name;
		super.s = s;
	}
	
	@Override
	public void update() {
		
		System.out.println("Notification sent to " + this.getName() + " : \nOffice is now " + 
							this.s.getState());
	}
	
	public String getName(){
		
		return this.name;
	}
}