/**
 * @author Maddy
 * Ver 1.0 Oct 2, 2017 6:50:06 PM
 * Remove duplicates from an unsorted linked list.
 */

package crackTheCode.Ch_2_LinkedLists;

public class RemoveDuplicates {

	private Node head;
	private Node current;

	/**
	 * constructor for linked list
	 */
	private RemoveDuplicates() {
		head = null;
	}

	/**
	 * insert head of the linked list
	 */
	private void insertHead(int val) {
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
		current = head;
	}

	/**
	 * insert a node at the end of the linked list
	 */
	private void insertAtTheTail(int val) {
		Node end = new Node(val);
		current.next = end;
		current = end;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RemoveDuplicates linkedList = new RemoveDuplicates();
		linkedList.insertHead(1);
		linkedList.insertAtTheTail(2);
		linkedList.insertAtTheTail(3);
		linkedList.insertAtTheTail(1);
		linkedList.insertAtTheTail(3);
		removeDuplicates(linkedList.head);
		displayList(linkedList.head);
	}

	/**
	 * @param linkedList
	 */
	private static void removeDuplicates(Node listHead) {
		Node current = listHead;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.getValue() == current.getValue()) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	/**
	 * @param linkedList
	 */
	private static void displayList(Node listHead) {
		Node current = listHead;
		while (current != null) {
			System.out.println(current.getValue());
			current = current.next;
		}
	}

}

class Node {
	public Node next;
	public int value;

	public Node(int val) {
		value = val;
	}

	public int getValue() {
		return value;
	}
}
