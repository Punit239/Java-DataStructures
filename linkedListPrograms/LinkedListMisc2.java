// PUNIT SHARMA :: 08/17/2014
// PROGRAM ::
// 1. TO CHECK IF A LINKED LIST HAS LOOP OR NOT
//    AND TO FIND AT WHICH NODE THE LOOP STARTS 
// 2. TO FIND IF A LIST IS A PALINDROME

package linkedListPrograms;

import java.util.HashMap;
import java.util.Stack;

public class LinkedListMisc2 {

	// REFERENCE TO THE FIRST LINK OF THE LIST
	public Link firstLink;
	
	// CONSTRUCTOR TO INITIALIZE LINKEDLIST
	public LinkedListMisc2(){
		
		firstLink = null;
	}

	public static void main(String[] args) {

		// ARRAYS TO INITIALIZE LINKED LIST
		int[] numbers = {22,44,55,11,99,77,88,66,33};
		int[] listToCheck = {1,1,2,4,5,5,4,2,1,1};
		LinkedListMisc2 list = new LinkedListMisc2();

		// LIST TO BE CHECKED FOR PALINDROME
		LinkedListMisc2 palindromeList = new LinkedListMisc2();
		
		list.initializeList(numbers);
		list.display();
		list.createLoopAtPos(6);

		if(list.listHasLoop())
			System.out.println("List has loop");
		else
			System.out.println("List doesn't has loop");
		
		if(list.listHasLoopAlternate())
			System.out.println("List has loop");
		else
			System.out.println("List doesn't has loop");
		
		palindromeList.initializeList(listToCheck);
		
		if(palindromeList.isPalindrome())
			System.out.println("It's a palinddrome");
		else
			System.out.println("It's not a palindrome");

	}

	// ADDING LINK AT THE BEGINNING OF THE LIST
	public void addAtBeg(int num){
		
		Link newLink = new Link(num);
		newLink.next = firstLink;
		firstLink = newLink;
		
	}
	
	// DISPLAY ALL LINKS IN A LIST
	public void display(){
		
		Link tmp = firstLink;
		System.out.println("Current list is : ");
		
		// TRAVERSING LIST TILL END
		while(tmp != null){
			
			System.out.print(tmp.data + "\t");
			tmp = tmp.next;
			
		}
		
		System.out.println();
		
	}
	
	// INITIALZED LINKED LIST WITH GIVEN ARRAY
	public void initializeList(int[] num){
		
		for(int i : num)
			addAtBeg(i);
	}
	
	// CREATE LOOP IN LINKED LIST
	public void createLoopAtPos(int loopAtPos){
		
		Link endNode = firstLink;
		Link tmp = firstLink;
		
		if(loopAtPos<1)
			return;
		
		while(endNode.next!=null)
			endNode = endNode.next;
		
		for(int i=1; i<loopAtPos; i++)
			tmp = tmp.next;
		
		endNode.next = tmp;
		
	}
	
	// RETURNS TRUE IF LIST HAS LOOP USING HASHMAP
	public boolean listHasLoop(){
		
		// HASHMAP TO HOLD STATUS OF A LINK. VALUE OF LINK IS SET
		// TO TRUE IF IT HAS BEEN SCANNED
		HashMap<Link,Boolean> map = new HashMap<Link,Boolean>();
		Link tmp = firstLink;
		
		if(firstLink==null || firstLink.next==null)
			return false;
		
		while(tmp!=null){
			
			// CHECK IF LINK HAS BEEN SCANNED
			if(map.containsKey(tmp))
				return loopStartsAt(tmp);
			
			map.put(tmp, true);
			tmp = tmp.next;
		}
		
		return false;
	}
	
	// GIVES POSITION IN LIST WHERE THE LOOP HAS STARTED.
	// FIRST NODE THAT IS SCANNED TWICE IN LIST IS THE 
	// STARTING POINT OF THE LOOP IN LIST
	public boolean loopStartsAt(Link startOfLoop){
		
		Link tmp = firstLink;
		int i = 1;
		while(tmp != startOfLoop){
			
			tmp = tmp.next;
			i++;
		}
			
		System.out.println("Loop starts at node " + i + " , " + tmp.data);
		return true;
		
	}
	
	// RETURNS TRUE IF A LIST HAS LOOP USING SLOW AND FAST RUNNER APPROACH
	public boolean listHasLoopAlternate(){
		
		Link tmp1 = this.firstLink;
		Link tmp2 = this.firstLink;
		
		while(tmp2 != null){

			tmp1 = tmp1.next;
			tmp2 = tmp2.next.next;

			if(tmp1==tmp2)
				return loopStartsAtAlternate(tmp1);
		}
		return false;
	}
	
	// ALTERNATE METHOD TO FIND STARTING NODE OF THE LOOP IN LIST.
	// ONCE COLLISION OCCURS BETWEEN FAST AND SLOW RUNNERS,THE START 
	// OF LIST IS EQUIDISTANT FROM THE COLLISION NODE AND HEAD OF LIST.
	public boolean loopStartsAtAlternate(Link collisionNode){
		
		Link tmpNode = this.firstLink;
		
		while(tmpNode != collisionNode){
			
			tmpNode = tmpNode.next;
			collisionNode = collisionNode.next;
		}
		
		System.out.println("Loop in list starts at node " + tmpNode.data);
		return true;
	}
	
	// RETURNS TRUE IF LIST IS PALINDROME. HALF OF THE LIST IS SCANNED AND
	// NODES ARE PUSHED IN A STACK. THEN THE REMAINING HALF NODES ARE COMPARED
	// WITH STACK ELEMENTS, POPPING ONE ELEMENT EVERYTIME TO COMPARE.
	public boolean isPalindrome(){
		
		Link slow = firstLink;
		Link fast = firstLink;
		Stack<Integer> tmpStack = new Stack<Integer>();
		
		// PUSH FIRST HALF ELEMENTS OF THE LIST TO THE STACK
		while(fast != null && fast.next != null){
			
			tmpStack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// IF THE END NODE OF LIST WAS NOT REACHED
		if(fast != null)
			slow = slow.next;
		
		// COMPARE REMAINING ELEMENTS OF THE LIST WITH THE STACK
		// OF FIRST HALF ELEMENTS OF THE LIST
		while(slow != null){
			
			// RETURN FALSE IF ANY REMAINING ELEMENT IN LIST DOES NOT
			// MATCHES WITH ELEMENTS IN STACK
			if(tmpStack.pop() != slow.data)
				return false;
			slow = slow.next;
		}
		return true;	
	}
}
