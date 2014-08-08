// PUNIT SHARMA :: 08/01/2014
// CLASS TO ACCESS BTREE 

package bTree;

public class CheckTree {
	
	public static void main(String[] args){
		
		BtreeOps tree1 = new BtreeOps();
		tree1.insert(79);
		tree1.insert(19);
		tree1.insert(29);
		tree1.insert(49);
		tree1.insert(99);
		tree1.insert(89);
		tree1.insert(199);
		System.out.println("Inorder Traversal :");
		tree1.inorderTraversal(tree1.root);
		System.out.println("\nPreorder Traversal :");
		tree1.preorderTraversal(tree1.root);
		System.out.println("\nPostorder Traversal :");
		tree1.postorderTraversal(tree1.root);
		tree1.deleteNode(89);
		System.out.println("Preorder Traversal :");
		tree1.preorderTraversal(tree1.root);
	}
}
