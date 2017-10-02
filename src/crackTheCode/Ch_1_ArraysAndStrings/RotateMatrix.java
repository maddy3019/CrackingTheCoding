/**
 * @author Maddy
 * Ver 1.0 Sep 30, 2017 5:41:23 PM
 * Rotate a matrix by 90 degrees in clockwise direction
 * Ex:
 * I/P: 1 2 3 4 5
 * 		6 7 8 9 10
 * 		11 12 13 14 15
 * 		16 17 18 19 20
 * 		21 22 23 24 25
 * O/P: 21 16 11 6 1
 * 		22 17 12 7 2
 * 		23 18 13 8 3
 * 		24 19 14 9 4
 * 		25 20 15 10 5
 */

package crackTheCode.Ch_1_ArraysAndStrings;

import java.util.Iterator;
import java.util.Scanner;

public class RotateMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] matrix = new int[5][5];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		printMatrix(matrix);
		rotateMatrix(matrix, matrix.length - 1);
		printMatrix(matrix);
	}

	/**
	 * @param matrix
	 */
	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * @param matrix
	 */
	private static void rotateMatrix(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;	//
			int last = n - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;

				// save top
				int top = matrix[first][i];

				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top;
			}
		}
	}
}
