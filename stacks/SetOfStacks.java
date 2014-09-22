// PUNIT SHARMA :: 08/20/2014
// PROGRAM TO IMPLEMENT SET OF STACKS SUCH THAT IF A STACK FROM SET EXCEEDS A THRESHOLD
// A NEW STACK IS CREATED. IMPLEMENTATION MUST PROVIDE OPERTIONS PUSH AND POP AS IF WE 
// ARE WORKING ON A SINGLE STACK.

package stacks;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {

	//ARRAY TO HOLD ALL STACKS
	ArrayList<Stack<Integer>> setOfStacks = new ArrayList<Stack<Integer>>();
	int stackSize = 3;
	Stack<Integer> newStack;
	
	public void push(int value){
		
		Stack<Integer> lastStack = getLastStack();
		if(lastStack != null && !(lastStack.size()<3))
			lastStack.push(value);
		
		// LINE BELOW WILL THROW ERROR AS WE HAVE NOT CREATED A SEPERATE CONSTRUCTOR
		// WHICH CAN CREATE A STACK WITH THE GIVEN SIZE. CONCEPT REMAINS THE SAME.
		newStack = new Stack<Integer>(stackSize);
		newStack.push(value);
		setOfStacks.add(newStack);
	}
	
	// POPS OUT ELEMENT FROM LAST STACK IN THE ARRAYLIST OF STACKS
	public void pop(){
		
		int value = getLastStack().pop();
		System.out.println(value + " popped out.");
		
		// IF LAST STACK IN ARRAYLIST OF STACK IS EMPTY THEN DELETE FROM ARRAYLIST
		if(getLastStack().isEmpty())
			setOfStacks.remove(setOfStacks.size() - 1);
	}
	
	// GIVES LAST STACK FROM ARRAYLIST OF STACKS
	public Stack<Integer> getLastStack(){
		
		return setOfStacks.get(setOfStacks.size() - 1);
	}
}
