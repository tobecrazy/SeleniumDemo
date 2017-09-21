package main.java.com.dbyl.algorithm.day2;

import org.testng.annotations.Test;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author young
 *
 */
public class Day2 {

	/**
	 * Node List
	 * 
	 * @author young
	 *
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		public void display() {
			System.out.println(val);
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return l2;

	}

	@SuppressWarnings("null")
	@Test
	public void TestAddNumber() {
		ListNode head = null;
		ListNode node = null;
		int values[] = new int[] { 1, 3, 5, 7, 2, 5, 3, 1, 6, 9, 2 };
		for (int value : values) {

			ListNode newNode = new ListNode(value);
			if (head == null) {
				node = newNode;
				head = newNode;

			} else {
				node.next = newNode;
				node = newNode;
			}

		}
		while (head != null) {
			node=head.next;
			head.display();
			head=node;
			
		}

		ListNode l1_head = new ListNode(2);
		ListNode l1_node1 = new ListNode(4);
		ListNode l1_node2 = new ListNode(3);
		l1_head.next = l1_node1;
		l1_node1.next = l1_node2;

		ListNode l2_head = new ListNode(5);
		ListNode l2_node1 = new ListNode(6);
		ListNode l2_node2 = new ListNode(4);
		l2_head.next = l2_node1;
		l2_node1.next = l2_node2;

	}

}
