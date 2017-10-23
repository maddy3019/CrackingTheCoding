/**
 * @author Maddy
 * Ver 1.0 Oct 22, 2017 12:25:31 AM
 * Implement Merge Sort algorithm using generics.
 */

package crackTheCode.Ch_10_SortingAndSearching;

public class MergeSort<T> {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] array = new Integer[] { 9, 4, 5, 2, 6, 8, 1, 7, 3 };
		// Code to test algorithm on large array of random integers.
		// Random dice = new Random();
		// Integer[] array = new Integer[1000 * 1000];
		// for (int i = 0; i < array.length; i++) {
		// array[i] = dice.nextInt(100);
		// }
		mergeSort(array, 0, array.length - 1, new Integer[array.length]);
		for (Integer elem : array) {
			System.out.println(elem);
		}
	}

	/**
	 * @param array
	 * @param leftStart
	 * @param rightEnd
	 * @param tmep
	 */
	static <T extends Comparable<T>> void mergeSort(T[] array, int leftStart, int rightEnd, T[] temp) {
		if (leftStart >= rightEnd) {
			return;
		}
		int middle = (leftStart + rightEnd) / 2;

		// divide
		mergeSort(array, leftStart, middle, temp);
		mergeSort(array, middle + 1, rightEnd, temp);

		// conquer
		merge(array, leftStart, rightEnd, temp);

	}

	/**
	 * @param array
	 * @param leftStart
	 * @param rightEnd
	 * @param temp
	 */
	private static <T extends Comparable<T>> void merge(T[] array, int leftStart, int rightEnd, T[] temp) {
		// numbers to sort
		int numbersToSort = rightEnd - leftStart + 1;

		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;

		// try using the improved algo in the class photo: 09/15/2017
		int left = leftStart;
		int right = rightStart;
		int index = left;
		while (left <= leftEnd && right <= rightEnd) {
			if (array[left].compareTo(array[right]) < 0) {
				temp[index] = array[left];
				left++;
			} else {
				temp[index] = array[right];
				right++;
			}
			index++;
		}
		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, array, leftStart, numbersToSort);
	}
}
