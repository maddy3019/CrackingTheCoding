/**
 * @author Maddy
 * Ver 1.0 Oct 14, 2017 4:09:34 PM
 * 
 */

package crackTheCode.Ch_1_ArraysAndStrings;

import java.util.HashMap;

public class LonelyInteger {

	private static HashMap<Integer, Integer> integerCount = new HashMap<Integer, Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("------Lonely Integer------");

		// array of integers
		int[] array = new int[] { 2, 3, 4, 5, 6, 2, 3, 4, 5, 6, 7, 7, 9 };

		// METHOD 1: HashMap
		// Time = O(n); Space = O(n)
		buildIntegerCount(array);
		// print lonely integer
		for (Integer key : integerCount.keySet()) {
			if (integerCount.get(key) == 1) {
				System.out.println(key);
				break;
			}
		}

		// METHOD 2: XOR
		// Time = O(n); Space = O(1)
		System.out.println(lonelyIntegerXor(array));
	}

	/**
	 * @param array
	 * @return
	 */
	private static int lonelyIntegerXor(int[] array) {
		int lonely = 0;
		for (int i : array) {
			lonely ^= i;
		}
		return lonely;
	}

	/**
	 * @param array
	 */
	private static void buildIntegerCount(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (!integerCount.containsKey(array[i])) {
				integerCount.put(array[i], 1);
			} else {
				int currentCount = integerCount.get(array[i]);
				integerCount.put(array[i], ++currentCount);
			}
		}

	}

}
