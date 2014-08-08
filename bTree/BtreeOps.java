// PUNIT SHARMA :: 08/01/2014
// CLASS TO PERFORM OPERATIONS ON BTREE 

package bTree;

public class BtreeOps {
	
	public Node root;
	
	public BtreeOps() {

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
	
	// INORDER TRAVERSAL OF BTREE 
	public void inorderTraversal(Node focusNode){
		
		if(focusNode!=null){
		
			inorderTraversal(focusNode.leftChild);
			System.out.print(focusNode.num + "\t");
			inorderTraversal(focusNode.rightChild);
			
		}
	}
	
	// PREORDER TRAVERSAL OF BTREE 
	public void preorderTraversal(Node focusNode){
			
		if(focusNode!=null){
			
			System.out.print(focusNode.num + "\t");
			preorderTraversal(focusNode.leftChild);
			preorderTraversal(focusNode.rightChild);
				
		}
	}
	
	// POSTORDER TRAVERSAL OF BTREE 
	public void postorderTraversal(Node focusNode){
			
		if(focusNode!=null){
			
			postorderTraversal(focusNode.leftChild);
			postorderTraversal(focusNode.rightChild);
			System.out.print(focusNode.num + "\t");
				
		}
	}
	
	
	public void deleteNode(int num){
		
		Node parent;
		Node tmp = root;
		boolean isItALeft=false;
		
		// VARIABLE TO HOLD PARENT OF THE LAST VISITED NODE
		parent = tmp;
		
		while(num != tmp.num){
			
			parent = tmp;
			
			if(num < tmp.num){
				
				tmp = tmp.leftChild;
				isItALeft = true;
				
			}
				
			if(num > tmp.num){
				
				tmp = tmp.rightChild;
				isItALeft = false;
				
			}
			
			
			if(tmp == null){
				
				System.out.println("\nNode not found.");
				return;
				
			}
		}
		
		// IF NODE FOUND IS A LEAF NODE
		if(tmp.leftChild == null && tmp.rightChild == null){
			
			if(tmp == root)
				root = null;
			
			else if(isItALeft)
				parent.leftChild = null;
				
			else
				parent.rightChild = null;
			
		}
			
		// IF NODE FOUND HAS ONLY RIGHT CHILD REPLACE IT WITH ITS RIGHT CHILD
		else if(tmp.leftChild == null){
			
			if(tmp == root)
				root = tmp.rightChild;
			
			else if(isItALeft)
				parent.leftChild = tmp.rightChild;
			
			else
				parent.rightChild = tmp.rightChild;
			
		}
		
		// IF NODE FOUND HAS ONLY LEFT CHILD REPLACE IT WITH ITS LEFT CHILD
		else if(tmp.rightChild == null){
			
			if(tmp == root)
				root = tmp.leftChild;

			else if(isItALeft)
				parent.leftChild = tmp.leftChild;
			
			else
				parent.rightChild = tmp.leftChild;
		}
		
		// IF NODE FOUND HAS BOTH LEFT AND RIGHT CHILD REPLACE IT WITH 
		// ITS WITH RIGHT CHILD (INORDER SUCCESSOR)
		else{
			
			if(tmp == root){
				
				root = root.rightChild;
				root.leftChild = root.leftChild;
				
			}
			
			else{
				
				if(isItALeft)					
					parent.leftChild = tmp.rightChild;
					
				else					
					parent.rightChild = tmp.rightChild;
									
				tmp.rightChild.leftChild = tmp.leftChild;
					
			}
			
		}
		
		System.out.println("\n" + tmp.num + " deleted successfully.");
	}
}
