/**
 * @author Maddy
 * Ver 1.0 Oct 1, 2017 7:07:35 PM
 * String compression using counts of repeated characters.
 * Ex:
 * I/P: "aabbccdd"
 * O/P: "a2b2c2d2"
 */

package crackTheCode.Ch_1_ArraysAndStrings;

public class StringCompression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(compressString("aabbbbbbbbbbcccddd"));
	}

	/**
	 * @param string
	 * @return
	 */
	private static String compressString(String str) {
		StringBuilder compressed = new StringBuilder(str);
		int len = compressed.length();
		Character t = null;
		int count = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (t == null || compressed.charAt(i) == t) {
				t = compressed.charAt(i);
				count++;
			} else {
				compressed.replace(i + 1, i + count + 1, String.valueOf(t) + String.valueOf(count));
				t = compressed.charAt(i);
				count = 1;
			}
			if (i == 0) {
				compressed.replace(i, i + count, String.valueOf(t) + String.valueOf(count));
			}
		}
		return compressed.toString();
	}

	/**
	 * @param compressed
	 * @param charAt
	 * @return
	 */
	// private static boolean containsCharacter(String compressed, char charAt) {
	// for (int i = 0; i < compressed.length(); i++) {
	// if (charAt == compressed.charAt(i)) {
	// return true;
	// }
	// }
	// return false;
	// }
}
