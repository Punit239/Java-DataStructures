// PUNIT SHARMA :: 7/27/2014
// CLASS TO GENERATE NODE STRUCTURE OF A BTREE 

package bTree;

public class Node {
	
	// NODE STRUCTURE
	int num;
	Node leftChild;
	Node rightChild;
	
	// CONSTRUCTOR TO INITIALIZE NODE
	Node(int data){
		
		num = data;
		leftChild = null;
		rightChild = null;
		
	}

}
