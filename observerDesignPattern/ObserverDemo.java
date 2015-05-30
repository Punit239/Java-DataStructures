// PUNIT SHARMA 3/24/2015
// OFFICEA IS OUR SUBJECT. THERE ARE EMPLOYEES REGISTERED WITH THIS OFFICE.
// AS THE CLOSING TIME OF THE OFFICE IS CHANGED ALL THE REGISTERED EMPLOYEES
// ARE AUTOMATICALLY UPDATED WITH THIS INFORMATION.

package observerDesignPattern;

public class ObserverDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Office officeA = new Office("Open");
		
		ObserverOfSubject emp1 = new Employee(officeA,"Employee 1");
		ObserverOfSubject emp2 = new Employee(officeA,"Employee 2");
		ObserverOfSubject emp3 = new Employee(officeA,"Employee 3");
		
		officeA.register(emp1);
		officeA.register(emp2);
		officeA.register(emp3);
		
		officeA.setState("Closed");
		officeA.setState("Open");
	}

}
