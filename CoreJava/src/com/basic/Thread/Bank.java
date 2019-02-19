package com.basic.Thread;


class Customer{
	int balance = 10000;
	
	public void withdraw(int amt){
		synchronized (this) {
			if(amt > balance){
				System.out.println("Current balance : "+ balance);
				System.out.println("Not enough balance");
				
				try{
					wait();
				}catch(Exception e){
					System.err.println(e.getMessage());
				}
				
				balance-=amt;
				System.out.println("Amount withdrawn. Balance : "+balance);
			}
		}
	}
	
	public void deposit(int amt){
		try{
			Thread.sleep(1000);
			
			synchronized (this) {
				balance+=amt;
				System.out.println("Amount deposited. Balance : "+balance);
				notify();
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
	}
	
	
	
}


public class Bank {

	public static void main(String[] args) {
		
		final Customer c = new Customer();
		
		Thread t1 = new Thread(new Runnable(){
			
			@Override
			public void run() {
				c.withdraw(15000);
				
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			
			@Override
			public void run() {
				c.deposit(10000);
				
			}
		});
		
		t1.start();
		t2.start();
		
		try{
			t1.join();
			t2.join();
		}catch(Exception e){
			System.out.println("Exception");
		}
		

	}

}
