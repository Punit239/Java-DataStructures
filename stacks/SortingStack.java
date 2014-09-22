// PUNIT SHARMA :: 08/21/2014
// PROGRAM TO SORT ELEMENTS OF A STACK

package stacks;

import java.util.Iterator;
import java.util.Stack;

public class SortingStack {

	public static void main(String[] args) {
		
		SortingStack s = new SortingStack();
		Stack<Integer> stackToSort = new Stack<Integer>();
		Stack<Integer> sortedStack = new Stack<Integer>();
		
		stackToSort.push(99);
		stackToSort.push(909);
		stackToSort.push(199);
		stackToSort.push(9);
		stackToSort.push(999);
		s.display(stackToSort);
		s.display(s.sortStack(stackToSort));
	}
	
	// METHOD TO SORT GIVEN STACK. PASSED STACK IS SCANNED AND ITS ELEMENTS ARE
	// MOVED TO ANOTHER STACK IN A SORTED ORDER AND THIS SORTED STACK IS RETURNED
	public Stack<Integer> sortStack(Stack<Integer> stackToSort){
		
		Stack<Integer> sortedStack = new Stack<Integer>();
		// CONTINUE LOOP TILL STACK TO SORT IS EMPTY
		while(!stackToSort.isEmpty()){
			
			int tmp = stackToSort.pop();
			if(sortedStack.isEmpty())
				sortedStack.push(tmp);
			
			else{
				// IF SORTED STACK IS EMPTY AND THE TOP ELEMENT IN PASSED STACK IS 
				// LESS THAN TOP ELEMENT IN SORTED STACK, MOVE ELEMENTS FROM SORTED
				// STACK TO STACK PASSED TILL TOP ELEMENT OF SORTED STACK IS LESS THAN
				// TOP ELEMENT OF PASSED STACK.
				while(!sortedStack.isEmpty() && tmp < sortedStack.peek())
					stackToSort.push(sortedStack.pop());
			
				// OTHERWISE ADD ELEMENT TO SORTED STACK
				sortedStack.push(tmp);
			}
		}
		
		System.out.println("\nStack sorted");
		return sortedStack;
	}

	// METHOD TO DISPLAY STACK
	public void display(Stack<Integer> stackToDisplay){
		
		System.out.println("Current stack :");
		for(Integer value : stackToDisplay)
			System.out.println(value);
		
		/* ALTERNATE TO INTERATE THROUGH STACK
		Iterator<Integer> iter = stackToDisplay.iterator();    
		while (iter.hasNext())
			System.out.println(iter.next());*/
	}
}
