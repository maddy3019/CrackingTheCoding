/**
 * @author Maddy
 * Ver 1.0 Oct 2, 2017 10:11:07 PM
 * Write a method to find frequency of occurrences of any given word in a book. 
 */

package crackTheCode.Ch_2_LinkedLists;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordFrequencies {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String contents = new Scanner(new File(sc.next())).useDelimiter("\\Z").next();
		String word = sc.next();
		countWordFrequency(contents, word);
	}

	/**
	 * @param f
	 * @param word
	 * @return frequency
	 */
	private static int countWordFrequency(String text, String word) {
		String[] words = text.split("[\n\t]");
		int count = 0;
		for (String each : words) {
			if (each.equals(word)) {
				count++;
			}
		}
		return count;
	}
}
