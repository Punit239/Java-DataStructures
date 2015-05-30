// PUNIT SHARMA :: 08/13/2014
// ACCESSING LINKED LIST

package linkedList;

public class CheckList {
	
	public static void main(String[] args){
		
		LinkedList list1 = new LinkedList();
		
		list1.addAtBeg("Punit");
		list1.addAtBeg("Matt");
		list1.addAtBeg("Manny");
		list1.append("Ravi");
		list1.addAtBeg("Manny");
		list1.append("Manny");
		list1.display();
		list1.delete(3);
		list1.display();
		list1.append("Susie");
		list1.append("Ravi");
		list1.append("JP");
		list1.display();
		list1.removeDuplicates();
		list1.display();
		
		System.out.println();
		list1.nthFromLast(list1.firstLink, 4);
		list1.nthFromLast(list1.firstLink, 2);
		
		System.out.println("\nElement at 4th position from last is "+ 
				list1.nthFromLastAlternate(list1.firstLink, 4).data);
		System.out.println("Element at 2nd position from last is " +
				list1.nthFromLastAlternate(list1.firstLink, 2).data);
		
		System.out.println("\nElement at 4th position from last is "+
							 list1.nthFromLastOptimal(4).data);
		System.out.println("Element at 2nd position from last is "+
				 list1.nthFromLastOptimal(2).data);
		
		list1.display();
		list1.reverseList();
		list1.display();
		list1.reverseListRecursive(list1.firstLink);
		list1.display();
	}

}
