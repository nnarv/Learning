package com.basic.Thread;

import java.util.Scanner;

public class ThreadExample {

	class PC {
		Scanner s = new Scanner(System.in);
		boolean pkey = false;
		
		public void produce() throws InterruptedException{	
			
			synchronized (this) {
				while(true){
					if(!pkey){
						wait();
					}
					System.out.println("Producer thread running");
					System.out.println("Waiting for return key");
					s.nextLine();
					System.out.println("Producer return key pressed");
					notify();
					pkey = false;
					Thread.sleep(1000);
				}
			}
			
		}	
		
		public void consume() throws InterruptedException {

			synchronized (this) {
				while(true){
					if(pkey){
						wait();
					}
					System.out.println("Consumer thread running");
					System.out.println("Waiting for return key");
					s.nextLine();
					System.out.println("Consumer return key pressed");
					notify();
					pkey = true;
					Thread.sleep(1000);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		final ThreadExample.PC pc = new ThreadExample().new PC();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
			
				try {
					pc.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		});
		
		try {
			
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
