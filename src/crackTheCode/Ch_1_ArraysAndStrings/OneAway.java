/**
 * @author Maddy
 * Ver 1.0 Oct 1, 2017 3:01:22 PM
 * Check if two strings are one or zero edits(insert, delete, update) away.
 * Ex:
 * I/P: "pale", "ple"
 * O/P: true
 * I/P: "pales", "pale"
 * O/P: true
 * I/P: "pale", "bale"
 * O/P: true
 * I/P: "pale", "bake"
 * O/P: false
 */

package crackTheCode.Ch_1_ArraysAndStrings;

public class OneAway {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "pale";
		String s2 = "plle";
		if (s1.equals(s2)) {
			System.out.println(true);
		} else {
			if (s1.length() - s2.length() > 1) {
				System.out.println(false);
			} else {
				if (s1.length() == s2.length()) {
					System.out.println(oneEditReplace(s1, s2));
				} else if (s1.length() + 1 == s2.length()) {
					System.out.println(oneEditInsert(s1, s2));
				} else if (s1.length() - 1 == s2.length()) {
					System.out.println(oneEditInsert(s2, s1));
				}
			}
		}
	}

	/**
	 * @param s1
	 * @param s2
	 * @return boolean
	 */
	private static boolean oneEditInsert(String destination, String source) {

		int destIndex = 0;
		int srcIndex = 0;

		while (destIndex < destination.length() && srcIndex < source.length()) {
			if (destination.charAt(destIndex) != source.charAt(srcIndex)) {
				if (destIndex != srcIndex) {
					return false;
				}
				srcIndex++;
			} else {
				destIndex++;
				srcIndex++;
			}
		}
		return true;
	}

	/**
	 * @param s1
	 * @param s2
	 * @return boolean
	 */
	private static boolean oneEditReplace(String str1, String str2) {
		int edits = 0;
		for (int i = 0; i < str2.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				edits++;
				if (edits > 1) {
					return false;
				}
			}
		}
		return true;
	}
}
