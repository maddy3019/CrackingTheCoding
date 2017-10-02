/**
 * @author Maddy
 * Ver 1.0 Sep 30, 2017 11:09:47 PM
 * URLify: Replace spaces in the string with "%20". Given length is the original length of the string.
 * String contains sufficient spaces at the end to hold additional characters.
 * Ex:
 * I/P: "Mr John Smith    ", 13
 * O/P: "Mr%20John%20Smith" 
 */

package crackTheCode.Ch_1_ArraysAndStrings;

public class ReplaceStringSpaces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(replaceSpaces("Mr John Smith    ", 13));
	}

	/**
	 * @param len
	 * @param string
	 */
	private static String replaceSpaces(String str, int len) {
		char[] strArr = str.toCharArray();
		int spaceCount = countSpaces(strArr, len);
		int newLength = len + spaceCount * 2;
		strArr[newLength-1] = '\0';
		for (int i = len - 1; i >= 0; i--) {
			if (strArr[i] == ' ') {
				strArr[newLength - 1] = '0';
				strArr[newLength - 2] = '2';
				strArr[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				strArr[newLength - 1] = strArr[i];
				newLength = newLength - 1;
			}
		}
		return new String(strArr);
	}

	/**
	 * @param str
	 * @return
	 */
	private static int countSpaces(char[] str, int len) {
		int spaceCount = 0;
		for (int i = 0; i < len; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		return spaceCount;
	}
}
