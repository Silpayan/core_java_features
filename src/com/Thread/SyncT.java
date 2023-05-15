package com.Thread;

public class SyncT  implements Runnable{
	
	volatile int v = 0;

	public static void main(String s[]){

		Thread t1 = new Thread(new SyncT());
		t1.run();
		Thread t2 = new Thread(new SyncT());
		t2.run();
	}

	@Override
	public void run() {
		printIncrmnt();
	}

	private void printIncrmnt() {
		
		int t=0;		
		
		for(int i =1; i<=5; i++){
			
			synchronized(this){
			
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Incr.i++);
				(this).notifyAll();
			}
		}
	}
}

class Incr{
	static Integer i = new Integer(1);
}