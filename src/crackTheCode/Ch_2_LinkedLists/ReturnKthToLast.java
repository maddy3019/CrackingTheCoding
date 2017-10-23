/**
 * @author Maddy
 * Ver 1.0 Oct 18, 2017 9:43:27 PM
 * 
 */

package crackTheCode.Ch_2_LinkedLists;

import java.util.ArrayList;

public class ReturnKthToLast {
	private Node head;
	private Node current;

	/**
	 * constructor for linked list
	 */
	public ReturnKthToLast() {
		head = null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReturnKthToLast list = new ReturnKthToLast();
		list.insert(1);
		list.insert(4);
		list.insert(3);
		list.insert(6);
		list.insert(2);
		list.insert(7);
		int k = 3;
		ArrayList<Integer> result = list.returnKthToLast(k);
		for (Integer val : result) {
			System.out.println(val);
		}
	}

	/**
	 * @param k
	 * @return
	 */
	private ArrayList<Integer> returnKthToLast(int k) {
		Node n = head;
		int count = 1;
		while (n != null && count != k) {
			n = n.next;
			count++;
		}
		if (n == null) {
			return null;
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		while (n != null) {
			res.add(n.value);
			n = n.next;
		}
		return res;
	}

	/**
	 * @param i
	 */
	private void insert(int i) {
		Node newNode = new Node(i);
		if (head == null) {
			head = newNode;
			head.next = null;
			current = head;
		} else {
			current.next = newNode;
			current = newNode;
		}
	}

}