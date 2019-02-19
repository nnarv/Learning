import java.util.Scanner;
/*
 * Longest Increasing Subsequence
You are given a string  of length . Now, you are given  queries. Each query is one of the following types:
 Change the character at position  to .
 Find the length of the longest increasing subsequence of the string .

Notes

. In the longest increasing subsequence, the characters are in strictly increasing order.
. A subsequence of a string not necessarily contains contiguous characters. For example, the string "ale" is a subsequence of string "apple".
. Read the constraints carefully.

Input Format

The first line contains an integer  as input denoting the length of the string .
The next line contains a string  of lowercase English alphabet characters. The length of this string is .
The next line contains an integer  as input denoting the total number of the queries.
Each query is one of the two types as described in the problem statement above.

Output Format

For each query of type , you need to print the answer in a new line.

Constraints



The string  will contain at most  distinct characters at every point of time. Each character belongs to .

Sample Input
7
aabccae
3
2
1 6 d
2
Sample Output
4
5
Explanation
In the sample for the first query of type  the length of the longest increasing subsequence of characters is  abce.

After the string is updated the length of the longest increasing subsequence of characters is  abcde.
 * 
 * 
 * 
 */


public class Subsequence {

	static String subSequence(String s){
		StringBuilder sub = new StringBuilder();
		for(int i=0;i<s.length();i++){
			
		}
		
		return sub.toString();
	}
	
	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
	   
	     int n = Integer.parseInt(s.nextLine());
	     String st = s.nextLine();
	     int q = Integer.parseInt(s.nextLine());
	     
	     for(int i=0;i<q;i++){
	    	 String qq[] = s.nextLine().split(" ");
	    	 if(qq[0] == "2"){
	    		 //find subsequence
	    	 }else if(qq[0]=="1"){
	    		 //replace string
	    	 }
	    	 
	     }

	}

}
