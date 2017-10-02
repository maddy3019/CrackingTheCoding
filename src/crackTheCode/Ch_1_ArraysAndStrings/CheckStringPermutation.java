/**
 * @author Maddy
 * Ver 1.0 Sep 30, 2017 9:37:57 PM
 * Given two strings, write a method to decide if one is permutation of the other.
 */

package crackTheCode.Ch_1_ArraysAndStrings;

import java.util.Arrays;

public class CheckStringPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(checkPermutation("abdc", "abcd"));
	}

	/**
	 * @param string
	 * @param string2
	 * @return
	 */
	private static boolean checkPermutation(String string, String string2) {
		if (string.length() != string2.length())
			return false;
		return sort(string).equals(sort(string2));
	}

	/**
	 * @param string2
	 * @return
	 */
	private static String sort(String str) {
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

}
