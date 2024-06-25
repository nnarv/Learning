/**
 * 
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 * 
 */
package com.leetcode.easy;

/**
 * 
 */
public class MoveZeroes {
	

	/**
	 * 2 pointer approach -i & j.
	 * i -  1st pointer to evaluate if the current element is 0.
	 * j - 2nd pointer to find the next non zero element
	 * 
	 * If i=0, find next non-zero j the  and swap with i  
	 * 
	 * 
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
		int i=0, j=1;
		int temp =0;
		int len = nums.length;
        while(i<len && j<len) {
        	if(nums[i]==0) {
        		if(nums[j]==0) {
        			j++;
        		}else {
        			temp = nums[i];
        			nums[i] = nums[j];
        			nums[j] = temp;
        			i++;
        			j++;
        		}
        	}else {
        		i++;
        		j++;
        	}
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
