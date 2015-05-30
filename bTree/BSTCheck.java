// PUNIT SHARMA :: 09/01/2014
// PROGRAM TO :
// 1. CHECK IF GIVEN B TREE IS A BINARY SEARCH TREE

package bTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BSTCheck {

	public Node root;
	// ARRAYLIST TO HOLD INORDER TRAVERSAL ELEMENTS OF TREE
	private ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public BSTCheck() {

		root = null;
	}

	// INSERT INTO BTREE
	public void insert(int data){
		
		Node newNode = new Node(data);
		
		// INITIALIZING TREE. CREATING ROOT NODE
		if(isEmpty()){
			
			root = newNode;
			return;
		}
		
		Node tmp = root;
		
		// TRAVESING TREE TO LOCATE NODE TO WHICH
		// NEW NODE WILL BE ATTACHED
		while(tmp != null){
			
			// CHECK IF NEW DATA IS LESS THAN NODE IN FOCUS
			if(data < tmp.num){
				
				// CHECK IF LEFT CHILD OF NODE IN FOCUS IS NULL
				if(tmp.leftChild == null){
					
					tmp.leftChild = newNode;
					return;
				}
					
				tmp = tmp.leftChild;
			}
				
			if(data > tmp.num){
				
				// CHECK IF RIGHT CHILD OF NODE IN FOCUS IS NULL
				if(tmp.rightChild == null){
					
					tmp.rightChild = newNode;
					return;
				}
					
				tmp = tmp.rightChild;
			}
		}
	}

	// CHECK IF TREE IS EMPTY
	public boolean isEmpty(){
		
		return (root==null);
	}
	
	// CHECK IF TREE IS BINARY SEARCH TREE
	public boolean isBinaryTree(){
		
		inorderTraversal(this.root);
		for(int i=1; i<arr.size(); i++){
			
			if(arr.get(i-1) > arr.get(i))
				return false;
		}
		return true;
	}
	
	// INORDER TRAVERSAL OF BTREE 
	public void inorderTraversal(Node focusNode){
		
		if(focusNode!=null){
		
			inorderTraversal(focusNode.leftChild);
			arr.add(focusNode.num);
			inorderTraversal(focusNode.rightChild);
		}
	}
	
	// ALTERNATE TO CHECK IF BTREE IS BINARY SEARCH TREE
	public boolean isBinaryTreeAlt(){
		
		return checkBTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean checkBTree(Node n, int min, int max){
		
		if(n == null)
			return true;
		
		if(n.num > min && n.num < max 
				&& checkBTree(n.leftChild, min, n.num) 
				&& checkBTree(n.rightChild, n.num, max))
			return true;
		else
			return false;
	}
	
	public void printLevels(Node root){
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			
			Node tmp = q.remove();
			System.out.print(tmp.num + " ");
			if(tmp.leftChild!=null)
				q.add(tmp.leftChild);
			if(tmp.rightChild!=null)
				q.add(tmp.rightChild);
		}
	}
}
