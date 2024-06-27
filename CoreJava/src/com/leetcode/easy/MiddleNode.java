/**
 *  Middle of the Linked List

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100
 * 
 */
package com.leetcode.easy;

/**
 * 
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class MiddleNode {
	
	public static ListNode createList(int[] arr) {
		ListNode head = null;
		ListNode current = null;
		for(int i=0;i<arr.length;i++) {
			ListNode newNode = new ListNode(arr[i]);
			if(head == null) {
				head = newNode;
				current = head;
				
			}else {
				current.next = newNode;
				current = current.next;
			}
		}
		return head;
	}

	public static void display(ListNode head) {
		ListNode current = head;
		while(current!=null) {
			System.err.print(current.val + " ");
			current = current.next;
		}
		System.err.println();
		
	}

	//Find mid of list using the tortoise and hare solution (slow/fast pointer - slow pointer hops 1 node while fast hops 2 nodes.
	//By the time fast reaches the end of list, slow pointer has reached MID way.
			
	public static ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	//	int[] arr = {47,22,81,46,94,95,90,22,55,91,6,83,49,65,10,32,41,26,83,99,14,85,42,99,89,69,30,92,32,74,9,81,5,9};
		int[] arr = {47,22,81,46,94};
		
		ListNode head = createList(arr);
		display(head);
		ListNode mid = middleNode(head);
		System.err.println(mid.val);

	}

}
