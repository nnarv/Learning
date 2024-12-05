/**
 * Given an unsorted array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. Do the mentioned change in the array in place.

Note: Consider the array as circular.

Examples :

Input: arr[] = [1, 2, 3, 4, 5], d = 2
Output: [3, 4, 5, 1, 2]
Explanation: when rotated by 2 elements, it becomes 3 4 5 1 2.
Input: arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20], d = 3
Output: [8, 10, 12, 14, 16, 18, 20, 2, 4, 6]
Explanation: when rotated by 3 elements, it becomes 8 10 12 14 16 18 20 2 4 6.
Input: arr[] = [7, 3, 9, 1], d = 9
Output: [3, 9, 1, 7]
Explanation: when we rotate 9 times, we'll get 3 9 1 7 as resultant array.
Constraints:
1 <= arr.size(), d <= 105
0 <= arr[i] <= 105
 * 
 * 
 * 
 */

package com.basic.Arrays;

import java.util.Arrays;

public class RotateArray {
	
	 // Function to rotate an array by d elements in counter-clockwise direction.
    
	/*Solution 1 : Naive approach
	 * In each iteration, shift the elements by one position to the left in a circular fashion (the first element becomes the last). 
	 * Perform this operation d times to rotate the elements to the left by d positions.
	
		Rotate one by one - O(n * d) Time and O(1) Space
	*/
	static void rotateArr(int arr[], int d) {
		int len = arr.length;
		int temp = -1;
        
		for(int i=0;i<d;i++) {
			
			temp = arr[0];
			for(int j=1;j<len;j++) {
				arr[j-1]= arr[j];	
			}
			arr[len-1]=temp;
		}
		
    }
	
	/**
	 * Solution 2 : 
	 * The idea is based on the observation that if we left rotate the array by d positions, 
	 * the first d elements will be at the end and the last (n - d) elements will be at the front and .

	Step 1 - Reverse the subarray containing the first d elements of the array.
	Step 2 - Reverse the subarray containing the last (n - d) elements of the array.
	Step 3 - reverse all the elements of the array.
	
	Using Reversal Algorithm - O(n) Time and O(1)
	


	 * @param nums
	 * @param k
	 */
	static public void rotate(int[] nums, int k) {
        int len = nums.length;
        
        //If the number of rotations is greater than length of array, the effective rotations = k%len
        //For example, 7 rotations on array of length 5 will give the same result as 2 rotations (7%5)  
        if(k>len)
        	k = k%len;
        
        //Depending on the direction, choose the first k(left/anti-clockwise) or last k(right/clockwise)
        
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
		reverse(nums, 0, len-1);     
    }

    static public void reverse(int[] nums, int start, int end){
        int temp = -1;

        while(start<=end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
	//	int arr[] = {10, 20, 30, 40};
	//	int arr[] = {7, 3, 9, 1};
		int arr[] = {1, 2};
	//	rotateArr(arr,9);
		rotate(arr, 3);
		Arrays.stream(arr).forEach(x -> System.out.print(x));

	}

}
