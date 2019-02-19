/*
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 */

package com.basic.Arrays;

public class Rotate {
	
	 // Space is O(n) and time is O(n).
	 public static void rotate(int[] nums, int k) {
		int[] helper = new int[nums.length];

		int i, j = 0;

		if (k > nums.length) // To consider the fact that no.of rotations can be
								// more than the length of the array
			k = k % nums.length;

		for (i = 0; i + k < nums.length; i++) {
			helper[i + k] = nums[i];
		}

		while (i < nums.length && j <= k) {
			helper[j++] = nums[i++];
		}

		// Alternate method to copy array
		System.arraycopy(helper, 0, nums, 0, nums.length);
	 }
	 
	 
	 /**
	  * To display the array
	  * @param array
	  */
	 static void display(int[] array){
		 for(int i=0;i<array.length;i++){
			 System.out.print(array[i]+" ");
		 }
	 }
	 
	public static void main(String[] args) {
		int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
		System.out.println("Input Array : ");
		display(inputArray);
		rotate(inputArray, 15);
		System.out.println("\nRotated Matrix : ");
		display(inputArray);	

	}

}
