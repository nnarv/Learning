/**
 * You have a string x of length N, which consists of small English letters. 
 * You have to find the number of indexes a, b, c and d, such that 1<=a<b<c<d<=N and x(a)==x(c) , as well as x(b)==x(d).
 * Input format

The first line contains the number N - the length of a string x. The second line contains the string x itself.

Output format

The first and only line should contain the answer to the problem.

SAMPLE INPUT 
5
ababa

SAMPLE OUTPUT 
2
 */
package com.basic.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * @author neha.narvekar
 *
 */
public class HolidaySeason {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String x = br.readLine();
        int count = 0;
        
        for(int i=0 ; i<n && (i+3)<n ; i++){
            char a = x.charAt(i);
            char b = x.charAt(i+1);
            char c = x.charAt(i+2);
            char d = x.charAt(i+3);
            
            if(a==c && b==d){
                count++;
            }
        }
        
        String test = "abc";
        int y = test.indexOf('d',0);
        
        System.out.println(y);

	}

}
