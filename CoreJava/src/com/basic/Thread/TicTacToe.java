/**
 * Classic Tic-Tac-Toe game
 */

package com.basic.Thread;

import java.util.Scanner;

public class TicTacToe {
	
	int[][] board = new int[3][3];
	boolean p1 = true;
	volatile boolean exit = false;
	Scanner sc = new Scanner(System.in);
	int x,y;
	
	
	/**
	 * Method to display the board
	 */
	void display(){	
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
	}
	
	
	/**
	 * Player 1 method
	 * @throws InterruptedException
	 */
	void player1() throws InterruptedException{
		synchronized (this) {
			while(!exit){
				if(!p1){
					wait();
				}
				play(1);
				notify();
				p1 = false;
				Thread.sleep(1000);
			}
		}
	}
	
	/**
	 * Player 2 method
	 * @throws InterruptedException
	 */
	void player2() throws InterruptedException{
		synchronized (this) {
			while(!exit){
				if(p1){
					wait();
				}
				play(2);
				notify();
				p1 = true;
				Thread.sleep(1000);
			}
		}
	}
	
	/**
	 * Method to enter the values. Re-enter data if the data at same spot has been entered
	 * @param player
	 */
	void enterData(int player){
		String[] pos = sc.nextLine().split(",");
		x = Integer.parseInt(pos[0]);
		y = Integer.parseInt(pos[1]);
		
		while(board[x][y]!=0){
			System.out.println("Spot occupied. Please re-enter");
			pos = sc.nextLine().split(",");
			x = Integer.parseInt(pos[0]);
			y = Integer.parseInt(pos[1]);
		}
		board[x][y] = player;	
	}
	
	
	/**
	 * 
	 * @param player
	 */
	void play(int player){
		if(!exit){
			System.out.println("Player "+player +" turn to play. Enter data ");
			
			enterData(player);
			
			display();
	
			if(checkBoard(player)){
				System.out.println("Game Over. Player " + player + " Won");
				exit = true;
			}else{
				exit = isGameOver();
			}	
		}
	}
	
	/**
	 * To check if any row is complete
	 * @return
	 */
	int isValidRow(){
		int result = -1;
		
		if( board[0][0]==board[0][1] && board[0][1]==board[0][2] ){
			result = board[0][0];
		}else if( board[1][0]==board[1][1] && board[1][1]==board[1][2] ){
			result = board[1][0];
		}else if( board[2][0]==board[2][1] && board[2][1]==board[2][2] ){
			result = board[2][0];
		}			
		return result;
	}
	
	/**
	 * To check if any column is complete
	 * @return
	 */
	int isValidColumn(){
		int result = -1;
		
		if( board[0][0]==board[1][0] && board[1][0]==board[2][0] ){
			result = board[0][0];
		}else if( board[0][1]==board[1][1] && board[1][1]==board[2][1] ){
			result = board[0][1];
		}else if( board[0][2]==board[1][2] && board[1][2]==board[2][2] ){
			result = board[0][2];
		}			
		return result;	
	}
	
	/**
	 * To check if any diagonal is complete
	 * @return
	 */
	int isValidDiagonal(){
		int result = -1;
		
		if( board[0][0]==board[1][1] && board[1][1]==board[2][2] ){
			result = board[0][0];
		}else if( board[2][0]==board[1][1] && board[1][1]==board[0][2] ){
			result = board[1][0];
		}		
		return result;
	}

	
	/**
	 * To check the board for any valid row, column or diagonal
	 * @param player
	 * @return
	 */
	boolean checkBoard(int player){
		int result = isValidRow();
		if(result ==-1){
			result = isValidColumn();
		}
		if(result == -1){
			result = isValidDiagonal();
		}
		
		return (result==player);
	}
	
	/**
	 * To check if the board has any spots left to play
	 * @return
	 */
	boolean isGameOver(){		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]==0){
					return false;
				}
			}	
		}
		System.out.println("Game Over. No winner");
		return true;
	}
	
	
	public static void main(String[] args){
		
		final TicTacToe t = new TicTacToe();
		
			Thread t1 = new Thread(new Runnable(){
				@Override
				public void run() {
					try {
						t.player1();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			
			Thread t2 = new Thread(new Runnable(){
				@Override
				public void run() {	
					try {
						t.player2();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		

		try{
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
	}
}
