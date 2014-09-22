// PUNIT SHARMA :: 08/19/2014
// PROGRAM TO ACCESS CLASS MINMAXINSTACK

package stacks;

import java.util.Stack;

public class MinMaxInStackMain {

	public static void main(String[] args) {
		
		MinMaxInStack stackToCheck = new MinMaxInStack();
		stackToCheck.push(99);
		stackToCheck.push(19);
		stackToCheck.push(29);
		stackToCheck.push(69);
		stackToCheck.push(919);
		System.out.println("Minimum value in stack is : " + stackToCheck.min());
		System.out.println("Maximum value in stack is : " + stackToCheck.max());
	}
}
