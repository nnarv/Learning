/**
 * Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */
package com.leetcode.medium;

/**
 * 
 */
public class ReverseWords {

	/**
	 * Solution 1: Using trim and split. Then combining array elements by traversing from back to front
	 * utilising StringBuilder
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		String[] arr = s.trim().split("[\s\t]+");

		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (i != arr.length - 1)
				sb.append(" ");
			sb.append(arr[i]);
		}

		return sb.toString();
	}
	
	/**
	 * 
	 * Solution 2: Using trim and split. Using 2 pointers to reverse the elements and then combining using
	 * the join method
	 * @param s
	 * @return
	 */
	public static String reverseWords1(String s) {
		String[] arr = s.trim().split("[\s\t]+");

		int i = arr.length-1;
		int j = 0;
		String temp = null;
		while(i>=j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i--;
			j++;
			
		}
		return String.join(" ", arr);
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// String s = "a good example";
		String s = "  hello world  ";
		System.err.println(reverseWords1(s));

	}

}
