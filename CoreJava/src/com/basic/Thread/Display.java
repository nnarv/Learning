package com.basic.Thread;

public class Display {
	
	
	static void display(int[][] board){
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(i!=board.length-1){
					System.out.print("_"+board[i][j]+"_");
				}else{
					System.out.print(" "+board[i][j]+" ");
				}
				
				if(j!=board[0].length-1){
					System.out.print("|");
				}
			}
			System.out.println();
		}
		
		/*
		System.out.println("_1_|_0_|_1_");
		System.out.println("_1_|_0_|_1_");
		System.out.println(" 1 | 0 | 1 ");*/
	}
	
	
	
	

	public static void main(String[] args) {
		int[][] board = {{1,1,1}, {1,0,0}, {0,1,1}};//new int[3][3];
		
		
		
		
		Display.display(board);
	}

}
