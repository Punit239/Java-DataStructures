// PUNIT SHARMA :: 08/31/2014
// PROGRAM TO ACCESS BTREE 

package bTree;

public class CheckTree {
	
	public static void main(String[] args){
		
		BtreeOps tree1 = new BtreeOps();
		BtreeOps tree2 = new BtreeOps();
		
		int[] sortedArray = {11,22,33,44,55,66,77,88,99};
		
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
		
		System.out.println();
		System.out.println("Height of tree is : " + tree1.heightOfBtree(tree1.root));
		tree1.insert(51);
		System.out.println("Height of tree is : " + tree1.heightOfBtree(tree1.root));
		
		if(tree1.isBalanced(tree1.root))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
		
		tree1.isBalancedAlt(tree1.root);
		
		System.out.println("Tree 2 :");
		tree2.root = tree2.createMinHeightBST(sortedArray, 0, sortedArray.length - 1);
		System.out.println("Inorder Traversal :");
		tree2.inorderTraversal(tree2.root);
	}
}
