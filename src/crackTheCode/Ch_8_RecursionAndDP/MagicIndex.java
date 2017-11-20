/**
 * @author Maddy
 * Ver 1.0 Oct 24, 2017 10:04:55 PM
 * A magic index in an array A[ 1 .•. n-1] is defined to be an index such that A[i] = i
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
 * array A.
 * Ex:
 * I/P: [1, 2, 3, 4, 5, 6, 6]
 * O/P: 6
 */

package crackTheCode.Ch_8_RecursionAndDP;

public class MagicIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { -1, 0, 1, 2, 3, 4, 6 };
		System.out.println("Magic Index for array with distinct elements: " + findMagicIndex(array, false));
		int[] array1 = { -1, 0, 1, 2, 3, 5, 5 };
		System.out.println("Magic Index for array without distinct elements: " + findMagicIndex(array1, false));
	}

	/**
	 * @param array
	 * @return
	 */
	private static int findMagicIndex(int[] array, boolean isArrayDistinct) {
		if (isArrayDistinct) {
			return binaryMagicDistinct(array, 0, array.length - 1);
		} else {
			return binaryMagicNonDistinct(array, 0, array.length - 1);
		}
	}

	/**
	 * @param array
	 * @param i
	 * @param j
	 * @return
	 */
	private static int binaryMagicNonDistinct(int[] array, int start, int end) {
		if (start > end) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midIndex == midValue) {
			return midIndex;
		}

		/* search left */
		int leftIndex = Math.min(midIndex - 1, midValue);
		int leftMagic = binaryMagicNonDistinct(array, start, leftIndex);
		if (leftMagic >= 0) {
			return leftMagic;
		}

		/* search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int rightMagic = binaryMagicDistinct(array, rightIndex, end);
		if (rightMagic >= 0) {
			return rightMagic;
		}
		return -1;
	}

	/**
	 * @param array
	 * @param i
	 * @param j
	 * @return
	 */
	private static int binaryMagicDistinct(int[] array, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] < mid) {
			return binaryMagicDistinct(array, mid + 1, end);
		} else {
			return binaryMagicDistinct(array, start, mid - 1);
		}
	}
}
