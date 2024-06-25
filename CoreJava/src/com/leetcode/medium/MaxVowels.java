/**
 * 
 * 1456. Maximum Number of Vowels in a Substring of Given Length

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length
 * 
 */
package com.leetcode.medium;

import java.util.Arrays;

/**
 * 
 */
public class MaxVowels {
	
	public static void setVowel(int x, char[] str, int[] vowels) {
		char c = str[x];
		if(c == 'a' || c == 'e' || c == 'i' || c=='o' || c=='u' ||
				c == 'A' || c == 'E' || c == 'I' || c=='O' || c=='U') {
			vowels[x]=1;
		}else {
			vowels[x]=0;
		}
	}
	
	public static boolean isVowel(int x, char[] str) {
		char c = str[x];
		if(c == 'a' || c == 'e' || c == 'i' || c=='o' || c=='u' ||
				c == 'A' || c == 'E' || c == 'I' || c=='O' || c=='U') {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 
	 * Solution 1 : Consider a window of k characters starting from 0th position.
	 * Maintain an array to store 1 or 0 basis the character is vowel or not.
	 * Count the no.of vowels in k window and calculate the max.
	 * Slide the window in each iteration and repeat.
	 * 
	 * 
	 * Time Limit Exceeded exception, since we traverse the entire the window again instead
	 * of checking the new character at the end of window
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public static int maxVowels(String s, int k) {
		int len = s.length();
		char[] str = s.toCharArray();
		int i=0;
		int j=i+k;
		int[] vowels = new int[len];
		Arrays.fill(vowels, -1);
		int max = 0;
		int count = 0;
		
		while(i<len && j<=len) {
			for (int x = i; x < j; x++) {
				if (vowels[x] == -1) {
					setVowel(x, str, vowels);
				}

				if (vowels[x] == 1) {
					count++;
					max = Math.max(count, max);
				}
			}
			count = 0;
			i++;
			j=i+k;
			
			
		}
		return max;
	}

	/**
	 * Solution 2: First count the max vowels in first k characters i.e initial window
	 * Then slide the window 1 character at a time. With each slide, we will have to recalculate the count
	 * based on the first and last character being vowel or not. In each slide, if the count is greater than the
	 * maximum count, set max
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public static int maxVowels2(String s, int k) {
		int len = s.length();
		char[] str = s.toCharArray();
		
		int[] vowels = new int[len];
		Arrays.fill(vowels, -1);
		int max = 0;
		int count = 0;
		
		//Calculate the count in first k characters - first window
		int x = 0;
		for (x = 0; x < k; x++) {
			if(isVowel(x, str)) {
				count++;
				max = Math.max(count, max);
			}
		}
		
		
		count = max;
		for(int i=0, current =k;i<len && current<len;i++, current++) {
			if(isVowel(i, str)) {
				count--;
			}
			
			if(isVowel(current, str)) {
				count++;
			}
			
			max = Math.max(count, max);		
		}
		
		
		return max;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.err.println(maxVowels("abciiidef", 3));
		System.err.println(maxVowels("aeiou", 2));
		System.err.println(maxVowels("leetcode", 3));
		System.err.println(maxVowels("weallloveyou", 7));
		
		System.err.println(maxVowels2("abciiidef", 3));
		System.err.println(maxVowels2("aeiou", 2));
		System.err.println(maxVowels2("leetcode", 3));
		System.err.println(maxVowels2("weallloveyou", 7));
	}

}
