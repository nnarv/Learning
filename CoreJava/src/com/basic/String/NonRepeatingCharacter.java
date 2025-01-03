/**
 * Given a string s consisting of lowercase Latin Letters. Return the first non-repeating character in s. If there is no non-repeating character, return '$'.
Note: When you return '$' driver code will output -1.

Examples:

Input: s = "geeksforgeeks"
Output: 'f'
Explanation: In the given string, 'f' is the first character in the string which does not repeat.
Input: s = "racecar"
Output: 'e'
Explanation: In the given string, 'e' is the only character in the string which does not repeat.
Input: s = "aabbccc"
Output: -1
Explanation: All the characters in the given string are repeating.
Constraints:
1 <= s.size() <= 105
 * 
 * 
 * 
 */
package com.basic.String;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 */
public class NonRepeatingCharacter {

	// Function to find the first non-repeating character in a string.
	static char nonRepeatingChar(String s) {
		Character result = '$';

		Map<Character, Integer> freq = new LinkedHashMap<>();
		for (char c : s.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}

		//Use Key Set
		
		for (Character e : freq.keySet()) {
			if (freq.get(e) == Integer.valueOf(1)) {
				result = e;
				break;
			}

		}
		
		// OR Entry Set
		/*
		for (Entry<Character, Integer> e : freq.entrySet()) {
			if (e.getValue() == Integer.valueOf(1)) {
				result = e.getKey();
				break;
			}

		}*/

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.err.println(nonRepeatingChar("geeksforgeeks"));
		System.err.println(nonRepeatingChar("yy"));
	}

}
