/**
 * Class to find all Anagrams in a String.
 * @author Maddy
 * Ver 1.0 09/02/2017
 * {Given nums = [2, 7, 11, 15], target = 9
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].}
 */

package crackTheCode.Ch_16_Moderate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnagrams {
	public static void main(String[] args) {
		System.out.println(isAnagram("Hi, Dad.", "Dah, ID."));
	}

	private static boolean isAnagram(String str1, String str2) {
		str1 = str1.toLowerCase();
		str1.trim();
		str1 = str1.replaceAll("[^a-z0-9]", "");
		str2 = str2.toLowerCase();
		str2.trim();
		str2 = str2.replaceAll("[^a-z0-9]", "");
		if (str1.length() != str2.length()) {
			return false;
		}
		int freq[] = new int[256];
		for (int i = 0; i < str1.length(); i++) {
			freq[str1.charAt(i)]++;
		}

		for (int i = 0; i < str2.length(); i++) {
			if (--freq[str2.charAt(i)] < 0)
				return false;
		}

		return true;
	}
}
