// PUNIT SHARMA :: 08/19/2014
// PROGRAM TO FIND MINIMUM AND MAXIMUM VALUE IN A STACK

package stacks;

import java.util.Stack;

public class MinMaxInStack extends Stack<Integer> {

    // VALUE AT THE TOP OF THIS STACK IS THE CURRENT MINIMUM
	private Stack<Integer> minStack;
	// VALUE AT THE TOP OF THIS STACK IS THE CURRENT MAXIMUM
    private Stack<Integer> maxStack;

    // INITIALIZING MIN AND MAX STACK
    public MinMaxInStack () {
        minStack = new Stack<Integer>();    
        maxStack = new Stack<Integer>();    
    }

    // PUSH FUNCTION TO INSERT IN MAIN STACK AND CHECK 
    // AND INSERT IN MIN AND MAX STACK 
    public void push(int value){
        if (value <= min()) {
            minStack.push(value);
        }

        if (value >= max()) {
            maxStack.push(value);
        }

        // INSERTING IN MAIN STACK
        super.push(value);
    }

    // PERFORMS POP FUNCTION IN MAIN STACK AND UPDATES MIN AND MAX STACK IF NEEDED
    public Integer pop() {
        
    	int value = super.pop();

        // IF POPPED VALUE IS EQUAL TO MINIMUM VALUE 
    	// PERFORM POP ON MIN STACK
    	if (value == min()) {
            minStack.pop();         
        }
        // IF POPPED VALUE IS EQUAL TO MAXIMUM VALUE 
    	// PERFORM POP ON MAX STACK
        if (value == max()) {
            maxStack.pop();         
        }

        return value;
    }

    // RETURN MIN VALUE IN STACK. VALUE AT TOP OF 
    // MIN STACK IS CURRENT MINIMUM
    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }

    // RETURNS MAX VALUE IN STACK. VALUE AT TOP OF 
    // MAX STACK IS CURRENT MAXIMUM
    public int max() {
        if (maxStack.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            return maxStack.peek();
        }
    }
}