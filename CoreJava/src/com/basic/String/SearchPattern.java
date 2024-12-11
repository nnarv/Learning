/**
 * Search Pattern (KMP-Algorithm)
 * 
 * Given two strings, one is a text string txt and the other is a pattern string pat. The task is to print the indexes of all the occurrences of the pattern string in the text string. Use 0-based indexing while returning the indices. 
Note: Return an empty list in case of no occurrences of pattern.

Examples :

Input: txt = "abcab", pat = "ab"
Output: [0, 3]
Explanation: The string "ab" occurs twice in txt, one starts at index 0 and the other at index 3. 
Input: txt = "abesdu", pat = "edu"
Output: []
Explanation: There's no substring "edu" present in txt.
Input: txt = "aabaacaadaabaaba", pat = "aaba"
Output: [0, 9, 12]
 * 
 * 
 * 
 */
package com.basic.String;

import java.util.ArrayList;

/**
 * 
 */
public class SearchPattern {

	/**
	 * The idea is, we start at every index in the text and compare it with the first character of the pattern, 
	 * if they match we move to the next character in both text and pattern.
	 *  If there is a mismatch, we start the same process for the next index of the text.
	 * 
	 * 
	 * Naive approach Time Complexity = O (m*n) [m = Text length, n = Pattern
	 * length]
	 * 
	 * @param pat
	 * @param txt
	 * @return
	 */
	static ArrayList<Integer> search(String pat, String txt) {
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < txt.length(); i++) {

			if (txt.charAt(i) == pat.charAt(0)) {
				int k = i, j = 0;
				while (k < txt.length() && j < pat.length()) {
					if (txt.charAt(k) == pat.charAt(j)) {
						k++;
						j++;
					} else {
						break;
					}
					if (j == pat.length()) {
						result.add(i);
					}
				}
			}
		}

		return result;
	}
	
	
	/**
	 * The Knuth-Morris-Pratt (KMP) algorithm is a string searching (or substring searching) algorithm used to find occurrences of a "pattern" string within a "text" string efficiently. It was developed by Donald Knuth, Vaughan Pratt, and James H. Morris. 
	 * The KMP algorithm improves on the naive approach of string matching by eliminating redundant comparisons.
	 * 
	 * Steps of the KMP Algorithm:
	 * 1. Preprocessing (Prefix Function or LPS array): 
	 * KMP first builds a Longest Prefix Suffix (LPS) array (or prefix function). 
	 * LPS is the Longest Proper Prefix which is also a Suffix. A proper prefix is a prefix that doesn't include whole string. 
	 * For example, prefixes of "abc" are "", "a", "ab" and "abc" but proper prefixes are "", "a" and "ab" only. Suffixes of the string are "", "c", "bc", and "abc".
	   Each value, lps[i] is the length of longest proper prefix of pat[0..i] which is also a suffix of pat[0..i].
	 * This array helps determine how much we can skip when a mismatch occurs.
	 * 
	 * 2. Pattern Matching: 
	 * After preprocessing, the algorithm compares the text with the pattern character by character. 
	 * When a mismatch occurs, it uses the LPS array to shift the pattern efficiently instead of moving it one character at a time.
	 * 
	 
	
	Time Complexity:
		Preprocessing: Building the LPS array takes O(m) time, where m is the length of the pattern.
		Searching: Matching the pattern with the text takes O(n) time, where n is the length of the text.
		Therefore, the overall time complexity of the KMP algorithm is O(n + m).
		
	Space Complexity:
		The space complexity is O(m) due to the LPS array used for preprocessing the pattern.
	*/
	
	/**
	 * Preprocessing: LPS Array Construction
	The LPS array is built by examining the pattern. It has the following properties:
	
	LPS[0] = 0 because there's no proper prefix for a single character.
	For every subsequent position i, if a match is found, the length of the proper prefix-suffix is increased.
	Example: Constructing the LPS array for the pattern "ABABAC"
	For "A", no prefix matches, so LPS[0] = 0.
	For "AB", no prefix matches, so LPS[1] = 0.
	For "ABA", the prefix "A" matches the suffix "A", so LPS[2] = 1.
	For "ABAB", the prefix "AB" matches the suffix "AB", so LPS[3] = 2.
	For "ABABA", the prefix "ABA" matches the suffix "ABA", so LPS[4] = 3.
	For "ABABAC", no prefix matches the suffix, so LPS[5] = 0.
	Thus, the LPS array for the pattern "ABABAC" is: [0, 0, 1, 2, 3, 0].

	 * @param pat
	 * @return
	 */
	static int[] createLps(String pat){
        int len = pat.length();
        int[] lps = new int[len]; //Sets the default value to 0
        
        char[] pattern = pat.toCharArray();
        int i=1, j=0;
        while(i<len){
            if(pattern[i]==pattern[j]){
                lps[i]=j+1;
                i++;
                j++;
            }else{
                if(j!=0){
                    j=lps[j-1]; // Use the previously computed LPS value
                }else{
                    i++;
                }
            }
        }
        return lps;
    }

	/**
	 * Pattern Matching Step 
	 * We compare the pattern with the text starting from the first character. 
	 * If a character matches, we move to the next character in the pattern and the text. 
	 * If there's a mismatch: Instead of shifting the pattern by just one character, 
	 * we use the LPS array to skip ahead by an amount determined by the longest prefix suffix.
	 * 
	 * 
	 * 
	 * @param pat
	 * @param txt
	 * @return
	 */
	
	// Function to search the pattern in the text using KMP algorithm
	static ArrayList<Integer> searchKmp(String pat, String txt) {
		ArrayList<Integer> result = new ArrayList<>();

		int len = txt.length();
		char[] pattern = pat.toCharArray();
		char[] text = txt.toCharArray();
		
		// Step 1: Build the LPS array
		int[] lps = createLps(pat);
		
		int i=0; // index for text
		int j=0; // index for pattern
		
		// Step 2: Iterate through the text and search for the pattern
		while(i<len){
		    if(text[i] == pattern[j]){
		        i++;
		        j++;
		        
		        // If the entire pattern is matched
		        if(j==pat.length()){
		            result.add(i-j);
		            j = lps[j-1];
		        }
		    }else{ // Mismatch after j matches
		        if(j!=0){
		            j=lps[j-1]; // Skip using the LPS array
		        }else{
		            i++;
		        }
		    }
		}

		return result; // Return the list of starting indices of pattern matches
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// String txt = "abcab", pat = "ab";
		// String txt = "abesdu", pat = "edu";
		//String txt = "aabaacaadaabaaba", pat = "aabac";
		String txt = "abababac", pat = "aba";
		ArrayList<Integer> result = searchKmp(pat, txt);
		result.stream().forEach(x -> System.out.println(x));

	}

}
