/**
 * 
 * Given two strings s1 and s2 consisting of lowercase characters. 
 * The task is to check whether two given strings are an anagram of each other or not. 
 * An anagram of a string is another string that contains the same characters, only the order of characters can be different. 
 * For example, act and tac are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.

Note: You can assume both the strings s1 & s2 are non-empty.

Examples :

Input: s1 = "geeks", s2 = "kseeg"
Output: true
Explanation: Both the string have same characters with same frequency. So, they are anagrams.
Input: s1 = "allergy", s2 = "allergic"
Output: false
Explanation: Characters in both the strings are not same, so they are not anagrams.
Input: s1 = "g", s2 = "g"
Output: true
Explanation: Character in both the strings are same, so they are anagrams.
Constraints:
1 ≤ s1.size(), s2.size() ≤ 105
 */
package com.basic.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 */
public class Anagram {

	// Function is to check whether two strings are anagram of each other or not.
	/**
	 * 
	 * [Naive Approach] Using Sorting The idea is that if the strings are anagrams,
	 * then their characters will be the same, just rearranged. Therefore, if we
	 * sort the characters in both strings, the sorted strings will be identical if
	 * the original strings were anagrams. We can simply sort the two given strings
	 * and compare them – if they are equal, then the original strings are anagrams
	 * of each other
	 * 
	 * 
	 * 
	 * Time Complexity: O(m*log(m) + n*log(n)), where m and n are length of string
	 * s1 and s2 respectively. Auxiliary Space: O(1) where the strings are mutable
	 * but O(n) in languages like Java, Python, C#, etc. where strings are
	 * immutable.
	 * 
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */

	public static boolean areAnagrams(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		// Your code here

		char[] first = s1.toCharArray();
		Arrays.sort(first);
		String sorted1 = new String(first);

		char[] second = s2.toCharArray();
		Arrays.sort(second);
		String sorted2 = new String(second);

		if (!sorted1.equalsIgnoreCase(sorted2)) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 * The idea is to use a hash map or dictionary count the frequency of each
	 * character in both the input strings. If the frequency of every character
	 * matches in both strings, then the strings are anagrams.
	 * 
	 * First, count the occurrences of each character in first string. Then,
	 * decrement the count for each character in the second string. If the strings
	 * are anagrams, all positions in the frequency array should be zero as any
	 * non-zero position means that the frequency of that character is not same in
	 * both strings.
	 * 
	 * Time Complexity: O(m + n), where m and n are length of string s1 and s2
	 * respectively. Auxiliary Space: O(26) = O(1). The input strings can only have
	 * lowercase letters, so there can be at most 26 distinct characters in the hash
	 * map.
	 * 
	 * 
	 * 
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean areAnagramsFrequency(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		Map<Character, Integer> freq = new HashMap<>();
		char[] first = s1.toCharArray();

		// Create the frequency map for characters of first string
		for (char c : first) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}

		char[] second = s2.toCharArray();

		// Subtract the frequency of characters of second string
		for (char c : second) {
			freq.put(c, freq.getOrDefault(c, 0) - 1);
		}

		// Check the map.If the frequency is 0 for all characters, then the strings are
		// anagrams

		for (Entry<Character, Integer> e : freq.entrySet()) {
			if (e.getValue() != Integer.valueOf(0)) {
				return false;
			}

		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 = "geeks", s2 = "kseeg";
		// String s1 = "allergy", s2 = "allergic";
		System.err.println(areAnagramsFrequency(s1, s2));

	}

}
