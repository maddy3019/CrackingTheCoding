/**
 * @author Maddy Ver 1.0 Oct 26, 2017 8:41:51 PM
 * Ref: https://www.hackerrank.com/challenges/ctci-find-the-running-median
 */

package crackTheCode.Ch_16_Moderate;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunnigMedian {
	public static double getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
		PriorityQueue<Integer> bigHeap = lower.size() > higher.size() ? lower : higher;
		PriorityQueue<Integer> smallHeap = lower.size() > higher.size() ? higher : lower;
		if (bigHeap.size() == smallHeap.size()) {
			return ((double) bigHeap.peek() + smallHeap.peek()) / 2;
		} else {
			return bigHeap.peek();
		}
	}

	public static void rebalance(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
		PriorityQueue<Integer> bigHeap = lower.size() > higher.size() ? lower : higher;
		PriorityQueue<Integer> smallHeap = lower.size() > higher.size() ? higher : lower;
		if (bigHeap.size() - smallHeap.size() > 1) {
			smallHeap.add(bigHeap.poll());
		}
	}

	public static void addNumber(int number, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
		if (lower.size() == 0 || number < lower.peek()) {
			lower.add(number);
		} else {
			higher.add(number);
		}
	}

	public static double[] runningMedian(int[] a) {
		// min heap
		PriorityQueue<Integer> higher = new PriorityQueue<Integer>();
		// max heap
		// comparator to store max value at the top rather than min value
		PriorityQueue<Integer> lower = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return -1 * a.compareTo(b);
			}
		});
		double[] medians = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			int number = a[i];
			addNumber(number, lower, higher);
			rebalance(lower, higher);
			medians[i] = getMedian(lower, higher);
		}
		return medians;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		double[] medians = runningMedian(a);
		for (double median : medians) {
			System.out.println(median);
		}
	}
}
