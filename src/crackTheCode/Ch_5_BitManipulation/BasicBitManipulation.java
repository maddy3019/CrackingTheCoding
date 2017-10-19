/**
 * @author Maddy
 * Ver 1.0 Oct 18, 2017 9:13:15 PM
 * Basic bit manipulations
 */

package crackTheCode.Ch_5_BitManipulation;

import java.util.Scanner;

public class BasicBitManipulation {
	private static int number = 44;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = number; // 44
		int i = 5;
		int shift = 1 << i;

		// for ith bit in num to be 1, num & shift should not be 0
		if ((num & shift) != 0) {
			System.out.println(i + "th bit in " + num + " is 1");
		}

		// set the ith bit
		int num1 = 12; // 44
		int i1 = 5;
		int shift1 = 1 << i1;
		System.out.println("Setting " + i1 + "th bit as 1");
		num1 = num1 | shift1;
		System.out.println(num1);

		// count the number of bits in a number
		int num2 = number;
		System.out.println("Counting number of bits in " + num2);
		int numOfBits = 0;
		while (num2 != 0) {
			numOfBits += (num2 & 1);
			num2 >>= 1;
		}
		System.out.println(numOfBits);

		// clear the ith bit
		int num3 = number;
		int i2 = 5;
		int shift2 = 1 << i2;
		System.out.println("Clearing " + i + "th bit in " + num3);
		num3 &= ~shift2;
		System.out.println(num2);
	}
}
