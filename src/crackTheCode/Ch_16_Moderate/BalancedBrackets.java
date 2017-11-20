/**
 * @author Maddy
 * Ver 1.0 Oct 26, 2017 9:33:05 AM
 * Ref: https://www.hackerrank.com/challenges/ctci-balanced-brackets?h_r=next-challenge&h_v=zen
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 * Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs
 * to the left of a closing bracket (i.e., ), ], or }) of the exact same type.
 * There are three types of matched pairs of brackets: [], {}, and ().
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched.
 * For example, {[(])} is not balanced because the contents in between { and } are not balanced.
 * The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses
 * encloses a single, unbalanced closing square bracket, ].
 * I/P:	3
	  	{[()]}
	 	{[(])}
	 	{{[[(())]]}}
 * O/P:	YES
		NO
		YES
 */

package crackTheCode.Ch_16_Moderate;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
	public static char[][] TOKENS = { { '{', '}' }, { '(', ')' }, { '[', ']' } };

	private static boolean isOpenTerm(char c) {
		return (c == TOKENS[0][0]) || (c == TOKENS[1][0]) || (c == TOKENS[2][0]);
	}

	private static boolean matches(char open, char closed) {
		if (open == TOKENS[0][0]) {
			return closed == TOKENS[0][1];
		} else if (open == TOKENS[1][0]) {
			return closed == TOKENS[1][1];
		} else if (open == TOKENS[2][0]) {
			return closed == TOKENS[2][1];
		}
		return true;
	}

	public static boolean isBalanced(String expression) {
		if (expression.length() % 2 != 0) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (char c : expression.toCharArray()) {
			if (isOpenTerm(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty() || !matches(stack.pop(), c)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}
	}
}
