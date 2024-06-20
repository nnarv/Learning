/*

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000


*/

package com.leetcode.medium;

public class ZigZagConversion {
	
	
	public static String convert(String s, int numRows) {

        int len = s.length();
		if (numRows == 1 || numRows>len) {
			return s;
		}
		
		//No.of strings = no.of rows. Create an String array to hold the resultant strings
		String[] arr = new String[numRows];
		boolean down = false;
		int t = 0;

		for (int i = 0; i < len; i++) {

			//Append characters to strings  
			String val = arr[t];
			if (val == null) {
				arr[t] = new String();
			}
			arr[t] = arr[t].concat(String.valueOf(s.charAt(i)));
			
			//Change direction on first and last row
			if (t == 0 || t == (numRows - 1)) {
				down = !down;
			}

			if (down) {
				t++;
			} else {
				t--;
			}

		}

		// Append string values to get the final string
		StringBuilder builder = new StringBuilder();
		for (int j = 0; j < numRows; j++) {
			builder.append(arr[j]);
		}
		return builder.toString();

    
}

	public static void main(String[] args) {
		
		String s = "PAYPALISHIRING";
		int numRows = 4;
		
		System.err.println(ZigZagConversion.convert(s, numRows));

	}

}
