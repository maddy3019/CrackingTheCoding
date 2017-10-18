/**
 * @author Maddy
 * Ver 1.0 Oct 2, 2017 10:03:43 PM
 * Swap two numbers without using a temporary variable. 
 */

package crackTheCode.Ch_16_Moderate;

public class SwapNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n1 = 3;
		int n2 = 4;
		System.out.println("Before swap:");
		System.out.println(String.valueOf(n1) + "," + String.valueOf(n2));
		swap(n1, n2);
	}

	/**
	 * @param n1
	 * @param n2
	 */
	private static void swap(int n1, int n2) {
		n1 = n1 + n2;
		n2 = n1 - n2;
		n1 = n1 - n2;
		System.out.println("After swap:");
		System.out.println(String.valueOf(n1) + "," + String.valueOf(n2));
	}
}
