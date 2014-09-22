package stacks;

import java.util.Stack;

public class QueueOfStacks<T> {

	Stack<T> stackOfNew;
	Stack<T> stackOfOld;
	
	QueueOfStacks(){
		
		stackOfNew = new Stack<T>();
		stackOfOld = new Stack<T>();
	}
	
	public void add(T value){
		
		stackOfNew.push(value);
	}
	
	public void pop(){
		
		shiftStacks();
		System.out.println(stackOfOld.pop() + " popped out.");
	}
	
	public void peek(){
		
		shiftStacks();
		stackOfOld.peek();
	}
	
	public void shiftStacks(){
		
		if(stackOfOld.isEmpty()){
			
			while(!stackOfNew.isEmpty())
				stackOfOld.push(stackOfNew.pop());
		}
	}
}
