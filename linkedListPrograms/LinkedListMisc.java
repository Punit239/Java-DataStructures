// PUNIT SHARMA :: 08/13/2014
// PROGRAM TO MOVE ALL ELEMENTS LESS THEN GIVEN NUMBER TO LEFT OF THIS NUMBER
// AND ALL ELEMENTS GREATER THAN THIS NUMBER TO RIGHT THIS NUMBER IN THE LIST

package linkedListPrograms;

public class LinkedListMisc {
	
	// REFERENCE TO THE FIRST LINK OF THE LIST
	public Link firstLink;
	
	// CONSTRUCTOR TO INITIALIZE LINKEDLIST
	public LinkedListMisc(){
		
		firstLink = null;
	}

	
	public static void main(String[] args) {
		
		LinkedListMisc list = new LinkedListMisc();
		LinkedListMisc list1 = new LinkedListMisc();
		LinkedListMisc list2 = new LinkedListMisc();
		LinkedListMisc sumList = new LinkedListMisc();
		
		// INITIALIZING LINKED LIST
		list.addAtBeg(69);
		list.addAtBeg(99);
		list.addAtBeg(19);
		list.addAtBeg(49);
		list.addAtBeg(24);
		list.addAtBeg(89);
		list.addAtBeg(79);
		list.addAtBeg(29);
		list.addAtBeg(86);
		list.display();
		list.splitAndMerge(49);
		list.display();
		list.splitAndMergeAlternate(49);
		list.display();
		
		// INITIALIZING LIST ONE
		list1.addAtBeg(2);
		list1.addAtBeg(9);
		list1.addAtBeg(6);
		System.out.println("List 1 ");
		list1.display();
		
		// INITIALIZING LIST TWO
		list2.addAtBeg(4);
		list2.addAtBeg(9);
		System.out.println("List 2 ");
		list2.display();
		
		list.addLists(list1.firstLink, list2.firstLink);
		sumList.firstLink = list.addList(list1.firstLink, list2.firstLink, 0);
		System.out.println("Sum of the two numbers, represented by list1 & list2,"
							+ " in form of list");
		sumList.display();
		
	}
	

	//CHECK IF LIST IS EMPTY
	public boolean isEmpty(){
		
		return (firstLink == null);
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
	
	// ADDING LINK AT THE END OF THE LIST
	public void append(int num){
		
		Link newLink = new Link(num);
		Link tmp = firstLink;
		
		// TRAVERSING LIST TILL END
		while(tmp.next != null)
			tmp = tmp.next;
		
		// APPENDING NEW LINK TO THE LAST LINK
		tmp.next = newLink;
	}
	
	// FUNCTION THAT MOVES ALL NUMBERS IN LIST LESS THAN GIVEN NUMBER
	// TO THE LEFT OF GIVEN NUMBER AND NUMBERS GREATER THAN GIVEN NUMBER
	// TO THE RIGHT OF GIVEN NUMBER IN LIST
	public void splitAndMerge(int splitNum){
		
		Link tmp = firstLink;
		Link connectingNode = new Link(splitNum);
		Link beforeStart = null;
		Link beforeEnd = null;
		Link afterStart = null;
		Link afterEnd = null;
		
		// CHECK IF LIST IS NOT EMPTY
		if(tmp == null)
			return;
		
		while(tmp != null){
			
			Link node = new Link(tmp.data);
			if(tmp.data < splitNum){
				
				// CREATING TWO LISTS
				// BEFORE LIST HAVING NUMBERS LESS THAN GIVEN NUMBER
				if(beforeStart == null){
					
					beforeStart = node;
					beforeEnd = node;
					
				}
				
				else{
					
					beforeEnd.next = node;
					beforeEnd = node;
				}
				
			}
			
			// AFTER LIST HOLDING NUMBERS GREATER THAN GIVEN NUMBER
			if (tmp.data > splitNum){
				
				if(afterStart == null){
					
					afterStart = node;
					afterEnd = node;
				}
			
				else{
					
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			
			tmp = tmp.next;
		}
	
		// CONNECTING BEFORE AND AFTER LIST
		beforeEnd.next = connectingNode;
		connectingNode.next = afterStart;
		firstLink = beforeStart;
		
		System.out.println("List split from element " + splitNum);
		
	}
	
	// ALTERNATE METHOD TO MOVE ALL NUMBERS LESS THAN GIVEN NUMBER TO LEFT OF
	// THIS NUMBER AND NUMBERS GREATER THAN GIVEN NUMBER TO RIGHT OF THIS NUMBER
	// IN THE LIST WITH REDUCED NUMBER OF VARIABLES
	public void splitAndMergeAlternate(int num){
		
		Link connectingNode = new Link(num);
		
		Link tmp = firstLink;
		Link beforeStart = null;
		Link beforeEnd = null;
		
		while(tmp != null){
			
			Link node = new Link(tmp.data);
			if(tmp.data < num){
				
				if(beforeStart == null){
					
					beforeStart = node;
					beforeEnd = node;
				}
				
				else{
					
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}		 

			if(tmp.data > num){
				
				node.next = connectingNode.next;
				connectingNode.next = node;
			}
			
			// MOVING TO NEXT NODE IN ORIGINAL LIST
			tmp = tmp.next;
		}
		
		// MERGING THE LAST NODE OF BEFORELIST AND FIRSTNODE OF RIGHTLIST
		beforeEnd.next = connectingNode;
		firstLink = beforeStart;
	}
	
	// GIVES SUM OF TWO NUMBERS REPRESENTED IN FORM OF A LINKED LIST
	// WITH ONE'S DIGIT AT THE HEAD OF LIST
	public void addLists(Link l1, Link l2){
		
		int count=1;
		int sum=0;
		
		// ADD NUMBERS AT ONES PLACE THEN AT TENS PLACE AND SO ON
		while((l1!=null) && (l2!=null)){
			
			sum += (l1.data)*count + (l2.data)*count;
			l1 = l1.next;
			l2 = l2.next;
			count*=10;
		}
		
		// EXECUTED IF NUMBERS ARE LEFT IN IN LIST ONE
		while(l1!=null){
			
			sum+=(l1.data)*count;
			l1=l1.next;
			count*=10;
		}
		
		// EXECUTED IF NUMBERS ARE LEFT IN IN LIST TWO
		while(l2!=null){
			
			sum+=(l2.data)*count;
			l2=l2.next;
			count*=10;
		}
		System.out.println("Sum of the two numbers is : " + sum);
	}
	
	// RECURSIVE SOLUTION THAT GIVES SUM OF TWO NUMBERS REPRESENTED IN FORM
	// OF A LINKED LIST WITH ONES DIGIT AT ROOT OF LIST. RETURNS THE RESULT 
	// IN FORM OF A LINKED LIST.
	public Link addList(Link l1, Link l2, int carry){
		
		if(l1 == null && l2 == null && carry == 0)
			return null;
		
		Link result = new Link(carry);
		int value = carry;
		
		if(l1 != null)
			value += l1.data;
			
		if(l2 != null)
			value += l2.data;
			
		result.data = value%10;
		
		if(l1 != null || l2 != null){
			
			Link newNode = addList(l1==null ? null : l1.next,
								   l2==null ? null : l2.next,
									value>=10 ? 1 : 0);
			result.next = newNode;
			
		}
		return result;
	}
}