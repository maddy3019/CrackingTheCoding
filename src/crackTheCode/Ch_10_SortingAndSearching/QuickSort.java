/**
 * @author Maddy
 * Ver 1.0 Oct 21, 2017 11:36:20 PM
 * Implement Quick Sort algorithm using generics.
 */

package crackTheCode.Ch_10_SortingAndSearching;

public class QuickSort<T> {

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
		quickSort(array);
		for (Integer elem : array) {
			System.out.println(elem);
		}
	}

	/**
	 * @param array
	 */
	private static <T extends Comparable<T>> void quickSort(T[] array) {
		quickSort(array, 0, array.length - 1);
	}

	/**
	 * @param array
	 * @param i
	 * @param j
	 */
	private static <T extends Comparable<T>> void quickSort(T[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		T pivot = array[(left + right) / 2];
		int index = partition(array, left, right, pivot);
		quickSort(array, left, index - 1);
		quickSort(array, index, right);
	}

	/**
	 * @param array
	 * @param left
	 * @param right
	 * @param pivot
	 * @return
	 */
	private static <T extends Comparable<T>> int partition(T[] array, int left, int right, T pivot) {
		while (left <= right) {
			while (array[left].compareTo(pivot) < 0) {
				left++;
			}
			while (array[right].compareTo(pivot) > 0) {
				right--;
			}
			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	/**
	 * @param array
	 * @param left
	 * @param right
	 */
	private static <T> void swap(T[] array, int left, int right) {
		T temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
