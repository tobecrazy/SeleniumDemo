package com.dbyl.tests.algorithm.day2;

import java.util.ArrayList;

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
			this.val = x;
		}

		public void display() {
			System.out.println(val);
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return l2;

	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		
		return null;
	}

	@Test
	public void TestAddNumber() {
		for(int i=0;i<1;i++)
		{
			ListNode n=new ListNode(i);
			n.next=new ListNode(i+1);
		}

	}

}
