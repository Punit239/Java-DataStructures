// PUNIT SHARMA :: 7/27/2014
// ACCESSING LINKED LIST

package linkedList;

public class CheckList {
	
	public static void main(String[] args){
		
		LinkedList list1 = new LinkedList();
		list1.addAtBeg("Punit");
		list1.addAtBeg("Matt");
		list1.addAtBeg("Manny");
		list1.display();
		list1.append("Ravi");
		list1.addAtBeg("Manny");
		list1.addAtBeg("Manny");
		list1.display();
		list1.delete(3);
		list1.display();
		list1.append("Susie");
		list1.append("Ravi");
		list1.append("JP");
		list1.display();
		list1.removeDuplicates();
		list1.display();
		
	}

}
