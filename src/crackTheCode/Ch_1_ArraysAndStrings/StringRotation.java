/**
 * @author Maddy
 * Ver 1.0 Oct 2, 2017 10:55:09 AM
 * Assume you have a isSubstirng() method that checks if one word is a substring of another. Given two strings s1, s2
 * write code to check if s2 is a roation of s2 using just one call to isSubstring()
 * Ex:
 * I/P: "waterbottle", "erbottlewat"
 * O/P: true
 */

package crackTheCode.Ch_1_ArraysAndStrings;

public class StringRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle", "erbottlewat"));
	}

	/**
	 * @param s2
	 * @param s1
	 * @return true/false
	 */
	private static boolean isRotation(String s2, String s1) {
		if (s2.length() == s1.length() && s1.length() > 0) {
			String s2New = s2 + s2;
			return isSubString(s1, s2New);
		}
		return false;
	}

	/**
	 * @param s1
	 * @param s2
	 * @return true/false
	 */
	private static boolean isSubString(String s1, String s2) {
		if (s2.contains(s1)) {
			return true;
		}
		return false;
	}
}
