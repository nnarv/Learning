/**
 * 
 * Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

 

Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
Example 2:

Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.
Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 

Constraints:

1 <= chars.length <= 2000
chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
 */
package com.leetcode.medium;

/**
 * 
 */
public class StringCompression {

	/**
	 * Solution 1 : Creating a separate resultant array
	 * 
	 * @param chars
	 * @return
	 */
	 public static int compress(char[] chars) {

		 int inputLength = chars.length;
		 
		 if(inputLength == 0 || inputLength == 1)
			 return inputLength;
		 
		 int i=0,j = i+1;
		 StringBuilder sb = new StringBuilder();
		 
		 
		 int count = 1;
		 while(i<inputLength && j<inputLength) {
			 if(chars[i] == chars[j]) {
				 count++;
				 j++;
			 }else {
				 sb.append(chars[i]);
				 if(count>1)
					 sb.append(count);
				 i=j;
				 j=i+1;
				 count=1;
			 } 
		 }
		 
		 sb.append(chars[i]);
		 if(count>1)
			 sb.append(count);
		 
		 System.err.println(sb.toString());
		 
		 char[] result = sb.toString().toCharArray();
		 return result.length;
	        
	 }
	 
		/**
		 * Solution 2 : Modifying the input array
		 * 
		 * @param chars
		 * @return
		 */
		public static int compress2(char[] chars) {

			int inputLength = chars.length;

			if (inputLength == 0 || inputLength == 1)
				return inputLength;

			int i = 0, j = i + 1;
			int res = 0;

			int count = 1;
			while (i < inputLength && j < inputLength) {
				if (chars[i] == chars[j]) {
					count++;
					j++;
				} else {
					chars[res++] = chars[i];
					if (count > 1) {
						char[] charArray = String.valueOf(count).toCharArray();
						for(int x=0;x<charArray.length;x++) {
							chars[res++] = charArray[x];
						}
						
					}
						
					i = j;
					j = i + 1;
					count = 1;
				}
			}

			chars[res++] = chars[i];
			if (count > 1) {
				char[] charArray = String.valueOf(count).toCharArray();
				for(int x=0;x<charArray.length;x++) {
					chars[res++] = charArray[x];
				}
			}

			System.err.println(chars);

			return res;

		}
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] input = {'a','a','b','b','c','c','c'};
	//	char[] input = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		System.err.println(StringCompression.compress2(input));
		

	}

}
