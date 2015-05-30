// PUNIT SHARMA :: 09/01/2014
// PROGRAM TO ACCESS CLASS TO CHECK IF BTREE IS BIANRY SEARCH TREE

package bTree;

public class BSTCheckMain {

	public static void main(String[] args) {
		
		BSTCheck b = new BSTCheck();
		
		b.insert(55);
		b.insert(56);
		b.insert(22);
		b.insert(77);
		b.insert(19);
		b.insert(99);
		b.insert(29);
		if(b.isBinaryTree())
			System.out.println("Tree is binary search tree");
		else 
			System.out.println("Tree is not a binary search tree");

		System.out.println("Using alternate method");
		if(b.isBinaryTreeAlt())
			System.out.println("Tree is binary search tree");
		else 
			System.out.println("Tree is not a binary search tree");
		
		b.printLevels(b.root);

	}

}
