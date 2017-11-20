/**
 * @author Maddy
 * Ver 1.0 Oct 27, 2017 9:32:07 AM
 * Implement a function to check if a binary tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
 * Ex:
 * I/P:
 *    1
 *	/   \
 * 2     3
 *  \
 *   5
 * O/P: false
 */

package crackTheCode.Ch_4_TreesAndGraphs;

public class CheckBalancedBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		System.out.println(isBalanced(root));
		System.out.println(isBalancedOptimized(root));
	}

	/**
	 * @param root
	 * @return
	 */
	private static boolean isBalancedOptimized(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	/**
	 * @param root
	 * @return
	 */
	private static int checkHeight(TreeNode root) {
		if (root == null)
			return -1;

		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		int diff = leftHeight - rightHeight;
		if (Math.abs(diff) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	/**
	 * @param root
	 * @return true/false
	 */
	private static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int diff = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(diff) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}

	/**
	 * @param root
	 * @return height
	 */
	private static int getHeight(TreeNode root) {
		if (root == null)
			return -1;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

}