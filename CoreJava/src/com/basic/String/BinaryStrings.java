/**
 * Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

Input: s1 = "1101", s2 = "111"
Output: 10100
Explanation:
 1101
+ 111
10100
Input: s1 = "00100", s2 = "010"
Output: 110
Explanation: 
  100
+  10
  110
Constraints:
1 ≤s1.size(), s2.size()≤ 106
 * 
 * 
 * 
 */

package com.basic.String;

public class BinaryStrings {

	public static String addBinary(String s1, String s2) {

		StringBuilder sb = new StringBuilder();
		char carry = '0';
		int i = 0, j = 0;
		
		//Trim the leading 0
		s1 = trimLeadingZeroes(s1);
		s2 = trimLeadingZeroes(s2);
		
		if (s1.length() < s2.length()) {
			// Exchange to make longer string as first one
			String temp = s1;
			s1 = s2;
			s2 = temp;

		}
		
		i = s1.length() - 1;
		j = s2.length() - 1;

		while (i >= 0 && j >= 0) {
			carry = add(s1.charAt(i), s2.charAt(j), sb, carry);
			i--;
			j--;
		}

		//if there are characters remaining in s1, add those
		if (j < 0) {
			while (i >= 0) {
				carry = add(s1.charAt(i), '0', sb, carry);
				i--;
			}
		}

		//Add the last carry if its '1'. Ignore if 0 
		if (carry == '1') {
			sb.append(carry);
		}

		//Reverse the resultant string.
		return sb.reverse().toString();
	}

	/**
	 * Function to trim the leading 0
	 * 
	 * @param s
	 * @return
	 */
	public static String trimLeadingZeroes(String s) {
		int i = 0;
		while(i<s.length() && s.charAt(i)!='1') {
			i++;
		}
		//while loop exits when 'i' the value is '1'. So substring from 'i'th index
		s = s.substring(i);
		return s;
	}
	
	public static char add(char c1, char c2, StringBuilder sb, char carry) {
		if (c1 != c2) { // 0 & 1 combination
			if (carry == '1') {
				// result = 0 and carry = 1
				sb.append('0');
				carry = '1';
			} else {
				sb.append('1');
				carry = '0';
			}
		} else {

			// Both are 0 or both are 1
			if (c1 == '0') {
				// Both 0
				if (carry == '1') {
					sb.append('1');
					carry = '0';
				} else {
					sb.append('0');
					carry = '0';
				}
			} else {
				// Both 1
				if (carry == '1') {
					sb.append('1');
					carry = '1';
				} else {
					sb.append('0');
					carry = '1';
				}

			}

		}
		return carry;

	}

	public static void main(String[] args) {
	
//		String s1 = "1101", s2 = "111";
//		String s1 = "00001", s2 = "111110";
		String s1 = "01001001", s2 = "0110101";
		System.err.println(addBinary(s1, s2));

	}

}
