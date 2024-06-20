/**
 * Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */
package com.leetcode.easy;

/**
 * 
 */
public class ReverseVowels {
	
	static boolean isVowel(char c) {
		if(c == 'a' || c== 'e' || c == 'i' || c == 'o' || c == 'u' ||
				c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
			return true;
		}
		return false;
	}
	
	public static String reverseVowels(String s) {
		int len = s.length();
		int i=0, j=len-1;
		
		char[] charString = s.toCharArray();
		
		char c ;
		
		//Start with 2 pointers one at each end
		while (i <= j) {
			//Find vowel from left side
			if (isVowel(charString[i])) {
				//If found, find vowel from right side
				if (isVowel(charString[j])) {
					
					//Swap the vowels
					c = charString[i];
					charString[i] = charString[j];
					charString[j] = c;
					
					//Increment left pointer, Decrement right pointer
					i++;
					j--;
				} else {
					j--;
				}

			} else {
				i++;
			}
		}
		
		return String.valueOf(charString);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.err.println(ReverseVowels.reverseVowels("hello"));
		System.err.println(ReverseVowels.reverseVowels("leetcode"));
		System.err.println(ReverseVowels.reverseVowels("aA"));
		
	}

}
