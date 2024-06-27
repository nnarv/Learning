/**
 * 1207. Unique Number of Occurrences

Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

 

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 

Constraints:

1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000
 * 
 */
package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 */
public class UniqueOccurrences {

	/**
	 * Solution 1 : Straighforward solution would be to count frequency of elements and store in map
	 * Then add the frequency to set and check uniqueness
	 * 
	 * In this solution below, avoiding the map
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean uniqueOccurrences(int[] arr) {
		
	        int len = arr.length;
	        
	        if(len == 1) {
	        	return true;
	        }
	        
	        Arrays.sort(arr);
	        
	        int count =1;
	        Set set = new HashSet<Integer>();
	        for(int i=0;i<len-1;i++){
	            if(arr[i+1] == arr[i]){
	                count++;
	            }else{
	                if(!set.add(count))
	                    return false;
	                count =1;
	            }
	        }
	        
	        // To handle the last number :
	        // 1. if it is same as the previous one, the count would have been incremented in the last run but not added to set
	        // 2. if not, else statement is executed in last run and count is added to the set and count reset to 1 (indicating last element which is unique obviously)
	        // Hence adding the count to set again to handle last numbers.
	        if(!set.add(count))
                return false;
	        
	                
	        return true;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int[] arr = { 5, -2, -2, 1, 5, -2 };
		int[] arr = { 1,2,2,10};
		
		System.err.println(uniqueOccurrences(arr));
	}

}
