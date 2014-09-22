// PUNIT SHARMA :: 08/19/2014
// PROGRAM TO IMPLEMENT 3 STACKS USING AN ARRAY

package stacks;

public class ArrayToStack {

	int stackSize = 3;  // SIZE OF SINGLE STACK
	int[] buffer = new int[stackSize*3];  // ARRAY USED TO IMPLEMENT 3 STACKS
	int[] stackPointer = {-1, -1, -1};  // POINTER USED TO ACCESS STACK. EACH ELEMENT IN THIS ARRAY
										// REPRESENTS INDEX OF THE 3 STACKS. 
	
	public static void main(String[] args) throws Exception {
		
		ArrayToStack a = new ArrayToStack();
		a.push(1, 99);
		a.push(1, 89);
		a.push(1, 19);
		a.push(2, 109);
		a.push(2, 209);
		a.push(2, 119);
		a.push(3, 199);
		a.push(3, 169);
		a.push(3, 179);
		a.pop(2);
		a.push(2, 111);
	}

	// METHOD TO PUSH INTO STACK. RECEIVES THE NUMBER OF STACK WHERE THE VALUES
	// NEEDS TO BE INSERTED AND THE VALUE TO BE INSERTED
	public void push(int stackNum, int value) throws Exception{
		
		// ONCE POINTER OF ANY STACK REACHES IS MAXIMUM EXCEPTION IS THROWN
		if(stackPointer[stackNum-1] + 1 >= stackSize)
			throw new Exception("Stack out of space.");
			
		// IF STACK IS NOT FULL INCREASE ITS POINTER
		stackPointer[stackNum-1]++;
		// ADDING VALUE TO THE MAIN ARRAY
		buffer[indexOfStack(stackNum)] = value;
		System.out.println(value + " pushed to stack " + stackNum);
	}
	
	// METHOD TO POP ELEMENT FROM GIVEN STACK
	public void pop(int stackNum) throws Exception{
		
		// CHECK IF STACK IS EMPTY
		if(stackPointer[stackNum-1] == -1)
			throw new Exception("Cannot delete from empty stack.");
		
		int value = indexOfStack(stackNum);
		System.out.println(buffer[value] + " popped out");
		// SETTING VALUE OF POPPED OUT ELEMENT IN ARRAY TO 0
		buffer[value] = 0;
		// DECREMENTING POINTER OF GIVEN STACK WHEN ELEMENT IS POPPED OUT
		stackPointer[stackNum-1]--;
	}
	
	// RETURNS INDEX OF STACK BASED IN GIVEN STACK AND IT'S STACK POINTER
	public int indexOfStack(int stackNum){
		
		return ((stackNum-1)*stackSize + stackPointer[stackNum-1]);
	}
}
