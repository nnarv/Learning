package com.basic.Thread;

class StopThread implements Runnable{
	
	private volatile boolean exit = false;
	
	@Override
	public void run() {
		while(!exit){
			System.out.println("Thread is running");
		}
	}
	
	public void stop(){
		this.exit = true;
	}
}	
	
	
	
public class TestStopThread{
	
	public static void main(String[] args) throws InterruptedException {
	
		System.out.println("Main thread running");
		
		System.out.println("Starting the child thread");
		
		StopThread st = new StopThread();
		Thread t = new Thread(st);
		t.start();
		
		Thread.sleep(1000);
		System.out.println("Stopping the thread");
		st.stop();
		
		System.out.println("The child thread stopped");
	}

	

}
