/**
 * To tilt a given matrix by 90 degrees clockwise
 */
package com.basic.Matrix;

/**
 * @author neha.narvekar
 *
 */
public class ReverseMatrix {

	/**
	 * @param args
	 */
	
	public static void displayMatrix(int[][] inputMatrix){
		int rows = inputMatrix.length;
		int columns = inputMatrix[0].length;
		
		for(int i=0;i<rows;i++){
			for (int j=0;j<columns;j++){
				System.out.print(inputMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] inputMatrix = {{2,1,5}, {6,4,8}, {5,0,3}, {9,7,2}};
		int rows = inputMatrix.length;
		int columns = inputMatrix[0].length;
		
		System.out.println("Input Matrix : ");
		displayMatrix(inputMatrix);
		
		int[][] reverseMatrix = new int[inputMatrix[0].length][inputMatrix.length];
		
		for(int x=0,m=0;x<columns && m<reverseMatrix.length; x++,m++){
			for(int y=rows-1,n=0;y>=0 && n<reverseMatrix[0].length;y--,n++){
				reverseMatrix[m][n] = inputMatrix[y][x]; 
			}
		}
		
		System.out.println("\nClockwise 90 Degrees tilted Matrix : ");
		displayMatrix(reverseMatrix);
		
		for(int x=columns-1,m=0;x>=0 && m<reverseMatrix.length; x--,m++){
			for(int y=0,n=0;y<rows && n<reverseMatrix[0].length;y++,n++){
				reverseMatrix[m][n] = inputMatrix[y][x]; 
			}
		}
		
		System.out.println("\nAnti-Clockwise 90 Degrees tilted Matrix : ");
		displayMatrix(reverseMatrix);

	}

}
