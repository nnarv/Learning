/**
 * Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 * 
 */
package com.leetcode.easy;


/**
 * 
 */

/**
 * Definition for singly-linked list.
 */

class ListNode1 {
	int val;
	ListNode1 next;

	ListNode1() {
	}

	ListNode1(int val) {
		this.val = val;
	}

	ListNode1(int val, ListNode1 next) {
		this.val = val;
		this.next = next;
	}
}


public class ReverseList {
	
	
	public static ListNode1 createList(int[] arr) {
		ListNode1 head = null;
		ListNode1 current = null;
		for(int i=0;i<arr.length;i++) {
			ListNode1 newNode = new ListNode1(arr[i]);
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

	public static void display(ListNode1 head) {
		ListNode1 current = head;
		while(current!=null) {
			System.err.print(current.val + " ");
			current = current.next;
		}
		System.err.println();
		
	}

	/**
	 * Solution 1 - Create a new list by traversing input list and adding new
	 * nodes to start of new list
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode1 reverseList(ListNode1 head) {
		if(head == null)
			return head;
	
		ListNode1 current = head;
		ListNode1 p1 = null;
		ListNode1 p2 = null;
		
		while(current!=null) {
			p2 = current.next;
			current.next = p1;
			p1 = current;
			current = p2;
		}
			
		return p1;
	}
	
	/**
	 * Solution 2 - The idea is to reach the last node of the linked list using recursion 
	 * then start reversing the linked list.
	 * 
	 * Takes extra stack space
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode1 reverseListRecursive(ListNode1 head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		
		//Reach the end and return
		ListNode1 reverseHead = reverseListRecursive(head.next);
		
		//Update the previous node
		head.next.next = head;
		head.next = null;
		
		return reverseHead;
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = {47,22,81,46,94};
		
		ListNode1 head = createList(arr);
		display(head);
		
		ListNode1 reverseHead = reverseListRecursive(head);
		display(reverseHead);

	}

}
