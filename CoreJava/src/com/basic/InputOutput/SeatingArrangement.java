/**

Akash and Vishal are quite fond of travelling. They mostly travel by railways. They were travelling in a train one day and they got interested in the seating arrangement of their compartment. The compartment looked something like 

 
So they got interested to know the seat number facing them and the seat type facing them. The seats are denoted as follows : 
Window Seat : WS
Middle Seat : MS
Aisle Seat : AS

You will be given a seat number, find out the seat number facing you and the seat type, i.e. WS, MS or AS.

INPUT
First line of input will consist of a single integer T denoting number of test-cases. Each test-case consists of a single integer N denoting the seat-number.

OUTPUT
For each test case, print the facing seat-number and the seat-type, separated by a single space in a new line.

CONSTRAINTS
1<=T<=105
1<=N<=108

SAMPLE INPUT
s
2
18
40

SAMPLE OUTPUT

19 WS
45 AS
 * 
 */
package com.basic.InputOutput;

import java.util.Scanner;

/**
 * @author neha.narvekar
 *
 */
public class SeatingArrangement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
	
		int[] input = new int[t];
		for(int i=0;i<t;i++){
			input[i] = sc.nextInt();	
		}
		String type = null;
		int mod = 0;
		int div = 0;
		int opp = 0;
		
		/**
		 * Map the input to a basic setting of 1-12 and then calculate
		 */
		
		for(int x=0;x<t;x++){
			mod = input[x]%12;
			div = input[x]/12;
			
			if(mod == 0 || mod == 1 || mod==6 || mod==7){
				type="WS";
			}else if(mod == 2 || mod == 5 || mod==8 || mod==11){
				type="MS";
			}else if(mod == 3 || mod == 4 || mod==9 || mod==10){
				type="AS";
			}
			if(input[x]<=12){
				opp = 13-input[x];
			}else if(mod==0){
				opp = (div * 12)-11;
			}
			else{
				opp = (13-mod)+(div * 12);
			}
			System.out.println(opp+" "+type);
			
		}
	}

}
