// PUNIT SHARMA :: 08/17/2014
// PROGRAM ::
// 1. TO REMOVE DUPLICATES FROM LINKED LIST
// 2. TO FIND NTH NODE FROM LAST
// 3. TO REVERSE A LINKED A LIST

package linkedList;

import java.util.HashMap;

public class LinkedList {
	
	// REFERENCE TO THE FIRST LINK OF THE LIST
	public Link firstLink;
	
	// USED FOR METHOD "nthFromLastAlternate"
	static int counter;
	
	// CONSTRUCTOR TO INITIALIZE LINKEDLIST
	public LinkedList(){
		
		firstLink = null;
	}

	//CHECK IF LIST IS EMPTY
	public boolean isEmpty(){
		
		return (firstLink == null);
	}
	
	// ADDING LINK AT THE BEGINNING OF THE LIST
	public void addAtBeg(String name){
		
		Link newLink = new Link(name);
		newLink.next = firstLink;
		firstLink = newLink;
	}
	
	// DISPLAY ALL LINKS IN A LIST
	public void display(){
		
		Link tmp = firstLink;
		System.out.println("Current list is : ");
		
		// TRAVERSING LIST TILL END
		while(tmp != null){
			
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
	
	// ADDING LINK AT THE END OF THE LIST
	public void append(String name){
		
		Link newLink = new Link(name);
		Link tmp = firstLink;
		
		// TRAVERSING LIST TILL END
		while(tmp.next != null)
			tmp = tmp.next;
		
		// APPENDING NEW LINK TO THE LAST LINK
		tmp.next = newLink;
	}
	
	// DELETING A LINK BY POSITION(EXCLUDING FIRST AND LAST)
	public void delete(int pos){
		
		Link preNode=null;
		Link tmp = firstLink;
		for(int i=1;i<pos;i++){
		
			preNode = tmp;
			tmp = tmp.next;
		}
		
		System.out.println("Deleting link : " + tmp.data);
		preNode.next = tmp.next;
	}
	
	// REMOVES DUPLICATES FROM LINKED LIST
	public void removeDuplicates(){
		
		if(firstLink == null)
			return;
		
		Link tmp = firstLink;
		Link previous = firstLink;
		// HASHMAP HOLDING LINK DATA AS KEYS AND IF A PARTICULAR KEY IS SCANNED
		// ONCE ITS CORRESPONDING VALUE IS SET TO TRUE IN HASHMAP
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		
		// TRAVERSING LIST
		while(tmp != null){
			
			// IF A KEY IS THERE IN HASHMAP CURRENT LINK IS SKIPPED
			if(map.containsKey(tmp.data))
				previous.next = tmp.next; 
			
			else{
				
				map.put(tmp.data, true);
				previous = tmp;
			}
			
			// MOVING TO NEXT NODE
			tmp = tmp.next;
		}
		System.out.println("Duplicates removed.");
	}
	
	// PRINTS N'TH ELEMENT FROM LAST USING RECURSION
	public int nthFromLast(Link tmp, int posFromLast){
		
		if(tmp==null)
			return 0;
		
		int i = nthFromLast(tmp.next, posFromLast) + 1;
		
		if(i==posFromLast)
			System.out.println(tmp.data + " is at position " + posFromLast + " from last." );
		
		return i;
	}
	
	// ALTERNATE TO RETURN N'TH NODE FROM LAST USING RECURSION
	public Link nthFromLastAlternate(Link tmp, int posFromLast2){
		
		// RECURSION CONTINUES TILL LAST NODE IS FOUND
		if(tmp == null)
			return null;
		
		Link node = nthFromLastAlternate(tmp.next, posFromLast2);
		counter++;
		
		// BREAKING RECURSION WHEN COUNTER MATCHES POSITION FROM LAST
		if(counter == posFromLast2){
			
			// counter SET TO 0 WHEN REQUIRED NODE IS FOUND
			counter = 0;
			return tmp;
		}
		return node;
	}
	
	// RETURN N'TH NODE FROM LAST. USES TWO POINTERS TO HOLD ADDRESSES OF 
	// FIRST AND NODE AT N UNIT FROM FIRST NODE SUCH THAT BOTH NODES ARE 
	// N NODES APART. BOTH NODES ARE INCREMENTED TILL SECOND POINTER REACHES
	// END. AT THIS POINT THE FISRT NODE WILL BE THE NTH NODE FROM LAST.
	public Link nthFromLastOptimal(int posFromLast3){
		
		// TWO POINTERS TO HOLD DIFFERENT ADDRESSES
		Link tmp1 = this.firstLink;
		Link tmp2 = this.firstLink;
		
		if(tmp2.equals(null))
			return null;
		
		// INCREMENTING SECOND POINTER TO NTH POSITION(POSITION PASSED) 
		for(int i=0; i<posFromLast3; i++){
			
			if(tmp2.equals(null))
				return null;
			tmp2 = tmp2.next;
		}
		
		if(tmp2 == null)
			return null;
		
		// POINTERS INCREMENTED TILL POINTER TWO REACHES END OF LIST
		while(tmp2 != null){
			
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		
		// RETURN POINTER ONE(NTH NODE FROM LAST) 
		return tmp1;
	}
	
	// REVERSE A LINKED LIST
	public void reverseList(){
		
		Link tmp = firstLink;
		Link currNode = tmp;
		Link prevNode = null;
		
		if(tmp == null || tmp.next == null)
			System.out.println("List is empty or has only one element.");
		
		while(tmp != null){
			
			tmp = tmp.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = tmp;
		}
		
		firstLink = prevNode;
		System.out.println("List reversed");
	}
	
	// REVERSE LINKED LIST RECURSIVELY
	public void reverseListRecursive(Link currNode){
		
		if(currNode == null)
			return;
		
		if(currNode.next == null){
			
			System.out.println("List reversed by recursion");
			firstLink = currNode;
			return;
		}
			
		reverseListRecursive(currNode.next);
		currNode.next.next = currNode;
		currNode.next = null;
	}
}
