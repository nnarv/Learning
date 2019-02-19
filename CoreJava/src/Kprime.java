import java.util.Scanner;
/*
 * K Prime Array
Given an array  of  integers and an integer . An array is called K-Prime if it contains at least  prime numbers. Now, you need to convert the array  into a K-Prime array by performing some operations. In one operation, you can choose an index of the array  and add number  to it. This will increase the value of the chosen element by . You need to print the minimum operations required to make the array  K-Prime. If the array is already K-Prime print .

Input

The first line contains two integers  and  as input.
The next line of input contains  space-separated integers.

Output

In the output print the minimum operations required to make the array  K-Prime.


Sample Input
4 3
2 8 1 14
Sample Output
4
Explanation
In the given sample, if you increment value  to  and  to  then in  operations you can make the array 3-Prime.
 * 
 * 
 * 
 * 
 * 
 */
public class Kprime {

	static boolean isPrime(int n){
		
		boolean isPrime = true;
		for(int i=2;i<=n/2;i++){
			if(n%i == 0){
				isPrime = false;
				break;
			}
		}
		return isPrime;
		
	}
	
	static int countPrime(int[] input){
		int count = 0;
		for(int i=0;i <input.length;i++){
			if(isPrime(input[i])){
				count++;
			}
		}
		return count;
	}
	
	static void makePrime(int[] input){
		int count = 0;
		for(int i=0;i <input.length;i++){
			if(isPrime(input[i])){
				count++;
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		 Scanner s = new Scanner(System.in);
	     String st[] = s.nextLine().split(" ");
	     int n = Integer.parseInt(st[0]);
	     int k = Integer.parseInt(st[1]);
	     st = s.nextLine().split(" ");
	     int[] input = new int[n];
	        for(int i=0;i<n;i++){
	        	input[i] = Integer.parseInt(st[i]);
	        }
	     
	        if(countPrime(input)==k){
	        	System.out.println("0");
	        }
	      
	        
	}

}
