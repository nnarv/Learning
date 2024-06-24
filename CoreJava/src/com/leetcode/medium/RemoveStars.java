/**
 * Removing Stars From a String

You are given a string s, which contains stars *.

In one operation, you can:

Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

Note:

The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.
 

Example 1:

Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
There are no more stars, so we return "lecoe".
Example 2:

Input: s = "erase*****"
Output: ""
Explanation: The entire string is removed, so we return an empty string.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters and stars *.
The operation above can be performed on s.
 */

package com.leetcode.medium;

import java.util.Stack;

/**
 * 
 */
public class RemoveStars {

	/**
	 * Solution 1: Using inbuilt data structures - Stack
	 * 
	 * @param s
	 * @return
	 */
	public static String removeStars(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		Stack stack = new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == '*' && !stack.isEmpty()) {
				stack.pop();
			}else {
				stack.add(s.charAt(i));
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
			
		}
		
	
		return sb.reverse().toString();

	}
	
	/**
	 * Solution 2 : Using 2 pointer approach
	 * 
	 * Convert the input string to a character array for easier manipulation.
	
		Use two pointers:
		j: This will keep track of the position in the array where the next valid character should be placed.
		i: This will iterate through the array to examine each character.
		Iterate through the array with pointer i:
		If the current character is a star (*), decrement j to effectively "remove" the last valid character.
		If the current character is not a star, place it at the position indicated by j and increment j.
		After the loop, the first j characters in the array represent the final string without stars and the characters preceding them.
		
		Convert the relevant portion of the character array back to a string and return it.
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public static String removeStars2(String s) {
		int i=0,j=0;
		int len = s.length();
		if(len==0 || (len==1 && s.charAt(0)=='*')) {
			return null;
		}
		
		char[] input = s.toCharArray();
		while(i<len && j<len) {
			if(input[i] == '*' && j>=0) {
				input[--j]=input[i++];
			}else {
				input[j++]=input[i++];
			}
		}
		
		// Multiple ways to get the resultant string
		
		// 1. Use copyValueOf method of String class - String.copyValueOf(char[] data, int offset, int count)
		String res = String.copyValueOf(input, 0, j);
		
		// 2. Create new String -  public String(char value[], int offset, int count) 
		//res = new String(input,0,j);
		
		// 3. Use StringBuilder to copy characters
		/*
		StringBuilder sb = new StringBuilder();
		for(int k=0;k<j;k++) {
			sb.append(input[k]);
		}
		res = sb.toString();
		*/
		
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "leet**cod*e";
		System.err.println(RemoveStars.removeStars2(input));
		
	
		

	}

}
