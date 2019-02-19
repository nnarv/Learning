/**
A left rotation operation on an array shifts each of the array's elements  unit to the left. 
For example, if  left rotations are performed on array , then the array would become .

Given an array  of  integers and a number, , perform  left rotations on the array. 
Return the updated array to be printed as a single line of space-separated integers.
 * 
 */
package com.basic.Arrays;

/**
 * @author neha.narvekar
 *
 */
public class RotateLeft {

	/**
	 * Iterate Over the array. Start with 0 index. 
		Find its new index using the formula:
		newIndex = (currentIndex - (no_of_rotation % array_length) + array_length) % array_length
		Example:
		(0 - (3 % 8) + 8) % 8 = 5
	 */
	
	 static int[] rotLeft(int[] a, int d) {
	        int[] rotated = new int[a.length];
	        
	        for(int i=0;i<a.length;i++){
	            int newIndex = (i-(d%a.length)+a.length)%a.length;
	            rotated[newIndex] = a[i];
	        }
	        return rotated;

	    }
	 
	 static void display(int[] matrix){
		 for(int i=0;i<matrix.length;i++){
			 System.out.print(matrix[i]+" ");
		 }
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArray = {3,4,5,6,7};
		int rotations = 4;
		int[] result = rotLeft(inputArray, rotations);
		System.out.println("Input Matrix : ");
		display(inputArray);
		System.out.println("\nNo.of Rotations : \n"+rotations);
		System.out.println("Rotated Matrix : ");
		display(result);
		
		
	}

}
