// PUNIT SHARMA :: 09/24/2014
// PROGRAM TO :
// 1. PERFORM OPERATIONS INSERTION, DELETION, TRAVERSAL(PREORDER, INORDER, POSTORDER) 
// 2. CALCULATE HEIGHT OF B TREE
// 3. CHECK IF TREE IS BALANCED
// 4. CREATE A BINARY SEARCH TREE WITH MINIMUM HEIGHT USING A SORTED ARRAY
// 5. FIND FIRST COMMON ANCESTOR OF TWO NODES 
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
	
	// METHOD TO DELETE A NUMBER FROM THE TREE
	public void deleteNode(int num){
		
		Node parent;
		Node tmp = root;
		boolean isItALeft=false;
		
		// VARIABLE TO HOLD PARENT OF THE LAST VISITED NODE
		parent = tmp;
		
		while(num != tmp.num){
			
			// PARENT OF THE NODE BEING SCANNED
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
	
	// FINDS HEIGHT OF A BTREE  BY TRAVERSING EACH NODE OF EACH SUBTREE RECURSIVELY
	public int heightOfBtree(Node tmp) {
		
		if(tmp == null)
			return -1;
			
		return Math.max(heightOfBtree(tmp.leftChild),heightOfBtree(tmp.rightChild)) + 1;
	}
	
	// RETURNS TRUE IF TREE IS BALANCED. CALCULATES HEIGHT OF SUBTREE OF EACH NODE. IF
	// DIFFERENCE IN HEIGHT'S OF SUBTREES OF ANY NODE IS MORE THAN ONE, RETURNS FALSE.
	public boolean isBalanced(Node tmp){
		
		if(tmp == null)
			return true;
		
		int heightDiff = heightOfBtree(tmp.leftChild) - heightOfBtree(tmp.rightChild);
		
		if(Math.abs(heightDiff) > 1 )
			return false;
		else
			// REUCURSE TILL LEAF NODE IS REACHED
			return (isBalanced(tmp.leftChild) && isBalanced(tmp.rightChild));
	}
	
	// OPTIMIZED METHOD TO GET HEIGHT OF B TREE. RETURNS FALSE AS SOON AS 
	// IT FINDS ANY TWO SUBTREES WITH HEIGHT DIFFERENCE GREATER THAN ONE
	public int heightOfBtreeOptimal(Node tmp){
		
		if(tmp == null)
			return 0;
		
		int heightLeft = heightOfBtreeOptimal(tmp.leftChild);
		if(heightLeft == -1)
			return -1;
		
		int heightRight = heightOfBtreeOptimal(tmp.rightChild);
		if(heightRight == -1)
			return -1;
		
		int heightDiff = heightLeft - heightRight;
		if(Math.abs(heightDiff) > 1)
			return -1;
		else
			return Math.max(heightLeft, heightRight) + 1;
	}
	
	// ALTERNATE METHOD TO CHECK IF TREE IS BALANCED
	public void isBalancedAlt(Node tmp){
		
		if(heightOfBtreeOptimal(tmp) == -1)
			System.out.println("Tree is not a balanced tree");
		else
			System.out.println("Tree is a balanced tree");
	}
	
	// CREATES TREE WITH MINIMUM HEIGHT USING A SORTED ARRAY WITH UNIQUE ELEMENTS
	public Node createMinHeightBST(int[] arr, int start, int end){
		
		if(end < start)
			return null;
		
		int mid = (start+end)/2;
		Node newNode = new Node(arr[mid]);
		newNode.leftChild = createMinHeightBST(arr, start, mid-1);
		newNode.rightChild = createMinHeightBST(arr, mid+1, end);
		
		return newNode;
	}
	
	// FUNCTION TO FIND COMMON ANCESTOR OF TWO NODES
	public Node findCommonAncestor(Node root, Node p, Node q){
		
		if(root == null)
			return null;
		
		if(root == p || root == q)
			return root;
		
		boolean pOnLeft = covers(root, p);
		boolean qOnLeft = covers(root, q);
		
		if(pOnLeft != qOnLeft)
			return root;
		
		Node childNode = pOnLeft?root.leftChild:root.rightChild;
		
		return findCommonAncestor(childNode, p, q);
	}
	
	// RETURNS TRUE IF THE NODE IS ON THE LEFT OF ROOT
	public boolean covers(Node root, Node tmp){
		
		if(root == null)
			return false;
		
		if(root == tmp)
			return true;
		
		return (covers(root.leftChild, tmp) || covers(root.rightChild, tmp));
	}
}
