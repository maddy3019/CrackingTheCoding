/**
 * @author Maddy
 * Ver 1.0 Nov 20, 2017 12:33:58 AM
 * Class to implement pre-order, in-order and post-order traversal of a binary tree.
 * EX:
 * I/P:
 *    	  5
 *		/   \
 * 	   3     7
 *    /	\   / \
 *   2   4 6   8
 * O/P:
 * Pre-order:
 * 5 3 2 4 7 6 8 
 * In-order:
 * 2 3 4 5 6 7 8 
 * Post-order:
 * 2 4 3 6 8 7 5 
 */

package crackTheCode.Ch_4_TreesAndGraphs;

public class BinaryTreeTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);

		/* pre-order traversal */
		System.out.println("Pre-order:");
		preOrder(root);
		System.out.println();

		/* in-order traversal */
		System.out.println("In-order:");
		inOrder(root);
		System.out.println();

		/* post-order traversal */
		System.out.println("Post-order:");
		postOrder(root);
	}

	/**
	 * Pre-order: visit - left - right
	 * 
	 * @param root
	 */
	private static void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	/**
	 * In-order: left - visit - right
	 * 
	 * @param root
	 */
	private static void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		}
	}

	/**
	 * Post-order: left - right - visit
	 * 
	 * @param root
	 */
	private static void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.val + " ");
		}
	}
}
