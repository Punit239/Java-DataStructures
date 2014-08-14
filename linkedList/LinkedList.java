// PUNIT SHARMA :: 08/13/2014
// PROG TO CREATE NEW LINKED LIST AND PERFORMING
// OPERATIONS INSERT, DELETE, APPEND, DISPLAY

package linkedList;

import java.util.HashMap;

public class LinkedList {
	
	// REFERENCE TO THE FIRST LINK OF THE LIST
	public Link firstLink;
	
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
			
			// MOVING TO MEXT NODE
			tmp = tmp.next;
			
		}
		
		System.out.println("Duplicates removed.");
		
	}
}
